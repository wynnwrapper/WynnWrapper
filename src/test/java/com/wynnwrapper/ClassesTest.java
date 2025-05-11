package com.wynnwrapper;

import com.wynnwrapper.data.classes.ClassInfo;
import com.wynnwrapper.data.classes.ClassMetaData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Map;

public class ClassesTest {

    static WynncraftAPI api;

    @BeforeAll
    static void setup() {
        api = new WynncraftAPI();
    }

    @Test
    public void testClassList() {
        Map<String, ClassMetaData> classList = api.classes().getClassList();
        Assertions.assertNotNull(classList);
    }

    @Test
    public void testClassInfo() {
        ClassInfo classInfo = api.classes().getClassInfo("archer");
        Assertions.assertNotNull(classInfo);
    }
}
