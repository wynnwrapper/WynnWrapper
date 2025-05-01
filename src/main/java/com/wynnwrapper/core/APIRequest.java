package com.wynnwrapper.core;

import com.wynnwrapper.exceptions.WynnRateLimitException;
import com.wynnwrapper.exceptions.WynnResponseException;
import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.config.RequestConfig;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.http.*;
import org.apache.hc.core5.http.io.HttpClientResponseHandler;
import org.apache.hc.core5.http.io.entity.EntityUtils;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public abstract class APIRequest {


    private String version;
    private String requestURL;
    private List<Header> headers;
    private int timeout;
    private APIHelper apiHelper;

    public APIRequest(APIHelper apiHelper, String requestURL) {
        this.apiHelper = apiHelper;
        this.version = apiHelper.apiVersion();
        this.timeout = apiHelper.timeout();
        this.requestURL = requestURL;
        this.headers = new ArrayList<>();
    }

    public <T> T getResponse(Class<T> clazz) {
        String jsonResponse = getJSONResponse();
        if (jsonResponse == null) {
            throw new WynnResponseException("No body in request response for " + requestURL, -1);
        }

        return apiHelper.gson().fromJson(jsonResponse, clazz);
    }

    public <T> T getResponse(Type type) {
        String jsonResponse = getJSONResponse();
        if (jsonResponse == null) {
            throw new WynnResponseException("No body in request response for " + requestURL, -1);
        }
        return apiHelper.gson().fromJson(jsonResponse, type);
    }

    private String getJSONResponse() {
        if (apiHelper.rateLimiter().isRateLimited()) {
            throw new WynnRateLimitException("Cannot make request, rate limit would be exceeded. Please try again later.", apiHelper.rateLimiter().rateLimitResetTimestamp(), true);
        }
        RequestConfig config = RequestConfig.custom().setResponseTimeout(timeout, TimeUnit.MILLISECONDS).setConnectionRequestTimeout(timeout, TimeUnit.MILLISECONDS).build();
        System.out.println("Making request to " + requestURL);
        try (CloseableHttpClient client = HttpClients.custom().setDefaultRequestConfig(config).build()) {
            HttpGet httpGet = new HttpGet(requestURL);
            Header[] requestHeaders = new Header[headers.size()];
            httpGet.setHeaders(headers.toArray(requestHeaders));
            httpGet.setHeader("User-Agent", "WynnWrapper/" + version);
            HttpClientResponseHandler<String> responseHandler = new HttpClientResponseHandler<String>() {
                @Override
                public String handleResponse(ClassicHttpResponse response) throws HttpException, IOException {
                    long rateLimitReset = Long.parseLong(response.getFirstHeader("RateLimit-Reset").getValue()) * 1000 + System.currentTimeMillis();
                    int rateLimitMax = Integer.parseInt(response.getFirstHeader("RateLimit-Limit").getValue());
                    int rateLimitRemaining = Integer.parseInt(response.getFirstHeader("RateLimit-Remaining").getValue());
                    apiHelper.rateLimiter().updateRateLimit(rateLimitReset, rateLimitRemaining, rateLimitMax);
                    int statusCode = response.getCode();

                    switch (statusCode) {
                        case HttpStatus.SC_OK: {
                            HttpEntity entity = response.getEntity();
                            String responseString = entity != null ? EntityUtils.toString(entity) : null;
                            if (responseString == null)
                                throw new WynnResponseException("No body in request response for " + requestURL, -1);
                            if (responseString.matches("\\{\"message\":\".*\"}")) {
                                throw new WynnResponseException("API error when requesting " + requestURL + ": " + responseString.split("\"message\":")[1].replace("\"", "").replace("}", ""), -1);
                            } else if (responseString.matches("\\{\"error\":\".*\"}")) {
                                throw new WynnResponseException("API error when requesting " + requestURL + ": " + responseString.split("\"error\":")[1].replace("\"", "").replace("}", ""), -1);
                            }
                            if (!entity.getContentType().contains("application/json"))
                                throw new WynnResponseException("Unexpected content type (not application/json): " + entity.getContentType(), -1);
                            return responseString;
                        }

                        //---- Error Codes ----//
                        case HttpStatus.SC_BAD_REQUEST: {
                            throw new WynnResponseException("400: Bad Request for " + requestURL, 400);
                        }
                        case 429: {
                            long resetTime;
                            try {
                                resetTime = Long.parseLong(response.getFirstHeader("ratelimit-reset").getValue()) * 1000 + System.currentTimeMillis();
                            } catch (NumberFormatException ex) {
                                resetTime = -1;
                            }
                            throw new WynnRateLimitException("429: Too Many Requests for " + requestURL, resetTime, true);
                        }
                        case HttpStatus.SC_NOT_FOUND: {
                            throw new WynnResponseException("404: Not Found for " + requestURL, 404);
                        }
                        case HttpStatus.SC_SERVICE_UNAVAILABLE: {
                            throw new WynnResponseException("503: Service Unavailable " + requestURL, 503);
                        }
                        default: {
                            throw new WynnResponseException("Unexpected status code " + statusCode + " returned by API for request " + requestURL, statusCode);
                        }
                    }
                }
            };
            return client.execute(httpGet, responseHandler);
        } catch (Exception e) {
            e.printStackTrace();
            return "";
            //throw new WynnConnectionException(e);
        }
    }
}
