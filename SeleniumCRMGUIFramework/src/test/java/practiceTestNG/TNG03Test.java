package practiceTestNG;

import org.testng.annotations.Test;

public class TNG03Test {
	
	@Test(invocationCount= 10)
	public void createContactTest(){
		System.out.println("execute createContactTest==>123");
	}
	
	@Test(enabled= false)
	public void modifyContactTest(){
		System.out.println("execute modifyContactTest==>123");
	}

}
