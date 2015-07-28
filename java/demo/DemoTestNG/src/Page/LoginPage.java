package Page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver driver;

	public LoginPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how = How.XPATH, using = "//button[contains(.,'Login')]")
	public static WebElement loginBtn;
	
	@FindBy(how = How.ID, using = "j_password")
	public static WebElement password;
	
	@FindBy(how = How.ID, using = "j_username")
	public static WebElement username;
	
//	public WebElement getUsername()
//	{
//		return username;
//	}
//	
//	public void setUsername(WebElement value)
//	{
//		this.username = value;
//	}

}
