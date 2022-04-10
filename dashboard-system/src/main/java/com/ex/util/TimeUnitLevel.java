package com.ex.util;

public enum TimeUnitLevel {

    Day(24 * 60 * 60 * 1000),
    Hour(60 * 60 * 1000),
    Minute(60 * 1000),
    Second(1000);

    private int millis;

    private TimeUnitLevel(int millis) {
        this.millis = millis;
    }

    public int inMillis() {
        return millis;
    }

}
