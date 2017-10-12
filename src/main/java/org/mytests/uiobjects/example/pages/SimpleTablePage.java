package org.mytests.uiobjects.example.pages;

import com.epam.jdi.uitests.web.selenium.elements.common.Button;
import com.epam.jdi.uitests.web.selenium.elements.complex.Elements;
import com.epam.jdi.uitests.web.selenium.elements.composite.WebPage;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.JPage;
import org.openqa.selenium.support.FindBy;

@JPage(url = "/page6.htm", title = "Simple Table")
public class SimpleTablePage extends WebPage {
    @FindBy(css = ".tbl-without-header td")
    public Elements<Button> tableCell;

}
