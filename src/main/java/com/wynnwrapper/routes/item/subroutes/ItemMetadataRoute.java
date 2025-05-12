package com.wynnwrapper.routes.item.subroutes;

import com.wynnwrapper.core.APIHelper;
import com.wynnwrapper.core.APIRequest;

public class ItemMetadataRoute extends APIRequest {
    private static final String route = "/item/metadata";

    public ItemMetadataRoute(APIHelper apiHelper) {
        super(apiHelper, apiHelper.buildURL(route));
    }
}