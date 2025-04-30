package com.wynnwrapper.core;

import com.google.gson.Gson;
import lombok.Getter;

@Getter
public class APIHelper {

    private Gson gson;
    private RateLimiter rateLimiter;
    private String baseURL;
    private String apiVersion;
    private int timeout;

    public APIHelper(Gson gson, RateLimiter rateLimiter, String baseURL, String apiVersion, int timeout) {
        this.gson = gson;
        this.rateLimiter = rateLimiter;
        this.baseURL = baseURL;
        this.apiVersion = apiVersion;
        this.timeout = timeout;
    }

    public String buildURL(String subPath) {
        return baseURL + "/" + subPath;
    }

}
