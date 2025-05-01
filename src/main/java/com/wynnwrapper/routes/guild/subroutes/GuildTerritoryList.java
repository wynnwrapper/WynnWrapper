package com.wynnwrapper.routes.guild.subroutes;

import com.wynnwrapper.core.APIHelper;
import com.wynnwrapper.core.APIRequest;

public class GuildTerritoryList extends APIRequest {
    private static final String route = "guild/list/territory";

    public GuildTerritoryList(APIHelper apiHelper) {
        super(apiHelper, apiHelper.buildURL(route));
    }
}