package com.lessannoyingcrmAutomation.webdriverutility;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * Utility class for Java reusable methods
 */
public class JavaUtility {

    /**
     * Generates random number
     * @return random integer
     */
    public int getRandomNumber() {

        Random random = new Random();
        return random.nextInt(1000);
    }

    /**
     * Returns current system date in yyyy-MM-dd format
     * @return current date as String
     */
    public String getSystemDate() {

        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        return sdf.format(date);
    }
}
