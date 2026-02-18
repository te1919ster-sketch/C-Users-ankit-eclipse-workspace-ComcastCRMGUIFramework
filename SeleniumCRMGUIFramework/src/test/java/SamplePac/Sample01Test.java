package SamplePac;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Sample01Test {
	/** using selenium grid and not selenium dependendcy **/
	@Test
	public void sampleTest() {
		WebDriver driver= new ChromeDriver();
		driver.get("https://developer.mozilla.org/en-US/");
		System.out.println(driver.getTitle());
		driver.close();	
	}
}
