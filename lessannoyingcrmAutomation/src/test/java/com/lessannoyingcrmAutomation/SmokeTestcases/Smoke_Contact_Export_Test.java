package com.lessannoyingcrmAutomation.SmokeTestcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.lessannoyingcrmAutomation.BaseTest.BaseClass;
import com.lessannoyingcrmAutomation.objectrepositoryutility.ContactPage;
import com.lessannoyingcrmAutomation.objectrepositoryutility.HomePage;

public class Smoke_Contact_Export_Test extends BaseClass {
	
	@Test
	public void TC_SM_17_ExportContact() {

	    // Home Page
	    HomePage hp = new HomePage(driver);
	    hp.clickOnConBtn();   // this is your Contacts navigation method

	    // Contact Page
	    ContactPage cp = new ContactPage(driver);

	    cp.clickExportPrint();
	    cp.clickExportOption();

	    String msg = cp.getExportMessage();

	   // Assert.assertTrue(msg.contains("Export") || msg.contains("success"));

	}


}
