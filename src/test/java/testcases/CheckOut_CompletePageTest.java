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
import pages.CheckOutPage1;
import pages.CheckOutPage2;
import pages.CheckOut_CompletePage;
import pages.Inventory_Page;
import pages.LoginPage;
import utility.Screenshot;

public class CheckOut_CompletePageTest extends TestBase
{
	LoginPage login;
	Inventory_Page inventory;
	Cart_Page cart;
	CheckOutPage1 check1;
	CheckOutPage2 check2;
	CheckOut_CompletePage orderdone;
	@BeforeMethod
	public void setup() throws IOException
	{
		initialization();
		login = new LoginPage();
		inventory = new Inventory_Page();
		cart = new Cart_Page();
		check1 = new CheckOutPage1();
		check2 = new CheckOutPage2();
		orderdone = new CheckOut_CompletePage();
		login.logintoAppication();
		inventory.add4product();
		inventory.cartbtn();
		cart.clickoncheckoutbtn();
		check1.inputinfo();
		check2.Verifyfinishbtn();
	}
	
	@Test
	public void verifypageURLTest()
	{
		String extURL = "https://www.saucedemo.com/checkout-complete.html";
		String actURL = orderdone.verifypageURL();
		Assert.assertEquals(actURL, extURL);
		Reporter.log(actURL);
	}
	
	@Test
	public void verifylableTest()
	{
		String expText = "Checkout: Complete!";
		String actText = orderdone.verifylable();
		Assert.assertEquals(actText, expText);
		Reporter.log(actText);
	}
	
	@Test
	public void verifythyTextTest()
	{
		String expText = "Thank you for your order!";
		String actText = orderdone.verifythyText();
		Assert.assertEquals(actText, expText);
		Reporter.log(actText);
	}
	
	@Test
	public void verifydispatchTextTest()
	{
		String expText = "Your order has been dispatched, and will arrive just as fast as the pony can get there!";
		String actText = orderdone.verifydispatchText();
		Assert.assertEquals(actText, expText);
		Reporter.log(actText);
	}
	
	@Test
	public void verifybackbtnTest()
	{
		String expURL = "https://www.saucedemo.com/inventory.html";
		String actURL = orderdone.verifybackbtn();
		Assert.assertEquals(actURL, expURL);
		Reporter.log(actURL);
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
