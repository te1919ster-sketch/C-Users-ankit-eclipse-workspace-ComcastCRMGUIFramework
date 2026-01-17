package practiceTestNG;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.comcast.crm.genericfileutilities.BaseClass;
import com.comcast.crm.objectrepositoryutility.HomePage;

public class TNG08Test extends BaseClass{
	//creating contact test
	//real useage of configuration annotations
	
	public void createContactTest() throws Throwable {
		//read the tc data from excel file
		String lastName= eLib.getdataFromExcelFile("contact", 1, 2) + jLib.getRandomNumber();
		
		//navigate to conatact module
		HomePage hp= new HomePage(driver);
		hp.getCampaignlnk().click();
		
//		//click on create contact button
//		ContactPage cp= new ConatctPage(driver);
//		cp.get
		
//		//enter all the deatils and create new contact 
//		CreatingNewContactPage ccp= new CreatingNewContactPage(driver);
//		ccp.createContact(lastName);
	
	}
}
