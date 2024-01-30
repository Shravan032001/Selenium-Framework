package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class CheckOut_CompletePage extends TestBase
{
	//Object Repository
	@FindBy(xpath = "//span[text()='Checkout: Complete!']") private WebElement completelable;
	@FindBy(xpath = "//h2[text()='Thank you for your order!']") private WebElement thyText;
	@FindBy(xpath = "//div[text()='Your order has been dispatched, and will arrive just as fast as the pony can get there!']") private WebElement dispatchText;
	@FindBy(xpath = "//button[text()='Back Home']") private WebElement backhomebtn;
	
	//CONSTRUCTOR
	public CheckOut_CompletePage()
	{
		PageFactory.initElements(driver,this);
	}
	
	//Methods
	
	public String verifypageURL()
	{
		return driver.getCurrentUrl();
	}
	
	public String verifylable()
	{
		return completelable.getText();
	}
	
	public String verifythyText()
	{
		return thyText.getText();
	}
	
	public String verifydispatchText()
	{
		return dispatchText.getText();
	}
	
	public String verifybackbtn()
	{
		backhomebtn.click();
		return driver.getCurrentUrl();
	}

}
