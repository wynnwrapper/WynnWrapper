package com.wynnwrapper.data.leaderboard.player;

public enum PlayerLeaderboardType {
    PROFESSIONS_GLOBAL_LEVEL("professionsGlobalLevel"),
    COMBAT_GLOBAL_LEVEL("combatGlobalLevel"),
    TOTAL_GLOBAL_LEVEL("totalGlobalLevel"),
    GLOBAL_PLAYER_CONTENT("globalPlayerContent"),
    GROOTSLANG_COMPLETION("grootslangCompletion"),
    COLOSSUS_COMPLETION("colossusCompletion"),
    ORPHION_COMPLETION("orphionCompletion"),
    NAMELESS_COMPLETION("namelessCompletion"),
    WARS_COMPLETION("warsCompletion");

    private final String apiName;

    PlayerLeaderboardType(String apiName) {
        this.apiName = apiName;
    }
    
    public String apiName() {
        return apiName;
    }
}
