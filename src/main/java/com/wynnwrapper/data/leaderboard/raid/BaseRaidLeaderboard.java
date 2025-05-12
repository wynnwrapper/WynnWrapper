package com.wynnwrapper.data.leaderboard.raid;

import lombok.Getter;

import java.util.UUID;

@Getter
public class BaseRaidLeaderboard {
    private String name;
    private UUID uuid;
    private int score;
    private int metaDataCompletions;
    private int metaDataGambitsUsed;

    protected BaseRaidLeaderboard(String name, UUID uuid, int score, int metaDataCompletions, int metaDataGambitsUsed) {
        this.name = name;
        this.uuid = uuid;
        this.score = score;
        this.metaDataCompletions = metaDataCompletions;
        this.metaDataGambitsUsed = metaDataGambitsUsed;
    }


}
