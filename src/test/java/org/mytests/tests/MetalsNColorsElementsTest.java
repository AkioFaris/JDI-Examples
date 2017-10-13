package org.mytests.tests;


import org.mytests.uiobjects.example.entities.MetalsNColorsData;
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
import static org.mytests.uiobjects.example.enums.Even.*;
import static org.mytests.uiobjects.example.enums.Metals.*;
import static org.mytests.uiobjects.example.enums.Odd.*;
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

    @DataProvider
    public static Object[][] metalsNColorsData() {
        return new Object[][]{
                {new MetalsNColorsData(FOUR, ONE, new Conditions[]{WATER, WIND}, ONION, BLUE, SILVER)},
                {new MetalsNColorsData(TWO, THREE, new Conditions[]{EARTH}, TOMATO, BLUE, GOLD)},
                {new MetalsNColorsData(SIX, FIVE, new Conditions[]{FIRE, WIND, EARTH}, CUCUMBER, BLUE, SELEN)},
                {new MetalsNColorsData(EIGHT, ONE, new Conditions[]{FIRE}, TOMATO, RED, BRONZE)},
                {new MetalsNColorsData(FOUR, SEVEN, new Conditions[]{WATER, WIND}, TOMATO, YELLOW, BRONZE)},
                {new MetalsNColorsData(SIX, ONE, new Conditions[]{EARTH, WATER, FIRE, WIND}, ONION, GREEN, SILVER)},
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
        metalsNColorsPage.metalsNColorsForm.addMetal(metal);
        metalsNColorsPage.metalsNColorsForm.selectColor(color);
        rightSection.verifyLogContains(metal);
        rightSection.verifyLogContains(color.text);
    }

    @Test(dataProvider = "vegetableAndCondition")
    public void checkCheckboxes(Vegetables[] vegetables, Conditions condition) {
        for (Vegetables vegetable: vegetables) {
            metalsNColorsPage.metalsNColorsForm.submitSaladIngredient(vegetable);
        }
        metalsNColorsPage.metalsNColorsForm.selectElement(condition);
        for (Vegetables vegetable: vegetables) {
            rightSection.verifyResultContains(vegetable.text);
        }
        rightSection.verifyLogContains(condition.text);
    }

    @Test(dataProvider = "metalsNColorsData")
    public void checkSubmitAllFields(MetalsNColorsData metalsNColorsData) {
        metalsNColorsPage.metalsNColorsForm.submit(metalsNColorsData);
        metalsNColorsPage.verifyResultContainsAllFields(metalsNColorsData);
    }

}
