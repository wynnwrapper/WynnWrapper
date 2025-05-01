package com.wynnwrapper.routes.guild;

import com.google.gson.reflect.TypeToken;
import com.wynnwrapper.core.APIHelper;
import com.wynnwrapper.data.guild.Guild;
import com.wynnwrapper.data.guild.GuildMetadata;
import com.wynnwrapper.data.guild.Territory;
import com.wynnwrapper.routes.guild.subroutes.GuildList;
import com.wynnwrapper.routes.guild.subroutes.GuildStats;
import com.wynnwrapper.routes.guild.subroutes.GuildTerritoryList;

import java.lang.reflect.Type;
import java.util.Map;

public class GuildRoute {
    private final APIHelper apiHelper;

    public GuildRoute(APIHelper apiHelper) {
        this.apiHelper = apiHelper;
    }

    public Guild guildStats(String guildName) {
        GuildStats subRoute = new GuildStats(apiHelper, guildName, false);
        return subRoute.getResponse(Guild.class);
    }

    public Guild guildStatsByPrefix(String guildPrefix) {
        GuildStats subRoute = new GuildStats(apiHelper, guildPrefix, true);
        return subRoute.getResponse(Guild.class);
    }

    public Map<String, Territory> territoryList() {
        GuildTerritoryList subRoute = new GuildTerritoryList(apiHelper);
        Type type = new TypeToken<Map<String, Territory>>() {}.getType();
        return subRoute.getResponse(type);
    }

    public Map<String, GuildMetadata> guildListByName() {
        GuildList subRoute = new GuildList(apiHelper, "?Identifier=username");
        Type type = new TypeToken<Map<String, GuildMetadata>>() {}.getType();
        return subRoute.getResponse(type);
    }

    public Map<String, GuildMetadata> guildListByUUID() {
        GuildList subRoute = new GuildList(apiHelper, "?Identifier=uuid");
        Type type = new TypeToken<Map<String, GuildMetadata>>() {}.getType();
        return subRoute.getResponse(type);
    }
}