package org.mytests.tests.task3_from_Selinide;

import org.mytests.tests.InitTests;
import org.mytests.uiobjects.example.enums.Colors;
import org.mytests.uiobjects.example.enums.Conditions;
import org.mytests.uiobjects.example.enums.Metals;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.mytests.uiobjects.example.JdiExampleSite.*;
import static org.mytests.uiobjects.example.enums.Colors.*;
import static org.mytests.uiobjects.example.enums.Conditions.*;
import static org.mytests.uiobjects.example.enums.MenuOptions.*;
import static org.mytests.uiobjects.example.enums.Metals.*;

public class TestUIElements extends InitTests {
    @DataProvider()
    public Object[][] conditionsMetalColorData() {
        return new Object[][]{
                {WIND, WATER, SELEN, YELLOW},
                {EARTH, FIRE, GOLD, GREEN},
                {WATER, EARTH, SILVER, RED},
                {FIRE, WIND, BRONZE, BLUE}};
    }

    @BeforeSuite
    public void openHomePageAndLogin() {
        //1 Open test site by URL
        homePage.open();

        //2 Perform login
        login();
    }

    @Test(groups = "Regression")
    public void checkExistenceOfElements() {
        //1 Open test site by URL
        header.open(HOME);

        //2 Assert User name in the left-top side of screen that user is logged in
        verifyLogin();

        //3 Check interface on Home page, it contains all needed elements.
        homePage.checkInterface();

        //4 Click on "Service" subcategory in the header and check that drop down contains options
        header.checkServiceOptions();

        //5 Click on Service subcategory in the left section and check that drop down contains options
        leftSection.checkServiceOptions();
    }

    @Test(dataProvider = "conditionsMetalColorData")
    public void checkSelectorsAndCheckers(Conditions condition1, Conditions condition2, Metals metal, Colors color) {
        //1 Open through the header menu Service -> Different Elements PageObject
        header.open(SERVICE, DIFF_EL);

        //2 Check interface on Service page, it contains all needed elements.
        diffElementsPage.checkInterface();

        //3 Select and assert checkboxes
        diffElementsPage.selectCheckbox(condition1);
        diffElementsPage.checkCheckbox(condition1, true);
        diffElementsPage.selectCheckbox(condition2);
        diffElementsPage.checkCheckbox(condition2, true);

        //4 Select radio
        diffElementsPage.selectRadio(metal);

        //5 Select in dropdown
        diffElementsPage.selectInDropdown(color);

        //6 Check in logs section selected values and status (true|false)
        diffElementsPage.checkConditionChanged(condition1.text, true);
        diffElementsPage.checkConditionChanged(condition2.text, true);
        diffElementsPage.checkValueChanged(metal.text);
        if (color != RED) { // the default (red) color won't be changed so it won't appear in log
            diffElementsPage.checkValueChanged(color.text);
        }

        //7 Deselect and assert checkboxes
        diffElementsPage.deselectCheckbox(condition1);
        diffElementsPage.checkCheckbox(condition1, false);
        diffElementsPage.deselectCheckbox(condition2);
        diffElementsPage.checkCheckbox(condition2, false);

        //8 Check in logs section unselected values and status (true|false)
        diffElementsPage.checkConditionChanged(condition1.text, false);
        diffElementsPage.checkConditionChanged(condition2.text, false);
    }
}

