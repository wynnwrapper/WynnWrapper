package com.wynnwrapper.routes.item;

import com.google.gson.reflect.TypeToken;
import com.wynnwrapper.core.APIHelper;
import com.wynnwrapper.data.item.ItemDatabaseResponse;
import com.wynnwrapper.data.item.Item;
import com.wynnwrapper.data.item.ItemMetadata;
import com.wynnwrapper.data.item.ItemSearchPayload;
import com.wynnwrapper.routes.item.subroutes.ItemDatabaseRoute;
import com.wynnwrapper.routes.item.subroutes.ItemQuickSearchRoute;
import com.wynnwrapper.routes.item.subroutes.ItemSearchRoute;

import java.lang.reflect.Type;
import java.util.Map;

public class ItemRoute {
    private final APIHelper apiHelper;

    public ItemRoute(APIHelper apiHelper) {
        this.apiHelper = apiHelper;
    }

    /**
     * Get paginated item database information
     * @param page Page number (starts at 1)
     * @return ItemDatabaseResponse containing paginated results
     */
    public ItemDatabaseResponse database(int page) {
        ItemDatabaseRoute subRoute = new ItemDatabaseRoute(apiHelper, "?page=" + page);
        return subRoute.getResponse(ItemDatabaseResponse.class);
    }

    /**
     * Get the full item database without pagination
     * @return Map of item names to item information
     */
    public Map<String, Item> fullDatabase() {
        ItemDatabaseRoute subRoute = new ItemDatabaseRoute(apiHelper, "?fullResult");
        Type type = new TypeToken<Map<String, Item>>(){}.getType();
        return subRoute.getResponse(type);
    }

    /**
     * Search for items with advanced filters
     * @param payload The search criteria
     * @return ItemDatabaseResponse containing search results
     */
    public ItemDatabaseResponse search(ItemSearchPayload payload) {
        ItemSearchRoute subRoute = new ItemSearchRoute(apiHelper, payload, false);
        return subRoute.getResponse(ItemDatabaseResponse.class);
    }

    /**
     * Search for items with advanced filters and get full results
     * @param payload The search criteria
     * @return Map of item names to item information
     */
    public Map<String, Item> fullSearch(ItemSearchPayload payload) {
        ItemSearchRoute subRoute = new ItemSearchRoute(apiHelper, payload, true);
        Type type = new TypeToken<Map<String, Item>>(){}.getType();
        return subRoute.getResponse(type);
    }

    /**
     * Quick search for items by name
     * @param query The search query
     * @return Map of item names to item information
     */
    public Map<String, Item> quickSearch(String query) {
        ItemQuickSearchRoute subRoute = new ItemQuickSearchRoute(apiHelper, query);
        Type type = new TypeToken<Map<String, Item>>(){}.getType();
        return subRoute.getResponse(type);
    }

    /**
     * Get item metadata for filter options
     * @return ItemMetadata containing available filters
     */
    public ItemMetadata metadata() {
        ItemDatabaseRoute subRoute = new ItemDatabaseRoute(apiHelper, "?metadata");
        return subRoute.getResponse(ItemMetadata.class);
    }

}