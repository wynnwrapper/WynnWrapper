package com.wynnwrapper.data.leaderboard.guild;

public enum GuildLeaderboardType {

    GUILD_LEVEL("guildLevel"),
    GUILD_TERRITORIES("guildTerritories"),
    GUILD_WARS("guildWars");


    private String apiName;

    GuildLeaderboardType(String apiName) {
        this.apiName = apiName;
    }

    public String apiName() {
        return apiName;
    }

}
