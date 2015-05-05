package prism_demo;

import org.testng.annotations.Test;
import org.testng.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import prism_demo.PrismHelper;

public class PrismTest {
	private WebDriver driver;
	@Parameters({ "browser" })
	
	@BeforeTest
	public void beforeTest(String browser) throws Exception {
		driver = BrowserHelper.openBrowser(browser, driver);
	}

	@AfterTest
	public void afterTest() {
		//driver.quit();
	}

	
	@Test
	public void SimpleSearch() throws Exception {
		PrismHelper.loginToPrism(driver);
		PrismHelper.waitForLoaderGifToFinish(driver);
		driver.findElement(By.xpath("//input[@id='srchTxt']")).sendKeys("auto");
		driver.findElement(By.xpath("//a[@class='srch_icon']")).click();
		PrismHelper.waitForLoaderGifToFinish(driver);
		driver.findElement(By.xpath("//a[@class='popup_cancel_icon']"));
		
	}


}
