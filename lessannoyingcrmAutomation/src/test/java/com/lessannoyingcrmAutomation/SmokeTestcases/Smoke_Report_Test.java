package com.lessannoyingcrmAutomation.SmokeTestcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.lessannoyingcrmAutomation.BaseTest.BaseClass;
import com.lessannoyingcrmAutomation.objectrepositoryutility.HomePage;
import com.lessannoyingcrmAutomation.objectrepositoryutility.ReportsPage;

public class Smoke_Report_Test extends BaseClass {
	    @Test
	    public void TC_SM_08_ConTest() {
	    	/** Click Reports button from sidebar */
	        HomePage hp = new HomePage(driver);
	        hp.clickOnRepBtn(); 
	        
	        ReportsPage rp = new ReportsPage(driver);
	        String actualText = rp.getreportsHeaderText();

	        Assert.assertEquals(actualText, "Reports");
	    }
	    
}

