package com.wynnwrapper.data.abilityaspects.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

public enum ArchetypeName {
    //Archer
    BOTSLINGER("Botslinger"),
    SHARPSHOOTER("Sharpshooter"),
    TRAPPER("Trapper"),

    //Warrior
    FALLEN("Fallen"),
    BATTLE_MONK("Battle Monk"),
    PALADIN("Paladin"),

    //Mage
    RIFTWALKER("Riftwalker"),
    LIGHT_BENDER("Lightbender"),
    ARCANIST("Arcanist"),

    //Assassin
    SHADESTEPPER("Shadestepper"),
    TRICKSTER("Trickster"),
    ACROBAT("Acrobat"),

    //Shaman
    SUMMONER("Summoner"),
    RITUALIST("Ritualist"),
    ACOLYTE("Acolyte");

    private final String name;

    ArchetypeName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {return name;}
}
