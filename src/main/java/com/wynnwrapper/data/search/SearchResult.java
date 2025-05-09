package com.wynnwrapper.data.search;

import java.util.List;
import java.util.Map;

public record SearchResult(
        String query,
        // Players are limited to 20 results
        Map<String, String> players,
        // Guilds are limited to 50 results
        Map<String, GuildInfo> guilds,
        Map<String, GuildInfo> guildsPrefix,
        Map<String, LocationBounds> territories,
        Map<String, LocationBounds> discoveries,
        Map<String, Item> items
) {

    public record GuildInfo(
            String name,
            String prefix
    ) { }

    public record LocationBounds(
            List<Integer> start,
            List<Integer> end
    ) { }

    @Override
    public String toString() {
        return "SearchResult{" +
                "query='" + query + '\'' +
                ", players=" + players +
                ", guilds=" + guilds +
                ", guildsPrefix=" + guildsPrefix +
                ", territories=" + territories +
                ", discoveries=" + discoveries +
                ", items=" + items +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SearchResult that)) return false;

        if (!query.equals(that.query)) return false;
        if (!players.equals(that.players)) return false;
        if (!guilds.equals(that.guilds)) return false;
        if (!guildsPrefix.equals(that.guildsPrefix)) return false;
        if (!territories.equals(that.territories)) return false;
        if (!discoveries.equals(that.discoveries)) return false;
        return items.equals(that.items);
    }
}
