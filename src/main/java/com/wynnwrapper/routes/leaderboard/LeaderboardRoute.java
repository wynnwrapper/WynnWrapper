package com.wynnwrapper.routes.leaderboard;

import com.google.gson.reflect.TypeToken;
import com.wynnwrapper.core.APIHelper;
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
import com.wynnwrapper.routes.leaderboard.subroute.*;

import java.util.List;

public class LeaderboardRoute {
    private final APIHelper apiHelper;

    public LeaderboardRoute(APIHelper apiHelper) {
        this.apiHelper = apiHelper;
    }

    public List<PlayerLeaderboard> player(PlayerLeaderboardType type, int limit) {
        LeaderboardGetPlayer subRoute = new LeaderboardGetPlayer(apiHelper, type, limit);
        return subRoute.getResponse(new TypeToken<List<PlayerLeaderboard>>() {
        }.getType());
    }

    public List<CharacterLeaderboard> character(CharacterLeaderboardType type, int limit) {
        LeaderboardGetCharacter subRoute = new LeaderboardGetCharacter(apiHelper, type, limit);
        return subRoute.getResponse(new TypeToken<List<CharacterLeaderboard>>() {
        }.getType());
    }

    public List<GuildLeaderboard> guild(GuildLeaderboardType type, int limit) {
        LeaderboardGetGuild subRoute = new LeaderboardGetGuild(apiHelper, type, limit);
        return subRoute.getResponse(new TypeToken<List<GuildLeaderboard>>() {
        }.getType());
    }

    public List<GamemodeLeaderboard> gamemode(GamemodeLeaderboardType type, int limit) {
        LeaderboardGetGamemode subRoute = new LeaderboardGetGamemode(apiHelper, type, limit);
        return subRoute.getResponse(new TypeToken<List<GamemodeLeaderboard>>() {
        }.getType());
    }

    public List<PlayerRaidLeaderboard> raidPlayer(PlayerRaidLeaderboardType type, int limit) {
        LeaderboardGetPlayerRaid subRoute = new LeaderboardGetPlayerRaid(apiHelper, type, limit);
        return subRoute.getResponse(new TypeToken<List<PlayerRaidLeaderboard>>() {
        }.getType());
    }

    public List<GuildRaidLeaderboard> raidGuild(GuildRaidLeaderboardType type, int limit) {
        LeaderboardGetGuildRaid subRoute = new LeaderboardGetGuildRaid(apiHelper, type, limit);
        return subRoute.getResponse(new TypeToken<List<GuildRaidLeaderboard>>() {
        }.getType());
    }
}
