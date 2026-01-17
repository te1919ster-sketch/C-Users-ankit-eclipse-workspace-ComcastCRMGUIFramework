package practicedatadriventesting;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
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

import com.mysql.jdbc.Driver;

public class DDT011Test {

	 public static void main(String[] args) throws Exception {
		 
    	//ddt based on database
		 //execute non-select query
		 //s1: load & register the database driver
		 Driver driverRef= new Driver();
		 DriverManager.registerDriver(driverRef);
		 
		 //s2: connect to the database
		 Connection cc= DriverManager.getConnection("jdbc:mysql://49.249.28.218:3333/ninza_hrm","root@%","root");
		 System.out.println("Connected!");

		 //s3: create sql statement
		  Statement s= cc.createStatement();
		 
		 //s4: execute non-select querry & result
		 int result= s.executeUpdate("insert into the project values('TY_PROJ_2001','Deepak','04/27/2023','FB_01','On Going','100');");
		 System.out.println(result); 
		 
		 //s5: close the connection
		  cc.close();
		 
		 
	
	 }
}