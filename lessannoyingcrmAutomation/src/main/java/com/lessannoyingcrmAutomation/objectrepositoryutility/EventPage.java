package com.lessannoyingcrmAutomation.objectrepositoryutility;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;

public class EventPage {

    WebDriver driver;

    public EventPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//button[text()='Add Event']")
    private WebElement addEventButton;

    public void clickOnAddEvent() {
        addEventButton.click();
    }
}
