package org.mytests.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.mytests.uiobjects.example.JdiExampleSite.*;
import static org.mytests.uiobjects.example.enums.MenuOptions.SERVICE;
import static org.mytests.uiobjects.example.enums.MenuOptions.SIMPLE_TBL;
import static org.mytests.uiobjects.example.enums.SimpleTableValues.*;

public class SimpleTableTest extends InitTests {

    @DataProvider
    public static Object[][] simpleTableValues() {
        return new Object[][]{
                {new String[]{ROW_1.column1, ROW_4.column2, ROW_5.column1, ROW_1.column2}},
                {new String[]{ROW_3.column3, ROW_1.column2}},
                {new String[]{ROW_2.column1, ROW_4.column2, ROW_2.column1, ROW_2.column2}},
                {new String[]{ROW_5.column1, ROW_5.column2, ROW_4.column3}},
                {new String[]{ROW_4.column1, ROW_4.column1, ROW_4.column1}},
                {new String[]{ROW_5.column2}},
                {new String[]{ROW_6.column3, ROW_5.column2, ROW_4.column1}},
                {new String[]{ROW_4.column1, ROW_5.column2, ROW_6.column3}}
        };
    }

    @BeforeSuite
    public void openHomePageAndLogin() {
        homePage.open();
        login();
    }

    @BeforeMethod
    public void openMetalsNColorsPage() {
        header.open(SERVICE, SIMPLE_TBL);
    }

    @Test(dataProvider = "simpleTableValues", groups = "Smoke")
    public void checkClickOnSell(String[] cellValues) {
        for (String cellValue : cellValues) {
            simpleTablePage.tableCell.get(cellValue).click();
            rightSection.verifyLogContains(cellValue);
        }
    }
}
