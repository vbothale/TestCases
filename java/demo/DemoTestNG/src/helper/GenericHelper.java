package helper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utility.JSONReader;

public class GenericHelper {
	private static List<WebElement> lstElements = new ArrayList<WebElement>();
	private JSONReader reader = new JSONReader();
	public static HashMap<String, Map<String, String>> _hashCustomers = new HashMap<String, Map<String, String>>();
	
	public static void loginToPrism(WebDriver driver)  {
		try {
			HashMap<String, String> propertiesMap = (HashMap<String, String>) _hashCustomers.get("fmartin");
			
			driver.get("https://qa.provapps.com/ProvAppCLWeb/");
			
			driver.findElement(By.id("j_username")).sendKeys("fmartin");
			driver.findElement(By.id("j_password")).sendKeys("Provenir1");
			
//			System.out.println("First Name: " + propertiesMap.get("fname"));
//			System.out.println("Lst Name: " + propertiesMap.get("lname"));
			
//			System.out.println("User Name: " + propertiesMap.get("username"));
//			driver.findElement(By.id("j_username")).sendKeys(propertiesMap.get("username"));
////			
//			System.out.println("Password  : " + propertiesMap.get("password"));
//			driver.findElement(By.id("j_password")).sendKeys(propertiesMap.get("password"));

			driver.findElement(By.xpath("//button[contains(.,'Login')]")).click();
			
			GenericHelper.waitForLoaderGifToFinish(driver);
			driver.manage().timeouts()
			.implicitlyWait(70, TimeUnit.MILLISECONDS);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public static void waitForLoaderGifToFinish(WebDriver driver) {
		try {
			new WebDriverWait(driver, 180).until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(".//img[contains(@src,'loader.gif')]")));
//		System.out.println("loader no longer exists");
		} catch (Exception e) {
            System.out.println(e.getMessage());
		}		
	}
	
	public static void enableAllDropdowns(WebDriver driver) {
		Actions action = new Actions(driver);
		lstElements = driver.findElements(By
				.xpath(".//span[@class='ui-combobox notYetBind']/a"));
		for (WebElement element : lstElements) {
			action.moveToElement(element).build().perform();
			driver.manage().timeouts()
					.implicitlyWait(70, TimeUnit.MILLISECONDS);
		}
		driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
	}

	public static void selectItemFromList(String customName, String option, WebDriver driver) {
		try {
			WebElement searchTxtBox = driver.findElement(By
					.cssSelector("input[customname='" + customName + "']"));

			searchTxtBox.clear();
			searchTxtBox.sendKeys(option);
			GenericHelper.waitForElementPresent(
					By.xpath(".//ul[@customid='" + customName + "']/li[1]"), 5, driver);

			driver.findElement(
					By.xpath(".//ul[@customid='" + customName + "']/li[1]"))
					.click();
		} catch (Exception e) {
			e.printStackTrace();
		}
		driver.manage().timeouts().implicitlyWait(0, TimeUnit.MILLISECONDS); // nullify
		// implicitlyWait()
	}
	
	public static WebElement waitForElementPresent(By locator, int timeout, WebDriver driver) {
		try {
			driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS); // nullify
			// implicitlyWait()
			WebDriverWait wait = new WebDriverWait(driver, timeout);
			wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}


}