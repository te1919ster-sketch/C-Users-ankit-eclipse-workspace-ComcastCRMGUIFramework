package com.lessannoyingcrmAutomation.BaseTest;

import java.io.IOException;

import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.*;

import com.lessannoyingcrmAutomation.genericutilities.*;
import com.lessannoyingcrmAutomation.objectrepositoryutility.LoginPage;
import com.lessannoyingcrmAutomation.webdriverutility.JavaUtility;
import com.lessannoyingcrmAutomation.webdriverutility.WebDriverUtility;

public class BaseClass {

    public static TakesScreenshot sdriver;

    protected WebDriver driver;

    protected FileUtility fUtil = new FileUtility();
    protected ExcelUtility eUtil = new ExcelUtility();
    protected JavaUtility jUtil = new JavaUtility();
    protected WebDriverUtility wUtil = new WebDriverUtility();

    @BeforeClass
    public void launchBrowser() throws IOException {

        String browser = fUtil.getDataFromPropertyFile("browser");
        String url = fUtil.getDataFromPropertyFile("url");

        if (browser.equalsIgnoreCase("chrome")) {

            ChromeOptions options = new ChromeOptions();
            options.addArguments("--remote-allow-origins=*");
            options.addArguments("--disable-dev-shm-usage");
            options.addArguments("--no-sandbox");

            driver = new ChromeDriver(options);
        } else {
            throw new RuntimeException("Browser not supported");
        }

        driver.manage().window().maximize();
        wUtil.waitForPageToLoad(driver);
        driver.get(url);

        sdriver = (TakesScreenshot) driver;
    }

    @BeforeMethod
    public void login() throws Throwable {

        String username = fUtil.getDataFromPropertyFile("username");
        String password = fUtil.getDataFromPropertyFile("password");

        new LoginPage(driver).loginToApp(username, password);
    }

    @AfterMethod
    public void logout() {
        // Add logout logic later
    }

    @AfterClass
    public void closeBrowser() {
        if (driver != null) {
            driver.quit();
        }
    }
}
