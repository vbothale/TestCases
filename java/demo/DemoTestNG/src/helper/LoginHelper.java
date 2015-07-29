package helper;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import Page.LoginPage;

public class LoginHelper {
	
	WebDriver driver;

//	public LoginHelper(WebDriver driver){
//		this.driver = driver;	
////		LoginPage loginPage = new LoginPage(driver);
//	}
	
//	LoginPage loginPage = LoginPage.getInstance(driver);
	

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

//			LoginPage.username.sendKeys(propertiesMap.get("username"));
//			LoginPage.username.sendKeys("fmartin");
			
//		LoginPage.username.sendKeys(propertiesMap.get("username"));
//		LoginPage.password.sendKeys(propertiesMap.get("password"));
//		LoginPage.loginBtn.click();
			
			 driver.findElement(By.xpath("//button[contains(.,'Login')]"))
			 .click();

			 Utility.Util.waitForLoaderToFinish(driver);
			driver.manage().timeouts()
					.implicitlyWait(70, TimeUnit.MILLISECONDS);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
