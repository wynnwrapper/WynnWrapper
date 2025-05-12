package com.wynnwrapper.data.leaderboard.gamemode;

import com.wynnwrapper.data.player.LegacyRankColour;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.UUID;


@Getter
@AllArgsConstructor
public class GamemodeLeaderboard {
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
    private String characterType;
    private UUID characterUUID;

}
