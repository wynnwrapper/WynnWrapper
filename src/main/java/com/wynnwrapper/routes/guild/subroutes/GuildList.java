package com.wynnwrapper.routes.guild.subroutes;

import com.wynnwrapper.core.APIHelper;
import com.wynnwrapper.core.APIRequest;

public class GuildList extends APIRequest {

    private static final String route = "guild/list/guild";

    public GuildList(APIHelper apiHelper, String identifier) {
        super(apiHelper, apiHelper.buildURL(route + identifier));
    }
}
