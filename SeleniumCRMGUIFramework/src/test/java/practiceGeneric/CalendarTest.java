package practiceGeneric;


import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class CalendarTest {

	public static void main(String[] args) {

		String monthAndYear = "August 2026";
		int date = 20;

		ChromeOptions option = new ChromeOptions();
		option.addArguments("--disable-notifications");

		WebDriver driver = new ChromeDriver(option);
		driver.manage().window().maximize();

		driver.get("https://www.goibibo.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.findElement(By.xpath("//span[@class='logSprite icClose']")).click();

		driver.findElement(By.xpath("//span[text()='Departure']")).click();

		for(;;) {

			try {

				driver.findElement(By.xpath("//div[text()='"+monthAndYear+"']/ancestor::div[@class='DayPicker-Month']/descendant::p[text()='"+date+"']"));

				break;

			}

			catch(Exception e) {

				driver.findElement(By.xpath("//span[@aria-label='Next Month']")).click();

			}

		}

	}

}
