package com.wynnwrapper.routes.player;

import com.google.gson.reflect.TypeToken;
import com.wynnwrapper.core.APIHelper;
import com.wynnwrapper.data.player.DetailedPlayer;
import com.wynnwrapper.data.player.Player;
import com.wynnwrapper.data.player.ability.PlayerAbilityEntry;
import com.wynnwrapper.data.player.character.Character;
import com.wynnwrapper.data.player.character.DetailedCharacter;
import com.wynnwrapper.routes.player.subroutes.*;

import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class PlayerRoute {
    private final APIHelper apiHelper;

    public PlayerRoute(APIHelper apiHelper) {
        this.apiHelper = apiHelper;
    }


    public Player playerStats(String playerName) {
        PlayerMainStats subRoute = new PlayerMainStats(apiHelper, playerName);
        return subRoute.getResponse(Player.class);
    }

    public Player playerStats(UUID playerUUID) {
        PlayerMainStats subRoute = new PlayerMainStats(apiHelper, playerUUID);
        return subRoute.getResponse(Player.class);
    }

    public DetailedPlayer playerDetailedStats(String playerName) {
        PlayerDetailedStats subRoute = new PlayerDetailedStats(apiHelper, playerName);
        return subRoute.getResponse(DetailedPlayer.class);
    }

    public DetailedPlayer playerDetailedStats(UUID playerUUID) {
        PlayerDetailedStats subRoute = new PlayerDetailedStats(apiHelper, playerUUID);
        return subRoute.getResponse(DetailedPlayer.class);
    }

    public Map<UUID, Character> playerCharacterList(String playerName) {
        PlayerCharacterList subRoute = new PlayerCharacterList(apiHelper, playerName);
        Type type = new TypeToken<Map<UUID, Character>>() {
        }.getType();
        return subRoute.getResponse(type);
    }

    public Map<UUID, Character> playerCharacterList(UUID playerUUID) {
        PlayerCharacterList subRoute = new PlayerCharacterList(apiHelper, playerUUID);
        Type type = new TypeToken<Map<UUID, Character>>() {
        }.getType();
        return subRoute.getResponse(type);
    }

    public DetailedCharacter playerCharacter(String playerName, UUID characterUUID) {
        PlayerCharacterData subRoute = new PlayerCharacterData(apiHelper, playerName, characterUUID);
        return subRoute.getResponse(DetailedCharacter.class);
    }

    public DetailedCharacter playerCharacter(UUID playerUUID, UUID characterUUID) {
        PlayerCharacterData subRoute = new PlayerCharacterData(apiHelper, playerUUID, characterUUID);

        return subRoute.getResponse(DetailedCharacter.class);
    }

    public List<PlayerAbilityEntry> playerCharacterAbilityMap(String playerName, UUID characterUUID) {
        PlayerCharacterAbilityMap subRoute = new PlayerCharacterAbilityMap(apiHelper, playerName, characterUUID);
        Type type = new TypeToken<List<PlayerAbilityEntry>>() {
        }.getType();
        return subRoute.getResponse(type);
    }

    public List<PlayerAbilityEntry> playerCharacterAbilityMap(UUID playerUUID, UUID characterUUID) {
        PlayerCharacterAbilityMap subRoute = new PlayerCharacterAbilityMap(apiHelper, playerUUID, characterUUID);
        Type type = new TypeToken<List<PlayerAbilityEntry>>() {
        }.getType();
        return subRoute.getResponse(type);
    }
}
