package collateral;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
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
		System.gc();
		driver.quit();
	}

	@Test
	public void addCollateral() throws InterruptedException {
		GenericHelper.loginToPrism(driver);
		GenericHelper.waitForLoaderGifToFinish(driver);
		searchResult.searchRequest(driver);
	}

	
	// Go to credit 360

}
