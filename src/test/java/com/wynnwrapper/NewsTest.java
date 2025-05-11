package com.wynnwrapper;

import com.wynnwrapper.data.news.News;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.google.gson.reflect.TypeToken;

import java.util.List;

public class NewsTest {

    static WynncraftAPI api;

    @BeforeAll
    static void setup() {
        api = new WynncraftAPI();
    }

    @Test
    void testNews() {
        List<News> newsList = api.news().getNews();
        Assertions.assertNotNull(newsList);
    }

}