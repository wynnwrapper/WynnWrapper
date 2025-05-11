package com.wynnwrapper.data.abilityaspects.enums;

public enum ClassType {
    ARCHER("archer"),
    ASSASSIN("assassin"),
    MAGE("mage"),
    WARRIOR("warrior"),
    SHAMAN("shaman");

    private final String classType;

    ClassType(String classType) {this.classType = classType;}

    public String getClassType() {return classType;}

    @Override
    public String toString() {return classType;}
}
