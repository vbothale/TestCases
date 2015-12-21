package com.provenir.automation.framework.helper;

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

}
