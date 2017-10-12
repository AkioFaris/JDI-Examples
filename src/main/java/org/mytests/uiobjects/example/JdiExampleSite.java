package org.mytests.uiobjects.example;

import com.epam.jdi.uitests.web.selenium.elements.common.Label;
import com.epam.jdi.uitests.web.selenium.elements.composite.WebSite;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.JSite;
import org.mytests.uiobjects.example.entities.User;
import org.mytests.uiobjects.example.forms.LoginForm;
import org.mytests.uiobjects.example.pages.ContactFormPage;
import org.mytests.uiobjects.example.pages.DatesPage;
import org.mytests.uiobjects.example.pages.DifferentElementsPage;
import org.mytests.uiobjects.example.pages.HomePage;
import org.mytests.uiobjects.example.sections.Header;
import org.mytests.uiobjects.example.sections.LeftSection;
import org.mytests.uiobjects.example.sections.RightSection;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;

@JSite(domain = "https://epam.github.io/JDI/")
public class JdiExampleSite extends WebSite {
    public static HomePage homePage;
    public static DatesPage datesPage;
    public static ContactFormPage contactFormPage;
    public static Header header;
    public static DifferentElementsPage diffElementsPage;
    public static LeftSection leftSection;
    public static RightSection rightSection;


    private static LoginForm loginForm;

    @FindBy(css = ".profile-photo")
    private static Label profilePhoto;

    @Step
    public static void login() {
        profilePhoto.click();
        loginForm.loginAs(new User());
    }

    public static void verifyLogin() {
        header.verifyLogin((new User()).name.toUpperCase());
    }

}
