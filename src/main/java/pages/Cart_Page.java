package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class Cart_Page extends TestBase ///////////////////
{
	// Object Repository
	@FindBy(xpath="//span[text()='Your Cart']") private WebElement cartlable;
	@FindBy(xpath="//button[@id='checkout']") private WebElement checkoutbtn;
	@FindBy(xpath="//button[@id='continue-shopping']") private WebElement continueshopbtn;
	
	// CONSTRUCTOR
	public Cart_Page() 
	{
		PageFactory.initElements(driver,this);
	}
	
	// Verify Cart Page URL
	public String verifycartpageURL()
	{
		return driver.getCurrentUrl();
	}
	
	// Verify Your Cart Lable
	public String verifycartlable() 
	{
		return cartlable.getText();
	}
	
	// Click on Checkout Button
	public String clickoncheckoutbtn()
	{
		checkoutbtn.click();
		return driver.getCurrentUrl();
	}
	
	// Click on Continue Shopping Button
	public String clickoncontinueshopbtn()
	{
		continueshopbtn.click();
		return driver.getCurrentUrl();
	}

}
