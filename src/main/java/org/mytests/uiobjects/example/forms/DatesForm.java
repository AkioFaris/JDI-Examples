package org.mytests.uiobjects.example.forms;

import com.epam.jdi.uitests.core.annotations.Mandatory;
import com.epam.jdi.uitests.core.interfaces.complex.FormFilters;
import com.epam.jdi.uitests.web.selenium.elements.common.*;
import com.epam.jdi.uitests.web.selenium.elements.complex.Elements;
import com.epam.jdi.uitests.web.selenium.elements.composite.Form;
import org.mytests.uiobjects.example.entities.DatesData;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import static com.epam.jdi.uitests.core.interfaces.complex.FormFilters.ALL;
import static com.epam.jdi.uitests.core.interfaces.complex.FormFilters.MANDATORY;
import static com.epam.jdi.uitests.core.interfaces.complex.FormFilters.OPTIONAL;


public class DatesForm extends Form<DatesData> {
    @Mandatory
    @FindBy(id = "Name")
    private TextField name;

    @Mandatory
    @FindBy(id = "LastName")
    private TextField lastName;

    @Mandatory
    @FindBy(css = ".range-from input")
    private Elements<TextField> range1;

    // optional fields
    @FindBy(id = "Description")
    private TextField description;

    @FindBy(css = ".uui-slider.blue.range.ui-slider")
    private Image sliderTrack;

    @FindBy(css = ".ui-slider-handle")
    private Elements<Link> range2;

    @FindBy(id = "timepicker")
    private TextField time;

    @FindBy(css ="#datepicker input")
    private DatePicker date;

    @FindBy(css = ".m-t35[type=submit]")
    private Button submit;

    private FormFilters currentFilter = ALL;

    @Override
    public void filter(FormFilters filter)
    {
        currentFilter = filter;
        super.filter(filter);
    }

    @Override
    public void submit(DatesData datesData) {
        if(currentFilter != MANDATORY) {
            setSliders(datesData.range2.from, datesData.range2.to);
        }
        if(currentFilter != OPTIONAL) {
            range1.get(0).sendKeys(String.valueOf(datesData.range1.from));
            range1.get(1).sendKeys(String.valueOf(datesData.range1.to));
        }
        super.submit(datesData);
    }

    public void submit() {
        submit.click();
    }



    private Double getStepInPixels() {
        return sliderTrack.getWebElement().getSize().width / 100.0;
    }

    private Double getPosInPixels(Link slider) {
        return Double.parseDouble(slider.getWebElement().getCssValue("left")
                .replaceAll("px", "")) + slider.getWebElement().getSize().width / 2.0;
    }

    private int getSliderPosition(Link slider) {
        return new Integer(slider.getText());
    }

    private void correctPosition(Link slider, int position) {
        int currPos = getSliderPosition(slider);
        if (currPos == position)
            return;
        int xOffset = (int) Math.round(getStepInPixels());
        int yOffset = 0;
        if (currPos > position)
            xOffset *= -1;
        while (currPos != position) {
            slider.dragAndDropBy(xOffset, yOffset);
            currPos = getSliderPosition(slider);
        }
    }

    private void moveSliderToPos(Link slider, int position) {
        int xOffset = (int) Math.round(position * getStepInPixels() - getPosInPixels(slider));
        int yOffset = 0;
        slider.dragAndDropBy(xOffset, yOffset);
        correctPosition(slider, position);
    }

    public void setSliders(int leftSliderPos, int rightSliderPos) {
        if (rightSliderPos < leftSliderPos)
            return;
        if (getSliderPosition(range2.get(1)) <= leftSliderPos) {
            moveSliderToPos(range2.get(1), rightSliderPos);
            moveSliderToPos(range2.get(0), leftSliderPos);
        } else {
            moveSliderToPos(range2.get(0), leftSliderPos);
            moveSliderToPos(range2.get(1), rightSliderPos);
        }
    }

    public void checkSliders(int leftSliderPos, int rightSliderPos) {
        Assert.assertEquals(range2.get(0).getText(), Integer.toString(leftSliderPos));
        Assert.assertEquals(range2.get(1).getText(), Integer.toString(rightSliderPos));
    }

}
