package com.lessannoyingcrmAutomation.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Import Page - File import operations
 */

public class ImportPage {

    private WebDriver driver;

    public ImportPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@type='file']")
    private WebElement fileUploadInput;

    @FindBy(xpath = "//button[contains(text(),'Import')]")
    private WebElement importButton;

    public void uploadFile(String filePath) {
        fileUploadInput.sendKeys(filePath);
    }

    public void clickImport() {
        importButton.click();
    }
}
