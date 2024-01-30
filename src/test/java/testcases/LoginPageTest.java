package testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.TestBase;

import pages.LoginPage;
import utility.Screenshot;

public class LoginPageTest extends TestBase
{
	LoginPage login;
	@BeforeMethod
	public void setUp() throws IOException
	{
		initialization();
		login = new LoginPage();
	}
	
	@Test(enabled = true, priority = 1)
	public void verifyURLofApplication()
	{
		String expURL = "https://www.saucedemo.com/";
		String actURL = login.verifyURLofApplication();
		Assert.assertEquals(actURL, expURL);
	}
	
	@Test(enabled = true, priority = 2, dependsOnMethods = "verifyURLofApplication")
	public void verifyTITLEofApplicationTEST()
	{
		String expTITLE = "Swag Labs";
		String actTITLE = login.verifyTITLEofApplication();
		Assert.assertEquals(actTITLE, expTITLE);
	}
	
	@Test(enabled = true, dependsOnMethods = "verifyURLofApplication") // Priority not given so Bydefault Priority is 0 & it will be executed FIRST.
	public void logintoAppicationTEST() throws IOException
	{
		String expURL = "https://www.saucedemo.com/inventory.html";
		String actURL = login.logintoAppication();
		Assert.assertEquals(expURL, actURL);
		Reporter.log("NextPage URL Of LOGINPAGE = " + actURL);
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
