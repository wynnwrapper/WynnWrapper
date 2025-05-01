package com.wynnwrapper.data.guild;

import java.util.Map;

public record GuildMembers(
        int total,
        Map<String, GuildMember> owner,
        Map<String, GuildMember> chief,
        Map<String, GuildMember> strategist,
        Map<String, GuildMember> captain,
        Map<String, GuildMember> recruiter,
        Map<String, GuildMember> recruit
) { }