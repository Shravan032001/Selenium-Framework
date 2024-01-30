package testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.TestBase;
import pages.Cart_Page;
import pages.Inventory_Page;
import pages.LoginPage;
import utility.Screenshot;

public class CartPageTest extends TestBase /////////
{
	LoginPage login;
	Inventory_Page inventory;
	Cart_Page cart;
	@BeforeMethod
	public void setup() throws IOException
	{
		initialization();
	    login = new LoginPage();
		inventory = new Inventory_Page();
		cart = new Cart_Page();
		login.logintoAppication();
		inventory.add4product();
		inventory.cartbtn();
	}
	
	@Test
	public void verifycartpageURLTest()
	{
		String expURL = "https://www.saucedemo.com/cart.html";
		String actURL = cart.verifycartpageURL();
		Assert.assertEquals(expURL, actURL);
		Reporter.log("CART PAGE URL = " + actURL);
	}
	
	@Test
	public void verifycartlableTest()
	{
		String expText = "Your Cart";       
		String actText = cart.verifycartlable();
		Assert.assertEquals(expText, actText);
		Reporter.log("Cart Lable = " + actText);
	}
	
	@Test
	public void clickoncheckoutbtnTest()
	{
		String expURL = "https://www.saucedemo.com/checkout-step-one.html";
		String actURL = cart.clickoncheckoutbtn();
		Assert.assertEquals(expURL, actURL);
		Reporter.log("Cart Page Next URL = " + actURL);
	}
	
	@Test
	public void clickoncontinueshopbtnTest()
	{
		String expURL = "https://www.saucedemo.com/inventory.html";
		String actURL = cart.clickoncontinueshopbtn();
		Assert.assertEquals(expURL, actURL);
		Reporter.log("Cart Page Before URL = " + actURL);
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
