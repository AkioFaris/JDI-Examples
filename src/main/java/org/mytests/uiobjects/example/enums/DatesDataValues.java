package org.mytests.uiobjects.example.enums;

import org.mytests.uiobjects.example.entities.DatesData;

public enum DatesDataValues {
    CORRECT("Stefani", "Nkodia", 20, 50, "EPAM's student.", 0, 0, "6:30 PM", "09/28/2017"),
    INCORRECT(" ➄ ste f ani", "Nk ➄di ➄", -30, -50, " ➄ ➄ ➄", 50, 20, "time", "date"),
    EMPTY("", "", 0, 0, "", 0, 0, "", "");

    public final DatesData data;

    DatesDataValues(String name, String lastName, int range1From, int range1To,
                    String description, int range2From, int range2To, String time, String date) {
        data = new DatesData(name, lastName, range1From, range1To,
                description, range2From, range2To, time, date);
    }
}
