package collateral;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class searchHelper {
	
	public static void searchRequest(WebDriver driver) {
		WebElement ele = driver.findElement(By.id("srchTxt"));
		ele.sendKeys("test123");
		ele.sendKeys(Keys.ENTER);
		GenericHelper.waitForLoaderGifToFinish(driver);
		new WebDriverWait(driver, 180)
				.until(ExpectedConditions.visibilityOfElementLocated(By
						.xpath(".//*[@id='partySrchRes']//span[contains(.,'Load')]")));
		driver.findElement(
				By.xpath(".//*[@id='partySrchRes']//span[contains(.,'Load')]"))
				.click();
		GenericHelper.waitForLoaderGifToFinish(driver);
	}

}
