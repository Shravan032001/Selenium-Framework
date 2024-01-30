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
import pages.Inventory_Page;
import pages.LoginPage;
import utility.Screenshot;

public class CheckOutPage2Test extends TestBase
{
	LoginPage login;
	Inventory_Page inventory;
	Cart_Page cart;
	CheckOutPage1 check1;
	CheckOutPage2 check2;
	@BeforeMethod
	public void setup() throws IOException
	{
		initialization();
		login = new LoginPage();
		inventory = new Inventory_Page();
		cart = new Cart_Page();
		check1 = new CheckOutPage1();
		check2 = new CheckOutPage2();
		login.logintoAppication();
		inventory.add4product();
		inventory.cartbtn();
		cart.clickoncheckoutbtn();
		check1.inputinfo();
	}
	
	@Test
	public void VerifyCheckOutPage2URLTest()
	{
		String expURL = "https://www.saucedemo.com/checkout-step-two.html";
		String actURL = check2.VerifyCheckOutPage2URL();
		Assert.assertEquals(expURL, actURL);
		Reporter.log(actURL);
	}
	
	@Test
	public void VerifyPITTextTest()
	{
		String expText = "Payment Information";
		String actText = check2.VerifyPITText();
		Assert.assertEquals(expText, actText);
		Reporter.log(actText);
	}
	
	@Test
	public void VerifySCTextTest()
	{
		String expText = "SauceCard #31337"; 
		String actText = check2.VerifySCText();
		Assert.assertEquals(expText, actText);
		Reporter.log(actText);
	}
	
	@Test
	public void VerifySITextTest()
	{
		String expText = "Shipping Information";
		String actText = check2.VerifySIText();
		Assert.assertEquals(expText, actText);
		Reporter.log(actText);
	}
	
	@Test
	public void VerifyFPEDTextTest()
	{
		String expText = "Free Pony Express Delivery!";
		String actText = check2.VerifyFPEDText();
		Assert.assertEquals(expText, actText);
		Reporter.log(actText);
	}
	
	@Test
	public void VerifyPTTextTest()
	{
		String expText = "Payment Information"; 
		String actText = check2.VerifyPITText();
		Assert.assertEquals(expText, actText);
		Reporter.log(actText);
	}
	
	@Test
	public void VerifyITTextTest()
	{
		String expText = "Item total: $105.96000000000001";
		String actText = check2.VerifyITText();
		Assert.assertEquals(expText, actText);
		Reporter.log(actText);
	}
	
	@Test
	public void VerifyTaxTextTest()
	{
		String expText = "Tax: $8.48";
		String actText = check2.VerifyTaxText();
		Assert.assertEquals(expText, actText);
		Reporter.log(actText);
	}
	
	@Test
	public void VerifyTotalText1Test()
	{
		String expText = "Total: $114.44";
		String actText = check2.VerifyTotalText1();
		Assert.assertEquals(expText, actText);
		Reporter.log(actText);
	}
	
	@Test
	public void Verifyfinishbtn()
	{
		String expURL = "https://www.saucedemo.com/checkout-complete.html";
		String actURL = check2.Verifyfinishbtn();
		Assert.assertEquals(expURL, actURL);
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
