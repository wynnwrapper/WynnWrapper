package com.wynnwrapper;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.wynnwrapper.core.APIHelper;
import com.wynnwrapper.core.RateLimiter;
import com.wynnwrapper.data.player.WynncraftPlayer;
import com.wynnwrapper.routes.abilityaspects.AbilityAspectsRoute;
import com.wynnwrapper.routes.classes.ClassesRoute;
import com.wynnwrapper.routes.guild.GuildRoute;
import com.wynnwrapper.routes.item.ItemRoute;
import com.wynnwrapper.routes.leaderboard.LeaderboardRoute;
import com.wynnwrapper.routes.map.MapRoute;
import com.wynnwrapper.routes.news.NewsRoute;
import com.wynnwrapper.routes.player.PlayerRoute;
import com.wynnwrapper.routes.search.SearchRoute;
import com.wynnwrapper.utils.DateTimeDeserializer;
import lombok.Getter;

import java.util.Date;

public class WynncraftAPI {

    private APIHelper helper;
    private String baseURL = "https://api.wynncraft.com/v3";
    private int timeout = 10000;

    @Getter
    private final String version = "0.1.0";

    /* Routes */
    private AbilityAspectsRoute abilityAspectsRoute;
    private ClassesRoute classesRoute;
    private ItemRoute itemRoute;
    private LeaderboardRoute leaderboardRoute;
    private MapRoute mapRoute;
    private NewsRoute newsRoute;
    private PlayerRoute playerRoute;
    private SearchRoute searchRoute;
    private GuildRoute guildRoute;

    public WynncraftAPI() {
        Gson gson = new GsonBuilder().serializeNulls().disableHtmlEscaping()
                .registerTypeAdapter(WynncraftPlayer.class, new WynncraftPlayer.WynncraftPlayerDeserializer())
                .registerTypeAdapter(Date.class, new DateTimeDeserializer()).create();
        RateLimiter rateLimiter = new RateLimiter();
        this.helper = new APIHelper(gson, rateLimiter, baseURL, version, timeout);

        // Initialize routes
        this.abilityAspectsRoute = new AbilityAspectsRoute(helper);
        this.classesRoute = new ClassesRoute(helper);
        this.itemRoute = new ItemRoute(helper);
        this.leaderboardRoute = new LeaderboardRoute(helper);
        this.mapRoute = new MapRoute(helper);
        this.newsRoute = new NewsRoute(helper);
        this.playerRoute = new PlayerRoute(helper);
        this.searchRoute = new SearchRoute(helper);
        this.guildRoute = new GuildRoute(helper);
    }

    public AbilityAspectsRoute abilityAspects() {
        return abilityAspectsRoute;
    }

    public ClassesRoute classes() {
        return classesRoute;
    }

    public ItemRoute items() {
        return itemRoute;
    }

    public LeaderboardRoute leaderboard() {
        return leaderboardRoute;
    }

    public MapRoute map() {
        return mapRoute;
    }

    public NewsRoute news() {
        return newsRoute;
    }

    public PlayerRoute player() {
        return playerRoute;
    }

    public SearchRoute search() {
        return searchRoute;
    }

    public GuildRoute guild() { return guildRoute; }
}
