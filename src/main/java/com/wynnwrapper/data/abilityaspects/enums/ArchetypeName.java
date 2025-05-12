package com.wynnwrapper.data.abilityaspects.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ArchetypeName {
    //Archer
    BOLTSLINGER("Boltslinger"),
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

    @Override
    public String toString() {return name;}
}
