package com.wynnwrapper;

import com.wynnwrapper.data.leaderboard.character.CharacterLeaderboard;
import com.wynnwrapper.data.leaderboard.character.CharacterLeaderboardType;
import com.wynnwrapper.data.leaderboard.gamemode.GamemodeLeaderboard;
import com.wynnwrapper.data.leaderboard.gamemode.GamemodeLeaderboardType;
import com.wynnwrapper.data.leaderboard.guild.GuildLeaderboard;
import com.wynnwrapper.data.leaderboard.guild.GuildLeaderboardType;
import com.wynnwrapper.data.leaderboard.player.PlayerLeaderboard;
import com.wynnwrapper.data.leaderboard.player.PlayerLeaderboardType;
import com.wynnwrapper.data.leaderboard.raid.GuildRaidLeaderboard;
import com.wynnwrapper.data.leaderboard.raid.GuildRaidLeaderboardType;
import com.wynnwrapper.data.leaderboard.raid.PlayerRaidLeaderboard;
import com.wynnwrapper.data.leaderboard.raid.PlayerRaidLeaderboardType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;

public class LeaderboardTest {

    static WynncraftAPI api;

    @BeforeAll
    static void setup() {
        api = new WynncraftAPI();
    }

    @Test
    void testPlayerMainStats() {
        List<PlayerLeaderboard> leaderboard = api.leaderboard().player(PlayerLeaderboardType.TOTAL_GLOBAL_LEVEL, 100);
        Assertions.assertNotNull(leaderboard.get(0));
        Assertions.assertEquals(leaderboard.size(), 100);
    }

    @Test
    void testCharacterStats() {
        List<CharacterLeaderboard> leaderboard = api.leaderboard().character(CharacterLeaderboardType.COOKING_LEVEL, 100);
        Assertions.assertNotNull(leaderboard.get(0));
    }

    @Test
    void testGuildRaidStats() {
        List<GuildRaidLeaderboard> leaderboard = api.leaderboard().raidGuild(GuildRaidLeaderboardType.NAMELESS_SR_GUILDS, 100);
        Assertions.assertNotNull(leaderboard.get(0));
    }

    @Test
    void testPlayerRaidStats() {
        List<PlayerRaidLeaderboard> leaderboard = api.leaderboard().raidPlayer(PlayerRaidLeaderboardType.NAMELESS_SR_PLAYERS, 100);
        Assertions.assertNotNull(leaderboard.get(0));
    }

    @Test
    void testGamemodeStats() {
        List<GamemodeLeaderboard> leaderboard = api.leaderboard().gamemode(GamemodeLeaderboardType.CRAFTSMAN_CONTENT, 100);
        Assertions.assertNotNull(leaderboard.get(0));
    }

    @Test
    void testGuildStats() {
        List<GuildLeaderboard> leaderboard = api.leaderboard().guild(GuildLeaderboardType.GUILD_LEVEL, 100);
        Assertions.assertNotNull(leaderboard.get(0));
    }
}
