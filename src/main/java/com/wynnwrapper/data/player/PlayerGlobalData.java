package com.wynnwrapper.data.player;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.Map;

public record PlayerGlobalData(
        int wars,
        int totalLevel,
        int killedMobs,
        int chestsFound,
        int dungeonsTotal,
        Map<String, Integer> dungeonsCompletionsList,
        int raidsTotal,
        Map<String, Integer> raidsCompletionsList,
        int completedQuests,
        int pvpKills,
        int pvpDeaths) {


    public static class PlayerGlobalDataDeserializer implements JsonDeserializer<PlayerGlobalData> {
        @Override
        public PlayerGlobalData deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
            JsonObject obj = json.getAsJsonObject();

            try {
                int wars = obj.get("wars") != null ? obj.get("wars").getAsInt() : -1;
                int totalLevel = obj.get("totalLevel") != null ? obj.get("totalLevel").getAsInt() : -1;
                int killedMobs = obj.get("killedMobs") != null ? obj.get("killedMobs").getAsInt() : -1;
                int chestsFound = obj.get("chestsFound") != null ? obj.get("chestsFound").getAsInt() : -1;
                int dungeonsTotal = obj.getAsJsonObject("dungeons") != null && obj.getAsJsonObject("dungeons").get("total") != null
                        ? obj.getAsJsonObject("dungeons").get("total").getAsInt() : -1;
                Map<String, Integer> dungeonsCompletionsList = obj.getAsJsonObject("dungeons") != null && obj.getAsJsonObject("dungeons").get("list") != null
                        ? context.deserialize(obj.getAsJsonObject("dungeons").get("list"), new TypeToken<Map<String, Integer>>() {
                }.getType()) : null;
                int raidsTotal = obj.getAsJsonObject("raids") != null && obj.getAsJsonObject("raids").get("total") != null
                        ? obj.getAsJsonObject("raids").get("total").getAsInt() : -1;
                Map<String, Integer> raidsCompletionsList = obj.getAsJsonObject("raids") != null && obj.getAsJsonObject("raids").get("list") != null
                        ? context.deserialize(obj.getAsJsonObject("raids").get("list"), new TypeToken<Map<String, Integer>>() {
                }.getType()) : null;
                int completedQuests = obj.get("completedQuests") != null ? obj.get("completedQuests").getAsInt() : -1;
                int pvpKills = obj.getAsJsonObject("pvp") != null && obj.getAsJsonObject("pvp").get("kills") != null
                        ? obj.getAsJsonObject("pvp").get("kills").getAsInt() : -1;
                int pvpDeaths = obj.getAsJsonObject("pvp") != null && obj.getAsJsonObject("pvp").get("deaths") != null
                        ? obj.getAsJsonObject("pvp").get("deaths").getAsInt() : -1;

                return new PlayerGlobalData(
                        wars,
                        totalLevel,
                        killedMobs,
                        chestsFound,
                        dungeonsTotal,
                        dungeonsCompletionsList,
                        raidsTotal,
                        raidsCompletionsList,
                        completedQuests,
                        pvpKills,
                        pvpDeaths

                );
            } catch (Exception e) {
                throw new JsonParseException("Error while deserializing", e);
            }
        }
    }
}
