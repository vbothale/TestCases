package collateral;

import Utility.*;

import java.util.concurrent.TimeUnit;
import java.lang.*;

import junit.framework.Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebDriver;
//import collateral.locatorCollateral;

public class Collateral360Helper {
	
//	@FindBy(how = How.XPATH, using = ".//*[@id='ctrl']")
//	public WebElement collateralLink;
	
	public void collateralAdd(WebDriver driver) {
		Utility.Util.waitForLoaderToFinish(driver);
		driver.findElement(By.id("ctrl")).click();
		Util.scrollDown(driver);
		Utility.Util.waitForLoaderToFinish(driver);
	}

	public static void clickOnAddBtn(WebDriver driver) {
//		new WebDriverWait(driver, 180)
//				.until(ExpectedConditions.visibilityOfElementLocated(By
//						.xpath(".//*[@id='addAddrRow2']")));
		Utility.Util.waitForElementPresent(By.xpath(".//*[@id='addAddrRow2']"), 30, driver);
		driver.findElement(By.id("addAddrRow2")).click();

	}

	@SuppressWarnings("deprecation")
	public static void verifyCollateralTitle(WebDriver driver) {
		Util.waitForLoaderToFinish(driver);
//		new WebDriverWait(driver, 180).until(ExpectedConditions
//				.visibilityOfElementLocated(By.xpath(".//*[@id='c360r']")));
		Utility.Util.waitForElementPresent(By.xpath(".//*[@id='c360r']"), 60, driver);
		Utility.Util.waitForLoaderToFinish(driver);
		String title = driver.findElement(By.xpath(".//*[@id='c360r']"))
				.getText().trim();
		Assert.assertEquals(title, "Basic Collateral Information");
	
	}

	public static void enterCollateralName(WebDriver driver) {
		Utility.Util.waitForLoaderToFinish(driver);
//		new WebDriverWait(driver, 180).until(ExpectedConditions
//				.visibilityOfElementLocated(By.id("collAccName")));
		Utility.Util.waitForElementPresent(By.id("collAccName"), 40, driver);
		driver.findElement(By.id("collAccName")).sendKeys("Test collateral");
	}

	public static void enterColateralCode(WebDriver driver) {
		driver.findElement(By.id("collCd")).sendKeys("coll1");
	}

	public static void selectCollateralType(WebDriver driver, String option)
			throws InterruptedException {
		// // new WebDriverWait(driver, 180).until(ExpectedConditions
		// // .visibilityOfElementLocated(By.xpath(".//*[@id='collType']")));
		// GenericHelper.enableAllDropdowns(driver);
		// GenericHelper.waitForLoaderGifToFinish(driver);
		// WebElement ele =
		// driver.findElement(By.xpath("//input[contains(@customname,'collType')]"));
		// WebElement ele1 = ele.findElement(By.xpath(".."));
		// WebElement ele2 = ele1.findElement(By.xpath(".//input"));
		// // Select sel = new
		// Select(driver.findElement(By.xpath("//input[contains(@customname,'collType')]")));
		// ele2.sendKeys("Real Estate");
		// ele2.sendKeys(Keys.ARROW_DOWN);
		// WebElement ele3 =
		// driver.findElement(By.xpath("//a[contains(.,'Real Estate')]"));
		// ele3.click();
		// // ele2.sendKeys(Keys.ENTER);
		// GenericHelper.waitForLoaderGifToFinish(driver);

		Utility.Util.enableAllDropdowns(driver);
		Utility.Util.waitForLoaderToFinish(driver);
		Utility.Util.waitForElementPresent(
				By.xpath("//input[contains(@customname,'collType')]"), 20,
				driver);
		String str = "collType";
		option = "Deposits";
		Utility.Util.selectItemFromList(str, option, driver);

	}

	public static void selectCollateralSubType(WebDriver driver, String option) {
		Utility.Util.enableAllDropdowns(driver);
		Utility.Util.waitForLoaderToFinish(driver);
		Utility.Util.waitForElementPresent(
				By.xpath("//input[contains(@customname,'collSubType')]"), 20,
				driver);
		String str = "collSubType";
		option = "Deposit Account, External";
		Utility.Util.selectItemFromList(str, option, driver);
	}

	public static void enterCollateralOwnerName(WebDriver driver) {
		Utility.Util.waitForLoaderToFinish(driver);
		driver.findElement(By.id("ownerName")).sendKeys("intex");

		driver.findElement(By.id("ownSearch")).click();

		Utility.Util.waitForLoaderToFinish(driver);
		Utility.Util.waitForElementPresent(
				By.xpath(".//*[@id='partySrchRes']//span[contains(.,'Load')]"),
				40, driver);
		driver.findElement(
				By.xpath(".//*[@id='partySrchRes']//span[contains(.,'Load')]"))
				.click();
		
		//When busy div is not showing need to wait for few secs until grid gets loaded
		driver.manage().timeouts().implicitlyWait(70, TimeUnit.MILLISECONDS);
	}

	public static void enterCollateralPercentage(WebDriver driver) {
		Utility.Util.waitForLoaderToFinish(driver);
		driver.findElement(By.id("ownerPer")).sendKeys("100");
	}

	public static void setPrimaryCollateralOwner(WebDriver driver) {
		driver.findElement(By.id("selectPrimaryOwner")).click();
	}

	public static void clickOnSaveCollateral(WebDriver driver) {
		driver.findElement(By.id("savecolldetails")).click();
		Utility.Util.waitForLoaderToFinish(driver);
		if(driver.findElement(By.id("useCurrentCust")).isDisplayed())
		{
			driver.findElement(By.id("useCurrentCust")).click();
			Utility.Util.waitForLoaderToFinish(driver);
		}
	}
	
	

}
