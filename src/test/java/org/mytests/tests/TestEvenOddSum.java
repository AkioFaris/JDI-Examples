package org.mytests.tests;

import org.mytests.uiobjects.example.entities.EvenOddPair;
import org.mytests.uiobjects.example.enums.Even;
import org.mytests.uiobjects.example.enums.MenuOptions;
import org.mytests.uiobjects.example.enums.Odd;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.mytests.uiobjects.example.JdiExampleSite.*;
import static org.mytests.uiobjects.example.enums.Even.*;
import static org.mytests.uiobjects.example.enums.Odd.*;

public class TestEvenOddSum extends InitTests {

    @DataProvider
    public static Object[][] evenOddSumData() {
        return new Object[][]{
                {TWO, ONE},
                {SIX, FIVE},
                {EIGHT, THREE},
                {FOUR, SEVEN}

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

    @Test(dataProvider = "evenOddSumData")
    public void checkCalculateSum(Even even, Odd odd) {
        EvenOddPair pair = new EvenOddPair(even, odd);
        metalsNColorsPage.evenOddCalcForm.submit(pair);
        metalsNColorsPage.checkCalcResult(pair);
    }
}
