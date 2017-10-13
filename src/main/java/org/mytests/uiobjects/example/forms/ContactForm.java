package org.mytests.uiobjects.example.forms;

import com.epam.jdi.uitests.web.selenium.elements.common.Button;
import com.epam.jdi.uitests.web.selenium.elements.common.TextField;
import com.epam.jdi.uitests.web.selenium.elements.composite.Form;
import org.mytests.uiobjects.example.entities.DatesData;
import org.openqa.selenium.support.FindBy;


public class ContactForm extends Form<DatesData> {
    @FindBy(id = "Name")
    public TextField name;

    @FindBy(id = "LastName")
    public TextField lastName;

    @FindBy(css = ".col-sm-6.text-right [type=submit]")
    public Button submit;

}
