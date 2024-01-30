package utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadData 
{
	public static String readpropertyfile(String value) throws IOException
	{
		Properties prop = new Properties();
		FileInputStream file = new FileInputStream("C:\\Users\\Dell\\eclipse-workspace\\Project_Sauce_Lab\\TestData\\config.properties");
		prop.load(file);
		return prop.getProperty(value);	
	}
}
