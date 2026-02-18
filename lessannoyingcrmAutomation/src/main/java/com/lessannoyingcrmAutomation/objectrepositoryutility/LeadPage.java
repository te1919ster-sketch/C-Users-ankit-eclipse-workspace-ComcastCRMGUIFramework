package com.lessannoyingcrmAutomation.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Lead Page - Lead operations
 */

public class LeadPage {

    private WebDriver driver;

    public LeadPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[contains(text(),'Add Lead')]")
    private WebElement addLeadButton;

    @FindBy(name = "lead[name]")
    private WebElement leadNameTextField;

    @FindBy(xpath = "//button[contains(text(),'Save')]")
    private WebElement saveButton;

    @FindBy(xpath = "//a[contains(text(),'Add Task')]")
    private WebElement addTaskButton;

    public void createLead(String leadName) {
        addLeadButton.click();
        leadNameTextField.sendKeys(leadName);
        saveButton.click();
    }

    public void clickAddTask() {
        addTaskButton.click();
    }
}
