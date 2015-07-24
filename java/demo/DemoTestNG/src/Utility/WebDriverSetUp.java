package Utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverSetUp {
	
	public static WebDriver getDriver(final String strDriver)
	{
		WebDriver driver = null;
		driver = new FirefoxDriver();
		return driver;
	}

}
