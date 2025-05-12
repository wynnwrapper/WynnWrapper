package com.wynnwrapper.routes.leaderboard.subroute;

import com.wynnwrapper.core.APIHelper;
import com.wynnwrapper.core.APIRequest;
import com.wynnwrapper.data.leaderboard.raid.GuildRaidLeaderboardType;

public class LeaderboardGetGuildRaid extends APIRequest {

    private static final String subRoute = "leaderboards/{value}?resultLimit={limit}";

    public LeaderboardGetGuildRaid(APIHelper apiHelper, GuildRaidLeaderboardType type, int limit) {
        super(apiHelper, apiHelper.buildURL(subRoute.replace("{value}", type.apiName()).replace("{limit}", String.valueOf(limit))));
    }

}