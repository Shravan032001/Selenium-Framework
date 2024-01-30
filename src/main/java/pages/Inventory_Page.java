package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import base.TestBase;
import utility.Handle_Dropdown;

public class Inventory_Page extends TestBase
{
	// Object Repository
	@FindBy(xpath="//span[@class='title']") private WebElement Productslable;
	//Add Product Repository
	@FindBy(xpath="//button[@id='add-to-cart-sauce-labs-backpack']") private WebElement addbackpack;
	@FindBy(xpath="//button[@id='add-to-cart-sauce-labs-bolt-t-shirt']") private WebElement addbolttshirt;
	@FindBy(xpath="//button[@id='add-to-cart-sauce-labs-bike-light']") private WebElement addbikelight;
	@FindBy(xpath="//button[@id='add-to-cart-sauce-labs-fleece-jacket']") private WebElement addjacket;
	//Remove Product Repository
	@FindBy(xpath="//button[@id='remove-sauce-labs-backpack']") private WebElement removebackpack;
	@FindBy(xpath="//button[@id='remove-sauce-labs-fleece-jacket']") private WebElement removejacket;
	//Cart Count Repository
	@FindBy(xpath="//span[@class='shopping_cart_badge']") private WebElement cartcount;
	//Cart Click Repository
	@FindBy(xpath="//a[@class='shopping_cart_link']") private WebElement cart;
	//DropDown Repository
	@FindBy(xpath="//select[@class='product_sort_container']") private WebElement dropdown;
	//Twitter Logo
	@FindBy(xpath="//a[text()='Twitter']") private WebElement twitterlogo;
	//Footer Text
	@FindBy(xpath="//div[@class='footer_copy']") private WebElement footertext;
	
	
	//CONSTRUCTOR
	public Inventory_Page() 
	{
		PageFactory.initElements(driver,this);
	}
	
	//First Verify Inventory Page URL
	public String verifyinventorypageURL()
	{
		return driver.getCurrentUrl();
	}
	
	//Add 4 Product
	public String add4product()
	{
		Handle_Dropdown.HandleSelectClass(dropdown,"Price (low to high)");
		addbackpack.click();
		addbolttshirt.click();
		addbikelight.click();
		addjacket.click();
		return cartcount.getText();
	}
	 
	//Remove 2 Product
	public String remove2product()
	{
		add4product();             
		removebackpack.click();    
		removejacket.click();
		return cartcount.getText();
	}
	
	//Twitter Logo
	public boolean verifytwitterlogo() 
	{
		return twitterlogo.isDisplayed();	
	}
	
	//Footer Text
	public String verifyfootertext()
	{
		return footertext.getText();
		
	}
	
	//Click On Cart Button
	public void cartbtn()
	{
		cart.click();
	}

}
