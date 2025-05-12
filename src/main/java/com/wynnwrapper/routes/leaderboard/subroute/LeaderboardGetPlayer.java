package com.wynnwrapper.routes.leaderboard.subroute;

import com.wynnwrapper.core.APIHelper;
import com.wynnwrapper.core.APIRequest;
import com.wynnwrapper.data.leaderboard.player.PlayerLeaderboardType;

public class LeaderboardGetPlayer extends APIRequest {

    private static final String subRoute = "leaderboards/{value}?resultLimit={limit}";

    public LeaderboardGetPlayer(APIHelper apiHelper, PlayerLeaderboardType type, int limit) {
        super(apiHelper, apiHelper.buildURL(subRoute.replace("{value}", type.apiName()).replace("{limit}", String.valueOf(limit))));
    }

}
