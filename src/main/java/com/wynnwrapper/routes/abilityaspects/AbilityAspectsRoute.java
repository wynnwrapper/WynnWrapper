package com.wynnwrapper.routes.abilityaspects;

import com.wynnwrapper.core.APIHelper;
import com.wynnwrapper.data.abilityaspects.AbilityMap;
import com.wynnwrapper.data.abilityaspects.AbilityTree;
import com.wynnwrapper.data.abilityaspects.AspectsList;
import com.wynnwrapper.data.classes.ClassType;
import com.wynnwrapper.routes.abilityaspects.subroutes.AbilityMapData;
import com.wynnwrapper.routes.abilityaspects.subroutes.AbilityTreeData;
import com.wynnwrapper.routes.abilityaspects.subroutes.AspectsListData;

public class AbilityAspectsRoute {

    private final APIHelper apiHelper;

    public AbilityAspectsRoute(APIHelper apiHelper) {
        this.apiHelper = apiHelper;
    }

    public AbilityTree getAbilityTreeData(ClassType classType) {
        AbilityTreeData subRoute = new AbilityTreeData(apiHelper, classType.toString().toLowerCase());
        return subRoute.getResponse(AbilityTree.class);
    }

    public AbilityMap getAbilityMapData(ClassType classType) {
        AbilityMapData subRoute = new AbilityMapData(apiHelper, classType.toString().toLowerCase());
        return subRoute.getResponse(AbilityMap.class);
    }

    public AspectsList getAspectsListData(ClassType classType) {
        AspectsListData subRoute = new AspectsListData(apiHelper, classType.toString().toLowerCase());
        return subRoute.getResponse(AspectsList.class);
    }
}
