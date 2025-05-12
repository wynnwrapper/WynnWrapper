package com.wynnwrapper.data.leaderboard.guild;

import com.wynnwrapper.data.guild.GuildBanner;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Date;
import java.util.UUID;


@Getter
@AllArgsConstructor
public class GuildLeaderboard {
    private UUID uuid;
    private String name;
    private String prefix;
    private int xp;
    private int territories;
    private int wars;
    private int level;
    private int members;
    private Date created;
    private GuildBanner banner;
}
