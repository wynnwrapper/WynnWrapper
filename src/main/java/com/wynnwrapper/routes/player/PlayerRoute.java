package com.wynnwrapper.routes.player;

import com.wynnwrapper.core.APIHelper;
import com.wynnwrapper.data.player.WynncraftPlayer;
import com.wynnwrapper.routes.player.subroutes.PlayerMainStats;

import java.util.UUID;

public class PlayerRoute {
    private final APIHelper apiHelper;

    public PlayerRoute(APIHelper apiHelper) {
        this.apiHelper = apiHelper;
    }


    public WynncraftPlayer playerStats(String playerName) {
        PlayerMainStats subRoute = new PlayerMainStats(apiHelper, playerName);
        return subRoute.getResponse(WynncraftPlayer.class);
    }

    public WynncraftPlayer playerStats(UUID playerUUID) {
        PlayerMainStats subRoute = new PlayerMainStats(apiHelper, playerUUID);
        return subRoute.getResponse(WynncraftPlayer.class);
    }
}
