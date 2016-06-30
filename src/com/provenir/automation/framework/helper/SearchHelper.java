package com.provenir.automation.framework.helper;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.provenir.automation.framework.utility.Util;

public class SearchHelper {

	WebDriver driver;

	public SearchHelper(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.ID, using = "srchTxt")
	private WebElement searchBox;

	@FindBy(how = How.ID, using = "selCustomer")
	private WebElement searchedCust;

	@FindBy(how = How.ID, using = "selCredReq")
	private WebElement searchedReq;

	@FindBy(how = How.ID, using = "selCredLine")
	private WebElement searchedFacility;

	@FindBy(how = How.XPATH, using = ".//*[@id='partySrchRes']//span[contains(.,'Load')]")
	private WebElement loadCustomer;

	@FindBy(how = How.XPATH, using = ".//*[@id='requestSrchRes']//span[contains(.,'Load')]")
	private WebElement loadReq;

	@FindBy(how = How.XPATH, using = ".//*[@id='transSrchRes']//span[contains(.,'Load')]")
	private WebElement loadFacility;

	@FindBy(how = How.XPATH, using = ".//*[@id='credSumm']")
	private WebElement creditSummary;

	@FindBy(how = How.XPATH, using = "//*[@id='credLnSum']")
	private WebElement facilityLnk;

	public void searchCustomer(
			HashMap<String, Map<String, String>> _hashCustomers) {
		HashMap<String, String> propertiesMap = (HashMap<String, String>) _hashCustomers
				.get("searchCustomer");

		System.out.println("**************************************"
				+ propertiesMap.get("searchCustomer"));

		searchBox.sendKeys(propertiesMap.get("searchCustomer"));
		searchBox.sendKeys(Keys.ENTER);
		Util.waitForLoaderToFinish(driver);
		Util.waitForAJAX(driver);

		Util.waitForElementPresent(driver,
				By.xpath(".//*[@id='transSrchRes']//span[contains(.,'Load')]"),
				20);
		searchedCust.click();
		loadCustomer.click();
		Util.waitForLoaderToFinish(driver);
		Util.waitForAJAX(driver);
	}

	public void searchRequest(HashMap<String, Map<String, String>> _hashReq) {
		HashMap<String, String> propertiesMap = (HashMap<String, String>) _hashReq
				.get("searchReq");

		System.out.println("**************************************"
				+ propertiesMap.get("searchReq"));

		searchBox.sendKeys(propertiesMap.get("searchReq"));
		searchBox.sendKeys(Keys.ENTER);
		Util.waitForLoaderToFinish(driver);
		Util.waitForAJAX(driver);

		Util.waitForElementPresent(driver, By
				.xpath(".//*[@id='requestSrchRes']//span[contains(.,'Load')]"),
				20);
		searchedReq.click();
		loadReq.click();
		Util.waitForLoaderToFinish(driver);
		Util.waitForAJAX(driver);
	}

	public void searchFacility(
			HashMap<String, Map<String, String>> _hashFacility) {
		HashMap<String, String> propertiesMap = (HashMap<String, String>) _hashFacility
				.get("searchFacility");

		System.out.println("**************************************"
				+ propertiesMap.get("searchFacility"));

		searchBox.sendKeys(propertiesMap.get("searchFacility"));
		searchBox.sendKeys(Keys.ENTER);
		Util.waitForLoaderToFinish(driver);
		Util.waitForAJAX(driver);

		Util.waitForElementPresent(driver,
				By.xpath(".//*[@id='transSrchRes']//span[contains(.,'Load')]"),
				20);
		searchedFacility.click();
		loadFacility.click();
		Util.waitForLoaderToFinish(driver);
		Util.waitForAJAX(driver);
	}

	public void searchExistingRequest() {

		searchBox.sendKeys("Request HCL Corporation");
		searchBox.sendKeys(Keys.ENTER);
		Util.waitForLoaderToFinish(driver);
		Util.waitForAJAX(driver);

		Util.waitForElementPresent(driver, By
				.xpath(".//*[@id='requestSrchRes']//span[contains(.,'Load')]"),
				20);
		searchedReq.click();
		loadReq.click();
		Util.waitForLoaderToFinish(driver);
		Util.waitForAJAX(driver);
	}

	public Credit360Helper clickCreditSummary() {
		Util.waitForElement(driver, creditSummary, 10);
		creditSummary.click();
		return new Credit360Helper(driver);
	}

	public MyRequests srchAssociatedFacility() {
		searchBox.sendKeys("Fac 1234");
		searchBox.sendKeys(Keys.ENTER);
		Util.waitForLoaderToFinish(driver);
		Util.waitForAJAX(driver);

		Util.waitForElementPresent(driver,
				By.xpath(".//*[@id='transSrchRes']//span[contains(.,'Load')]"),
				20);
		searchedFacility.click();
		loadFacility.click();
		Util.waitForLoaderToFinish(driver);
		Util.waitForAJAX(driver);
		return new MyRequests(driver);
	}

	public void srchExistingReq() {
		searchBox.sendKeys("Request HCL Corporation");
		searchBox.sendKeys(Keys.ENTER);
		Util.waitForLoaderToFinish(driver);
		Util.waitForAJAX(driver);

		Util.waitForElementPresent(driver, By
				.xpath(".//*[@id='requestSrchRes']//span[contains(.,'Load')]"),
				20);
		searchedReq.click();
		loadReq.click();
		Util.waitForLoaderToFinish(driver);
		Util.waitForAJAX(driver);
	}

	public Facility360Details clickFacSummary() {
		Util.waitForElement(driver, facilityLnk, 10);
		facilityLnk.click();
		return new Facility360Details(driver);
	}

	public void searchExistingFacility() {
		searchBox.sendKeys("Fac for intex");
		searchBox.sendKeys(Keys.ENTER);
		Util.waitForLoaderToFinish(driver);
		Util.waitForAJAX(driver);

		Util.waitForElementPresent(driver,
				By.xpath(".//*[@id='transSrchRes']//span[contains(.,'Load')]"),
				20);
		searchedFacility.click();
		loadFacility.click();
		Util.waitForLoaderToFinish(driver);
		Util.waitForAJAX(driver);
	}

	public void srchReq(String option) {
		Util.waitForElement(driver, searchBox, 10);
		searchBox.clear();
		searchBox.sendKeys(option);
		searchBox.sendKeys(Keys.ENTER);
		Util.waitForAJAX(driver);
	}

	public Credit360Helper clickLoadBtnOnSearchPopup() {
		Util.waitForAJAX(driver);
		searchedReq.click();
		loadReq.click();
		Util.waitForLoaderToFinish(driver);
		Util.waitForAJAX(driver);
		return new Credit360Helper(driver);
	}

}
