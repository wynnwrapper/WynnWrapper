package com.wynnwrapper;

import com.wynnwrapper.data.item.ItemDatabaseResponse;
import com.wynnwrapper.data.item.Item;
import com.wynnwrapper.data.item.ItemMetadata;
import com.wynnwrapper.data.item.ItemSearchPayload;
import com.wynnwrapper.data.item.enums.ItemType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Map;

public class ItemTest {

    static WynncraftAPI api;

    @BeforeAll
    static void setup() {
        api = new WynncraftAPI();
    }

    @Test
    void testDatabase() {
        ItemDatabaseResponse response = api.items().database(1);
        Assertions.assertNotNull(response);
    }

    @Test
    void testFullDatabase() {
        Map<String, Item> items = api.items().fullDatabase();
        Assertions.assertNotNull(items);
        Assertions.assertFalse(items.isEmpty());
    }

    @Test
    void testSearch() {
        ItemSearchPayload payload = ItemSearchPayload.builder()
                .query("bow")
                .build();
        ItemDatabaseResponse response = api.items().search(payload);
        Assertions.assertNotNull(response);
    }

    @Test
    void testFullSearch() {
        ItemSearchPayload payload = ItemSearchPayload.builder()
                .query(null)
                .type(ItemType.BOW)
                .build();
        Map<String, Item> items = api.items().fullSearch(payload);
        Assertions.assertNotNull(items);
    }

    @Test
    void testQuickSearch() {
        Map<String, Item> items = api.items().quickSearch("bow");
        Assertions.assertNotNull(items);
        Assertions.assertFalse(items.isEmpty());
    }

    @Test
    void testMetadata() {
        ItemMetadata metadata = api.items().metadata();
        Assertions.assertNotNull(metadata);
    }
}