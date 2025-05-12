package com.wynnwrapper.routes.classes;

import com.google.gson.reflect.TypeToken;
import com.wynnwrapper.core.APIHelper;
import com.wynnwrapper.data.classes.ClassInfo;
import com.wynnwrapper.data.classes.ClassMetaData;
import com.wynnwrapper.routes.classes.subroutes.ClassInfoData;
import com.wynnwrapper.routes.classes.subroutes.ClassListData;

import java.util.List;
import java.util.Map;

public class ClassesRoute {
    private final APIHelper apiHelper;

    public ClassesRoute(APIHelper apiHelper) {
        this.apiHelper = apiHelper;
    }

    public Map<String, ClassMetaData> getClassList() {
        ClassListData subroute = new ClassListData(apiHelper);
        return subroute.getResponse(new TypeToken<Map<String, ClassMetaData>>() {}.getType());
    }

    public ClassInfo getClassInfo(String className) {
        ClassInfoData subroute = new ClassInfoData(apiHelper, className);
        return subroute.getResponse(ClassInfo.class);
    }
}
