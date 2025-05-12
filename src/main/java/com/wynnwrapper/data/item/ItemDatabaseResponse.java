package com.wynnwrapper.data.item;

import java.util.Map;

public record ItemDatabaseResponse(
        Controller controller,
        Map<String, Item> results
) {
    public record Controller(
            int count,
            int pages,
            String previous,
            int current,
            int next,
            Links links
    ) {
        public record Links(
                String previous,
                String next
        ) {}
    }
}