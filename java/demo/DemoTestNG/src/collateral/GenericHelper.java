package collateral;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GenericHelper {
	
	public static void loginToPrism(WebDriver driver)  {
		try {
			driver.get("http://qa01.provapps.com:6080/ProvAppCLWeb/");
			driver.findElement(By.id("j_username")).sendKeys("sdietz");
			driver.findElement(By.id("j_password")).sendKeys("Provenir1");
			driver.findElement(By.xpath(".//*[@id='fLogin']/div[2]/div/div/div[3]/button")).click();
			GenericHelper.waitForLoaderGifToFinish(driver);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public static void waitForLoaderGifToFinish(WebDriver driver) {
		try {
			new WebDriverWait(driver, 180).until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(".//img[contains(@src,'loader.gif')]")));
		System.out.println("loader no longer exists");
		} catch (Exception e) {
            System.out.println(e.getMessage());
		}		
	}


}
