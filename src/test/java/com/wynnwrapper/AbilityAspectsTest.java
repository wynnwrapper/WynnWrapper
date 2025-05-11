package com.wynnwrapper;

import com.wynnwrapper.data.abilityaspects.AbilityMap;
import com.wynnwrapper.data.abilityaspects.AbilityTree;
import com.wynnwrapper.data.abilityaspects.AspectsList;
import com.wynnwrapper.data.abilityaspects.enums.ClassType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class AbilityAspectsTest {

    static WynncraftAPI api;

    @BeforeAll
    static void setup() {api = new WynncraftAPI();}

    @Test
    void testAbilityTree() {
        AbilityTree abilityTree = api.abilityAspects().getAbilityTreeData(ClassType.ARCHER);
        Assertions.assertNotNull(abilityTree);
    }

    @Test
    void testAbilityMap() {
        AbilityMap abilityMap = api.abilityAspects().getAbilityMapData(ClassType.WARRIOR);
        Assertions.assertNotNull(abilityMap);
    }

    @Test
    void testAspectsList(){
        AspectsList aspectsList = api.abilityAspects().getAspectsListData(ClassType.MAGE);
        Assertions.assertNotNull(aspectsList);
    }
}
