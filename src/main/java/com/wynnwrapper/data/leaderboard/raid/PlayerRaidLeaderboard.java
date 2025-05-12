package com.wynnwrapper.data.leaderboard.raid;

import com.wynnwrapper.data.player.LegacyRankColour;
import lombok.Getter;

import java.util.UUID;

@Getter
public class PlayerRaidLeaderboard extends BaseRaidLeaderboard {
    private String rank;
    private String rankBadge;
    private String supportRank;
    private String shortenedRank;
    private LegacyRankColour legacyRankColor;
    private int previousRanking;

    public PlayerRaidLeaderboard(String name, UUID uuid, int score, int previousRanking, int metaDataCompletions, int metaDataGambitsUsed, String rank, String rankBadge, String supportRank, String shortenedRank, LegacyRankColour legacyRankColor) {
        super(name, uuid, score, metaDataCompletions, metaDataGambitsUsed);
        this.previousRanking = previousRanking;
        this.rank = rank;
        this.rankBadge = rankBadge;
        this.supportRank = supportRank;
        this.shortenedRank = shortenedRank;
        this.legacyRankColor = legacyRankColor;
    }
}
