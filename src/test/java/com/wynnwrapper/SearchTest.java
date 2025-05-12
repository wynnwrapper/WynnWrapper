package com.wynnwrapper;

import com.wynnwrapper.data.search.SearchResult;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class SearchTest {

    static WynncraftAPI api;

    @BeforeAll
    static void setup() {api = new WynncraftAPI();}

    @Test
    public void testSearch() {
        String query = "idol";
        SearchResult result = api.search().search(query);
        Assertions.assertNotNull(result);
        Assertions.assertEquals(query, result.query());
    }
}
