package org.mytests.uiobjects.example.pages;

import com.epam.jdi.uitests.web.selenium.elements.common.Image;
import com.epam.jdi.uitests.web.selenium.elements.common.Text;
import com.epam.jdi.uitests.web.selenium.elements.complex.Elements;
import com.epam.jdi.uitests.web.selenium.elements.complex.TextList;
import com.epam.jdi.uitests.web.selenium.elements.composite.WebPage;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.JPage;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

@JPage(url = "/index.htm", title = "Index Page")
public class HomePage extends WebPage {
    @FindBy(css = ".benefit-icon")
    private Elements<Image> pictures;

    @FindBy(css = ".benefit-txt")
    private TextList picLabels;

    @FindBy(css = ".main-title")
    private Text title;

    @FindBy(css = ".main-txt")
    private Text mainText;

    public void checkInterface() {
        Assert.assertTrue(pictures.isDisplayed());
        Assert.assertTrue(picLabels.isDisplayed());
        Assert.assertTrue(title.isDisplayed());
        Assert.assertTrue(mainText.isDisplayed());
    }
}
