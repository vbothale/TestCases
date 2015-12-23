package com.provenir.automation.framework.helper;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.provenir.automation.framework.utility.Util;

public class MyTasks {

	WebDriver driver;
	Actions actions = null;

	public MyTasks(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		actions = new Actions(driver);
	}

	@FindBy(how = How.XPATH, using = "//label[contains(.,'My Tasks Queue')]")
	private WebElement myTaskTitle;

	@FindBy(how = How.XPATH, using = "//label[contains(.,'Entity Type:')]")
	private WebElement entityTypeTitle;

	@FindBy(how = How.XPATH, using = "//label[contains(.,'Status:')]")
	private WebElement statusTitle;

	@FindBy(how = How.XPATH, using = "//label[contains(.,'Role:')]")
	private WebElement roleTitle;

	@FindBy(how = How.XPATH, using = "//label[contains(.,'Group:')]")
	private WebElement groupTitle;

	@FindBy(how = How.XPATH, using = "//label[contains(.,'Category:')]")
	private WebElement categoryTitle;

	@FindBy(how = How.XPATH, using = "//label[contains(.,'From Date:')]")
	private WebElement fromDateTitle;

	@FindBy(how = How.XPATH, using = "//label[contains(.,'To Date:')]")
	private WebElement toDateTitle;

	@FindBy(how = How.ID, using = "filterMyTask")
	private WebElement filterBtn;

	@FindBy(how = How.XPATH, using = "//button[contains(.,'All Selected')]")
	private WebElement defaultValue;

	@FindBy(how = How.XPATH, using = ".//*[@id='myTaskGrid']/div[2]/div[1]/div[2]/div[1]/p/div/button")
	private WebElement entityTypeField;

	@FindBy(how = How.XPATH, using = ".//*[@name='selectAllentity']")
	private WebElement allOnEntityType;

	@FindBy(how = How.XPATH, using = ".//*[@id='myTaskGrid']/div[2]/div[1]/div[2]/div[2]/p/div/button")
	private WebElement statusField;

	@FindBy(how = How.XPATH, using = ".//*[@name='selectAllstatus']")
	private WebElement allOnStatus;

	@FindBy(how = How.ID, using = "home")
	private WebElement homeLink;

	@FindBy(how = How.XPATH, using = ".//*[@class='slick-sort-indicator slick-sort-indicator-asc']")
	private WebElement dueOn;

	private WebElement element = null;

	public boolean verifyMyTaskPage() {
		Util.waitForAJAX(driver);
		Util.waitForElement(driver, myTaskTitle, 10);
		if (myTaskTitle.isDisplayed())
			return true;
		else
			return false;
	}

	public boolean verifyFiltersOnMyTasks() {
		String s1 = entityTypeTitle.getText().trim();
		String s2 = statusTitle.getText().trim();
		String s3 = roleTitle.getText().trim();
		String s4 = groupTitle.getText().trim();
		String s5 = categoryTitle.getText().trim();
		String s6 = fromDateTitle.getText().trim();
		String s7 = toDateTitle.getText().trim();
		if (s1.equalsIgnoreCase("Entity Type:")
				&& s2.equalsIgnoreCase("Status:")
				&& s3.equalsIgnoreCase("Role:")
				&& s4.equalsIgnoreCase("Group:")
				&& s5.equalsIgnoreCase("Category:")
				&& s6.equalsIgnoreCase("From Date:")
				&& s7.equalsIgnoreCase("To Date:")) {
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

	public void selectEntityType() {
		Util.enableAllDropdowns(driver);
		Util.waitForElementPresent(
				driver,
				By.xpath(".//*[@id='myTaskGrid']/div[2]/div[1]/div[2]/div[1]/p/div/button"),
				20);
		element = null;
		entityTypeField.click();
		allOnEntityType.click();

		WebElement ele = driver
				.findElement(By
						.xpath(".//*[@id='myTaskGrid']/div[2]/div[1]/div[2]/div[1]/p/div/div/ul/li[3]/label/input"));
		ele.click();
		entityTypeField.click();
	}

	public void selectStatus() {
		Util.enableAllDropdowns(driver);
		Util.waitForElementPresent(
				driver,
				By.xpath(".//*[@id='myTaskGrid']/div[2]/div[1]/div[2]/div[2]/p/div/button"),
				20);
		element = null;
		statusField.click();
		allOnStatus.click();

		WebElement ele = driver
				.findElement(By
						.xpath(".//*[@id='myTaskGrid']/div[2]/div[1]/div[2]/div[2]/p/div/div/ul/li[4]/label"));
		ele.click();
		statusField.click();
	}

	public void clickFilterBTn() {
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

	public void clickDueOnIndicator() {
		Util.waitForElementPresent(
				driver,
				By.xpath(".//*[@class='slick-sort-indicator slick-sort-indicator-asc']"),
				20);
		dueOn.click();
		Util.waitForLoaderToFinish(driver);
		Util.waitForAJAX(driver);
	}

}
