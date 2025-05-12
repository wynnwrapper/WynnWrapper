package com.wynnwrapper.routes.leaderboard.subroute;

import com.wynnwrapper.core.APIHelper;
import com.wynnwrapper.core.APIRequest;
import com.wynnwrapper.data.leaderboard.raid.PlayerRaidLeaderboardType;

public class LeaderboardGetPlayerRaid extends APIRequest {

    private static final String subRoute = "leaderboards/{value}?resultLimit={limit}";

    public LeaderboardGetPlayerRaid(APIHelper apiHelper, PlayerRaidLeaderboardType type, int limit) {
        super(apiHelper, apiHelper.buildURL(subRoute.replace("{value}", type.apiName()).replace("{limit}", String.valueOf(limit))));
    }

}