package com.wynnwrapper;

import com.wynnwrapper.data.map.MapLocation;
import com.wynnwrapper.data.map.PlayerLocation;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;

public class MapModuleTest {

    static WynncraftAPI api;

    @BeforeAll
    static void setup() {
        api = new WynncraftAPI();
    }

    @Test
    public void testMapLocations() {
        List<MapLocation> mapLocations = api.map().getMapLocations();
        Assertions.assertNotNull(mapLocations);
        Assertions.assertFalse(mapLocations.isEmpty());
    }

    @Test
    public void testPlayerLocations() {
        List<PlayerLocation> playerLocations = api.map().getPlayerLocations();
        Assertions.assertNotNull(playerLocations);
        Assertions.assertFalse(playerLocations.isEmpty());
    }

    @Test
    public void testQuestCount() {
        int questCount = api.map().getQuestCount();
        Assertions.assertTrue(questCount > 0);
    }
}
