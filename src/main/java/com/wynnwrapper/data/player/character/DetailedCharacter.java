package com.wynnwrapper.data.player.character;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
import com.wynnwrapper.data.classes.ClassType;
import com.wynnwrapper.data.player.Profession;
import com.wynnwrapper.data.player.ProfessionType;
import com.wynnwrapper.data.player.SkillPoints;
import lombok.Getter;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
public final class DetailedCharacter extends Character {
    private final String uuid;
    private final int wars;
    private final float playtime;
    private final int mobsKilled;
    private final int chestsFound;
    private final int blocksWalked;
    private final int itemsIdentified;
    private final int logins;
    private final int deaths;
    private final int discoveries;
    private final int pvpKills;
    private final int pvpDeaths;
    private final Map<SkillPoints, Integer> skillPoints;
    private final Map<ProfessionType, Profession> professions;
    private final int dungeonsTotal;
    private final Map<String, Integer> dungeonsCompletionsList;
    private final int raidsTotal;
    private final Map<String, Integer> raidsCompletionsList;
    private final List<String> quests;

    public DetailedCharacter(ClassType type, String nickname, int level, int xp, int xpPercent, int totalLevel, List<String> gamemode, String uuid, int wars, float playtime, int mobsKilled, int chestsFound, int blocksWalked, int itemsIdentified, int logins, int deaths, int discoveries, int pvpKills, int pvpDeaths, Map<SkillPoints, Integer> skillPoints, Map<ProfessionType, Profession> professions, int dungeonsTotal, Map<String, Integer> dungeonsCompletionsList, int raidsTotal, Map<String, Integer> raidsCompletionsList, List<String> quests) {
        super(type, nickname, level, xp, xpPercent, totalLevel, gamemode, false);
        this.uuid = uuid;
        this.wars = wars;
        this.playtime = playtime;
        this.mobsKilled = mobsKilled;
        this.chestsFound = chestsFound;
        this.blocksWalked = blocksWalked;
        this.itemsIdentified = itemsIdentified;
        this.logins = logins;
        this.deaths = deaths;
        this.discoveries = discoveries;
        this.pvpKills = pvpKills;
        this.pvpDeaths = pvpDeaths;
        this.skillPoints = skillPoints;
        this.professions = professions;
        this.dungeonsTotal = dungeonsTotal;
        this.dungeonsCompletionsList = dungeonsCompletionsList;
        this.raidsTotal = raidsTotal;
        this.raidsCompletionsList = raidsCompletionsList;
        this.quests = quests;
    }

    public static DetailedCharacter fromPlayerCharacter(Character playerCharacter, String uuid, int wars, float playtime, int mobsKilled, int chestsFound, int blocksWalked, int itemsIdentified, int logins, int deaths, int discoveries, int pvpKills, int pvpDeaths, Map<SkillPoints, Integer> skillPoints, Map<ProfessionType, Profession> professions, int dungeonsTotal, Map<String, Integer> dungeonsCompletionsList, int raidsTotal, Map<String, Integer> raidsCompletionsList, List<String> quests) {
        return new DetailedCharacter(
                playerCharacter.type(),
                playerCharacter.nickname(),
                playerCharacter.level(),
                playerCharacter.xp(),
                playerCharacter.xpPercent(),
                playerCharacter.totalLevel(),
                playerCharacter.gamemode(),
                uuid,
                wars,
                playtime,
                mobsKilled,
                chestsFound,
                blocksWalked,
                itemsIdentified,
                logins,
                deaths,
                discoveries,
                pvpKills,
                pvpDeaths,
                skillPoints,
                professions,
                dungeonsTotal,
                dungeonsCompletionsList,
                raidsTotal,
                raidsCompletionsList,
                quests
        );
    }

    public static class DetailedPlayerCharacterDeserializer implements JsonDeserializer<DetailedCharacter> {
        @Override
        public DetailedCharacter deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
            JsonObject obj = json.getAsJsonObject();
            try {
                PlayerCharacterDeserializer playerCharacterDeserializer = new PlayerCharacterDeserializer();
                Character playerCharacter = playerCharacterDeserializer.deserialize(json, typeOfT, context);

                String uuid = obj.has("uuid") && !obj.get("uuid").isJsonNull() ? obj.get("uuid").getAsString() : null;
                int wars = obj.has("wars") && !obj.get("wars").isJsonNull() ? obj.get("wars").getAsInt() : -1;
                float playtime = obj.has("playtime") && !obj.get("playtime").isJsonNull() ? obj.get("playtime").getAsFloat() : -1f;
                int mobsKilled = obj.has("mobsKilled") && !obj.get("mobsKilled").isJsonNull() ? obj.get("mobsKilled").getAsInt() : -1;
                int chestsFound = obj.has("chestsFound") && !obj.get("chestsFound").isJsonNull() ? obj.get("chestsFound").getAsInt() : -1;
                int blocksWalked = obj.has("blocksWalked") && !obj.get("blocksWalked").isJsonNull() ? obj.get("blocksWalked").getAsInt() : -1;
                int itemsIdentified = obj.has("itemsIdentified") && !obj.get("itemsIdentified").isJsonNull() ? obj.get("itemsIdentified").getAsInt() : -1;
                int logins = obj.has("logins") && !obj.get("logins").isJsonNull() ? obj.get("logins").getAsInt() : -1;
                int deaths = obj.has("deaths") && !obj.get("deaths").isJsonNull() ? obj.get("deaths").getAsInt() : -1;
                int discoveries = obj.has("discoveries") && !obj.get("discoveries").isJsonNull() ? obj.get("discoveries").getAsInt() : -1;
                int pvpKills = obj.has("pvp") && obj.getAsJsonObject("pvp").has("kills") && !obj.getAsJsonObject("pvp").get("kills").isJsonNull() ? obj.getAsJsonObject("pvp").get("kills").getAsInt() : -1;
                int pvpDeaths = obj.has("pvp") && obj.getAsJsonObject("pvp").has("deaths") && !obj.getAsJsonObject("pvp").get("deaths").isJsonNull() ? obj.getAsJsonObject("pvp").get("deaths").getAsInt() : -1;
                Map<SkillPoints, Integer> skillPoints = new HashMap<>();
                if (obj.has("skillPoints") && !obj.get("skillPoints").isJsonNull()) {
                    JsonObject skillPointsJSON = obj.getAsJsonObject("skillPoints");
                    for (Map.Entry<String, JsonElement> entry : skillPointsJSON.entrySet()) {
                        skillPoints.put(SkillPoints.valueOf(entry.getKey().toUpperCase()), entry.getValue().isJsonNull() ? -1 : entry.getValue().getAsInt());
                    }
                }
                Map<ProfessionType, Profession> professions = new HashMap<>();
                if (obj.has("professions") && !obj.get("professions").isJsonNull()) {
                    JsonObject professionsJSON = obj.getAsJsonObject("professions");
                    for (Map.Entry<String, JsonElement> entry : professionsJSON.entrySet()) {
                        String professionName = entry.getKey();
                        JsonObject professionData = entry.getValue().getAsJsonObject();
                        int levelProf = professionData.has("level") && !professionData.get("level").isJsonNull() ? professionData.get("level").getAsInt() : -1;
                        int xpPercentProf = professionData.has("xpPercent") && !professionData.get("xpPercent").isJsonNull() ? professionData.get("xpPercent").getAsInt() : -1;
                        professions.put(ProfessionType.valueOf(professionName.toString().toUpperCase()), new Profession(ProfessionType.valueOf(professionName.toString().toUpperCase()), levelProf, xpPercentProf));
                    }
                }
                int dungeonsTotal = obj.has("dungeons") && obj.getAsJsonObject("dungeons").has("total") && !obj.getAsJsonObject("dungeons").get("total").isJsonNull() ? obj.getAsJsonObject("dungeons").get("total").getAsInt() : -1;
                Map<String, Integer> dungeonsCompletionsList = obj.has("dungeons") && obj.getAsJsonObject("dungeons").has("list") && !obj.getAsJsonObject("dungeons").get("list").isJsonNull() ? context.deserialize(obj.getAsJsonObject("dungeons").get("list"), new TypeToken<Map<String, Integer>>() {
                }.getType()) : null;
                int raidsTotal = obj.has("raids") && obj.getAsJsonObject("raids").has("total") && !obj.getAsJsonObject("raids").get("total").isJsonNull() ? obj.getAsJsonObject("raids").get("total").getAsInt() : -1;
                Map<String, Integer> raidsCompletionsList = obj.has("raids") && obj.getAsJsonObject("raids").has("list") && !obj.getAsJsonObject("raids").get("list").isJsonNull() ? context.deserialize(obj.getAsJsonObject("raids").get("list"), new TypeToken<Map<String, Integer>>() {
                }.getType()) : null;
                List<String> quests = obj.has("quests") && !obj.get("quests").isJsonNull() ? context.deserialize(obj.get("quests"), List.class) : null;

                return DetailedCharacter.fromPlayerCharacter(playerCharacter, uuid, wars, playtime, mobsKilled, chestsFound, blocksWalked, itemsIdentified, logins, deaths, discoveries, pvpKills, pvpDeaths, skillPoints, professions, dungeonsTotal, dungeonsCompletionsList, raidsTotal, raidsCompletionsList, quests);

            } catch (Exception e) {
                throw new JsonParseException("Error while deserializing", e);
            }
        }
    }
}