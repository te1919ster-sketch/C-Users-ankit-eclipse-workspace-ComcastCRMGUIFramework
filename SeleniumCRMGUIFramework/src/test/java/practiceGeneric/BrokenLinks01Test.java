package practiceGeneric;

import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrokenLinks01Test {

	public static void main(String[] args) throws Throwable {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://necouncil.gov.in/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		// 1. get all the links which are available on webpages
		List<WebElement> links = driver.findElements(By.xpath("//a"));
		System.out.println(links.size());

		URL url = null;
		int statusCode = 0;

		// 2. get the attribute of the links
		for(WebElement eachLink : links)
		{

			String link = eachLink.getDomAttribute("href");

			// 3. open url
			url = new URI(link).toURL();

			// 4. http connection
			HttpURLConnection httpConn = (HttpURLConnection) url.openConnection();
			httpConn.connect();

			// 5. get response status codes
			statusCode = httpConn.getResponseCode();

			// 6. validate
			if(statusCode>=400)
			{

				System.out.println(link+" is broken link"+" "+statusCode);

			}

		}
     // driver.quit();
	}

}
