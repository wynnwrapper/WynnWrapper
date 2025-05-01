package com.wynnwrapper.data.player;


import lombok.Getter;

@Getter
public class Profession {

    private final ProfessionType professionType;
    private final int level;
    private final int xpPercent;

    public Profession(ProfessionType professionType, int level, int xpPercent) {
        this.professionType = professionType;
        this.level = level;
        this.xpPercent = xpPercent;
    }

}

