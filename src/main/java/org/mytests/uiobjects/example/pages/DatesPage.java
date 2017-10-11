package org.mytests.uiobjects.example.pages;

import com.epam.jdi.uitests.web.selenium.elements.common.Image;
import com.epam.jdi.uitests.web.selenium.elements.common.Link;
import com.epam.jdi.uitests.web.selenium.elements.complex.Elements;
import com.epam.jdi.uitests.web.selenium.elements.composite.WebPage;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.JPage;
import org.mytests.uiobjects.example.forms.DatesForm;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;


@JPage(url = "/page4.htm", title = "Dates")
public class DatesPage extends WebPage {
    public DatesForm datesForm;

    @FindBy(css = ".uui-slider.blue.range.ui-slider")
    private Image sliderTrack;

    @FindBy(css = ".ui-slider-handle")
    private Elements<Link> sliders;

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
        if (getSliderPosition(sliders.get(1)) <= leftSliderPos) {
            moveSliderToPos(sliders.get(1), rightSliderPos);
            moveSliderToPos(sliders.get(0), leftSliderPos);
        } else {
            moveSliderToPos(sliders.get(0), leftSliderPos);
            moveSliderToPos(sliders.get(1), rightSliderPos);
        }
    }

    public void checkSliders(int leftSliderPos, int rightSliderPos) {
        Assert.assertEquals(sliders.get(0).getText(), Integer.toString(leftSliderPos));
        Assert.assertEquals(sliders.get(1).getText(), Integer.toString(rightSliderPos));
    }
}
