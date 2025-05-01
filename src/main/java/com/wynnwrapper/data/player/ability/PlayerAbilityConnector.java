package com.wynnwrapper.data.player.ability;

import com.google.gson.*;
import lombok.Getter;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;


@Getter

public final class PlayerAbilityConnector extends PlayerAbilityEntry {
    private final String icon;
    private final int page;

    public PlayerAbilityConnector(
            AbilityMapType type,
            int coordinateX,
            int coordinateY,
            String icon,
            int page,
            List<String> family
    ) {
        super(type, coordinateX, coordinateY, family);
        this.icon = icon;
        this.page = page;
    }

    public static class PlayerAbilityConnectorDeserializer implements JsonDeserializer<PlayerAbilityConnector> {
        @Override
        public PlayerAbilityConnector deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
            JsonObject obj = json.getAsJsonObject();
            try {
                AbilityMapType type = obj.has("type") && !obj.get("type").isJsonNull() ? AbilityMapType.valueOf(obj.get("type").getAsString().toUpperCase()) : null;
                int coordinateX = obj.has("coordinates") && !obj.get("coordinates").isJsonNull() ? obj.getAsJsonObject("coordinates").get("x").getAsInt() : -1;
                int coordinateY = obj.has("coordinates") && !obj.get("coordinates").isJsonNull() ? obj.getAsJsonObject("coordinates").get("y").getAsInt() : -1;

                JsonObject metaObject = obj.has("meta") && !obj.get("meta").isJsonNull() ? obj.getAsJsonObject("meta") : null;

                String icon = metaObject != null && metaObject.has("icon") && !metaObject.get("icon").isJsonNull() ? metaObject.get("icon").getAsString() : null;
                int page = metaObject.has("page") && !metaObject.get("page").isJsonNull() ? metaObject.get("page").getAsInt() : -1;
                List<String> family = metaObject.has("family") && !metaObject.get("family").isJsonNull() ? context.deserialize(metaObject.get("family"), List.class) : new ArrayList<>();

                return new PlayerAbilityConnector(
                        type,
                        coordinateX,
                        coordinateY,
                        icon,
                        page,
                        family
                );

            } catch (Exception e) {
                throw new JsonParseException("Error while deserializing", e);
            }
        }
    }
}