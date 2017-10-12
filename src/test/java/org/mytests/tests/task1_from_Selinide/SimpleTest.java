package org.mytests.tests.task1_from_Selinide;

import org.mytests.tests.InitTests;
import org.mytests.uiobjects.example.entities.DatesData;
import org.testng.annotations.Test;

import static org.mytests.uiobjects.example.JdiExampleSite.*;
import static org.mytests.uiobjects.example.enums.DatesDataValues.CORRECT;
import static org.mytests.uiobjects.example.enums.MenuOptions.CONTACT_FORM;


public class SimpleTest extends InitTests {

    @Test
    public void verifyLoginAndContactSubmitting() {
//1 Open test site by URL
        homePage.open();

//2 Assert Browser title
        homePage.checkOpened();

//3 Perform login
        login();

//4 Assert User name in the left-top side of screen that user is logged in
        verifyLogin();

//5 Open Contact form
        header.open(CONTACT_FORM);

//6 Assert Browser title
        contactFormPage.checkOpened();

//7 Input first and last name in text fields and click submit button
        contactFormPage.contactForm.submit(new DatesData(CORRECT.data.name, CORRECT.data.lastName));

//8 Assert that in the log section a new raw has displayed which contains text "submit"
        rightSection.verifyLogContains("submit");
    }
}
