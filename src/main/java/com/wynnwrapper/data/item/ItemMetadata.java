package com.wynnwrapper.data.item;

import java.util.List;

public record ItemMetadata(
        List<String> identifications,
        List<String> majorIds,
        Filters filters
) {
    public record Filters(
            List<String> type,
            Advanced advanced,
            Tier tier,
            LevelRange levelRange
    ) {
        public record Advanced(
                List<String> attackSpeed,
                List<String> weapons,
                List<String> armour,
                List<String> accessories,
                List<String> tomes,
                List<String> tools,
                List<String> crafting,
                List<String> gathering
        ) {}

        public record Tier(
                List<String> items,
                List<Integer> ingredients
        ) {}

        public record LevelRange(
                int items,
                int ingredients
        ) {}
    }
}