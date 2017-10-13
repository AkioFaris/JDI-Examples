package org.mytests.uiobjects.example.enums;

public enum Vegetables {
    CUCUMBER("Cucumber"),
    TOMATO("Tomato"),
    SALAD("Salad"),
    ONION("Onion");

    final public String text;

    Vegetables(String text) {
        this.text = text;
    }
}

