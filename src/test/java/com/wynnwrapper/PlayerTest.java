package com.wynnwrapper;

import com.wynnwrapper.data.player.WynncraftPlayer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class PlayerTest {

    static WynncraftAPI api;

    @BeforeAll
    static void setup() {
        api = new WynncraftAPI();
    }


    @Test
    void testPlayerMainStats() {
        WynncraftPlayer player = api.player().playerStats("42nao");
        Assertions.assertEquals(player.username(), "42nao");
    }
}
