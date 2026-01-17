package com.comcast.crm.genericfileutilities;

import java.io.FileInputStream;
import java.util.Properties;

public class FileUtility {

	public String getDataFromPropertiesFile(String key) throws Throwable {
		
		//FileInputStream fis= new FileInputStream("./comnfigAppData.properties");
		FileInputStream fis= new FileInputStream("C:\\Users\\ankit\\Java Files\\commondata.properties");
		Properties pObj= new Properties();
		pObj.load(fis);
		String data= pObj.getProperty(key);
		return data;
	}
}
