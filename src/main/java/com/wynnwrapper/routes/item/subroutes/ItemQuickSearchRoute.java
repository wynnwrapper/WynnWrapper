package com.wynnwrapper.routes.item.subroutes;

import com.wynnwrapper.core.APIHelper;
import com.wynnwrapper.core.APIRequest;

public class ItemQuickSearchRoute extends APIRequest {
    private static final String route = "/item/search/";

    public ItemQuickSearchRoute(APIHelper apiHelper, String query) {
        super(apiHelper, apiHelper.buildURL(route + query));
    }
}