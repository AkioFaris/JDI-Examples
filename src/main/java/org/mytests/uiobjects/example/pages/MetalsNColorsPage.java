package org.mytests.uiobjects.example.pages;

import com.epam.jdi.uitests.web.selenium.elements.composite.WebPage;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.JPage;
import org.mytests.uiobjects.example.entities.EvenOddPair;
import org.mytests.uiobjects.example.forms.EvenOddCalcForm;

import static org.mytests.uiobjects.example.JdiExampleSite.rightSection;


@JPage(url = "/page2.htm", title = "Metal & Colors")
public class MetalsNColorsPage extends WebPage {
    public EvenOddCalcForm evenOddCalcForm;

    public void checkCalcResult(EvenOddPair pair) {
        int even = Integer.valueOf(pair.even.number);
        int odd = Integer.valueOf(pair.odd.number);
        rightSection.verifyResultContains("Summary: " + String.valueOf(even + odd));
    }
}
