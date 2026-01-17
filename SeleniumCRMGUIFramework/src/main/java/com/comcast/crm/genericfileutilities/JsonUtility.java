package com.comcast.crm.genericfileutilities;

import java.io.FileReader;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JsonUtility {

	public String getDataFromJsonFile(String key) throws Throwable, ParseException {
		FileReader fileR= new FileReader("./configAppData/appCommonData.json");
		JSONParser p= new JSONParser();
		Object o= p.parse(fileR);
		JSONObject map= (JSONObject)o;
		String data= (String)map.get(key);
		return data;
		
	}
}
