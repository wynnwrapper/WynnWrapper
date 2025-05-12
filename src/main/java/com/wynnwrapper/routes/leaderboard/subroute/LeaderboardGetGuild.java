package com.wynnwrapper.routes.leaderboard.subroute;

import com.wynnwrapper.core.APIHelper;
import com.wynnwrapper.core.APIRequest;
import com.wynnwrapper.data.leaderboard.guild.GuildLeaderboardType;

public class LeaderboardGetGuild extends APIRequest {

    private static final String subRoute = "leaderboards/{value}?resultLimit={limit}";

    public LeaderboardGetGuild(APIHelper apiHelper, GuildLeaderboardType type, int limit) {
        super(apiHelper, apiHelper.buildURL(subRoute.replace("{value}", type.apiName()).replace("{limit}", String.valueOf(limit))));
    }

}