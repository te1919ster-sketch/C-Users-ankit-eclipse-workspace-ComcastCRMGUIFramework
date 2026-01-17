package practicedatadriventesting;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.Properties;
import java.io.FileReader;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class DDT009Test {

	 public static void main(String[] args) throws Exception {
		 
    	//ddt based on json file
		//s1: parse json file in java object using json parse class
		 
		 JSONParser parser= new JSONParser();
		 Object obj= parser.parse(new FileReader("C:\\Users\\ankit\\Java Files\\appCommonData.json"));
		 
		//s2: downcast the java object into json object
		JSONObject map= (JSONObject) obj;
		
	    //s3:get the value from json file using key
		System.out.println(map.get("url"));
		System.out.println(map.get("browser"));
		System.out.println(map.get("username"));
		System.out.println(map.get("password"));
		System.out.println(map.get("timeOut"));
		 
	
	 }
}