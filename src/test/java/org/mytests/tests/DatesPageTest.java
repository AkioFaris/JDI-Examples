package org.mytests.tests;

import com.epam.jdi.uitests.core.interfaces.complex.FormFilters;
import org.mytests.uiobjects.example.entities.DatesData;
import org.testng.Assert;
import org.testng.annotations.*;
import ru.yandex.qatools.allure.annotations.Description;

import static com.epam.jdi.uitests.core.interfaces.complex.FormFilters.ALL;
import static org.mytests.uiobjects.example.JdiExampleSite.*;
import static org.mytests.uiobjects.example.enums.DatesDataValues.*;
import static org.mytests.uiobjects.example.enums.MenuOptions.DATES;
import static org.mytests.uiobjects.example.enums.MenuOptions.SERVICE;

public class DatesPageTest extends InitTests {

    @DataProvider
    public static Object[][] incorrectDatesData() {
        return new Object[][]{
                // name, lastName, range1, time, date
                {new DatesData(INCORRECT.data.name, CORRECT.data.lastName, CORRECT.data.range1, EMPTY.data.description,
                        CORRECT.data.range2, CORRECT.data.time, CORRECT.data.date)},
                {new DatesData(CORRECT.data.name, INCORRECT.data.lastName, CORRECT.data.range1, EMPTY.data.description,
                        CORRECT.data.range2, CORRECT.data.time, CORRECT.data.date)},
                {new DatesData(CORRECT.data.name, CORRECT.data.lastName, INCORRECT.data.range1, EMPTY.data.description,
                        CORRECT.data.range2, CORRECT.data.time, CORRECT.data.date)},
                {new DatesData(CORRECT.data.name, CORRECT.data.lastName, CORRECT.data.range1, EMPTY.data.description,
                        CORRECT.data.range2, INCORRECT.data.time, CORRECT.data.date)},
                {new DatesData(CORRECT.data.name, CORRECT.data.lastName, CORRECT.data.range1, EMPTY.data.description,
                        CORRECT.data.range2, CORRECT.data.time, INCORRECT.data.date)},

        };
    }

    @BeforeSuite
    public void openHomePageAndLogin() {
        homePage.open();
        login();
    }

    @BeforeMethod
    public void openDatesPage() {
        header.open(SERVICE, DATES);
    }

    @Test
    public void checkSubmitAllFields() {
        DatesData datesData = new DatesData(CORRECT.data);
        datesPage.datesForm.filter(ALL);
        datesPage.datesForm.submit(datesData);
        Assert.assertTrue(datesPage.checkResultContainsMandatoryFields(datesData) &&
                datesPage.checkResultContainsOptionalFields(datesData));
    }

    @Test
    public void checkFillMandatoryFields() {
        DatesData datesData = new DatesData(CORRECT.data);
        datesPage.datesForm.onlyMandatory().fill(datesData);
        datesPage.datesForm.fillRange1(datesData);
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
    public void checkSubmitIncorrectData(DatesData datesData) {
        datesPage.datesForm.submit(datesData);
        Assert.assertTrue(rightSection.checkResultContains("Error")
                || rightSection.checkResultContains("Error".toUpperCase())
                || rightSection.checkResultContains("Error".toLowerCase()));
    }
}
