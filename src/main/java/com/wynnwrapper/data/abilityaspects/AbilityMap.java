package com.wynnwrapper.data.abilityaspects;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

public record AbilityMap (
        List<List<AbilityMapEntry>> pages
){

    @Override
    public String toString() {
        return "AbilityMap{" +
                "pages=" + pages +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (AbilityMap) obj;
        return this.pages.equals(that.pages);
    }

    public static class AbilityMapDeserializer implements JsonDeserializer<AbilityMap> {
        @Override
        public AbilityMap deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
            Map<String, List<AbilityMapEntry>> pagesMap = context.deserialize(json, new TypeToken<Map<String, List<AbilityMapEntry>>>() {}.getType());

            List<List<AbilityMapEntry>> pages = pagesMap != null ? List.copyOf(pagesMap.values()) : null;
            return new AbilityMap(pages);
        }
    }

}