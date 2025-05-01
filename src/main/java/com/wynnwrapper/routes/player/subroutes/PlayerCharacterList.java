package com.wynnwrapper.routes.player.subroutes;

import com.wynnwrapper.core.APIHelper;
import com.wynnwrapper.core.APIRequest;

import java.util.UUID;

public class PlayerCharacterList extends APIRequest {

    private static final String subRoute = "player/{value}/characters";

    public PlayerCharacterList(APIHelper apiHelper, String name) {
        super(apiHelper, apiHelper.buildURL(subRoute.replace("{value}", name)));
    }

    public PlayerCharacterList(APIHelper apiHelper, UUID uuid) {
        super(apiHelper, apiHelper.buildURL(subRoute.replace("{value}", uuid.toString())));
    }

}