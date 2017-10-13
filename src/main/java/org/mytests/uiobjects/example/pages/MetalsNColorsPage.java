package org.mytests.uiobjects.example.pages;

import com.epam.jdi.uitests.web.selenium.elements.composite.WebPage;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.JPage;
import org.mytests.uiobjects.example.entities.EvenOddPair;
import org.mytests.uiobjects.example.entities.MetalsNColorsData;
import org.mytests.uiobjects.example.enums.Conditions;
import org.mytests.uiobjects.example.forms.MetalsNColorsForm;
import org.testng.Assert;
import ru.yandex.qatools.allure.annotations.Step;

import static org.mytests.uiobjects.example.JdiExampleSite.rightSection;


@JPage(url = "/page2.htm", title = "Metal & Colors")
public class MetalsNColorsPage extends WebPage {
    public MetalsNColorsForm metalsNColorsForm;

    @Step
    public void checkCalcResult(EvenOddPair pair) {
        int even = Integer.valueOf(pair.even.number);
        int odd = Integer.valueOf(pair.odd.number);
        rightSection.verifyResultContains("Summary: " + String.valueOf(even + odd));
    }

    @Step
    public void verifyResultContainsAllFields(MetalsNColorsData metalsNColorsData) {
        for (Conditions condition : metalsNColorsData.conditions) {
            Assert.assertTrue(rightSection.checkResultContains(condition.text));
        }
        checkCalcResult(metalsNColorsData.evenOddPair);
        Assert.assertTrue(rightSection.checkResultContains(metalsNColorsData.color.text)
                && rightSection.checkResultContains(metalsNColorsData.metal.text)
                && rightSection.checkResultContains(metalsNColorsData.vegetable.text));
    }
}
