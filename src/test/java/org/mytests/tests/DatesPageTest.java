package org.mytests.tests;

import org.mytests.uiobjects.example.entities.DatesData;
import org.mytests.uiobjects.example.entities.Range;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Description;

import static org.mytests.uiobjects.example.JdiExampleSite.*;
import static org.mytests.uiobjects.example.enums.DatesDataValues.*;

public class DatesPageTest extends InitTests {

    @DataProvider
    public static Object[][] incorrectDatesData() {
        return new Object[][]{
                // name, lastName, range1, time, date
                {INCORRECT.data.name, CORRECT.data.lastName, CORRECT.data.range1, CORRECT.data.time, CORRECT.data.date},
                {CORRECT.data.name, INCORRECT.data.lastName, CORRECT.data.range1, CORRECT.data.time, CORRECT.data.date},
                {CORRECT.data.name, CORRECT.data.lastName, INCORRECT.data.range1, CORRECT.data.time, CORRECT.data.date},
                {CORRECT.data.name, CORRECT.data.lastName, CORRECT.data.range1, INCORRECT.data.time, CORRECT.data.date},
                {CORRECT.data.name, CORRECT.data.lastName, CORRECT.data.range1, CORRECT.data.time, INCORRECT.data.date},

        };
    }

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
        Assert.assertTrue(datesPage.checkResultContainsMandatoryFields(datesData) &&
                datesPage.checkResultContainsOptionalFields(datesData));
    }

    @Test
    public void checkFillMandatoryFields() {
        DatesData datesData = new DatesData(CORRECT.data);
        datesPage.datesForm.onlyMandatory().fill(datesData);
    }

    @Test
    public void checkSubmitOptionalFields() {
        DatesData datesData = new DatesData(CORRECT.data);
        datesPage.datesForm.onlyOptional().submit(datesData);
        Assert.assertTrue(!datesPage.checkResultContainsMandatoryFields(datesData) &&
                datesPage.checkResultContainsOptionalFields(datesData));
    }

    @Test
    public void checkSubmitEmptyFields() {
        datesPage.datesForm.submit();
        Assert.assertTrue(!rightSection.checkResultContains("Name") && !rightSection.checkResultContains("Range 1"));
    }

    @Description("This test is expected to be failed because of a bug on the JDI test site.")
    @Test(dataProvider = "incorrectDatesData")
    public void checkSubmitIncorrectData(String name, String lastName, Range range1,
                                         String time, String date) {
        DatesData datesData = new DatesData(name, lastName, range1, EMPTY.data.description, CORRECT.data.range2,
                time, date);
        datesPage.datesForm.submit(datesData);
        Assert.assertTrue(rightSection.checkResultContains("Error")
                || rightSection.checkResultContains("Error".toUpperCase())
                || rightSection.checkResultContains("Error".toLowerCase()));
    }
}
