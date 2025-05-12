package com.wynnwrapper.data.item.enums;

public enum IngredientRarity {
    COMMON(0),
    UNCOMMON(1),
    RARE(2),
    LEGENDARY(3);

    private final int rarity;

    IngredientRarity(int rarity) {
        this.rarity = rarity;
    }

    public int getRarity() {
        return rarity;
    }

    @Override
    public String toString() {
        return String.valueOf(rarity);
    }
}
