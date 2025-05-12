package com.wynnwrapper.data.item;

import java.util.List;

public record DropMeta(
        List<Integer> coordinates,
        String name,
        Object type // Can be a String or List<String>
) {}