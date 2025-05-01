package com.wynnwrapper.data.guild;

import java.util.List;

public record Territory(
        GuildFullMetadata guild,
        String acquired,
        Location location
) {
    public record Location(
            List<Integer> start,
            List<Integer> end
    ) {}
}