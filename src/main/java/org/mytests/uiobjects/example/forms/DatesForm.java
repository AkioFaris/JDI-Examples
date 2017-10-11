package org.mytests.uiobjects.example.forms;

import com.epam.jdi.uitests.core.annotations.Mandatory;
import com.epam.jdi.uitests.web.selenium.elements.common.Button;
import com.epam.jdi.uitests.web.selenium.elements.common.DatePicker;
import com.epam.jdi.uitests.web.selenium.elements.common.Link;
import com.epam.jdi.uitests.web.selenium.elements.common.TextField;
import com.epam.jdi.uitests.web.selenium.elements.complex.Elements;
import com.epam.jdi.uitests.web.selenium.elements.composite.Form;
import org.mytests.uiobjects.example.entities.DatesData;
import org.openqa.selenium.support.FindBy;


public class DatesForm extends Form<DatesData> {
    @Mandatory
    @FindBy(id = "Name")
    public TextField name;

    @Mandatory
    @FindBy(id = "LastName")
    public TextField lastName;

//    @Mandatory
//    @FindBy(css = ".range-from input")
//    public Elements<TextField> range1;

    // optional fields
    @FindBy(id = "Description")
    public TextField description;

    @FindBy(css = ".ui-slider-handle")
    public Elements<Link> range2;

    @FindBy(id = "timepicker")
    public TextField time;

    @FindBy(id = "datepicker")
    public DatePicker date;

    @FindBy(css = ".m-t35[type=submit]")
    public Button submit;

    /*@Override
    public void submit(DatesData datesData) {
//        range1.get(0).setAttribute("text", String.valueOf(datesData.range1.from));
//        range1.get(1).setAttribute("text", String.valueOf(datesData.range1.to));
        fill(datesData);
        getElementClass.getButton("submit").click();
    }*/
}
