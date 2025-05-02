package com.wynnwrapper.data.item;

public record ItemOnlyIDs(
        int durability_modifier,
        int strength_requirement,
        int dexterity_requirement,
        int intelligence_requirement,
        int defence_requirement,
        int agility_requirement
) {}