package com.wynnwrapper.data.player;

import java.util.Map;

public record WynncraftPlayerGlobalData(
        int wars,
        int totalLevels,
        int killedMobs,
        int chestsFound,
        int dungeonsTotal,
        Map<String, Integer> dungeonsCompletionsList,
        int raidsTotal,
        Map<String, Integer> raidsCompletionsList,
        int completedQuests,
        int pvpKills,
        int pvpDeaths) {}
