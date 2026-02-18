package com.lessannoyingcrmAutomation.webdriverutility;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;  // Import TestNG Assert

public class WebDriverUtility {

    // ================= IMPLICIT WAIT =================

    public void waitForPageToLoad(WebDriver driver) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }

    // ================= EXPLICIT WAIT =================

    public void waitForElementPresent(WebDriver driver, WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    // ================= WINDOW SWITCH =================

    public void switchToTabOnURL(WebDriver driver, String partialURL) {
        Set<String> set = driver.getWindowHandles();
        Iterator<String> it = set.iterator();

        while (it.hasNext()) {
            String windowID = it.next();
            driver.switchTo().window(windowID);

            String actURL = driver.getCurrentUrl();
            if (actURL.contains(partialURL)) {
                break;
            }
        }
    }

    public void switchToTabOnTitle(WebDriver driver, String partialTitle) {
        Set<String> set = driver.getWindowHandles();
        Iterator<String> it = set.iterator();

        while (it.hasNext()) {
            String windowID = it.next();
            driver.switchTo().window(windowID);

            String actTitle = driver.getTitle();
            if (actTitle.contains(partialTitle)) {
                break;
            }
        }
    }

    // ================= FRAME SWITCH =================

    public void switchToFrame(WebDriver driver, int index) {
        driver.switchTo().frame(index);
    }

    public void switchToFrame(WebDriver driver, String nameID) {
        driver.switchTo().frame(nameID);
    }

    public void switchToFrame(WebDriver driver, WebElement element) {
        driver.switchTo().frame(element);
    }

    // ================= ALERT HANDLING =================

    public void switchToAlertAndAccept(WebDriver driver) {
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }

    public void switchToAlertAndCancel(WebDriver driver) {
        Alert alert = driver.switchTo().alert();
        alert.dismiss();
    }

    // ================= DROPDOWN HANDLING =================

    public void select(WebElement element, String text) {
        Select sel = new Select(element);
        sel.selectByVisibleText(text);
    }

    public void select(WebElement element, int index) {
        Select sel = new Select(element);
        sel.selectByIndex(index);
    }

    // ================= ACTIONS CLASS =================

    public void mousemoveOnElement(WebDriver driver, WebElement element) {
        Actions act = new Actions(driver);
        act.moveToElement(element).perform();
    }

    public void doubleClick(WebDriver driver, WebElement element) {
        Actions act = new Actions(driver);
        act.doubleClick(element).perform();
    }

    // ================= ASSERTION METHODS =================

    /**
     * Verify if a specific element is displayed
     */
    public void verifyElementIsDisplayed(WebElement element, String message) {
        Assert.assertTrue(element.isDisplayed(), message);
    }

    /**
     * Verify page title matches expected title
     */
    public void verifyPageTitle(WebDriver driver, String expectedTitle) {
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, expectedTitle, "Page title mismatch: Expected = " + expectedTitle + ", Actual = " + actualTitle);
    }

    /**
     * Verify page URL contains expected text
     */
    public void verifyPageURL(WebDriver driver, String expectedURLPart) {
        String actualURL = driver.getCurrentUrl();
        Assert.assertTrue(actualURL.contains(expectedURLPart), "Page URL does not contain expected part: " + expectedURLPart);
    }
}
