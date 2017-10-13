package org.mytests.uiobjects.example.sections;

import com.epam.jdi.uitests.core.interfaces.complex.ITextList;
import com.epam.jdi.uitests.web.selenium.elements.composite.Section;
import com.epam.web.matcher.testng.Assert;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class RightSection extends Section {
    @FindBy(css = ".panel-body-list.logs")
    private ITextList log;

    @FindBy(css = ".panel-body-list.logs li")
    private ITextList logList;

    @FindBy(css = ".panel-body-list.results")
    private ITextList result;

    @FindBy(css = ".panel-body-list.results li")
    private ITextList resultList;

    public void checkInterface() {
        org.testng.Assert.assertTrue(log.isDisplayed());
        org.testng.Assert.assertTrue(result.isDisplayed());
    }


    public Boolean checkResultContains(String text) {
        List<String> results = resultList.getTextList();
        int occurrences = 0;
        for (String result : results) {
            if (result.contains(text))
                ++occurrences;
        }
        return (occurrences > 0);
    }

    public void verifyResultContains(String text) {
        Assert.assertTrue(checkResultContains(text));
    }

    private Boolean checkLogContains(String text) {
        List<String> logs = logList.getTextList();
        int occurrences = 0;
        for (String log : logs) {
            if (log.contains(text))
                ++occurrences;
        }
        return occurrences > 0;
    }

    public void verifyLogContains(String text) {
        List<String> logs = logList.getTextList();
        int occurrences = 0;
        for (String log : logs) {
            if (log.contains(text))
                ++occurrences;
        }
        Assert.assertTrue(checkLogContains(text));
    }

    public Boolean checkLogStatus(String text, Boolean status) {
        List<String> logs = logList.getTextList();
        for (String log : logs) {
            if (log.contains(text)) {
                if (log.contains(status.toString())) {
                    return true;
                }
            }
        }
        return false;
    }
}
