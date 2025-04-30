package com.wynnwrapper.routes.player.subroutes;

import com.wynnwrapper.core.APIHelper;
import com.wynnwrapper.core.APIRequest;

import java.util.UUID;

public class PlayerMainStats extends APIRequest {

    private static final String subRoute = "player/";

    public PlayerMainStats(APIHelper apiHelper, String name) {
        super(apiHelper, apiHelper.buildURL(subRoute + name));
    }

    public PlayerMainStats(APIHelper apiHelper, UUID uuid) {
        super(apiHelper, apiHelper.buildURL(subRoute + uuid.toString()));
    }

}
