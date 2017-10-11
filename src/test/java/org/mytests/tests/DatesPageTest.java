package org.mytests.tests;

import org.mytests.uiobjects.example.entities.DatesData;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import static org.mytests.uiobjects.example.JDIExampleSite.*;
import static org.mytests.uiobjects.example.enums.DatesDataValues.CORRECT;
import static org.mytests.uiobjects.example.enums.DatesDataValues.EMPTY;

public class DatesPageTest extends InitTests {

    @BeforeSuite
    public void openHomePageAndLogin() {
        homePage.open();
        login();
    }

    @BeforeMethod
    public void openDatesPage() {
        datesPage.open();
    }

    @Test
    public void checkSubmitAllFields() {
        DatesData datesData = new DatesData(CORRECT.data);
        datesPage.datesForm.submit(datesData);
        Assert.assertTrue(rightSection.checkResultContainsMandatoryFields(datesData) &&
                rightSection.checkResultContainsOptionalFields(datesData));
    }

    @Test
    public void checkFillMandatoryFields() {
        DatesData datesData = new DatesData(CORRECT.data);
        datesPage.datesForm.onlyMandatory().fill(datesData);
        datesPage.datesForm.fill(datesData);
    }

    @Test
    public void checkSubmitOptionalFields() {
        DatesData datesData = new DatesData(CORRECT.data);
        datesPage.datesForm.onlyOptional().submit(datesData);
        Assert.assertTrue(!rightSection.checkResultContainsMandatoryFields(datesData) &&
                rightSection.checkResultContainsOptionalFields(datesData));
    }

    @Test
    public void checkSubmitEmptyFields() {
        DatesData datesData = new DatesData(EMPTY.data);
        datesPage.datesForm.submit(datesData);
        Assert.assertTrue(!rightSection.checkResultContains("Name") && !rightSection.checkResultContains("Range 1"));
    }
}
