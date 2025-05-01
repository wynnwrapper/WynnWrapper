package com.wynnwrapper.data.player.character;

import com.google.gson.*;
import com.wynnwrapper.data.classes.ClassType;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.lang.reflect.Type;
import java.util.List;

@Getter
@AllArgsConstructor
public class Character {
    private final ClassType type;
    private final String nickname;
    private final int level;
    private final int xp;
    private final int xpPercent;
    private final int totalLevel;
    private final List<String> gamemode;
    private final boolean died;


    public static class PlayerCharacterDeserializer implements JsonDeserializer<Character> {
        @Override
        public Character deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
            JsonObject obj = json.getAsJsonObject();
            try {
                ClassType type = obj.has("type") && !obj.get("type").isJsonNull() ? ClassType.valueOf(obj.get("type").getAsString().toUpperCase()) : null;
                String nickname = obj.has("nickname") && !obj.get("nickname").isJsonNull() ? obj.get("nickname").getAsString() : null;
                int level = obj.has("level") && !obj.get("level").isJsonNull() ? obj.get("level").getAsInt() : -1;
                int xp = obj.has("xp") && !obj.get("xp").isJsonNull() ? obj.get("xp").getAsInt() : -1;
                int xpPercent = obj.has("xpPercent") && !obj.get("xpPercent").isJsonNull() ? obj.get("xpPercent").getAsInt() : -1;
                int totalLevel = obj.has("totalLevel") && !obj.get("totalLevel").isJsonNull() ? obj.get("totalLevel").getAsInt() : -1;
                List<String> gamemode = obj.has("gamemode") && !obj.get("gamemode").isJsonNull() ? context.deserialize(obj.get("gamemode"), List.class) : null;
                boolean died = obj.has("meta") && !obj.get("meta").isJsonNull() ? obj.getAsJsonObject("meta").has("died") && !obj.getAsJsonObject("meta").get("died").isJsonNull() ? obj.getAsJsonObject("meta").get("died").getAsBoolean() : false : false;

                return new Character(
                        type,
                        nickname,
                        level,
                        xp,
                        xpPercent,
                        totalLevel,
                        gamemode,
                        died
                );

            } catch (Exception e) {
                throw new JsonParseException("Error while deserializing", e);
            }
        }
    }

}
