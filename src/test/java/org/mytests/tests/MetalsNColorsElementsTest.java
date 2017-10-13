package org.mytests.tests;


import org.mytests.uiobjects.example.enums.Colors;
import org.mytests.uiobjects.example.enums.Conditions;
import org.mytests.uiobjects.example.enums.Vegetables;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.mytests.uiobjects.example.JdiExampleSite.*;
import static org.mytests.uiobjects.example.enums.Colors.*;
import static org.mytests.uiobjects.example.enums.Conditions.*;
import static org.mytests.uiobjects.example.enums.Metals.BRONZE;
import static org.mytests.uiobjects.example.enums.Metals.SELEN;
import static org.mytests.uiobjects.example.enums.Vegetables.*;

public class MetalsNColorsElementsTest extends InitTests {

    @DataProvider
    public static Object[][] colorAndMental() {
        return new Object[][]{
                {RED, SELEN.text},
                {YELLOW, "Aluminum"},
                {GREEN, "Copper"},
                {BLUE, BRONZE.text}
        };
    }

    @DataProvider
    public static Object[][] vegetableAndCondition() {
        return new Object[][]{
                {new Vegetables[]{SALAD, SALAD}, WATER},
                {new Vegetables[]{CUCUMBER}, WIND},
                {new Vegetables[]{TOMATO, CUCUMBER, ONION}, FIRE},
                {new Vegetables[]{TOMATO, ONION}, EARTH},
        };
    }

    @BeforeSuite
    public void openHomePageAndLogin() {
        homePage.open();
        login();
    }

    @BeforeMethod
    public void openMetalsNColorsPage() {
        metalsNColorsPage.open();
    }

    @Test(dataProvider = "colorAndMental")
    public void checkDropdowns(Colors color, String metal) {
        metalsNColorsPage.addMetal(metal);
        metalsNColorsPage.selectColor(color);
        rightSection.verifyLogContains(metal);
        rightSection.verifyLogContains(color.text);
    }

    @Test(dataProvider = "vegetableAndCondition")
    public void checkCheckboxes(Vegetables[] vegetables, Conditions condition) {
        for (Vegetables vegetable: vegetables) {
            metalsNColorsPage.submitSaladIngredient(vegetable);
        }
        metalsNColorsPage.selectElement(condition);
        for (Vegetables vegetable: vegetables) {
            rightSection.verifyResultContains(vegetable.text);
        }
        rightSection.verifyLogContains(condition.text);
    }
}
