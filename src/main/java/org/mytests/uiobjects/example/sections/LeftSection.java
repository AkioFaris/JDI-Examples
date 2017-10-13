package org.mytests.uiobjects.example.sections;

import com.epam.jdi.uitests.core.interfaces.complex.IDropDown;
import com.epam.jdi.uitests.web.selenium.elements.complex.Menu;
import com.epam.jdi.uitests.web.selenium.elements.composite.Section;
import org.mytests.uiobjects.example.enums.MenuOptions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.EnumSet;
import java.util.Set;

import static org.mytests.uiobjects.example.enums.MenuOptions.*;

public class LeftSection extends Section {
    @FindBy(css = ".sidebar-menu li a")
    private Menu menu;

    @FindBy(css = ".sub-menu li a")
    private IDropDown<MenuOptions> serviceOptions;

    @Step("Open page by the left section")
    private void open(MenuOptions... menuItems) {
        menu.clickOn(menuItems[0].getLabel());
        if (menuItems.length == 2) {
            serviceOptions.select(menuItems[1].getLabel());
        }
    }

    @Step("Check existence of left section's elements")
    public void checkInterface() {
        Assert.assertTrue(menu.isDisplayed());
        Assert.assertTrue(serviceOptions.isDisplayed());
    }

    @Step
    public void checkServiceOptions() {
        open(SERVICE);
        Set<MenuOptions> serviceOptionsSet = EnumSet.of(SUPPORT, DATES, COMPLEX_TBL, SIMPLE_TBL, PAGES_TBL, DIFF_EL);
        serviceOptions.getOptions().containsAll(serviceOptionsSet);
    }
}
