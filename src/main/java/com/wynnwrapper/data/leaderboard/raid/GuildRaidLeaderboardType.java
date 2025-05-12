package com.wynnwrapper.data.leaderboard.raid;

public enum GuildRaidLeaderboardType {

    COLOSSUS_SR_GUILDS("colossusSrGuilds"),
    NAMELESS_SR_GUILDS("namelessSrGuilds"),
    ORPHION_SR_GUILDS("orphionSrGuilds"),
    GROOTSLANG_SR_GUILDS("grootslangSrGuilds");

    private final String apiName;

    GuildRaidLeaderboardType(String apiName) {
        this.apiName = apiName;
    }
    
    public String apiName() {
        return apiName;
    }
}
