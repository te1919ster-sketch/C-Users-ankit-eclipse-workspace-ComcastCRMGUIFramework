package practiceTestNG;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TNG04Test {
	
	@Test(dataProvider="getData")
	public void createContact(String FirstName, String LastName) {
		System.out.println("FirstName : "+ FirstName + ", LastName : "+ LastName);
	}
	
	@DataProvider
	public Object[][] getData(){
	//creating 2D array
	Object[][] objArr= new Object[3][2];
	
	    //hard coding thre data
	//fetching the data for 1st row
	objArr[0][0]= "Deepak";
	objArr[0][1]= "hr";
	//fetching the data for 2nd row
	objArr[1][0]= "Sam";
	objArr[1][1]= "hs";
	//fetching the data for 3rd row
	objArr[2][0]= "Jhon";
	objArr[2][1]= "Smith";
	
	return objArr;

  }
}