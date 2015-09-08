package helper;

import java.util.concurrent.TimeUnit;
import java.lang.*;

import org.testng.Assert;
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

import utility.*;

public class Collateral360Helper {
	
	WebDriver driver;
	
	public Collateral360Helper(WebDriver driver)
	{
		this.driver = driver;
	}

	// @FindBy(how = How.XPATH, using = ".//*[@id='ctrl']")
	// public WebElement collateralLink;

	public void collateralAdd(WebDriver driver) {
		Util.waitForLoaderToFinish(driver);
		driver.findElement(By.id("ctrl")).click();
		Util.scrollDown(driver);
		Util.waitForLoaderToFinish(driver);
		Util.waitForAJAX(driver);
	}

	public void clickOnAddBtn(WebDriver driver) {
		Util.waitForAJAX(driver);
		driver.findElement(By.id("ctrl")).click();
		Util.waitForElementPresent(
				By.xpath(".//*[@id='clientCollateral']/div/a"), 30, driver);
		driver.findElement(By.xpath(".//*[@id='clientCollateral']/div/a"))
				.click();

	}

	public void verifyCollateralTitle(WebDriver driver) {
		Util.waitForLoaderToFinish(driver);
		Util.waitForElementPresent(By.xpath(".//*[@id='c360r']"), 60, driver);
		Util.waitForLoaderToFinish(driver);
		String title = driver.findElement(By.xpath(".//*[@id='c360r']"))
				.getText().trim();
		Assert.assertEquals("Basic Collateral Information", title);
	}

	public void enterCollateralName(WebDriver driver) {
		Util.waitForAJAX(driver);
		Util.waitForLoaderToFinish(driver);
		Util.waitForElementPresent(By.id("collAccName"), 40, driver);
		driver.findElement(By.id("collAccName")).sendKeys("Test collateral");
	}

	public void enterColateralCode(WebDriver driver) {
		driver.findElement(By.id("collCd")).sendKeys("coll1");
	}

	public void selectCollateralType(WebDriver driver, String option)
			throws InterruptedException {

		Util.enableAllDropdowns(driver);
		Util.waitForLoaderToFinish(driver);
		Util.waitForElementPresent(
				By.xpath("//input[contains(@customname,'collType')]"), 20,
				driver);
		String str = "collType";
		option = "Deposits";
		Util.selectItemFromList(str, option, driver);

	}

	public void selectCollateralSubType(WebDriver driver, String option) {
		Util.enableAllDropdowns(driver);
		Util.waitForLoaderToFinish(driver);
		Util.waitForElementPresent(
				By.xpath("//input[contains(@customname,'collSubType')]"), 20,
				driver);
		String str = "collSubType";
		option = "Deposit Account, External";
		Util.selectItemFromList(str, option, driver);
	}

	public void enterCollateralOwnerName(WebDriver driver) {
		Util.waitForLoaderToFinish(driver);
		driver.findElement(By.id("ownerName")).sendKeys("intex");
		Util.scrollUp(driver);
		driver.findElement(By.id("ownSearch")).click();

		Util.waitForLoaderToFinish(driver);
		Util.waitForElementPresent(
				By.xpath(".//*[@id='partySrchRes']//span[contains(.,'Load')]"),
				40, driver);
		driver.findElement(
				By.xpath(".//*[@id='partySrchRes']//span[contains(.,'Load')]"))
				.click();

		Util.waitForAJAX(driver);
	}

	public void enterCollateralPercentage(WebDriver driver) {
		Util.waitForLoaderToFinish(driver);
		driver.findElement(By.id("ownerPer")).sendKeys("100");
	}

	public void setPrimaryCollateralOwner(WebDriver driver) {
		driver.findElement(By.id("selectPrimaryOwner")).click();
	}

	public void clickOnSaveCollateral(WebDriver driver) {
		driver.findElement(By.id("savecolldetails")).click();
		Util.waitForLoaderToFinish(driver);
		if (driver.findElement(By.id("useCurrentCust")).isDisplayed()) {
			driver.findElement(By.id("useCurrentCust")).click();
			Util.waitForLoaderToFinish(driver);
		}
		Util.waitForAJAX(driver);
	}

	public void selectCollateralTypeAsVehicle(WebDriver driver, String option) {
		Util.waitForAJAX(driver);
		Util.waitForLoaderToFinish(driver);
		Util.enableAllDropdowns(driver);
		Util.waitForLoaderToFinish(driver);
		Util.waitForElementPresent(
				By.xpath("//input[contains(@customname,'collType')]"), 20,
				driver);
		String str = "collType";
		option = "Vehicles";
		Util.selectItemFromList(str, option, driver);
	}

	public void selectCollateralSubTypeAsTitledMotorVehicles(WebDriver driver,
			String option) {
		Util.enableAllDropdowns(driver);
		Util.waitForLoaderToFinish(driver);
		Util.waitForElementPresent(
				By.xpath("//input[contains(@customname,'collSubType')]"), 20,
				driver);
		String str = "collSubType";
		option = "Titled Motor Vehicles";
		Util.selectItemFromList(str, option, driver);
	}

	public void enterMovable(WebDriver driver, String option) {
		Util.enableAllDropdowns(driver);
		Util.waitForLoaderToFinish(driver);
		Util.waitForElementPresent(
				By.xpath("//input[@customname='881fefc6262441bf8e649f4bf62cf93c']"),
				20, driver);
		String str = "881fefc6262441bf8e649f4bf62cf93c";
		option = "N/A";
		Util.selectItemFromList(str, option, driver);
	}

	public void enterCountry(WebDriver driver, String option) {
		Util.enableAllDropdowns(driver);
		Util.waitForLoaderToFinish(driver);
		Util.waitForElementPresent(
				By.xpath("//input[@customname='b15e876eefb9403b95b8f8f055c7a71b']"),
				20, driver);
		String str = "b15e876eefb9403b95b8f8f055c7a71b";
		option = "United States";
		Util.selectItemFromList(str, option, driver);
	}

	public void enterCity(WebDriver driver) {
		Util.waitForAJAX(driver);
		driver.findElement(By.id("city")).sendKeys("Parsipanny");
	}

	public void enterStreet(WebDriver driver) {
		Util.waitForAJAX(driver);
		driver.findElement(By.id("addr2")).sendKeys("address 2");
	}

	public void enterNumber(WebDriver driver) {
		Util.waitForAJAX(driver);
		driver.findElement(By.id("addr1")).sendKeys("address 1");
	}

	public void enterZipCode(WebDriver driver) {
		Util.waitForAJAX(driver);
		driver.findElement(By.id("zip")).sendKeys("07054");
	}

	public boolean verifyLeftHandMenuOnCollateralTypeAsVehicle(WebDriver driver) {
		Util.waitForAJAX(driver);
		String s1 = driver.findElement(By.xpath(".//*[@id='c360']")).getText()
				.trim();
		String s2 = driver.findElement(By.xpath(".//*[@id='titledMot']"))
				.getText().trim();
		String s3 = driver.findElement(By.xpath(".//*[@id='cvnt']")).getText()
				.trim();
		String s4 = driver.findElement(By.xpath(".//*[@id='dcts']")).getText()
				.trim();
		String s5 = driver.findElement(By.xpath(".//*[@id='siteVisit']"))
				.getText().trim();
		String s6 = driver.findElement(By.xpath(".//*[@id='existLiens']"))
				.getText().trim();
		String s7 = driver.findElement(By.xpath(".//*[@id='cVal']")).getText()
				.trim();
		String s8 = driver.findElement(By.xpath(".//*[@id='cFac']")).getText()
				.trim();
		if (s1.equalsIgnoreCase("Basic Collateral Information")
				&& s2.equalsIgnoreCase("Titled Motor Vehicle")
				&& s3.equalsIgnoreCase("Covenants")
				&& s4.equalsIgnoreCase("Documents")
				&& s5.equalsIgnoreCase("Site Visit/Audit")
				&& s6.equalsIgnoreCase("Existing Liens")
				&& s7.equalsIgnoreCase("Collateral Valuation")
				&& s8.equalsIgnoreCase("Collateral Facility")) {
			return true;
		} else

			return false;

	}

	public Customer360Helper clickBackButton(WebDriver driver) {
		Util.waitForElementPresent(By.id("backBC"), 15, driver);
		driver.findElement(By.id("backBC")).click();
		Util.waitForLoaderToFinish(driver);
		return new Customer360Helper(driver);
	}

	public void selectCollateralTypeAsShares(WebDriver driver, String option) {
		Util.waitForAJAX(driver);
		Util.waitForLoaderToFinish(driver);
		Util.enableAllDropdowns(driver);
		Util.waitForLoaderToFinish(driver);
		Util.waitForElementPresent(
				By.xpath("//input[contains(@customname,'collType')]"), 20,
				driver);
		String str = "collType";
		option = "Shares/Stocks/Bonds/Mutual Funds";
		Util.selectItemFromList(str, option, driver);
	}

	public boolean verifyLeftHandMenuOnCollateralTypeAsShares(WebDriver driver) {
		Util.waitForAJAX(driver);
		String s1 = driver.findElement(By.xpath(".//*[@id='c360']")).getText()
				.trim();
		String s2 = driver.findElement(By.xpath(".//*[@id='stock']")).getText()
				.trim();
		String s3 = driver.findElement(By.xpath(".//*[@id='cvnt']")).getText()
				.trim();
		String s4 = driver.findElement(By.xpath(".//*[@id='dcts']")).getText()
				.trim();
		String s5 = driver.findElement(By.xpath(".//*[@id='siteVisit']"))
				.getText().trim();
		String s6 = driver.findElement(By.xpath(".//*[@id='existLiens']"))
				.getText().trim();
		String s7 = driver.findElement(By.xpath(".//*[@id='cVal']")).getText()
				.trim();
		String s8 = driver.findElement(By.xpath(".//*[@id='cFac']")).getText()
				.trim();
		if (s1.equalsIgnoreCase("Basic Collateral Information")
				&& s2.equalsIgnoreCase("Shares/Stocks/Bonds/Mutual Funds")
				&& s3.equalsIgnoreCase("Covenants")
				&& s4.equalsIgnoreCase("Documents")
				&& s5.equalsIgnoreCase("Site Visit/Audit")
				&& s6.equalsIgnoreCase("Existing Liens")
				&& s7.equalsIgnoreCase("Collateral Valuation")
				&& s8.equalsIgnoreCase("Collateral Facility")) {
			return true;
		} else

			return false;

	}

	public void selectCollateralTypeAsAccountsReceivable(WebDriver driver,String option) {
		Util.waitForAJAX(driver);
		Util.waitForLoaderToFinish(driver);
		Util.enableAllDropdowns(driver);
		Util.waitForLoaderToFinish(driver);
		Util.waitForElementPresent(
				By.xpath("//input[contains(@customname,'collType')]"), 20,
				driver);
		String str = "collType";
		option = "Accounts Receivable";
		Util.selectItemFromList(str, option, driver);
	}

	public boolean verifyLeftHandMenuOnCollateralTypeAsAccountsReceivable(
			WebDriver driver) {
		Util.waitForAJAX(driver);
		String s1 = driver.findElement(By.xpath(".//*[@id='c360']")).getText()
				.trim();
		String s2 = driver.findElement(By.xpath(".//*[@id='ucc']")).getText()
				.trim();
		String s3 = driver.findElement(By.xpath(".//*[@id='cvnt']")).getText()
				.trim();
		String s4 = driver.findElement(By.xpath(".//*[@id='dcts']")).getText()
				.trim();
		String s5 = driver.findElement(By.xpath(".//*[@id='siteVisit']"))
				.getText().trim();
		String s6 = driver.findElement(By.xpath(".//*[@id='existLiens']"))
				.getText().trim();
		String s7 = driver.findElement(By.xpath(".//*[@id='cVal']")).getText()
				.trim();
		String s8 = driver.findElement(By.xpath(".//*[@id='cFac']")).getText()
				.trim();
		if (s1.equalsIgnoreCase("Basic Collateral Information")
				&& s2.equalsIgnoreCase("UCC")
				&& s3.equalsIgnoreCase("Covenants")
				&& s4.equalsIgnoreCase("Documents")
				&& s5.equalsIgnoreCase("Site Visit/Audit")
				&& s6.equalsIgnoreCase("Existing Liens")
				&& s7.equalsIgnoreCase("Collateral Valuation")
				&& s8.equalsIgnoreCase("Collateral Facility")) {
			return true;
		} else

			return false;

	}

	public void selectCollateralTypeAsRealEstate(WebDriver driver, String option) {
		Util.waitForAJAX(driver);
		Util.waitForLoaderToFinish(driver);
		Util.enableAllDropdowns(driver);
		Util.waitForLoaderToFinish(driver);
		Util.waitForElementPresent(
				By.xpath("//input[contains(@customname,'collType')]"), 20,
				driver);
		String str = "collType";
		option = "Real Estate";
		Util.selectItemFromList(str, option, driver);
	}

	public boolean verifyLeftHandMenuOnCollateralTypeAsRealEstate(WebDriver driver) {
		Util.waitForAJAX(driver);
		String s1 = driver.findElement(By.xpath(".//*[@id='c360']")).getText()
				.trim();
		String s2 = driver.findElement(By.xpath(".//*[@id='add']"))
				.getText().trim();
		String s3 = driver.findElement(By.xpath(".//*[@id='cHold']")).getText()
				.trim();
		String s4 = driver.findElement(By.xpath(".//*[@id='apn']")).getText()
				.trim();
		String s5 = driver.findElement(By.xpath(".//*[@id='insurance']"))
				.getText().trim();
		String s6 = driver.findElement(By.xpath(".//*[@id='floodInfo']"))
				.getText().trim();
		String s7 = driver.findElement(By.xpath(".//*[@id='leaseInfo']")).getText()
				.trim();
		String s8 = driver.findElement(By.xpath(".//*[@id='envDetails']")).getText()
				.trim();
		String s9 = driver.findElement(By.xpath(".//*[@id='cVal']")).getText()
				.trim();
		String s10 = driver.findElement(By.xpath(".//*[@id='siteVisit']")).getText()
				.trim();
		String s11 = driver.findElement(By.xpath(".//*[@id='existLiens']")).getText()
				.trim();
		String s12 = driver.findElement(By.xpath(".//*[@id='bDetails']")).getText()
				.trim();
		String s13 = driver.findElement(By.xpath(".//*[@id='propDetails']")).getText()
				.trim();
		String s14 = driver.findElement(By.xpath(".//*[@id='pDesign']")).getText()
				.trim();
		String s15 = driver.findElement(By.xpath(".//*[@id='pInsp']")).getText()
				.trim();
		String s16 = driver.findElement(By.xpath(".//*[@id='pHistory']")).getText()
				.trim();
		String s17 = driver.findElement(By.xpath(".//*[@id='pMgmt']")).getText()
				.trim();
		String s18 = driver.findElement(By.xpath(".//*[@id='cvnt']")).getText()
				.trim();
		String s19 = driver.findElement(By.xpath(".//*[@id='dcts']")).getText()
				.trim();
		String s20 = driver.findElement(By.xpath(".//*[@id='cFac']")).getText()
				.trim();
		if (s1.equalsIgnoreCase("Basic Collateral Information")
				&& s2.equalsIgnoreCase("Address")
				&& s3.equalsIgnoreCase("Collateral Holdings")
				&& s4.equalsIgnoreCase("APN/Tax Information")
				&& s5.equalsIgnoreCase("Insurance")
				&& s6.equalsIgnoreCase("Flood Information")
				&& s7.equalsIgnoreCase("Lease Information")
				&& s8.equalsIgnoreCase("Environmental Details") && s9.equalsIgnoreCase("Collateral Valuation") && s10.equalsIgnoreCase("Site Visit/Audit") && s11.equalsIgnoreCase("Existing Liens") && s12.equalsIgnoreCase("Building") && s13.equalsIgnoreCase("Property Details") && s14.equalsIgnoreCase("Property Designation") && s15.equalsIgnoreCase("Property Inspection") && s16.equalsIgnoreCase("Property History") &&  s17.equalsIgnoreCase("Property Management") && s18.equalsIgnoreCase("Covenants") && s19.equalsIgnoreCase("Documents") && s20.equalsIgnoreCase("Collateral Facility")) {
			return true;
		} else

			return false;

	}
}
