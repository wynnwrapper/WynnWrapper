package com.wynnwrapper.routes.classes.subroutes;

import com.wynnwrapper.core.APIHelper;
import com.wynnwrapper.core.APIRequest;

public class ClassListData extends APIRequest {
    static final String route = "/classes";

    public ClassListData(APIHelper apiHelper) {
        super(apiHelper, apiHelper.buildURL(route));
    }
}
