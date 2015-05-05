package prism_demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PrismHelper {
	public static void loginToPrism(WebDriver driver)  {
		try {
			driver.get("http://qa01.provapps.com:6080/ProvAppCLWeb/");
			driver.findElement(By.id("j_username")).sendKeys("sdietz");
			driver.findElement(By.id("j_password")).sendKeys("Provenir1");
			driver.findElement(By.xpath(".//*[@id='fLogin']/div[2]/div/div/div[3]/button")).click();
			new WebDriverWait(driver, 180).until(ExpectedConditions.invisibilityOfElementLocated(By.id("j_username")));
			PrismHelper.waitForLoaderGifToFinish(driver);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public static void waitForLoaderGifToFinish(WebDriver driver) {
		try {
			//System.out.println("loader exists");
			new WebDriverWait(driver, 180).until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(".//img[contains(@src,'loader.gif')]")));
			System.out.println("loader no longer exists");
		} catch (Exception e) {
            System.out.println(e.getMessage());
		}		
	}
	
	public static void AddComment(WebDriver driver) {

		try {
			waitForLoaderGifToFinish(driver);
			driver.findElement(By.partialLinkText("My Dashboard")).click();
			waitForLoaderGifToFinish(driver);
			driver.findElement(By.xpath("//a[@name='credLineLnk0']"));
			waitForLoaderGifToFinish(driver);
			  
			  
			driver.findElement(By.xpath("//div[@class='common_div_all_comment']"));
			driver.findElement(By.xpath("//div[@class='richTxtArea']")).click();
			
			
		} catch (Exception e) {
            System.out.println(e.getMessage());
		}
		
	}

}