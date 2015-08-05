package helper;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utility.Util;

public class AdvanceSearch {
	
	WebDriver driver;
	
	public static void searchRequest(WebDriver driver, HashMap<String, Map<String, String>>_hashSearch) {
		
		HashMap<String, String> propertiesMap = (HashMap<String, String>) _hashSearch
				.get("searchRequest");
		
		System.out.println("**************************************" + propertiesMap.get("searchRequest"));
		Util.enableAllDropdowns(driver);
		String str = driver.findElement(By.name("advSrchTyp")).sendKeys(
				propertiesMap.get("searchCustomer"));
	
	}

}
