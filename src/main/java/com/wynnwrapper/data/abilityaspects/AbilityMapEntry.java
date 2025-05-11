package com.wynnwrapper.data.abilityaspects;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;


public record AbilityMapEntry (
        String type,
        int[] coordinates,
        Meta meta,
        List<String> family
){

    public record Meta (
            Object icon, //can be either a String or an IconValue
            Integer page,
            String id){ }

    public record IconValue (
        String id,
        String name,
        String customModelData,
        String format){ }



    @Override
    public String toString() {
        return "AbilityMapEntry{" +
                "type='" + type + '\'' +
                ", coordinates=" + coordinates[0] + ", " + coordinates[1] +
                ", meta=" + meta +
                ", family=" + family +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (AbilityMapEntry) obj;
        return this.type.equals(that.type) &&
                this.coordinates[0] == that.coordinates[0] &&
                this.coordinates[1] == that.coordinates[1] &&
                this.meta.equals(that.meta) &&
                this.family.equals(that.family);
    }


    public static class AbilityMapEntryDeserializer implements JsonDeserializer<AbilityMapEntry> {
        @Override
        public AbilityMapEntry deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
            JsonObject obj = json.getAsJsonObject();

            String type = obj.get("type").getAsString();

            com.google.gson.JsonObject coordsObj = obj.getAsJsonObject("coordinates");
            int[] coordinates = new int[2];
            coordinates[0] = coordsObj.get("x").getAsInt();
            coordinates[1] = coordsObj.get("y").getAsInt();

            Meta meta = context.deserialize(obj.get("meta"), Meta.class);

            List<String> family = context.deserialize(obj.get("family"), new TypeToken<List<String>>() {}.getType());

            return new AbilityMapEntry(type, coordinates, meta, family);
        }
    }

}