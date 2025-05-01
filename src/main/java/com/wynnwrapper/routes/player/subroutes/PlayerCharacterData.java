package com.wynnwrapper.routes.player.subroutes;

import com.wynnwrapper.core.APIHelper;
import com.wynnwrapper.core.APIRequest;

import java.util.UUID;

public class PlayerCharacterData extends APIRequest {

    private static final String subRoute = "player/{value}/characters/{character}";
    
    public PlayerCharacterData(APIHelper apiHelper, String playerName, UUID characterUUID) {
        super(apiHelper, apiHelper.buildURL(subRoute.replace("{value}", playerName).replace("{character}", characterUUID.toString())));
    }

    public PlayerCharacterData(APIHelper apiHelper, UUID playerName, UUID characterUUID) {
        super(apiHelper, apiHelper.buildURL(subRoute.replace("{value}", playerName.toString()).replace("{character}", characterUUID.toString())));
    }

}