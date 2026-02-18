package com.lessannoyingcrmAutomation.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Company Page - Company operations
 */

public class CompanyPage {

    private WebDriver driver;

    public CompanyPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[contains(text(),'Add Company')]")
    private WebElement addCompanyButton;

    @FindBy(name = "company[name]")
    private WebElement companyNameTextField;

    @FindBy(xpath = "//button[contains(text(),'Save')]")
    private WebElement saveButton;

    @FindBy(xpath = "//input[@placeholder='Search']")
    private WebElement searchTextField;

    public void createCompany(String companyName) {
        addCompanyButton.click();
        companyNameTextField.sendKeys(companyName);
        saveButton.click();
    }

    public void searchCompany(String companyName) {
        searchTextField.clear();
        searchTextField.sendKeys(companyName);
    }
}
