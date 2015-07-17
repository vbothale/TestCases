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

public class collateral360 {

	public WebDriver driver;

	@Parameters({ "browser" })
	@BeforeTest
	public void beforeTest(String browser) throws Exception {
		driver = BrowserHelper.openBrowser(browser, driver);
		driver.manage().window().maximize();
		GenericHelper.loginToPrism(driver);
		GenericHelper.waitForLoaderGifToFinish(driver);
		searchHelper.searchRequest(driver);
		collateral360Helper.collateralAdd(driver);
		collateral360Helper.clickOnAddBtn(driver);
	}

	@AfterTest
	public void afterTest() {
		System.gc();
		driver.quit();
	}

	@Test
	public void verifyCollateralTitle() throws InterruptedException {
		collateral360Helper.verifyCollateralTitle(driver);
	}
	
	@Test
	public void saveCollateralInformation() throws InterruptedException
	{
		collateral360Helper.enterCollateralName(driver);
		collateral360Helper.enterColateralCode(driver);
		collateral360Helper.selectCollateralType(driver);
		collateral360Helper.selectCollateralSubType(driver);
	}

}
