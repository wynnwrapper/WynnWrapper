package com.wynnwrapper.data.item.enums;

public enum Profession {
    MINING("Mining"),
    FISHING("Fishing"),
    FARMING("Farming"),
    WOODCUTTING("Woodcutting"),

    ALCHEMISM("Alchemism"),
    ARMOURING("Armouring"),
    COOKING("Cooking"),
    JEWELING("Jeweling"),
    SCRIBING("Scribing"),
    TAILORING("Tailoring"),
    WEAPONSMITHING("Weaponsmithing"),
    WOODWORKING("Woodworking");

    private final String profession;

    Profession(String profession) {
        this.profession = profession;
    }

    public String getProfession() {
        return profession;
    }

    @Override
    public String toString() {
        return profession;
    }
}
