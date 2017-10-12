package org.mytests.uiobjects.example.entities;

import com.epam.commons.DataClass;

public class DatesData extends DataClass {
    // mandatory fields
    public String name;
    public String lastName;
    public Range range1;

    // optional fields
    public String description;
    public Range range2;
    public String time;
    public String date;

    public DatesData() {
    }

    public DatesData(String name, String lastName) {
        this.name = name;
        this.lastName = lastName;
    }

    public DatesData(String name, String lastName, Range range1, String description, Range range2, String time,
                     String date) {
        this.name = name;
        this.lastName = lastName;
        this.range1 = range1;
        this.description = description;
        this.range2 = range2;
        this.time = time;
        this.date = date;
    }

    public DatesData(String name, String lastName, int range1From, int range1To, String description,
                     int range2From, int range2To, String time, String date) {
        this.name = name;
        this.lastName = lastName;
        range1 = new Range(range1From, range1To);
        this.description = description;
        range2 = new Range(range2From, range2To);
        this.time = time;
        this.date = date;
    }

    public DatesData(DatesData data)
    {
        this.name = data.name;
        this.lastName = data.lastName;
        range1 = new Range(data.range1.from, data.range1.to);
        this.description = data.description;
        range2 = new Range(data.range2.from, data.range2.to);
        this.time = data.time;
        this.date = data.date;
    }
}
