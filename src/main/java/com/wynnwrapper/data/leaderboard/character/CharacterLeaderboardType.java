package com.wynnwrapper.data.leaderboard.character;

public enum CharacterLeaderboardType {
    COMBAT_SOLO_LEVEL("combatSoloLevel"),
    TOTAL_SOLO_LEVEL("totalSoloLevel"),
    WOODCUTTING_LEVEL("woodcuttingLevel"),
    PLAYER_CONTENT("playerContent"),
    HUNTED_CONTENT("huntedContent"),
    MINING_LEVEL("miningLevel"),
    FISHING_LEVEL("fishingLevel"),
    FARMING_LEVEL("farmingLevel"),
    ALCHEMISM_LEVEL("alchemismLevel"),
    ARMOURING_LEVEL("armouringLevel"),
    COOKING_LEVEL("cookingLevel"),
    JEWELING_LEVEL("jewelingLevel"),
    SCRIBING_LEVEL("scribingLevel"),
    TAILORING_LEVEL("tailoringLevel"),
    WEAPONSMITHING_LEVEL("weaponsmithingLevel"),
    WOODWORKING_LEVEL("woodworkingLevel");


    private final String apiName;

    CharacterLeaderboardType(String apiName) {
        this.apiName = apiName;
    }

    public String apiName() {
        return apiName;
    }
}
