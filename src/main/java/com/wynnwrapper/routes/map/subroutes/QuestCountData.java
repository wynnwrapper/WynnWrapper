package com.wynnwrapper.routes.map.subroutes;

import com.wynnwrapper.core.APIHelper;
import com.wynnwrapper.core.APIRequest;

public class QuestCountData extends APIRequest {
    static final String route = "map/quests";

    public QuestCountData(APIHelper apiHelper) {
        super(apiHelper, apiHelper.buildURL(route));
    }
}
