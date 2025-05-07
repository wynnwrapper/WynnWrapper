package com.wynnwrapper.routes.abilityaspects.subroutes;

import com.wynnwrapper.core.APIHelper;
import com.wynnwrapper.core.APIRequest;
import com.wynnwrapper.data.abilityaspects.enums.ClassType;

public class AbilityMapData extends APIRequest {

    private static final String route = "ability/map";

    public AbilityMapData(APIHelper apiHelper, String classType) {
        super(apiHelper, apiHelper.buildURL(route + "/" + classType));
    }
}