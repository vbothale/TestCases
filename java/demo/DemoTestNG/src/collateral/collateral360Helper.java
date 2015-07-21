package collateral;

import java.sql.Driver;
import java.lang.*;

import junit.framework.Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebDriver;

public class collateral360Helper {

	public static void collateralAdd(WebDriver driver) {
		GenericHelper.waitForLoaderGifToFinish(driver);
		driver.findElement(By.id("ctrl")).click();
		GenericHelper.waitForLoaderGifToFinish(driver);
	}

	public static void clickOnAddBtn(WebDriver driver) {
		new WebDriverWait(driver, 180)
				.until(ExpectedConditions.visibilityOfElementLocated(By
						.xpath(".//*[@id='addAddrRow2']")));
		driver.findElement(By.id("addAddrRow2")).click();

	}

	@SuppressWarnings("deprecation")
	public static void verifyCollateralTitle(WebDriver driver) {
		new WebDriverWait(driver, 180).until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath(".//*[@id='c360r']")));
		GenericHelper.waitForLoaderGifToFinish(driver);
		String title = driver.findElement(By.xpath(".//*[@id='c360r']"))
				.getText().trim();
		Assert.assertEquals(title, "Basic Collateral Information");
	}

	public static void enterCollateralName(WebDriver driver) {
		GenericHelper.waitForLoaderGifToFinish(driver);
		new WebDriverWait(driver, 180).until(ExpectedConditions
				.visibilityOfElementLocated(By.id("collAccName")));
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

		GenericHelper.enableAllDropdowns(driver);
		GenericHelper.waitForLoaderGifToFinish(driver);
		GenericHelper.waitForElementPresent(
				By.xpath("//input[contains(@customname,'collType')]"), 20,
				driver);
		String str = "collType";
		option = "Deposits";
		GenericHelper.selectItemFromList(str, option, driver);

	}

	public static void selectCollateralSubType(WebDriver driver, String option) {
		GenericHelper.enableAllDropdowns(driver);
		GenericHelper.waitForLoaderGifToFinish(driver);
		GenericHelper.waitForElementPresent(
				By.xpath("//input[contains(@customname,'collSubType')]"), 20,
				driver);
		String str = "collSubType";
		option = "Deposit Account, External";
		GenericHelper.selectItemFromList(str, option, driver);
	}
	
	public static void enterCollateralOwnerName(WebDriver driver)
	{
		GenericHelper.waitForLoaderGifToFinish(driver);
		driver.findElement(By.id("ownerName")).sendKeys("intex");
		driver.findElement(By.id("ownSearch")).click();
		driver.findElement(
				By.xpath(".//*[@id='partySrchRes']//span[contains(.,'Load')]"))
				.click();
	}
	
	public static void enterCollateralPercentage(WebDriver driver)
	{
		GenericHelper.waitForLoaderGifToFinish(driver);
		driver.findElement(By.id("ownerPer")).sendKeys("100");
	}
	
	public static void setPrimaryCollateralOwner(WebDriver driver)
	{
		driver.findElement(By.id("selectPrimaryOwner")).click();
	}
	
	public static void clickOnSaveCollateral(WebDriver driver)
	{
		driver.findElement(By.id("savecolldetails")).click();
		GenericHelper.waitForLoaderGifToFinish(driver);
	}

}
