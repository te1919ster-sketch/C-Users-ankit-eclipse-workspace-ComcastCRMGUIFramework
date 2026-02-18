package com.lessannoyingcrmAutomation.objectrepositoryutility;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {

    WebDriver driver;
    WebDriverWait wait;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    /** contact */
    @FindBy(xpath = "//a[@aria-label='Contacts']")
    private WebElement conButton;

    public void clickOnConBtn() {
        wait.until(ExpectedConditions.elementToBeClickable(conButton));
        conButton.click();
    }
    
    /** report */    
    @FindBy(xpath = "//a[@aria-label='Reports']")
    private WebElement repButton;

    public void clickOnRepBtn() {
        wait.until(ExpectedConditions.elementToBeClickable(repButton));
        repButton.click();
    } 
    
    
    
}
