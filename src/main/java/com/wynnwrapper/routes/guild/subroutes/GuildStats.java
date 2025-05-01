package com.wynnwrapper.routes.guild.subroutes;

import com.wynnwrapper.core.APIHelper;
import com.wynnwrapper.core.APIRequest;


public class GuildStats extends APIRequest {

    private static final String subRoute = "guild/";

    public GuildStats(APIHelper apiHelper, String name, boolean isPrefix) {
        super(apiHelper, apiHelper.buildURL(subRoute + (isPrefix ? "prefix/" : "") + name ));
    }
}
