package com.wynnwrapper.routes.map.subroutes;

import com.wynnwrapper.core.APIHelper;
import com.wynnwrapper.core.APIRequest;

public class PlayerLocationsData extends APIRequest {
    static final String route = "map/locations/player";

    public PlayerLocationsData(APIHelper apiHelper) {
        super(apiHelper, apiHelper.buildURL(route));
    }
}
