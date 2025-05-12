package com.wynnwrapper.data.leaderboard.raid;

import com.wynnwrapper.data.guild.GuildBanner;
import lombok.Getter;

import java.util.UUID;

@Getter
public class GuildRaidLeaderboard extends BaseRaidLeaderboard {
    private String prefix;
    private GuildBanner banner;

    public GuildRaidLeaderboard(String name, UUID uuid, int score, String prefix, int metaDataCompletions, int metaDataGambitsUsed, GuildBanner banner) {
        super(name, uuid, score, metaDataCompletions, metaDataGambitsUsed);
        this.banner = banner;
        this.prefix = prefix;
    }
}
