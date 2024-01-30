package utility;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;

import base.TestBase;

public class Screenshot extends TestBase
{
	public static String getDate()
	{
		return new SimpleDateFormat("dd-MM-YYYY").format(new Date());
	}
	
	public static void screenshot(String nameofMethod) throws IOException
	{
		File Source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File Dest = new File("C:\\Users\\Dell\\eclipse-workspace\\Project_Sauce_Lab\\Screenshot\\"+nameofMethod+"----"+getDate()+".jpeg");                                           
		FileHandler.copy(Source, Dest);
	}

}
