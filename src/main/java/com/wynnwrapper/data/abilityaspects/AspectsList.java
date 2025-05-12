package com.wynnwrapper.data.abilityaspects;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

public record AspectsList(
        Map<String, Aspect> aspects
) {
    public record Aspect(
            String name,
            Icon icon,
            String rarity,
            String requiredClass,
            Map<String, Tier> tiers
    ) {
        @Override
        public String toString() {
            return "Aspect{" +
                    "name='" + name + '\'' +
                    ", icon=" + icon +
                    ", rarity='" + rarity + '\'' +
                    ", requiredClass='" + requiredClass + '\'' +
                    ", tiers=" + tiers +
                    '}';
        }
    }

    public record Icon(
            Object value, // can be either a String or an IconDetails
            String format
    ) {
        @Override
        public String toString() {
            return "Icon{" +
                    "value=" + value +
                    ", format='" + format + '\'' +
                    '}';
        }
    }

    public record IconDetails(
            String id,
            String name,
            String customModelData
    ) {
        @Override
        public String toString() {
            return "IconDetails{" +
                    "id='" + id + '\'' +
                    ", name='" + name + '\'' +
                    ", customModelData='" + customModelData + '\'' +
                    '}';
        }
    }

    public record Tier(
            int threshold,
            List<String> description
    ) {
        @Override
        public String toString() {
            return "Tier{" +
                    "threshold=" + threshold +
                    ", description=" + description +
                    '}';
        }
    }


    @Override
    public String toString() {
        return "AspectsList{" +
                "aspects=" + aspects +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (AspectsList) obj;
        return this.aspects.equals(that.aspects);
    }


    public static class AspectListDeserializer implements JsonDeserializer<AspectsList> {
        @Override
        public AspectsList deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) {
            Map<String, Aspect> aspects = context.deserialize(json, new TypeToken<Map<String, Aspect>>() {}.getType());
            return new AspectsList(aspects);
        }
    }

}