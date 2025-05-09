package com.wynnwrapper.routes.search;

import com.wynnwrapper.core.APIHelper;
import com.wynnwrapper.data.search.SearchResult;
import com.wynnwrapper.routes.search.subroutes.SearchData;

public class SearchRoute {
    private final APIHelper apiHelper;

    public SearchRoute(APIHelper apiHelper) {
        this.apiHelper = apiHelper;
    }

    public SearchResult search(String query) {
        SearchData subroute = new SearchData(apiHelper, query);
        return subroute.getResponse(SearchResult.class);
    }
}
