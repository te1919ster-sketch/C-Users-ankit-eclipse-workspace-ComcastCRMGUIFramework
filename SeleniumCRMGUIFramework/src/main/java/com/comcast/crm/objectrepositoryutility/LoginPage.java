package com.comcast.crm.objectrepositoryutility;

/**
 * @author ankit
 * Contains Login page elements & business lib like login()
 * 
 */

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage{
	
	WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver= driver;
		PageFactory.initElements(driver, this);
    }
	//Rule 1 -> create a seperate java class 
	//Rule 2 -> Object creation
	
	public LoginPage(String url, String un, String pwd) {}

	@FindBy(name="user_name")
	private WebElement usernameEdt;
	
	@FindBy(name="user_password")
	private WebElement passwordEdt;
	
	@FindBy(id="submitButton")
	private WebElement loginBtn;
	
	//Rule 3 -> Object initialization 
	
	//Rule 4 -> Object Encapsulation 

	public WebElement getUsernameEdt() {
		return usernameEdt;
	}

	public WebElement getPasswordEdt() {
		return passwordEdt;
	}

	public WebElement getLoginBtn() {
		return loginBtn;
	}
	
	//Rule 5 -> provide action
	/**
	 *  loging to app based on username, password arguments
	 * @param username
	 * @param password
	 */
	public void loginToapp(String username, String password) {
		driver.manage().window().maximize();
		usernameEdt.sendKeys(username);
		passwordEdt.sendKeys(password);
		loginBtn.click();
		
	}

	public void logout() {
		Actions act= new Actions(driver);
		act.moveToElement(driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"))).perform();
		driver.findElement(By.xpath("//a[@href='index.php?module=Users&action=Logout']")).click();
	}
	
	
	

}
