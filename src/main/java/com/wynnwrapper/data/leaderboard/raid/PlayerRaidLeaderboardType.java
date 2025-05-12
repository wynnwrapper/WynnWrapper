package com.wynnwrapper.data.leaderboard.raid;

public enum PlayerRaidLeaderboardType {
    GROOTSLANG_SR_PLAYERS("grootslangSrPlayers"),
    NAMELESS_SR_PLAYERS("namelessSrPlayers"),
    COLOSSUS_SR_PLAYERS("colossusSrPlayers"),
    ORPHION_SR_PLAYERS("orphionSrPlayers");

    private final String apiName;

    PlayerRaidLeaderboardType(String apiName) {
        this.apiName = apiName;
    }
    
    public String apiName() {
        return apiName;
    }
}
