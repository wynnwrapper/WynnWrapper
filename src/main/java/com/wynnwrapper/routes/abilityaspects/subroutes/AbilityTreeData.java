package com.wynnwrapper.routes.abilityaspects.subroutes;

import com.wynnwrapper.core.APIHelper;
import com.wynnwrapper.core.APIRequest;

public class AbilityTreeData extends APIRequest {

    private static final String route = "ability/tree";

    public AbilityTreeData(APIHelper apiHelper, String classType) {
        super(apiHelper, apiHelper.buildURL(route + "/" + classType));
    }
}
