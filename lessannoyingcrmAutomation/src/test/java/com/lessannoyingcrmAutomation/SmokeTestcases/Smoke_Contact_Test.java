package com.lessannoyingcrmAutomation.SmokeTestcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.lessannoyingcrmAutomation.BaseTest.BaseClass;
import com.lessannoyingcrmAutomation.objectrepositoryutility.*;

public class Smoke_Contact_Test extends BaseClass {

    @Test
    public void TC_SM_08_ConTest() {
    	/** Click contact button from sidebar */
        HomePage hp = new HomePage(driver);
        hp.clickOnConBtn(); 
        
        ContactPage cp = new ContactPage(driver);
        String actualText = cp.getContactHeaderText();

        Assert.assertEquals(actualText, "Contacts and companies");
    }
    
}
