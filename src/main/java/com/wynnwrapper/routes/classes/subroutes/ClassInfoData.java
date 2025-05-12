package com.wynnwrapper.routes.classes.subroutes;

import com.wynnwrapper.core.APIHelper;
import com.wynnwrapper.core.APIRequest;

public class ClassInfoData extends APIRequest {
    static final String route = "/classes";

    public ClassInfoData(APIHelper apiHelper, String className) {
        super(apiHelper,  apiHelper.buildURL(route + "/" + className));
    }
}
