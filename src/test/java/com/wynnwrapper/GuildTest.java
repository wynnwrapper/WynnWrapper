package com.wynnwrapper;

import com.wynnwrapper.data.guild.Guild;
import com.wynnwrapper.data.guild.GuildMetadata;
import com.wynnwrapper.data.guild.Territory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Map;

public class GuildTest {

    static WynncraftAPI api;

    @BeforeAll
    static void setup() {
        api = new WynncraftAPI();
    }

    @Test
    void testGuildStats() {
        Guild guild = api.guild().guildStatsByPrefix("SEQ");
        Assertions.assertEquals(guild.name(), "Sequoia");

        Guild guild2 = api.guild().guildStats("Sequoia");
        Assertions.assertEquals(guild2.prefix(), "SEQ");
    }

    @Test
    void testTerritoryList() {
        Map<String, Territory> territoryList = api.guild().territoryList();
        Assertions.assertNotNull(territoryList);
    }

    @Test
    void testGuildList() {
        Map<String, GuildMetadata> guildList = api.guild().guildListByName();
        Assertions.assertNotNull(guildList);

        Map<String, GuildMetadata> guildList2 = api.guild().guildListByUUID();
        Assertions.assertNotNull(guildList2);
    }

}
