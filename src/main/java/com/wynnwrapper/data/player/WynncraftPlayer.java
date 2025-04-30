package com.wynnwrapper.data.player;

import com.google.gson.*;

import java.lang.reflect.Constructor;
import java.lang.reflect.RecordComponent;
import java.lang.reflect.Type;
import java.net.URL;
import java.util.Arrays;
import java.util.Map;

public record WynncraftPlayer(
        String username,
        boolean online,
        String server,
        String activeCharacter,
        String nickname,
        String uuid,
        String rank,
        URL rankBadge,
        LegacyRankColour legacyRankColour,
        String shortenedRank,
        String supportRank,
        boolean veteran,
        String firstJoin,
        String lastJoin,
        float playtime,
        WynncraftPlayerGuild guild,
        WynncraftPlayerGlobalData globalData,
        Integer forumLink,
        Map<String, Integer> ranking,
        Map<String, Integer> previousRanking,
        boolean publicProfile
) {


    public static class WynncraftPlayerDeserializer implements JsonDeserializer<WynncraftPlayer> {
        @Override
        public WynncraftPlayer deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
            JsonObject obj = json.getAsJsonObject();
            try {
                Class<?> recordClass = WynncraftPlayer.class;
                RecordComponent[] components = recordClass.getRecordComponents();
                Object[] values = new Object[components.length];

                for (int i = 0; i < components.length; i++) {
                    RecordComponent comp = components[i];
                    String name = comp.getName();
                    Type fieldType = comp.getGenericType();

                    //veteran possible null handling TODO: check if possible null removed
                    if (name.equals("veteran")) {
                        if (obj.has(name) && !obj.get(name).isJsonNull()) {
                            try {
                                values[i] = obj.get(name).getAsBoolean();
                            } catch (Exception e) {
                                values[i] = false;
                            }
                        } else {
                            values[i] = false;
                        }
                    } else {
                        if (obj.has(name)) {
                            values[i] = context.deserialize(obj.get(name), fieldType);
                        } else {
                            values[i] = null;
                        }
                    }
                }
                Constructor<?> constructor = recordClass.getDeclaredConstructor(
                        Arrays.stream(components)
                                .map(RecordComponent::getType)
                                .toArray(Class[]::new)
                );
                return (WynncraftPlayer) constructor.newInstance(values);
            } catch (Exception e) {
                throw new JsonParseException("Error while building the record", e);
            }
        }
    }

}

