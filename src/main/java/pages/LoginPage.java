package pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;
import utility.ReadData;

public class LoginPage extends TestBase
{
	// Object Repository
	@FindBy(xpath ="//input[@id='user-name']") private WebElement usernameTxtBox;
	@FindBy(xpath="//input[@id='password']") private WebElement passwordTxtBox;
	@FindBy(xpath="//input[@id='login-button']") private WebElement loginBtn;
	
	// Constructor
	public LoginPage()
	{
		PageFactory.initElements(driver,this);
	}

	public String verifyURLofApplication() 
	{
		return driver.getCurrentUrl();	
	}
	
	public String verifyTITLEofApplication()
	{
		return driver.getTitle();
	}
	
	public String logintoAppication() throws IOException
	{
		usernameTxtBox.sendKeys(ReadData.readpropertyfile("Username"));
		passwordTxtBox.sendKeys(ReadData.readpropertyfile("Password"));
		loginBtn.click();
		return driver.getCurrentUrl();	
	}

}
