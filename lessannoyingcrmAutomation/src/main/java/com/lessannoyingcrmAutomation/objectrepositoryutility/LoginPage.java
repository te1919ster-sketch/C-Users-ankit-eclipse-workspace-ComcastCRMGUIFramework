package com.lessannoyingcrmAutomation.objectrepositoryutility;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;

public class LoginPage {

    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(name = "Email")
    private WebElement usernameTextField;

    @FindBy(name = "Password")
    private WebElement passwordTextField;

    @FindBy(id = "Login")
    private WebElement loginButton;

    public void loginToApp(String username, String password) {
        usernameTextField.sendKeys(username);
        passwordTextField.sendKeys(password);
        loginButton.click();
    }
}
