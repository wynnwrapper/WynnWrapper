package com.wynnwrapper.data.leaderboard.player;

import com.wynnwrapper.data.player.LegacyRankColour;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.UUID;

@Getter
@AllArgsConstructor
public class PlayerLeaderboard {
    private String name;
    private UUID uuid;
    private int score;
    private int previousRanking;
    private int metaDataXp;
    private float metaDataPlaytime;
    private String rank;
    private String rankBadge;
    private String supportRank;
    private LegacyRankColour legacyRankColor;
}
