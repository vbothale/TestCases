package helper;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import locators.loginPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class loginHelper {
	
	public static void loginToPrism(WebDriver driver, HashMap<String, Map<String, String>>_hashLogins) {
		try {
			HashMap<String, String> propertiesMap = (HashMap<String, String>) _hashLogins
					.get("fmartin");

			driver.get("https://qa.provapps.com/ProvAppCLWeb/");

			// driver.findElement(By.id("j_username")).sendKeys("fmartin");
			// driver.findElement(By.id("j_password")).sendKeys("Provenir1");

			// System.out.println("First Name: " + propertiesMap.get("fname"));
			// System.out.println("Lst Name: " + propertiesMap.get("lname"));

//			System.out.println("User Name: " + propertiesMap.get("username"));
//			System.out.println("Password  : " + propertiesMap.get("password"));
//			driver.manage().timeouts()
//					.implicitlyWait(100, TimeUnit.MILLISECONDS);

			driver.findElement(By.id("j_username")).sendKeys(
					propertiesMap.get("username"));

			driver.findElement(By.id("j_password")).sendKeys(
					propertiesMap.get("password"));

//			driver.findElement(By.xpath("//button[contains(.,'Login')]"))
//					.click();
			loginPage.LoginBtn(driver);
			
			
			GenericHelper.waitForLoaderGifToFinish(driver);
			driver.manage().timeouts()
					.implicitlyWait(70, TimeUnit.MILLISECONDS);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
