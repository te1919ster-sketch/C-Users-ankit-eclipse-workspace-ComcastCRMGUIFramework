package com.lessannoyingcrmAutomation.genericutilities;

import java.io.FileReader;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JsonUtility {

    public String getDataFromJsonFile(String key) throws Throwable, ParseException {

        FileReader fileR = new FileReader("./configAppData/appCommonData.json");

        JSONParser parser = new JSONParser();
        Object obj = parser.parse(fileR);

        JSONObject map = (JSONObject) obj;

        String value = (String) map.get(key);

        return value;
    }
}
