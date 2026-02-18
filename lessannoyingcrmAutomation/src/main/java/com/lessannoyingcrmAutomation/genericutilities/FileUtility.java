package com.lessannoyingcrmAutomation.genericutilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Utility class to read data from property file
 */
public class FileUtility {

    public String getDataFromPropertyFile(String key) throws IOException {

        FileInputStream fis = new FileInputStream("./configAppData/commondata.properties");

        		//new FileInputStream("C:\\Users\\ankit\\Java Files\\commondata.properties");
                // new FileInputStream("./src/test/resources/commonData.properties");

        Properties prop = new Properties();
        prop.load(fis);

        return prop.getProperty(key);
    }
}
