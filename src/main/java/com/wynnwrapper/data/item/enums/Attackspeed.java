package com.wynnwrapper.data.item.enums;

public enum Attackspeed {
    SUPER_FAST("Super Fast"),
    VERY_FAST("Very Fast"),
    FAST("Fast"),
    NORMAL("Normal"),
    SLOW("Slow"),
    VERY_SLOW("Very Slow"),
    SUPER_SLOW("Super Slow");

    private final String speed;

    Attackspeed(String speed) {
        this.speed = speed;
    }

    public String getSpeed() {
        return speed;
    }

    @Override
    public String toString() {
        return speed;
    }
}
