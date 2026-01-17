package practice.orgtest;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class GU05Test {

	public static void main(String[] args) throws Exception {
	
		//when we want the date in system format and with the details
		 Date d= new Date();
		 
		// when we want the date in custom or simple format
		 SimpleDateFormat sim= new SimpleDateFormat("yyyy-MM-dd");
		 String actDate= sim.format(d);
		 System.out.println(actDate);
		 
		//when we want to specify the date period
		 Calendar cal= sim.getCalendar();
		 cal.add(Calendar.DAY_OF_MONTH,30);
		 String afterDateReq= sim.format(cal.getTime());
		 System.out.println(afterDateReq);
		 
	 }
}
