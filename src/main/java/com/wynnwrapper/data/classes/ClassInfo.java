package com.wynnwrapper.data.classes;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

public record ClassInfo(
        ClassType id,
       String name,
       String lore,
       int overallDifficulty,
       Map<ArchetypeID, Archetype> archetypes
) {

    public record Archetype(
            String name,
            int difficulty,
            int damage,
            int defense,
            int range,
            int speed
    ) { }

    @Override
    public String toString() {
        return "ClassInfo{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", lore='" + lore + '\'' +
                ", overallDifficulty=" + overallDifficulty +
                ", archetypes=" + archetypes +
                '}';
    }


    public static class ClassInfoDeserializer implements JsonDeserializer<ClassInfo> {
        @Override
        public ClassInfo deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws com.google.gson.JsonParseException {
            JsonObject obj = json.getAsJsonObject();
            ClassType id = obj.has("id") && !obj.get("id").isJsonNull() ? ClassType.valueOf(obj.get("id").getAsString().toUpperCase()) : null;
            String name = obj.get("name").getAsString();
            String lore = obj.get("lore").getAsString();
            int overallDifficulty = obj.get("overallDifficulty").getAsInt();

            Map<ArchetypeID, Archetype> archetypes = new HashMap<>();
            JsonObject archetypesObj = obj.getAsJsonObject("archetypes");
            for (Map.Entry<String, JsonElement> entry : archetypesObj.entrySet()) {
                ArchetypeID key = ArchetypeID.valueOf(entry.getKey().toUpperCase());
                Archetype value = context.deserialize(entry.getValue(), Archetype.class);
                archetypes.put(key, value);
            }

            return new ClassInfo(id, name, lore, overallDifficulty, archetypes);
        }
    }
}
