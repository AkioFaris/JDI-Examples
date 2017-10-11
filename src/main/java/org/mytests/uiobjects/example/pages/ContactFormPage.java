package org.mytests.uiobjects.example.pages;

import com.epam.jdi.uitests.web.selenium.elements.composite.WebPage;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.JPage;
import org.mytests.uiobjects.example.forms.ContactForm;


@JPage(url = "/page1.htm", title = "Contact Form")
public class ContactFormPage extends WebPage {
    public ContactForm contactForm;
}
