package testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.TestBase;
import pages.Inventory_Page;
import pages.LoginPage;
import utility.Screenshot;

public class InventoryPageTest extends TestBase
{
	LoginPage login;
	Inventory_Page inventory;
	
	@BeforeMethod
	public void setup() throws IOException
	{
		initialization();
		login = new LoginPage();
		inventory = new Inventory_Page();
		login.logintoAppication();	
	}
	
	@Test
	public void verifyinventorypageURLTest()
	{
		String expURL = "https://www.saucedemo.com/inventory.html";
		String actURL = inventory.verifyinventorypageURL();
		Assert.assertEquals(expURL, actURL);
		Reporter.log("Inventory Page URL = " + actURL);
	}
	
	@Test
	public void verifyadd4product()
	{
		String expcount = "4";
		String actcount = inventory.add4product();
		Assert.assertEquals(expcount, actcount);
		Reporter.log("No. of Product in Cart = " + actcount);
	}
	
	@Test
	public void verifyremove2product() 
	{
		String expcount = "2";
		String actcount = inventory.remove2product();
		Assert.assertEquals(expcount, actcount);
		Reporter.log("Remaining No. of Product = " + actcount);
	}
	
	@Test
	public void verifytwitterlogoTest()
	{
		boolean result = inventory.verifytwitterlogo();
		Assert.assertEquals(result,true);
		Reporter.log("Is Twitter Logo Displayed or Not = " + result);	
	}
	
	@Test
	public void verifyfootertextTest()
	{
		String expText = "© 2024 Sauce Labs. All Rights Reserved. Terms of Service | Privacy Policy";
		String actText = inventory.verifyfootertext();
		Assert.assertEquals(expText, actText);
		Reporter.log("Text of Footer" + actText);
	}
	
	@AfterMethod
	public void CloseDriver(ITestResult it) throws IOException
	{
		if(it.FAILURE==it.getStatus())
		{
			Screenshot.screenshot(it.getName());
		}
		driver.close();
	}
	

}
