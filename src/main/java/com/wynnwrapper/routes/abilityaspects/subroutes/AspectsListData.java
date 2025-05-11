package com.wynnwrapper.routes.abilityaspects.subroutes;

import com.wynnwrapper.core.APIHelper;
import com.wynnwrapper.core.APIRequest;

public class AspectsListData extends APIRequest {
    static final String route = "aspects/";

    public AspectsListData(APIHelper apiHelper, String classType) {
        super(apiHelper, apiHelper.buildURL(route + "/" + classType));
    }


}
