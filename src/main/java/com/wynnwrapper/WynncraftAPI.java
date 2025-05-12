package com.wynnwrapper;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.wynnwrapper.core.APIHelper;
import com.wynnwrapper.core.RateLimiter;
import com.wynnwrapper.data.abilityaspects.*;
import com.wynnwrapper.data.leaderboard.LeaderboardDeserializer;
import com.wynnwrapper.data.leaderboard.character.CharacterLeaderboard;
import com.wynnwrapper.data.leaderboard.gamemode.GamemodeLeaderboard;
import com.wynnwrapper.data.leaderboard.guild.GuildLeaderboard;
import com.wynnwrapper.data.leaderboard.player.PlayerLeaderboard;
import com.wynnwrapper.data.leaderboard.raid.GuildRaidLeaderboard;
import com.wynnwrapper.data.leaderboard.raid.PlayerRaidLeaderboard;
import com.wynnwrapper.data.player.DetailedPlayer;
import com.wynnwrapper.data.player.Player;
import com.wynnwrapper.data.player.PlayerGlobalData;
import com.wynnwrapper.data.player.ability.PlayerAbility;
import com.wynnwrapper.data.player.ability.PlayerAbilityConnector;
import com.wynnwrapper.data.player.ability.PlayerAbilityEntry;
import com.wynnwrapper.data.player.character.Character;
import com.wynnwrapper.data.player.character.DetailedCharacter;
import com.wynnwrapper.data.search.Item;
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
import java.util.List;

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
                .registerTypeAdapter(Player.class, new Player.PlayerDeserializer())
                .registerTypeAdapter(PlayerGlobalData.class, new PlayerGlobalData.PlayerGlobalDataDeserializer())
                .registerTypeAdapter(DetailedPlayer.class, new DetailedPlayer.DetailedPlayerDeserializer())
                .registerTypeAdapter(DetailedCharacter.class, new DetailedCharacter.DetailedPlayerCharacterDeserializer())
                .registerTypeAdapter(Character.class, new Character.PlayerCharacterDeserializer())
                .registerTypeAdapter(PlayerAbility.class, new PlayerAbility.PlayerAbilityDeserializer())
                .registerTypeAdapter(PlayerAbilityConnector.class, new PlayerAbilityConnector.PlayerAbilityConnectorDeserializer())
                .registerTypeAdapter(PlayerAbilityEntry.class, new PlayerAbilityEntry.PlayerAbilityMapEntryDeserializer())
                .registerTypeAdapter(PlayerAbility.class, new PlayerAbility.PlayerAbilityDeserializer())
                .registerTypeAdapter(Date.class, new DateTimeDeserializer())
                .registerTypeAdapter(AbilityTree.class, new AbilityTree.AbilityTreeDeserializer())
                .registerTypeAdapter(AbilityTreeArchetype.class, new AbilityTreeArchetype.AbilityTreeArchetypeDeserializer())
                .registerTypeAdapter(AbilityTreeAbility.class, new AbilityTreeAbility.AbilityTreeAbilityDeserializer())
                .registerTypeAdapter(AbilityMap.class, new AbilityMap.AbilityMapDeserializer())
                .registerTypeAdapter(AbilityMapEntry.class, new AbilityMapEntry.AbilityMapEntryDeserializer())
                .registerTypeAdapter(AspectsList.class, new AspectsList.AspectListDeserializer())
                .registerTypeAdapter(Item.Identification.class, new Item.Identification.IdentificationDeserializer())
                .registerTypeAdapter(new TypeToken<List<PlayerLeaderboard>>() {
                }.getType(), new LeaderboardDeserializer<PlayerLeaderboard>())
                .registerTypeAdapter(new TypeToken<List<GuildLeaderboard>>() {
                }.getType(), new LeaderboardDeserializer<GuildLeaderboard>())
                .registerTypeAdapter(new TypeToken<List<GuildRaidLeaderboard>>() {
                }.getType(), new LeaderboardDeserializer<GuildRaidLeaderboard>())
                .registerTypeAdapter(new TypeToken<List<PlayerRaidLeaderboard>>() {
                }.getType(), new LeaderboardDeserializer<PlayerRaidLeaderboard>())
                .registerTypeAdapter(new TypeToken<List<GuildLeaderboard>>() {
                }.getType(), new LeaderboardDeserializer<GuildLeaderboard>())
                .registerTypeAdapter(new TypeToken<List<GamemodeLeaderboard>>() {
                }.getType(), new LeaderboardDeserializer<GamemodeLeaderboard>())
                .registerTypeAdapter(new TypeToken<List<CharacterLeaderboard>>() {
                }.getType(), new LeaderboardDeserializer<CharacterLeaderboard>())
                .create();

        // Initialize the APIHelper with the base URL and timeout
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

    public GuildRoute guild() {
        return guildRoute;
    }
}
