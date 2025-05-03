package com.wynnwrapper.routes.news;

import com.wynnwrapper.core.APIHelper;
import com.wynnwrapper.core.APIRequest;
import com.wynnwrapper.data.news.News;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

public class NewsRoute {
    private final APIHelper apiHelper;

    public NewsRoute(APIHelper apiHelper) {
        this.apiHelper = apiHelper;
    }

    public List<News> getNews() {
        NewsRequest news = new NewsRequest(apiHelper);
        Type type = new TypeToken<List<News>>() {}.getType();
        return news.getResponse(type);
    }


    public static class NewsRequest extends APIRequest{

        private static final String route = "latest-news";

        public NewsRequest(APIHelper apiHelper) {
            super(apiHelper, apiHelper.buildURL(route));
        }
    }
}
