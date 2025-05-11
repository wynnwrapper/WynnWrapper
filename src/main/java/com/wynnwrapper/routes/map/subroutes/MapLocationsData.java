package com.wynnwrapper.routes.map.subroutes;

import com.wynnwrapper.core.APIHelper;
import com.wynnwrapper.core.APIRequest;

public class MapLocationsData extends APIRequest {
    static final String route = "map/locations/markers";

    public MapLocationsData(APIHelper apiHelper) {
        super(apiHelper, apiHelper.buildURL(route));
    }

}
