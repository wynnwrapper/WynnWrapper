package com.wynnwrapper.routes.item.subroutes;

import com.wynnwrapper.core.APIHelper;
import com.wynnwrapper.core.APIRequest;
import com.wynnwrapper.data.item.ItemSearchPayload;

import java.lang.reflect.Type;

public class ItemSearchRoute extends APIRequest {

    private final ItemSearchPayload payload;

    public ItemSearchRoute(APIHelper apiHelper, ItemSearchPayload payload, boolean fullResult) {
        // Remove the query parameter from the URL construction
        super(apiHelper, "https://api.wynncraft.com/v3/item/search" + (fullResult ? "?fullResult" : ""));
        this.payload = payload;
    }

    @Override
    public <T> T getResponse(Class<T> clazz) {
        return postResponse(payload, clazz);
    }

    @Override
    public <T> T getResponse(Type type) {
        return postResponse(payload, type);
    }
}