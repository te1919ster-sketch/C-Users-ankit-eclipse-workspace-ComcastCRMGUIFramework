package com.lessannoyingcrmAutomation.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Contact Page Object Class
 */
public class ReportsPage {

    @FindBy(xpath = "//h1[text()='Reports']")
    private WebElement reportsHeader;

    public ReportsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public String getreportsHeaderText() {
        return reportsHeader.getText();
    }
}

