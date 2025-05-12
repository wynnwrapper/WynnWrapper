package com.wynnwrapper.routes.map;

import com.google.gson.reflect.TypeToken;
import com.wynnwrapper.core.APIHelper;
import com.wynnwrapper.data.map.MapLocation;
import com.wynnwrapper.data.map.PlayerLocation;
import com.wynnwrapper.routes.map.subroutes.MapLocationsData;
import com.wynnwrapper.routes.map.subroutes.PlayerLocationsData;
import com.wynnwrapper.routes.map.subroutes.QuestCountData;

import java.util.List;

public class MapRoute {
    private final APIHelper apiHelper;

    public MapRoute(APIHelper apiHelper) {
        this.apiHelper = apiHelper;
    }

    public List<MapLocation> getMapLocations() {
        MapLocationsData subRoute = new MapLocationsData(apiHelper);
        return subRoute.getResponse(new TypeToken<List<MapLocation>>() {}.getType());
    }

    public List<PlayerLocation> getPlayerLocations() {
        PlayerLocationsData subRoute = new PlayerLocationsData(apiHelper);
        return subRoute.getResponse(new TypeToken<List<PlayerLocation>>() {}.getType());
    }

    public int getQuestCount() {
        QuestCountData subRoute = new QuestCountData(apiHelper);
        MapQuestCount mapQuestCount = subRoute.getResponse(MapQuestCount.class);

        return mapQuestCount.quests;
    }

    public record MapQuestCount (
            int quests
    ){ }
}
