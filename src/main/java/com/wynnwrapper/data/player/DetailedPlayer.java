package com.wynnwrapper.data.player;

import com.google.gson.*;
import com.wynnwrapper.data.player.character.DetailedCharacter;
import lombok.Getter;

import java.lang.reflect.Type;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DetailedPlayer extends Player {
    @Getter
    private final List<DetailedCharacter> characters;

    public DetailedPlayer(String username, boolean online, String server, String activeCharacter, String nickname, String uuid, String rank, URL rankBadge, LegacyRankColour legacyRankColour, String shortenedRank, String supportRank, boolean veteran, String firstJoin, String lastJoin, float playtime, PlayerGuild guild, PlayerGlobalData globalData, Integer forumLink, Map<String, Integer> ranking, Map<String, Integer> previousRanking, boolean publicProfile, List<DetailedCharacter> characters) {
        super(username, online, server, activeCharacter, nickname, uuid, rank, rankBadge, legacyRankColour, shortenedRank, supportRank, veteran, firstJoin, lastJoin, playtime, guild, globalData, forumLink, ranking, previousRanking, publicProfile);
        this.characters = characters;
    }

    public static DetailedPlayer fromPlayer(Player player, List<DetailedCharacter> characters) {
        return new DetailedPlayer(
                player.username(),
                player.online(),
                player.server(),
                player.activeCharacter(),
                player.nickname(),
                player.uuid(),
                player.rank(),
                player.rankBadge(),
                player.legacyRankColour(),
                player.shortenedRank(),
                player.supportRank(),
                player.veteran(),
                player.firstJoin(),
                player.lastJoin(),
                player.playtime(),
                player.guild(),
                player.globalData(),
                player.forumLink(),
                player.ranking(),
                player.previousRanking(),
                player.publicProfile(),
                characters
        );
    }


    public static class DetailedPlayerDeserializer implements JsonDeserializer<Player> {
        @Override
        public Player deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
            JsonObject obj = json.getAsJsonObject();
            try {
                PlayerDeserializer playerDeserializer = new PlayerDeserializer();
                Player player = playerDeserializer.deserialize(json, typeOfT, context);
                JsonObject charactersElement = obj.has("characters") && !obj.get("characters").isJsonNull() ? obj.getAsJsonObject("characters") : null;
                if (charactersElement != null) {
                    List<DetailedCharacter> characters = new ArrayList<>();
                    for (Map.Entry<String, JsonElement> entry : charactersElement.entrySet()) {
                        JsonObject characterObject = entry.getValue().getAsJsonObject();
                        characterObject.addProperty("uuid", entry.getKey());
                        DetailedCharacter character = context.deserialize(characterObject, DetailedCharacter.class);
                        characters.add(character);
                    }
                    return DetailedPlayer.fromPlayer(player, characters);
                } else {
                    return DetailedPlayer.fromPlayer(player, new ArrayList<>());
                }
            } catch (Exception e) {
                throw new JsonParseException("Error while deserializing", e);
            }
        }
    }
}
