package Page;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import utility.Util;

public class LoginPage{
	
	WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how = How.ID, using = "j_username")
	private WebElement username;

	@FindBy(how = How.ID, using = "j_password")
	private WebElement password;
	
	@FindBy(how = How.XPATH, using = "//button[contains(.,'Login')]")
	private WebElement loginBtn;
	
	public void login(HashMap<String, Map<String, String>> _hashLogins)
	{
		try
		{
			HashMap<String, String> propertiesMap = (HashMap<String, String>) _hashLogins
					.get("fmartin");
			username.sendKeys(propertiesMap.get("username"));
			password.sendKeys(propertiesMap.get("password"));
			loginBtn.click();
			Util.waitForAJAX(driver);
			Util.waitForLoaderToFinish(driver);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
