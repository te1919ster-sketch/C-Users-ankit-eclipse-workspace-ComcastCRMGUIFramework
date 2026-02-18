package practiceGeneric;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BrokenLinks02Test {

	public static void main(String[] args) {

		ChromeOptions option = new ChromeOptions();
		option.setAcceptInsecureCerts(true);

		WebDriver driver = new ChromeDriver(option);
		driver.manage().window().maximize();

		driver.get("https://expired.badssl.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//driver.quit();
}
}
