package org.mytests.uiobjects.example.enums;

public enum Even {
    TWO("2"),
    FOUR("4"),
    SIX("6"),
    EIGHT("8");

    public final String number;

    Even(String number) {
        this.number = number;
    }
}
