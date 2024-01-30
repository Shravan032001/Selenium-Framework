package pages;
///////////////////////

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class CheckOutPage2 extends TestBase
{
	// Object Repository
	@FindBy(xpath="//div[text()='Payment Information']") private WebElement PIText;
	@FindBy(xpath="//div[text()='SauceCard #31337']") private WebElement SCText;
	@FindBy(xpath="//div[text()='Shipping Information']") private WebElement SIText;
	@FindBy(xpath="//div[text()='Free Pony Express Delivery!']") private WebElement FPEDText;
	@FindBy(xpath="//div[text()='Price Total']") private WebElement PTText;
	@FindBy(xpath="//div[text()='Item total: $']") private WebElement ITText;
	@FindBy(xpath="//div[text()='Tax: $']") private WebElement TaxText;
	@FindBy(xpath="//div[text()='Total: $']") private WebElement TotalText1;
	@FindBy(xpath="//button[@id='finish']") private WebElement finishbtn;
	
	// CONSTRUCTOR
	public CheckOutPage2()
	{
		PageFactory.initElements(driver,this);
	}
	
	// Methods
	
	public String VerifyCheckOutPage2URL()
	{
		return driver.getCurrentUrl();	
	}
	
	public String VerifyPITText()
	{
		return PIText.getText();
	}
	
	public String VerifySCText()
	{
		return SCText.getText();
	}
	
	public String VerifySIText()
	{
		return SIText.getText();
	}
	
	public String VerifyFPEDText()
	{
		return FPEDText.getText();
	}
	
	public String VerifyPTText()
	{
		return PTText.getText();
	}
	
	public String VerifyITText()
	{
		return ITText.getText();
	}
	
	public String VerifyTaxText()
	{
		return TaxText.getText();
	}
	
	public String VerifyTotalText1()
	{
		return TotalText1.getText();
	}
	
	public String Verifyfinishbtn()
	{
		finishbtn.click();
		return driver.getCurrentUrl();
	}
	
	
	

}
