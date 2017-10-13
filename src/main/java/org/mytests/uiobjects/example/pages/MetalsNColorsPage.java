package org.mytests.uiobjects.example.pages;

import com.epam.jdi.uitests.web.selenium.elements.common.Button;
import com.epam.jdi.uitests.web.selenium.elements.common.CheckBox;
import com.epam.jdi.uitests.web.selenium.elements.common.Label;
import com.epam.jdi.uitests.web.selenium.elements.common.TextField;
import com.epam.jdi.uitests.web.selenium.elements.complex.Elements;
import com.epam.jdi.uitests.web.selenium.elements.composite.WebPage;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.JPage;
import org.mytests.uiobjects.example.entities.EvenOddPair;
import org.mytests.uiobjects.example.enums.Colors;
import org.mytests.uiobjects.example.enums.Conditions;
import org.mytests.uiobjects.example.enums.Vegetables;
import org.mytests.uiobjects.example.forms.EvenOddCalcForm;
import org.openqa.selenium.support.FindBy;

import static org.mytests.uiobjects.example.JdiExampleSite.rightSection;


@JPage(url = "/page2.htm", title = "Metal & Colors")
public class MetalsNColorsPage extends WebPage {
    public EvenOddCalcForm evenOddCalcForm;

    @FindBy(css = "#submit-button[type='submit']")
    private Button submit;

    @FindBy(css = ".vertical-group .checkbox label")
    private Elements<CheckBox> elementsCheckboxes;

    @FindBy(css = (".form-group .dropdown.salad"))
    private Button saladDropdownButton;

    @FindBy(css = ".form-group .dropdown.salad label")
    private Elements<CheckBox> saladCheckboxes;

    @FindBy(css = ".form-group.colors")
    private Button colorsDropdownButton;

    @FindBy(css = ".form-group.colors .dropdown-menu li")
    private Elements<Label> colorsDropdown;

    @FindBy(css = ".form-group.metals input")
    private TextField metalsInput;

    public void checkCalcResult(EvenOddPair pair) {
        int even = Integer.valueOf(pair.even.number);
        int odd = Integer.valueOf(pair.odd.number);
        rightSection.verifyResultContains("Summary: " + String.valueOf(even + odd));
    }

    public void selectElement(Conditions condition) {
        elementsCheckboxes.get(condition.ordinal()).click();
    }

    public void submitSaladIngredient(Vegetables vegetable) {
        saladDropdownButton.click();
        saladCheckboxes.get(vegetable.ordinal()).click();
        submit.click();
    }

    public void selectColor(Colors color) {
        colorsDropdownButton.click();
        colorsDropdown.get(color.ordinal() + 1).click();
    }

    public void addMetal(String metal) {
        metalsInput.sendKeys(metal);
    }

}
