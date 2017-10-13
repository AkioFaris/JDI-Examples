package org.mytests.uiobjects.example.enums;

public enum PageIndices {
    ONE(1, "Contact Form"),
    TWO(2, "Support"),
    THREE(3, "Dates"),
    FOUR(4, "Complex Table"),
    FIVE(5, "Simple Table"),
    SIX(6, "Table with pages"),
    SEVEN(7, "Different Element"),
    EIGHT(8, "Metal and Colors");
    
    public final int index;
    public final String title;

    PageIndices(int number, String title) {
        this.index = number;
        this.title = title;
    }

}
