package org.mytests.uiobjects.example.pages;

import com.epam.jdi.uitests.web.selenium.elements.composite.WebPage;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.JPage;
import org.mytests.uiobjects.example.entities.DatesData;
import org.mytests.uiobjects.example.forms.DatesForm;

import static org.mytests.uiobjects.example.JdiExampleSite.rightSection;


@JPage(url = "/page4.htm", title = "Dates")
public class DatesPage extends WebPage {
    public DatesForm datesForm;

    public Boolean checkResultContainsOptionalFields(DatesData datesData) {
        return rightSection.checkResultContains(datesData.description)
                && rightSection.checkResultContains(datesData.time)
                && rightSection.checkResultContains(datesData.date)
                && rightSection.checkResultContains(Integer.toString(datesData.range2.from))
                && rightSection.checkResultContains(Integer.toString(datesData.range2.to));
    }


    public Boolean checkResultContainsMandatoryFields(DatesData datesData) {
        return rightSection.checkResultContains(datesData.name)
                && rightSection.checkResultContains(datesData.lastName)
                && rightSection.checkResultContains(Integer.toString(datesData.range1.from))
                && rightSection.checkResultContains(Integer.toString(datesData.range1.to));
    }


}
