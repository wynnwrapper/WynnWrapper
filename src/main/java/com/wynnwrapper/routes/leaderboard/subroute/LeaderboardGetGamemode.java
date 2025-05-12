package com.wynnwrapper.routes.leaderboard.subroute;

import com.wynnwrapper.core.APIHelper;
import com.wynnwrapper.core.APIRequest;
import com.wynnwrapper.data.leaderboard.gamemode.GamemodeLeaderboardType;

public class LeaderboardGetGamemode extends APIRequest {

    private static final String subRoute = "leaderboards/{value}?resultLimit={limit}";

    public LeaderboardGetGamemode(APIHelper apiHelper, GamemodeLeaderboardType type, int limit) {
        super(apiHelper, apiHelper.buildURL(subRoute.replace("{value}", type.apiName()).replace("{limit}", String.valueOf(limit))));
    }

}