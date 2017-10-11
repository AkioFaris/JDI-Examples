package org.mytests.uiobjects.example.pages;

import com.epam.jdi.uitests.web.selenium.elements.common.Button;
import com.epam.jdi.uitests.web.selenium.elements.common.CheckBox;
import com.epam.jdi.uitests.web.selenium.elements.complex.Dropdown;
import com.epam.jdi.uitests.web.selenium.elements.complex.Elements;
import com.epam.jdi.uitests.web.selenium.elements.complex.RadioButtons;
import com.epam.jdi.uitests.web.selenium.elements.composite.WebPage;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.JPage;
import org.mytests.uiobjects.example.enums.Conditions;
import org.mytests.uiobjects.example.enums.Colors;
import org.mytests.uiobjects.example.enums.Metals;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import static org.mytests.uiobjects.example.JDIExampleSite.leftSection;
import static org.mytests.uiobjects.example.JDIExampleSite.rightSection;


@JPage(url = "/page8.htm", title = "Different Element")
public class DifferentElementsPage extends WebPage {
    @FindBy(css = ".label-checkbox input")
    private Elements<CheckBox> checkboxes;

     /*@FindBy(css = ".label-checkbox")
    public ICheckList<Conditions> checkboxes = new CheckList<Conditions>() {
        @Override
        protected boolean isSelectedAction(WebElement el) {
            return el.findElement(By.tagName("input")).getAttribute("checked") != null;
        }
    };*/

    @FindBy(css = "label.label-radio input")
    private RadioButtons<Metals> radioButtons;

    final private Dropdown<Colors> dropdown = new Dropdown<>(
            By.cssSelector("div.colors"),
            By.cssSelector(".uui-form-element option")
    );

    @FindBy(css = "[name='Default Button']")
    private Button defaultBtn;

    @FindBy(css = "input.uui-button")
    private Button button;


    public void checkInterface() {
        Assert.assertTrue(checkboxes.isDisplayed());
        Assert.assertTrue(radioButtons.isDisplayed());
        Assert.assertTrue(dropdown.isDisplayed());
        Assert.assertTrue(defaultBtn.isDisplayed());
        Assert.assertTrue(button.isDisplayed());
        Assert.assertTrue(defaultBtn.isDisplayed());
        Assert.assertTrue(defaultBtn.isDisplayed());
        leftSection.checkInterface();
        rightSection.checkInterface();
    }

    public void selectCheckbox(Conditions checkboxLabel) {
        checkboxes.get(checkboxLabel.ordinal()).check();
//        checkboxes.check(checkboxLabel);

    }

    public void deselectCheckbox(Conditions checkboxLabel) {
//        checkboxes.uncheck(checkboxLabel);
        checkboxes.get(checkboxLabel.ordinal()).uncheck();
    }

    public void checkCheckbox(Conditions checkboxLabel, Boolean isSelected) {
        if (isSelected) {
            Assert.assertTrue(checkboxes.get(checkboxLabel.ordinal()).isChecked());
        } else {
            Assert.assertTrue(!(checkboxes.get(checkboxLabel.ordinal()).isChecked()));
        }
    }

    public void selectRadio(Metals radioLabel) {
        radioButtons.select(radioLabel.ordinal() + 1);
    }

    public void selectInDropdown(Colors color) {
        dropdown.select(color.ordinal() + 1);
    }

    public void checkValueChanged(String subStr) {
        rightSection.verifyLogContains(subStr);
    }

    public void checkConditionChanged(String subStr, Boolean status) {
        Assert.assertTrue(rightSection.checkLogStatus(subStr, status));
    }
}
