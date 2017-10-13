package org.mytests.uiobjects.example.entities;

import com.epam.commons.DataClass;
import org.mytests.uiobjects.example.enums.*;

public class MetalsNColorsData extends DataClass {
    public EvenOddPair evenOddPair;
    public Conditions[] conditions;
    public Vegetables vegetable;
    public Colors color;
    public Metals metal;

    public MetalsNColorsData(Even even, Odd odd, Conditions[] conditions, Vegetables vegetable, Colors color, Metals metal) {
        this.evenOddPair = new EvenOddPair(even, odd);
        this.conditions = conditions;
        this.vegetable = vegetable;
        this.color = color;
        this.metal = metal;
    }
}
