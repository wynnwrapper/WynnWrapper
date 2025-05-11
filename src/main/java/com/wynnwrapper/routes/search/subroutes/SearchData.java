package com.wynnwrapper.routes.search.subroutes;

import com.wynnwrapper.core.APIHelper;
import com.wynnwrapper.core.APIRequest;

public class SearchData extends APIRequest {
    static final String route = "/search";

    public SearchData(APIHelper apiHelper, String query) {
        super(apiHelper, apiHelper.buildURL(route + "/" + query));
    }
}
