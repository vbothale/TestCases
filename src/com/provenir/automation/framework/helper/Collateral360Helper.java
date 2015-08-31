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
		Util.enableAllDropdowns();
		Util.waitForLoaderToFinish();
		Util.waitForElementPresent(
				By.xpath("//input[contains(@customname,'collType')]"), 10);
		option = "Deposits";
		Util.selectItemFromList(collType, option);
		Util.waitForAJAX();
	}

	public void selectCollSubType(String option) {
		Util.enableAllDropdowns();
		Util.waitForLoaderToFinish();
		Util.waitForElementPresent(
				By.xpath("//input[contains(@customname,'collSubType')]"), 10);
		option = "Deposit Account, External";
		Util.selectItemFromList(collSubType, option);
		Util.waitForAJAX();
	}

	public void clickCollateralLink() throws InterruptedException {
		Util.waitForLoaderToFinish();
//		Thread.sleep(4000);
//		Util.waitForElement(collateralLink, 20);
		collateralLink.click();
		Util.scrollDown();
		Util.waitForLoaderToFinish();
	}

	public void clickOnAddCollateralLink() {
		collateralLink.click();
		Util.waitForElement(addBtnOnCollateral, 20);
		addBtnOnCollateral.click();
		Util.waitForLoaderToFinish();
		Util.waitForAJAX();
	}

	public void verifyCollateralTitle() throws InterruptedException {
		Util.waitForLoaderToFinish();
		Util.waitForLoaderToFinish();
//		Thread.sleep(3000);
		Util.waitForElement(collateralTitle, 20);
		String title = collateralTitle.getText().trim();
		Assert.assertEquals("Basic Collateral Information", title);
	}

	public void enterCollateralName() {
		Util.waitForLoaderToFinish();
		Util.waitForElement(collateralName, 20);
		collateralName.sendKeys("Test collateral");
	}

	public void enterCollateralCode() {
		Util.waitForElement(collateralCode, 10);
		collateralCode.sendKeys("coll1");
	}

	public void enterCollateralOwnerName() {
		Util.waitForLoaderToFinish();
		collateralOwnerName.sendKeys("intex");
		Util.scrollUp();
		clickSearchedCollateralOwner.click();
		Util.waitForLoaderToFinish();
		Util.waitForElement(loadCollateralOwner, 10);
		loadCollateralOwner.click();
		Util.waitForAJAX();
	}

	public void enterCollateralPercentage() {
		Util.waitForLoaderToFinish();
		collateralOwnerPercentage.sendKeys("100");
	}

	public void setPrimaryCollateralOwner() {
		collateralPrimaryOwner.click();
	}

	public void clickOnSaveCollateral() {
		saveCollateralDetails.click();
		Util.waitForLoaderToFinish();
		if (useCurrentCustomer.isDisplayed()) {
			useCurrentCustomer.click();
			Util.waitForLoaderToFinish();
		}
		Util.waitForAJAX();
	}

}
