package com.wynnwrapper.data.classes;

import java.util.Map;

public record ClassInfo(
       String id,
       String name,
       String lore,
       int overallDifficulty,
       Map<String, Archetype> archetypes
) {

    public record Archetype(
            String name,
            int difficulty,
            int damage,
            int defense,
            int range,
            int speed
    ) { }

    @Override
    public String toString() {
        return "ClassInfo{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", lore='" + lore + '\'' +
                ", overallDifficulty=" + overallDifficulty +
                ", archetypes=" + archetypes +
                '}';
    }
}
