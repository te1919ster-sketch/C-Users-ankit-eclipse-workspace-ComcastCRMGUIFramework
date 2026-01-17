package practiceTestNG;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.comcast.crm.genericfileutilities.BaseClass;

//screenshot for failed testscript
//@Listeners(com.comcast.crm.listenerutility.ListenersUtility.class)

public class TNG11Test extends BaseClass {
	//for retry execution of failed testscript
	//@Test(retryAnalyzer= com.comcast.crm.listenerutility.RetryAnalyzerListenerUtility.class)
	public void createInvoiceTest() {
		System.out.print("execute createInvoiceTest");
		String actTitle= driver.getTitle();
		Assert.assertEquals(actTitle, "Login");
		System.out.print("step-1");
		System.out.print("step-2");
		System.out.print("step-3");
		System.out.print("step-4");
	}
	
	@Test
	public void createInvoiceWithContactTest() {
		System.out.print("execute createInvoiceWithConatctTest");
		System.out.print("step-1");
		System.out.print("step-2");
		System.out.print("step-3");
		System.out.print("step-4");
	}
}