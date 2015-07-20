package collateral;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GenericHelper {
	private static List<WebElement> lstElements = new ArrayList<WebElement>();
	
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



}
