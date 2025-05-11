package com.wynnwrapper.data.item;

import java.util.List;

public record Requirements(
        int level,
        LevelRange levelRange,
        int strength,
        int dexterity,
        int intelligence,
        int defence,
        int agility,
        String quest,
        String class_requirement,
        List<String> skills
) {}