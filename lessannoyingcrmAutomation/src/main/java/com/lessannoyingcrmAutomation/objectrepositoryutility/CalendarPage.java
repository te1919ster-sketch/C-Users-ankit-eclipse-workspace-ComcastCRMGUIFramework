package com.lessannoyingcrmAutomation.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Calendar Page - Event operations
 */

public class CalendarPage {

    private WebDriver driver;

    public CalendarPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//button[contains(text(),'Add Event')]")
    private WebElement addEventButton;

    @FindBy(name = "event[name]")
    private WebElement eventTitleTextField;

    @FindBy(name = "event[start_time]")
    private WebElement eventTimeTextField;

    @FindBy(xpath = "//button[contains(text(),'Save')]")
    private WebElement saveButton;

    public void createEvent(String eventTitle, String eventTime) {
        addEventButton.click();
        eventTitleTextField.sendKeys(eventTitle);
        eventTimeTextField.sendKeys(eventTime);
        saveButton.click();
    }
}
