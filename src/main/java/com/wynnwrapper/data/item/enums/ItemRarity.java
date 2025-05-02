package com.wynnwrapper.data.item.enums;

public enum ItemRarity {
    COMMON("Common"),
    UNIQUE("Unique"),
    RARE("Rare"),
    LEGENDARY("Legendary"),
    FABLED("Fabled"),
    SET("Set"),
    MYTHIC("Mythic");

    private final String rarity;

    ItemRarity(String rarity) {
        this.rarity = rarity;
    }

    public String getRarity() {
        return rarity;
    }

    @Override
    public String toString() {
        return rarity;
    }
}
