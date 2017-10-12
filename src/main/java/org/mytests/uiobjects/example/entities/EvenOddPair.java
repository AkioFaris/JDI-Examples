package org.mytests.uiobjects.example.entities;

import org.mytests.uiobjects.example.enums.Even;
import org.mytests.uiobjects.example.enums.Odd;

public class EvenOddPair {
    public Even even;
    public Odd odd;

    public EvenOddPair(Even even, Odd odd) {
        this.even = even;
        this.odd = odd;
    }
}
