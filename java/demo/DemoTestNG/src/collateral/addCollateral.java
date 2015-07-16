package collateral;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import collateral.BrowserHelper.*;

public class addCollateral {

	private WebDriver driver;
	@Parameters({ "browser" })
	
	@BeforeTest
	public void beforeTest(String browser) throws Exception {
		driver = BrowserHelper.openBrowser(browser, driver);
	}

	@AfterTest
	public void afterTest() {
		driver.quit();
	}

	@Test
	public void addCollateral() throws InterruptedException
	{
		// Todo : Login into QA
//		driver.get("http://provappsvpcqa01.provapps.com:6080/ProvAppCLWeb");
//		driver.findElement(By.id("j_username")).sendKeys("fmartin");
//		driver.findElement(By.id("j_password")).sendKeys("Provenir1");
//		driver.findElement(By.xpath(".//*[@id='fLogin']/div[2]/div/div/div[3]/button")).click();
		GenericHelper.loginToPrism(driver);
		GenericHelper.waitForLoaderGifToFinish(driver);
		
		// Go to Credit 360
	}
	 
}
