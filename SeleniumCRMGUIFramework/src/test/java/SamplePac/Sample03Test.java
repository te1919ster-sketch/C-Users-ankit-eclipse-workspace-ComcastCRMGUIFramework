package SamplePac;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Sample03Test {

	RemoteWebDriver driver;
	@Parameters("browserName")
	@Test
	public void sampleTest(String bN) throws MalformedURLException {
		URL ipADD= new URL("http://3.27.63.39:4444");
		
		if(bN.equals("edge")) {
			EdgeOptions option= new EdgeOptions();
			driver= new RemoteWebDriver(ipADD, option);
		}else if(bN.equals("chrome")) {
			ChromeOptions option= new ChromeOptions();
			driver= new RemoteWebDriver(ipADD, option);
		}
		
		driver.get("https://developer.mozilla.org/en-US/");
		System.out.println(driver.getTitle());
		driver.close();	
		
	}
	

}
