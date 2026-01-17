package practicedatadriventesting;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class SampleDDT001Test {

	 public static void main(String[] args) throws IOException {
		 
		 // step 1: get the java representation object of the physical file
		 FileInputStream fis= new FileInputStream("C:\\Users\\ankit\\Java Files\\commondata.properties");
		 
		 // step 2: using properties class, load all the keys
		 Properties p= new Properties();
		 p.load(fis);
		 
		 // step 3: get the value based on keys
		 System.out.println(p.getProperty("browser"));
		 
		 
	 }
}
