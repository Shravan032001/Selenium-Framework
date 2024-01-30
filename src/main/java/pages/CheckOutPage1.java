package pages;
////////////////////////////////

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class CheckOutPage1 extends TestBase
{
	// Object Repository
	@FindBy(xpath="//input[@id='first-name']") private WebElement FNtxtBox;
	@FindBy(xpath="//input[@id='last-name']") private WebElement LNtxtBox;
	@FindBy(xpath="//input[@id='postal-code']") private WebElement ZipCodetxtBox;
	@FindBy(xpath="//input[@id='continue']") private WebElement continuebtn;
	
	// CONSTRUCTOR
	public CheckOutPage1()
	{
		PageFactory.initElements(driver,this);
	}
	
	// Methods
	
	public String verifycheckoutpageURL()
	{
		return driver.getCurrentUrl();
	}
	
	public String inputinfo()
	{
		FNtxtBox.sendKeys("Virat");
		LNtxtBox.sendKeys("King");
		ZipCodetxtBox.sendKeys("1112222");
		continuebtn.click();
		return driver.getCurrentUrl();
	}

}
