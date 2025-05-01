package com.wynnwrapper.data.player.ability;

import com.google.gson.*;
import lombok.Getter;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

@Getter
public final class PlayerAbility extends PlayerAbilityEntry {
    private final PlayerAbilityIcon icon;
    private final int page;
    private final String id;

    public PlayerAbility(
            AbilityMapType type,
            int coordinateX,
            int coordinateY,
            PlayerAbilityIcon icon,
            int page,
            String id,
            List<String> family
    ) {
        super(type, coordinateX, coordinateY, family);
        this.icon = icon;
        this.page = page;
        this.id = id;
    }

    public static class PlayerAbilityDeserializer implements JsonDeserializer<PlayerAbility> {
        @Override
        public PlayerAbility deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
            JsonObject obj = json.getAsJsonObject();
            try {
                AbilityMapType type = obj.has("type") && !obj.get("type").isJsonNull() ? AbilityMapType.valueOf(obj.get("type").getAsString().toUpperCase()) : null;
                int coordinateX = obj.has("coordinates") && !obj.get("coordinates").isJsonNull() ? obj.getAsJsonObject("coordinates").get("x").getAsInt() : -1;
                int coordinateY = obj.has("coordinates") && !obj.get("coordinates").isJsonNull() ? obj.getAsJsonObject("coordinates").get("y").getAsInt() : -1;

                JsonObject metaObject = obj.has("meta") && !obj.get("meta").isJsonNull() ? obj.getAsJsonObject("meta") : null;

                JsonObject iconObject = metaObject.has("icon") && !metaObject.get("icon").isJsonNull() ? metaObject.getAsJsonObject("icon") : null;
                String iconFormat = iconObject.has("format") && !iconObject.get("format").isJsonNull() ? iconObject.get("format").getAsString() : null;

                JsonObject iconValueObject = iconObject.has("value") && !iconObject.get("value").isJsonNull() ? iconObject.getAsJsonObject("value") : null;
                String iconId = iconValueObject.has("id") && !iconValueObject.get("id").isJsonNull() ? iconValueObject.get("id").getAsString() : null;
                String iconName = iconValueObject.has("name") && !iconValueObject.get("name").isJsonNull() ? iconValueObject.get("name").getAsString() : null;
                String iconCustomModelData = iconValueObject.has("customModelData") && !iconValueObject.get("customModelData").isJsonNull() ? iconValueObject.get("customModelData").getAsString() : null;
                PlayerAbilityIcon playerAbilityIcon = new PlayerAbilityIcon(iconFormat, iconId, iconName, iconCustomModelData);

                int page = metaObject.has("page") && !metaObject.get("page").isJsonNull() ? metaObject.get("page").getAsInt() : -1;
                String id = metaObject.has("id") && !metaObject.get("id").isJsonNull() ? metaObject.get("id").getAsString() : null;
                List<String> family = metaObject.has("family") && !metaObject.get("family").isJsonNull() ? context.deserialize(metaObject.get("family"), List.class) : new ArrayList<>();

                return new PlayerAbility(
                        type,
                        coordinateX,
                        coordinateY,
                        playerAbilityIcon,
                        page,
                        id,
                        family
                );

            } catch (Exception e) {
                throw new JsonParseException("Error while deserializing", e);
            }
        }
    }
}
