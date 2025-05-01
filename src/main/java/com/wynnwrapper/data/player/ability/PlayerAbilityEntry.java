package com.wynnwrapper.data.player.ability;

import com.google.gson.*;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.lang.reflect.Type;
import java.util.List;


@Getter
@AllArgsConstructor
public class PlayerAbilityEntry {

    private final AbilityMapType type;
    private final int coordinateX;
    private final int coordinateY;
    private final List<String> family;


    public static class PlayerAbilityMapEntryDeserializer implements JsonDeserializer<PlayerAbilityEntry> {
        @Override
        public PlayerAbilityEntry deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
            JsonObject obj = json.getAsJsonObject();
            try {
                AbilityMapType type = obj.has("type") && !obj.get("type").isJsonNull() ? AbilityMapType.valueOf(obj.get("type").getAsString().toUpperCase()) : null;
                if (type != null) {
                    if (type == AbilityMapType.CONNECTOR) {
                        return context.deserialize(obj, PlayerAbilityConnector.class);
                    } else if (type == AbilityMapType.ABILITY) {
                        return context.deserialize(obj, PlayerAbility.class);
                    }
                }
                return new PlayerAbilityEntry(null, -1, -1, null);
            } catch (Exception e) {
                throw new JsonParseException("Error while deserializing", e);
            }
        }
    }

}
