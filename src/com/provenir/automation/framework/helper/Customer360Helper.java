package com.provenir.automation.framework.helper;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.provenir.automation.framework.utility.Util;

public class Customer360Helper {

	WebDriver driver;

	public Customer360Helper(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.ID, using = "addr")
	private WebElement addressLink;

	@FindBy(how = How.XPATH, using = ".//*[@id='clientAddress']/div/a")
	private WebElement addBtnOnAddress;

	@FindBy(how = How.XPATH, using = "//h2[contains(.,'Add Address')]")
	private WebElement addressTitle;

	@FindBy(how = How.ID, using = "addrLn1")
	private WebElement addressLine;

	@FindBy(how = How.ID, using = "postalCd")
	private WebElement postalCode;

	@FindBy(how = How.ID, using = "city")
	private WebElement city;

	@FindBy(how = How.XPATH, using = ".//*[@id='postCodeDivId']/img")
	private WebElement postalCodeImage;
	
	@FindBy(how = How.XPATH, using = "//span[contains(.,'Save')]")
	private WebElement saveAddress;

	private String addressType = "addrTyp";
	private String country = "country";
	private String region = "state";

	public void clickAddressLink() {
		Util.waitForAJAX();
		Util.waitForElement(addressLink, 20);
		addressLink.click();
		Util.waitForLoaderToFinish();
	}

	public void clickAddBtnOfAddressLink() {
		Util.waitForElement(addBtnOnAddress, 10);
		addBtnOnAddress.click();
		Util.waitForLoaderToFinish();
	}

	public void verifyAddressTitle() {
		Util.waitForAJAX();
		Util.waitForElement(addressTitle, 20);
		String title = addressTitle.getText().trim();
		Assert.assertEquals("Add Address", title);
	}

	public void enterAddressType(String option) {
		Util.waitForAJAX();
		Util.scrollUp();
		Util.enableAllDropdowns();
		Util.waitForElementPresent(By.xpath(addressType), 20);
		option = "Mailing";
		Util.selectItemFromList(addressType, option);
	}

	public void selectCountry(String option) {
		Util.enableAllDropdowns();
		Util.waitForElementPresent(By.xpath(country), 20);
		option = "United States";
		Util.selectItemFromList(country, option);
	}

	public void enterAddressLine() {
		Util.waitForAJAX();
		Util.waitForElement(addressLine, 10);
		addressLine.sendKeys("address line 1");
	}

	public void enterPostalCode() {
		Util.waitForAJAX();
		Util.waitForElement(postalCode, 20);
		postalCode.sendKeys("10005");
		postalCodeImage.click();
		Util.waitForLoaderToFinish();
	}

	public void enterCity() {
		Util.waitForElement(city, 10);
		city.sendKeys("NY");
	}

	public void enterRegion(String option) {
		Util.enableAllDropdowns();
		Util.waitForElementPresent(By.xpath(region), 20);
		option = "New York";
		Util.selectItemFromList(country, option);
	}

	public void saveAddress() {
		Util.waitForAJAX();
		Util.waitForElement(saveAddress, 15);
		saveAddress.click();
		Util.waitForLoaderToFinish();
	}

}
