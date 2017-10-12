package org.mytests.uiobjects.example.forms;

import com.epam.jdi.uitests.web.selenium.elements.common.Button;
import com.epam.jdi.uitests.web.selenium.elements.common.CheckBox;
import com.epam.jdi.uitests.web.selenium.elements.complex.Elements;
import com.epam.jdi.uitests.web.selenium.elements.complex.RadioButtons;
import com.epam.jdi.uitests.web.selenium.elements.composite.Form;
import org.mytests.uiobjects.example.entities.EvenOddPair;
import org.mytests.uiobjects.example.enums.Even;
import org.mytests.uiobjects.example.enums.Odd;
import org.openqa.selenium.support.FindBy;


public class EvenOddCalcForm extends Form<EvenOddPair> {
    @FindBy(css = "#odds-selector .radio")
    private RadioButtons<Odd> oddNumbers;

    @FindBy(css = "#even-selector .radio")
    private RadioButtons<Even> evenNumbers;

    @FindBy(id = "calculate-button")
    private Button calculate;

    @Override
    public void submit(EvenOddPair evenOddPair) {
        oddNumbers.select(evenOddPair.odd.ordinal() + 1);
        evenNumbers.select(evenOddPair.even.ordinal() + 1);
        super.submit(evenOddPair);
    }
}
