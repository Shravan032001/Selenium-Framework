package utility;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Handle_Dropdown 
{
	public static void HandleSelectClass(WebElement element, String value)
	{
		Select s = new Select(element);
		s.selectByVisibleText(value);
	}

}
