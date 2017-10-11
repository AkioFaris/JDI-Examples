package org.mytests.uiobjects.example.enums;

public enum Conditions {
    WATER("Water"),
    EARTH("Earth"),
    WIND("Wind"),
    FIRE("Fire");

    final public String text;

    Conditions(String text) {
        this.text = text;
    }
}

