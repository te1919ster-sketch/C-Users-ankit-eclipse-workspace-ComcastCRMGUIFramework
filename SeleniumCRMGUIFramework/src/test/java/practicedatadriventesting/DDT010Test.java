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

public class DDT010Test {

	 public static void main(String[] args) throws Exception {
		 
    	//ddt based on database
		 //execute select query
		 //s1: load & register the database driver
		 Driver driverRef= new Driver();
		 DriverManager.registerDriver(driverRef);
		 
		 //s2: connect to the database
		 Connection cc= DriverManager.getConnection("jdbc:mysql://49.249.28.218:3307/projects");
		 System.out.println("Connected!");

		 //s3: create sql statement
		  Statement s= cc.createStatement();
		 
		 //s4: execute select querry & result
		  ResultSet rs= s.executeQuery("select * from project");
		  while (rs.next()) {
			  System.out.println(rs.getString(1)+ "/t" + rs.getString(5));
		  }
		  
		 //s5: close the connection
		  cc.close();
		 
		 
	
	 }
}