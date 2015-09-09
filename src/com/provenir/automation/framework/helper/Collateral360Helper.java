package com.provenir.automation.framework.helper;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.provenir.automation.framework.utility.Util;

public class Collateral360Helper {

	WebDriver driver;

	public Collateral360Helper(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.ID, using = "ctrl")
	private WebElement collateralLink;

	@FindBy(how = How.XPATH, using = ".//*[@id='clientCollateral']/div/a")
	private WebElement addBtnOnCollateral;

	@FindBy(how = How.XPATH, using = ".//*[@id='c360r']")
	private WebElement collateralTitle;

	@FindBy(how = How.ID, using = "collAccName")
	private WebElement collateralName;

	@FindBy(how = How.ID, using = "collCd")
	private WebElement collateralCode;

	@FindBy(how = How.ID, using = "ownerName")
	private WebElement collateralOwnerName;

	@FindBy(how = How.ID, using = "ownSearch")
	private WebElement clickSearchedCollateralOwner;

	@FindBy(how = How.ID, using = "ownerPer")
	private WebElement collateralOwnerPercentage;

	@FindBy(how = How.ID, using = "selectPrimaryOwner")
	private WebElement collateralPrimaryOwner;

	@FindBy(how = How.ID, using = "savecolldetails")
	private WebElement saveCollateralDetails;

	@FindBy(how = How.ID, using = "useCurrentCust")
	private WebElement useCurrentCustomer;

	@FindBy(how = How.XPATH, using = ".//*[@id='partySrchRes']//span[contains(.,'Load')]")
	private WebElement loadCollateralOwner;

	private String collType = "collType";
	private String collSubType = "collSubType";

	public void selectCollType(String option) {
		Util.enableAllDropdowns(driver);
		Util.waitForLoaderToFinish(driver);
		Util.waitForElementPresent(driver,
				By.xpath("//input[contains(@customname,'collType')]"), 10);
		option = "Deposits";
		Util.selectItemFromList(driver,collType, option);
		Util.waitForAJAX(driver);
	}

	public void selectCollSubType(String option) {
		Util.enableAllDropdowns(driver);
		Util.waitForLoaderToFinish(driver);
		Util.waitForElementPresent(driver,
				By.xpath("//input[contains(@customname,'collSubType')]"), 10);
		option = "Deposit Account, External";
		Util.selectItemFromList(driver,collSubType, option);
		Util.waitForAJAX(driver);
	}

	public void clickCollateralLink() throws InterruptedException {
		Util.waitForLoaderToFinish(driver);
//		Thread.sleep(4000);
//		Util.waitForElement(collateralLink, 20);
		collateralLink.click();
		Util.scrollDown(driver);
		Util.waitForLoaderToFinish(driver);
	}

	public void clickOnAddCollateralLink() {
		collateralLink.click();
		Util.waitForElement(driver,addBtnOnCollateral, 20);
		addBtnOnCollateral.click();
		Util.waitForLoaderToFinish(driver);
		Util.waitForAJAX(driver);
	}

	public void verifyCollateralTitle() throws InterruptedException {
		Util.waitForLoaderToFinish(driver);
		Util.waitForLoaderToFinish(driver);
//		Thread.sleep(3000);
		Util.waitForElement(driver,collateralTitle, 20);
		String title = collateralTitle.getText().trim();
		Assert.assertEquals("Basic Collateral Information", title);
	}

	public void enterCollateralName() {
		Util.waitForLoaderToFinish(driver);
		Util.waitForElement(driver,collateralName, 20);
		collateralName.sendKeys("Test collateral");
	}

	public void enterCollateralCode() {
		Util.waitForElement(driver,collateralCode, 10);
		collateralCode.sendKeys("coll1");
	}

	public void enterCollateralOwnerName() {
		Util.waitForLoaderToFinish(driver);
		collateralOwnerName.sendKeys("intex");
		Util.scrollUp(driver);
		clickSearchedCollateralOwner.click();
		Util.waitForLoaderToFinish(driver);
		Util.waitForElement(driver,loadCollateralOwner, 10);
		loadCollateralOwner.click();
		Util.waitForAJAX(driver);
	}

	public void enterCollateralPercentage() {
		Util.waitForLoaderToFinish(driver);
		collateralOwnerPercentage.sendKeys("100");
	}

	public void setPrimaryCollateralOwner() {
		collateralPrimaryOwner.click();
	}

	public void clickOnSaveCollateral() {
		saveCollateralDetails.click();
		Util.waitForLoaderToFinish(driver);
		if (useCurrentCustomer.isDisplayed()) {
			useCurrentCustomer.click();
			Util.waitForLoaderToFinish(driver);
		}
		Util.waitForAJAX(driver);
	}

}
