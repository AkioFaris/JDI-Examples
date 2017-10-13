package org.mytests.tests;

import com.epam.jdi.uitests.web.selenium.elements.composite.WebPage;
import org.junit.Assert;
import org.mytests.uiobjects.example.enums.MenuOptions;
import org.mytests.uiobjects.example.enums.PageIndices;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.xbill.DNS.DNSSEC;

import static org.mytests.uiobjects.example.JdiExampleSite.*;
import static org.mytests.uiobjects.example.enums.PageIndices.*;

public class TestPagination extends InitTests {

    @DataProvider
    public static Object[][] adjacentPagesData() {
        return new Object[][]{
                {ONE, TWO, THREE},
                {TWO, THREE, FOUR},
                {THREE, FOUR, FIVE},
                {FOUR, FIVE, SIX},
                {FIVE, SIX, SEVEN},
                {SIX, SEVEN, EIGHT},
        };
    }

    @BeforeSuite
    public void openHomePageAndLogin() {
        homePage.open();
        login();
        supportPage.open();
    }

    @Test(dataProvider = "adjacentPagesData")
    public void checkAdjacentPages(PageIndices prevPage, PageIndices page, PageIndices nextPage) {
        pagination.selectPage(page.index);
        Assert.assertTrue(WebPage.getTitle().equals(page.title));

        pagination.previous();
        Assert.assertTrue(WebPage.getTitle().equals(prevPage.title));

        pagination.next();
        pagination.next();
        Assert.assertTrue(WebPage.getTitle().equals(nextPage.title));
    }


    @Test()
    public void checkClickOnPages() {
        for (PageIndices page: PageIndices.values()) {
            pagination.selectPage(page.index);
            Assert.assertTrue(WebPage.getTitle().equals(page.title));
        }

        pagination.last();
        Assert.assertTrue(WebPage.getTitle().equals(EIGHT.title));

        pagination.first();
        Assert.assertTrue(WebPage.getTitle().equals(ONE.title));
    }
}
