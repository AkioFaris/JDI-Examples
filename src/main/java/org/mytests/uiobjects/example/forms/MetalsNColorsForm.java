package org.mytests.uiobjects.example.forms;

import com.epam.jdi.uitests.web.selenium.elements.common.Button;
import com.epam.jdi.uitests.web.selenium.elements.common.CheckBox;
import com.epam.jdi.uitests.web.selenium.elements.common.Label;
import com.epam.jdi.uitests.web.selenium.elements.common.TextField;
import com.epam.jdi.uitests.web.selenium.elements.complex.Elements;
import com.epam.jdi.uitests.web.selenium.elements.composite.Form;
import org.mytests.uiobjects.example.entities.MetalsNColorsData;
import org.mytests.uiobjects.example.enums.Colors;
import org.mytests.uiobjects.example.enums.Conditions;
import org.mytests.uiobjects.example.enums.Vegetables;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;


public class MetalsNColorsForm extends Form<MetalsNColorsData> {

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

    @Step
    public void selectElement(Conditions condition) {
        elementsCheckboxes.get(condition.ordinal()).click();
    }

    @Step
    public void submitSaladIngredient(Vegetables vegetable) {
        saladDropdownButton.click();
        saladCheckboxes.get(vegetable.ordinal()).click();
        submit.click();
    }

    @Step
    public void selectColor(Colors color) {
        colorsDropdownButton.click();
        colorsDropdown.get(color.ordinal() + 1).click();
    }

    @Step
    public void addMetal(String metal) {
        metalsInput.sendKeys(metal);
    }

    @Step
    @Override
    public void submit(MetalsNColorsData data) {
        evenOddCalcForm.submit(data.evenOddPair);
        for (Conditions condition : data.conditions) {
            selectElement(condition);
        }
        selectColor(data.color);
        addMetal(data.metal.text);
        super.fill(data);
        submitSaladIngredient(data.vegetable);
    }

}
