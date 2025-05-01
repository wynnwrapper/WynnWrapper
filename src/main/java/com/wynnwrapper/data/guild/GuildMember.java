package com.wynnwrapper.data.guild;

public record GuildMember(
        String uuid,
        boolean online,
        String server,
        long contributed,
        int guildRank,
        String joined
) { }