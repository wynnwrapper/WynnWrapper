package com.wynnwrapper.data.player;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.lang.reflect.Type;
import java.net.URI;
import java.net.URL;
import java.util.Map;
import java.util.Objects;


@Getter
@AllArgsConstructor
public class Player {
    private final String username;
    private final boolean online;
    private final String server;
    private final String activeCharacter;
    private final String nickname;
    private final String uuid;
    private final String rank;
    private final URL rankBadge;
    private final LegacyRankColour legacyRankColour;
    private final String shortenedRank;
    private final String supportRank;
    private final boolean veteran;
    private final String firstJoin;
    private final String lastJoin;
    private final float playtime;
    private final PlayerGuild guild;
    private final PlayerGlobalData globalData;
    private final Integer forumLink;
    private final Map<String, Integer> ranking;
    private final Map<String, Integer> previousRanking;
    private final boolean publicProfile;
    
    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (Player) obj;
        return Objects.equals(this.username, that.username) &&
                this.online == that.online &&
                Objects.equals(this.server, that.server) &&
                Objects.equals(this.activeCharacter, that.activeCharacter) &&
                Objects.equals(this.nickname, that.nickname) &&
                Objects.equals(this.uuid, that.uuid) &&
                Objects.equals(this.rank, that.rank) &&
                Objects.equals(this.rankBadge, that.rankBadge) &&
                Objects.equals(this.legacyRankColour, that.legacyRankColour) &&
                Objects.equals(this.shortenedRank, that.shortenedRank) &&
                Objects.equals(this.supportRank, that.supportRank) &&
                this.veteran == that.veteran &&
                Objects.equals(this.firstJoin, that.firstJoin) &&
                Objects.equals(this.lastJoin, that.lastJoin) &&
                Float.floatToIntBits(this.playtime) == Float.floatToIntBits(that.playtime) &&
                Objects.equals(this.guild, that.guild) &&
                Objects.equals(this.globalData, that.globalData) &&
                Objects.equals(this.forumLink, that.forumLink) &&
                Objects.equals(this.ranking, that.ranking) &&
                Objects.equals(this.previousRanking, that.previousRanking) &&
                this.publicProfile == that.publicProfile;
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, online, server, activeCharacter, nickname, uuid, rank, rankBadge, legacyRankColour, shortenedRank, supportRank, veteran, firstJoin, lastJoin, playtime, guild, globalData, forumLink, ranking, previousRanking, publicProfile);
    }

    @Override
    public String toString() {
        return "WynncraftPlayer[" +
                "username=" + username + ", " +
                "online=" + online + ", " +
                "server=" + server + ", " +
                "activeCharacter=" + activeCharacter + ", " +
                "nickname=" + nickname + ", " +
                "uuid=" + uuid + ", " +
                "rank=" + rank + ", " +
                "rankBadge=" + rankBadge + ", " +
                "legacyRankColour=" + legacyRankColour + ", " +
                "shortenedRank=" + shortenedRank + ", " +
                "supportRank=" + supportRank + ", " +
                "veteran=" + veteran + ", " +
                "firstJoin=" + firstJoin + ", " +
                "lastJoin=" + lastJoin + ", " +
                "playtime=" + playtime + ", " +
                "guild=" + guild + ", " +
                "globalData=" + globalData + ", " +
                "forumLink=" + forumLink + ", " +
                "ranking=" + ranking + ", " +
                "previousRanking=" + previousRanking + ", " +
                "publicProfile=" + publicProfile + ']';
    }

    public static class PlayerDeserializer implements JsonDeserializer<Player> {
        @Override
        public Player deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
            JsonObject obj = json.getAsJsonObject();

            try {
                String username = obj.has("username") && !obj.get("username").isJsonNull() ? obj.get("username").getAsString() : null;
                boolean online = obj.has("online") && !obj.get("online").isJsonNull() && obj.get("online").getAsBoolean();
                String server = obj.has("server") && !obj.get("server").isJsonNull() ? obj.get("server").getAsString() : null;
                String activeCharacter = obj.has("activeCharacter") && !obj.get("activeCharacter").isJsonNull() ? obj.get("activeCharacter").getAsString() : null;
                String nickname = obj.has("nickname") && !obj.get("nickname").isJsonNull() ? obj.get("nickname").getAsString() : null;
                String uuid = obj.has("uuid") && !obj.get("uuid").isJsonNull() ? obj.get("uuid").getAsString() : null;
                String rank = obj.has("rank") && !obj.get("rank").isJsonNull() ? obj.get("rank").getAsString() : null;
                URL rankBadge = obj.has("rankBadge") && !obj.get("rankBadge").isJsonNull() ? new URI("https://cdn.wynncraft.com/" + obj.get("rankBadge").getAsString()).toURL() : null;
                LegacyRankColour legacyRankColour = obj.has("legacyRankColour") && !obj.get("legacyRankColour").isJsonNull() ? context.deserialize(obj.get("legacyRankColour"), LegacyRankColour.class) : null;
                String shortenedRank = obj.has("shortenedRank") && !obj.get("shortenedRank").isJsonNull() ? obj.get("shortenedRank").getAsString() : null;
                String supportRank = obj.has("supportRank") && !obj.get("supportRank").isJsonNull() ? obj.get("supportRank").getAsString() : null;
                boolean veteran = obj.has("veteran") && !obj.get("veteran").isJsonNull() && obj.get("veteran").getAsBoolean();
                String firstJoin = obj.has("firstJoin") && !obj.get("firstJoin").isJsonNull() ? obj.get("firstJoin").getAsString() : null;
                String lastJoin = obj.has("lastJoin") && !obj.get("lastJoin").isJsonNull() ? obj.get("lastJoin").getAsString() : null;
                float playtime = obj.has("playtime") && !obj.get("playtime").isJsonNull() ? obj.get("playtime").getAsFloat() : 0.0f;
                PlayerGuild guild = obj.has("guild") && !obj.get("guild").isJsonNull() ? context.deserialize(obj.get("guild"), PlayerGuild.class) : null;
                PlayerGlobalData globalData = obj.has("globalData") && !obj.get("globalData").isJsonNull() ? context.deserialize(obj.get("globalData"), PlayerGlobalData.class) : null;
                Integer forumLink = obj.has("forumLink") && !obj.get("forumLink").isJsonNull() ? obj.get("forumLink").getAsInt() : null;
                Map<String, Integer> ranking = obj.has("ranking") && !obj.get("ranking").isJsonNull() ? context.deserialize(obj.get("ranking"), new TypeToken<Map<String, Integer>>() {
                }.getType()) : null;
                Map<String, Integer> previousRanking = obj.has("previousRanking") && !obj.get("previousRanking").isJsonNull() ? context.deserialize(obj.get("previousRanking"), new TypeToken<Map<String, Integer>>() {
                }.getType()) : null;
                boolean publicProfile = obj.has("publicProfile") && !obj.get("publicProfile").isJsonNull() && obj.get("publicProfile").getAsBoolean();

                return new Player(username, online, server, activeCharacter, nickname, uuid, rank, rankBadge,
                        legacyRankColour, shortenedRank, supportRank, veteran, firstJoin, lastJoin, playtime, guild,
                        globalData, forumLink, ranking, previousRanking, publicProfile);
            } catch (Exception e) {
                throw new JsonParseException("Error while deserializing", e);
            }
        }
    }


}

