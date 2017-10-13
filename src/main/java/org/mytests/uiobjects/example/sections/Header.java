package org.mytests.uiobjects.example.sections;

import com.epam.jdi.uitests.core.interfaces.complex.IDropDown;
import com.epam.jdi.uitests.web.selenium.elements.common.Text;
import com.epam.jdi.uitests.web.selenium.elements.complex.Menu;
import com.epam.jdi.uitests.web.selenium.elements.composite.Section;
import org.mytests.uiobjects.example.enums.MenuOptions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.EnumSet;
import java.util.Set;

import static org.mytests.uiobjects.example.enums.MenuOptions.*;

public class Header extends Section {
    @FindBy(css = ".uui-navigation.nav.navbar-nav.m-l8 li a")
    private Menu<MenuOptions> menu;

    @FindBy(css = ".dropdown-menu li a")
    private IDropDown<MenuOptions> serviceOptions;

    @FindBy(css = ".profile-photo span")
    private Text profile;

    public void open(MenuOptions... menuItems) {
        menu.clickOn(menuItems[0].getLabel().toUpperCase());

        if (menuItems.length == 2) {
            serviceOptions.select(menuItems[1].getLabel().toUpperCase());
        }
    }

    public void verifyLogin(String userName) {
        Assert.assertEquals(profile.getText(), userName);
    }

    public void checkServiceOptions() {
        open(SERVICE);
        Set<MenuOptions> serviceOptionsSet = EnumSet.of(SUPPORT, DATES, COMPLEX_TBL, SIMPLE_TBL, PAGES_TBL, DIFF_EL);
        serviceOptions.getOptions().containsAll(serviceOptionsSet);
    }
}
