package org.mytests.tests.task3_from_Selinide;

import org.mytests.tests.InitTests;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.mytests.uiobjects.example.JDIExampleSite.*;

public class TestRangeSliders extends InitTests {


    @DataProvider
    public static Object[][] slidersPositions() {
        return new Object[][]{{0, 100},
                {0, 0},
                {100, 100},
                {30, 70},
                {50, 50}};
    }

    @BeforeSuite
    public void openDatesPage()
    {
        // Open test site by URL
        homePage.open();

        // Perform login
        login();

        // Assert User name in the left-top side of screen that user is loggined
        verifyLogin();

        // Open Service ->Dates
        datesPage.open();
//        header.open(DATES);
    }

    @Test(dataProvider = "slidersPositions")
    public void checkRangeSliders(int leftSliderPos, int rightSliderPos) {
        // Set left and right sliders to their positions accordingly
        datesPage.setSliders(leftSliderPos, rightSliderPos);
        datesPage.checkSliders(leftSliderPos, rightSliderPos);
    }
}
