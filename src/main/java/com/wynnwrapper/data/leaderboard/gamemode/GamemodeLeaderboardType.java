package com.wynnwrapper.data.leaderboard.gamemode;

public enum GamemodeLeaderboardType {
    CRAFTSMAN_CONTENT("craftsmanContent"),
    HUIC_CONTENT("huicContent"),
    IRONMAN_CONTENT("ironmanContent"),
    ULTIMATE_IRONMAN_CONTENT("ultimateIronmanContent"),
    HARDCORE_CONTENT("hardcoreContent"),
    HARDCORE_LEGACY_LEVEL("hardcoreLegacyLevel"),
    HUICH_CONTENT("huichContent"),
    HIC_CONTENT("hicContent"),
    HICH_CONTENT("hichContent"),
    ;

    private String apiName;

    GamemodeLeaderboardType(String apiName) {
        this.apiName = apiName;
    }

    public String apiName() {
        return apiName;
    }
}
