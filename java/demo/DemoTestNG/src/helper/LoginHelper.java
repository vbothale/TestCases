package helper;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginHelper {

	WebDriver driver;

	public LoginHelper(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.XPATH, using = "//button[contains(.,'Login')]")
	private static WebElement loginBtn;

	public LoginHelper clickLoginBtn(WebDriver driver) {
		loginBtn.click();
		GenericHelper.waitForLoaderGifToFinish(driver);
		return new LoginHelper(driver);
	}
	
	public void clickLogin(WebDriver driver)
	{
		loginBtn.click();
	}

	// static loginPage login;

	public static void loginToPrism(WebDriver driver,
			HashMap<String, Map<String, String>> _hashLogins) {
		try {
			HashMap<String, String> propertiesMap = (HashMap<String, String>) _hashLogins
					.get("fmartin");

			driver.get("http://provappsvpcqa01.provapps.com:6080/ProvAppCLWeb/");

			driver.findElement(By.id("j_username")).sendKeys(
					propertiesMap.get("username"));

			driver.findElement(By.id("j_password")).sendKeys(
					propertiesMap.get("password"));

//			 driver.findElement(By.xpath("//button[contains(.,'Login')]"))
//			 .click();
//
//			GenericHelper.waitForLoaderGifToFinish(driver);
//			driver.manage().timeouts()
//					.implicitlyWait(70, TimeUnit.MILLISECONDS);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
