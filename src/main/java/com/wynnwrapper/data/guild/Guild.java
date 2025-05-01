package com.wynnwrapper.data.guild;

import java.util.Map;

public record Guild(
        String uuid,
        String name,
        String prefix,
        int level,
        int xpPercent,
        int territories,
        int wars,
        String created,
        GuildMembers members,
        int online,
        GuildBanner banner,
        Map<String, GuildSeasonRank> seasonRanks
) {}