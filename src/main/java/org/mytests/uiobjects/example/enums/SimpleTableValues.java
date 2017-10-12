package org.mytests.uiobjects.example.enums;

public enum SimpleTableValues {
    ROW_1("Drivers", "Selenium Custom", "JavaScript, Appium, WinAPI, Sikuli"),
    ROW_2("Test Runner","TestNG, JUnit Custom", "MSTest, NUnit, Epam"),
    ROW_3("Asserter","TestNG, JUnit, Custom", "MSTest, NUnit, Epam"),
    ROW_4("Logger","Log4J, TestNG log, Custom", "Epam, XML/Json logging, Hyper logging"),
    ROW_5("Reporter","Jenkins, Allure, Custom", "EPAM Report portal, Serenity, TimCity, Hudson"),
    ROW_6("BDD/DSL","Custom", "Cucumber, Jbehave, Thucydides, SpecFlow");

    final public String column1;
    final public String column2;
    final public String column3;

    SimpleTableValues(String column1, String column2, String column3) {
        this.column1 = column1;
        this.column2 = column2;
        this.column3 = column3;
    }
}

