package com.lessannoyingcrmAutomation.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Contact Page Object Class
 */
public class ContactPage {

    @FindBy(xpath = "//h1[text()='Contacts and companies']")
    private WebElement contactHeader;

    public ContactPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public String getContactHeaderText() {
        return contactHeader.getText();
    }
    
 // Export/Print button
    @FindBy(xpath = "//span[text()='Export/Print']/parent::button")
    private WebElement exportPrintBtn;

    // Export option inside dropdown
    @FindBy(xpath = "//span[text()='Export']")
    private WebElement exportOption;

    // Success / validation message (adjust if needed)
    @FindBy(xpath = "//div[contains(@class,'Notification') or contains(text(),'Export')]")
    private WebElement exportMessage;

    
    public void clickExportPrint() {
        exportPrintBtn.click();
    }

    public void clickExportOption() {
        exportOption.click();
    }

    public String getExportMessage() {
        return exportMessage.getText();
    }

}

