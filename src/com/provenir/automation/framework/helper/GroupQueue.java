package com.provenir.automation.framework.helper;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.provenir.automation.framework.utility.Util;

public class GroupQueue {

	WebDriver driver;
	Actions actions = null;

	public GroupQueue(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		actions = new Actions(driver);
	}

	@FindBy(how = How.XPATH, using = ".//*[@id='rightContent']/div/div/div/div[1]/label")
	private WebElement grpQueTitle;

	@FindBy(how = How.XPATH, using = "//label[contains(.,'Entity Type:')]")
	private WebElement entityTypeTitle;

	@FindBy(how = How.XPATH, using = "//label[contains(.,'Status:')]")
	private WebElement statusTitle;

	@FindBy(how = How.XPATH, using = "//label[contains(.,'Role:')]")
	private WebElement roleTitle;

	@FindBy(how = How.XPATH, using = "//label[contains(.,'Category:')]")
	private WebElement categoryTitle;

	@FindBy(how = How.XPATH, using = "//label[contains(.,'From Date:')]")
	private WebElement fromDateTitle;

	@FindBy(how = How.XPATH, using = "//label[contains(.,'To Date:')]")
	private WebElement toDateTitle;

	@FindBy(how = How.ID, using = "filterRoleGrpQueue")
	private WebElement filterBtn;

	@FindBy(how = How.XPATH, using = "//button[contains(.,'All Selected')]")
	private WebElement defaultValue;

	@FindBy(how = How.ID, using = "home")
	private WebElement homeLink;

	@FindBy(how = How.XPATH, using = ".//*[@id='rightContent']/div/div/div/div[1]/div[2]/div[1]/p/div/button")
	private WebElement entityTypeField;

	@FindBy(how = How.XPATH, using = ".//*[@name='selectAllentity']")
	private WebElement allOnEntityType;

	@FindBy(how = How.XPATH, using = ".//*[@id='rightContent']/div/div/div/div[1]/div[2]/div[2]/p/div/button")
	private WebElement statusField;

	@FindBy(how = How.XPATH, using = ".//*[@name='selectAllstatus']")
	private WebElement allOnStatus;

	private WebElement element = null;

	public boolean verifyGroupQueueTitle() {
		Util.waitForAJAX(driver);
		Util.waitForElement(driver, grpQueTitle, 10);
		if (grpQueTitle.isDisplayed())
			return true;
		else
			return false;
	}

	public boolean verifyFiltersOnGroupQueue() {
		String s1 = entityTypeTitle.getText().trim();
		String s2 = statusTitle.getText().trim();
		String s3 = roleTitle.getText().trim();
		String s4 = categoryTitle.getText().trim();
		String s5 = fromDateTitle.getText().trim();
		String s6 = toDateTitle.getText().trim();
		if (s1.equalsIgnoreCase("Entity Type:")
				&& s2.equalsIgnoreCase("Status:")
				&& s3.equalsIgnoreCase("Role:")
				&& s4.equalsIgnoreCase("Category:")
				&& s5.equalsIgnoreCase("From Date:")
				&& s6.equalsIgnoreCase("To Date:")) {
			return true;
		} else
			return false;
	}

	public boolean verifyDefaultValueOfFilters() {
		Util.waitForAJAX(driver);
		Util.waitForElement(driver, defaultValue, 10);
		if (defaultValue.isDisplayed()) {
			return true;
		} else
			return false;
	}

	public void clickFilterBtn() {
		Util.waitForAJAX(driver);
		Util.waitForElement(driver, filterBtn, 20);
		filterBtn.click();
		Util.waitForLoaderToFinish(driver);
		Util.waitForAJAX(driver);
	}

	public MyRequests clickHome() {
		Util.waitForElement(driver, homeLink, 10);
		homeLink.click();
		Util.waitForAJAX(driver);
		return new MyRequests(driver);
	}

	public void selectEntityType() {
		Util.waitForAJAX(driver);
		Util.enableAllDropdowns(driver);
		Util.waitForElementPresent(
				driver,
				By.xpath(".//*[@id='rightContent']/div/div/div/div[1]/div[2]/div[1]/p/div/button"),
				20);
		element = null;
		entityTypeField.click();
		allOnEntityType.click();

		WebElement ele = driver
				.findElement(By
						.xpath(".//*[@id='rightContent']/div/div/div/div[1]/div[2]/div[1]/p/div/div/ul/li[3]/label/input"));
		ele.click();
		entityTypeField.click();
	}

	public void selectStatus() {
		Util.waitForAJAX(driver);
		Util.enableAllDropdowns(driver);
		Util.waitForElementPresent(
				driver,
				By.xpath(".//*[@id='rightContent']/div/div/div/div[1]/div[2]/div[2]/p/div/button"),
				20);
		element = null;
		statusField.click();
		allOnStatus.click();

		WebElement ele = driver
				.findElement(By
						.xpath(".//*[@id='rightContent']/div/div/div/div[1]/div[2]/div[2]/p/div/div/ul/li[11]/label/input"));
		ele.click();
		statusField.click();
	}

}
