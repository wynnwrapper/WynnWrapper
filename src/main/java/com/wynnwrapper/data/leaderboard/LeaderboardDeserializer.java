package com.wynnwrapper.data.leaderboard;

import com.google.gson.*;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class LeaderboardDeserializer<T> implements JsonDeserializer<List<T>> {
    @Override
    public List<T> deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        JsonObject obj = json.getAsJsonObject();
        try {
            List<T> leaderboard = new ArrayList<>();
            for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
                JsonObject entryObject = entry.getValue().getAsJsonObject();
                entryObject.remove("metaScore");
                leaderboard.add(context.deserialize(entryObject, getListElementType(typeOfT)));
            }
            return leaderboard;
        } catch (Exception e) {
            throw new JsonParseException("Error while deserializing", e);
        }
    }

    public static Class<?> getListElementType(Type type) {
        if (type instanceof ParameterizedType) {
            ParameterizedType pt = (ParameterizedType) type;
            Type[] typeArguments = pt.getActualTypeArguments();
            if (typeArguments.length == 1) {
                Type elementType = typeArguments[0];
                if (elementType instanceof Class<?>) {
                    return (Class<?>) elementType;
                } else if (elementType instanceof ParameterizedType) {
                    return (Class<?>) ((ParameterizedType) elementType).getRawType();
                }
            }
        }
        return null;
    }
}
