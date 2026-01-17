package practiceTestNG;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class TNG07Test {
	//configuratin annotations
	
	@BeforeSuite
	public void configBS() {
		System.out.println("execute configBS");
	}

	@AfterSuite
	public void configAS() {
		System.out.println("execute configAS");
	}
	
	@BeforeClass
	public void configBC() {
		System.out.println("execute configBC");
	}
	
	@AfterClass
	public void configAC() {
		System.out.println("execute configAC");
	}
	
	@BeforeMethod
	public void configBM() {
		System.out.println("execute configBM"); 
	}
	
	@AfterMethod
	public void configAM() {
		System.out.println("execute configAM"); 
	}
	
	@Test 
	public void createContact() {
		System.out.println("execute createContact");  
	}
	
	@Test 
	public void createContactWithDate() {
		System.out.println("execute createContactWithDate");  
	}
}
