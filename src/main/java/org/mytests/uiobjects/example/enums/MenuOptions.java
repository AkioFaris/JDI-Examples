package org.mytests.uiobjects.example.enums;

public enum MenuOptions {
//    main menu options
    HOME("Home"), CONTACT_FORM("Contact Form"), SERVICE("Service"), METALS_AND_COLORS("Metals & Colors"),

//    dropdown menu options
    SUPPORT("Support"), DATES("Dates"), COMPLEX_TBL("Complex Table"),
    SIMPLE_TBL("Simple Table"), PAGES_TBL("Pages Table"), DIFF_EL("Different Elements");

    final private String label;

    public String getLabel() {
        return label;
    }

    MenuOptions(String label) {
        this.label = label;
    }
}
