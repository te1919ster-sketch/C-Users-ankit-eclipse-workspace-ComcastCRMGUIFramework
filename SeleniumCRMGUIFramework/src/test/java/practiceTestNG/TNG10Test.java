package practiceTestNG;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.openqa.selenium.support.events.WebDriverListener;
import org.testng.annotations.Test;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class TNG10Test {
 //screenshot code
	@Test
	public void amazonTest() throws Exception {

	    WebDriver driver = new ChromeDriver();
	    driver.get("https://www.amazon.com");

	    WebDriverListener listener = new WebDriverListener() {
	    };

	    WebDriver decoratedDriver =
	            new EventFiringDecorator(listener).decorate(driver);

	    File src = ((TakesScreenshot) decoratedDriver)
	                    .getScreenshotAs(OutputType.FILE);

	    FileUtils.copyFile(src, new File("./screenshots/amazon.png"));

	    driver.quit();
	}
}