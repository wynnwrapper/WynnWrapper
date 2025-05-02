package com.wynnwrapper.routes.item.subroutes;

import com.wynnwrapper.core.APIHelper;
import com.wynnwrapper.core.APIRequest;

public class ItemDatabaseRoute extends APIRequest {

    private static final String route = "item/database";

    public ItemDatabaseRoute(APIHelper apiHelper, String identifier) {
        super(apiHelper, apiHelper.buildURL(route + identifier));
    }
}
