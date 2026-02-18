package SamplePac;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class Sample02Test {
	
	/** run the test scripts in different environments **/
	@Test
	public void sampleTest() throws MalformedURLException {
		ChromeOptions option= new ChromeOptions();
		
		
		URL ipADD= new URL("http://54.253.111.189:5555");
	    RemoteWebDriver driver= new RemoteWebDriver(ipADD, option);
	    driver.get("https://developer.mozilla.org/en-US/");	
	    System.out.println(driver.getTitle());
	    driver.close();		
	    
	}
}
