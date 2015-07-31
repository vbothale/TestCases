package helper;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utility.TestDataReader;

public class SearchHelper {

	public static void searchCustomer(WebDriver driver, HashMap<String, Map<String, String>>_hashCustomers) {
		
		HashMap<String, String> propertiesMap = (HashMap<String, String>) _hashCustomers
				.get("searchCustomer");
		
		System.out.println("**************************************" + propertiesMap.get("searchCustomer"));
		driver.findElement(By.id("srchTxt")).sendKeys(
				propertiesMap.get("searchCustomer"));
		

		WebElement ele = driver.findElement(By.id("srchTxt"));
		
		// ele.sendKeys("test12345");
		
		ele.sendKeys(Keys.ENTER);
		utility.Util.waitForLoaderToFinish(driver);
		driver.manage().timeouts().implicitlyWait(70, TimeUnit.MILLISECONDS);
		new WebDriverWait(driver, 180)
				.until(ExpectedConditions.visibilityOfElementLocated(By
						.xpath(".//*[@id='transSrchRes']//span[contains(.,'Load')]")));
		driver.findElement(By.id("selCustomer")).click();
		driver.findElement(
				By.xpath(".//*[@id='partySrchRes']//span[contains(.,'Load')]"))
				.click();
		utility.Util.waitForLoaderToFinish(driver);
	}

	public static void searchRequest(WebDriver driver) {
		// TODO Auto-generated method stub

	}

}
