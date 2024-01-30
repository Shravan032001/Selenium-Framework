package testcases;
///////////////////////////////

import java.io.IOException;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.TestBase;
import pages.Cart_Page;
import pages.CheckOutPage1;
import pages.Inventory_Page;
import pages.LoginPage;
import utility.Screenshot;

public class CheckOutPage1Test extends TestBase
{
	LoginPage login;
	Inventory_Page inventory;
	Cart_Page cart;
	CheckOutPage1 check1;
	@BeforeMethod
	public void setup() throws IOException
	{
		initialization();
		login = new LoginPage();
		inventory = new Inventory_Page();
		cart = new Cart_Page();
		check1 = new CheckOutPage1();
		login.logintoAppication();
		inventory.add4product();
		inventory.cartbtn();
		cart.clickoncheckoutbtn();
	}
	
	@Test
	public void verifycheckoutpageURLTest()
	{
		String expURL = "https://www.saucedemo.com/checkout-step-one.html";
		String actURL = check1.verifycheckoutpageURL();
		Assert.assertEquals(expURL, actURL);
		Reporter.log("Check Out Page URL = " + actURL);
	}
	
	@Test
	public void verifyinputinfo()
	{
		String expURL = "https://www.saucedemo.com/checkout-step-two.html";
		String actURL = check1.inputinfo();
		Assert.assertEquals(expURL, actURL);
		Reporter.log("Check Out Page 1 Next URL = " + actURL);
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
