package com.wynnwrapper.routes.player.subroutes;


import com.wynnwrapper.core.APIHelper;
import com.wynnwrapper.core.APIRequest;

import java.util.UUID;

public class PlayerCharacterAbilityMap extends APIRequest {

    private static final String subRoute = "player/{value}/characters/{character}/abilities";

    public PlayerCharacterAbilityMap(APIHelper apiHelper, String playerName, UUID characterUUID) {
        super(apiHelper, apiHelper.buildURL(subRoute.replace("{value}", playerName).replace("{character}", characterUUID.toString())));
    }

    public PlayerCharacterAbilityMap(APIHelper apiHelper, UUID playerName, UUID characterUUID) {
        super(apiHelper, apiHelper.buildURL(subRoute.replace("{value}", playerName.toString()).replace("{character}", characterUUID.toString())));
    }

}
