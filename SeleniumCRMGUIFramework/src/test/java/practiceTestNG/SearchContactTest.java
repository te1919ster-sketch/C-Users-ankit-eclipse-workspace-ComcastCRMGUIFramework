package practiceTestNG;

import org.testng.annotations.Test;

import com.comcast.crm.genericfileutilities.BaseClass;
import com.comcast.crm.objectrepositoryutility.LoginPage;

/**
 * test class for Contact module
 * @author ankit
 * 
 */

public class SearchContactTest extends BaseClass{
	// coding standards
	/**
	 * Scenario : login()==> navigate to contact ==> createcontact()== verify
	 */
	
	@Test
	public void searchcontactTest() {
		/*step 1 : login to app*/
		LoginPage lp= new LoginPage(driver);
		lp.loginToapp("username", "pas");
	}

}
