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
	private WebElement usernameEdit;

	@FindBy(how = How.ID, using = "j_password")
	private WebElement passwordEdit;
	
	public void enterUsername(HashMap<String, Map<String, String>> _hashLogins)
	{
		
	}

}
