package com.provenir.automation.framework.helper;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.provenir.automation.framework.utility.Util;

public class Credit360Helper {

	WebDriver driver;
	Actions actions = null;

	public Credit360Helper(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.ID, using = "credBorr")
	private WebElement creditBorrowerLink;

	@FindBy(how = How.XPATH, using = ".//*[@id='credBorrowers']/a")
	private WebElement addBtnOfCreditBorrower;

	@FindBy(how = How.XPATH, using = ".//*[@id='SEARCHCUSTFORM']/input[5]")
	private WebElement srchBorrower;

	@FindBy(how = How.ID, using = "imgBtn")
	private WebElement imgBtn;

	@FindBy(how = How.ID, using = "selCustomer")
	private WebElement selectedCustomer;

	@FindBy(how = How.XPATH, using = "//span[contains(.,'Select')]")
	private WebElement selectBtnOnCreditBorrower;

	@FindBy(how = How.XPATH, using = "//span[contains(.,'Save')]")
	private WebElement saveBtnOnCreditBorrower;

	@FindBy(how = How.XPATH, using = "//a[contains(.,'Action')]")
	private WebElement actionColumnOnCredit360;

	@FindBy(how = How.ID, using = "taskMangmnt")
	private WebElement taskMgmt;
	
	@FindBy(how = How.XPATH, using = ".//*[@id='credLineSumm']")
	private WebElement facSumLink;

	@FindBy(how = How.XPATH, using = ".//*[@id='DEWORKFLOWDEFFORM']/div/div/ul/li[30]/a/span")
	private WebElement actionList;

	public void clickCreditBorrowerAndAdd() {
		Util.waitForAJAX(driver);
		Util.scrollDown(driver);
		Util.waitForElement(driver, creditBorrowerLink, 10);
		creditBorrowerLink.click();
		Util.waitForLoaderToFinish(driver);

	}

	public void clickAddBtnOnCreditBorrower() {
		Util.waitForElement(driver, addBtnOfCreditBorrower, 10);
		addBtnOfCreditBorrower.click();
		Util.waitForLoaderToFinish(driver);
	}

	public void saveBorrower() {
		Util.waitForAJAX(driver);
		Util.waitForElement(driver, srchBorrower, 10);
		srchBorrower.sendKeys("intex");
		imgBtn.click();
		Util.waitForLoaderToFinish(driver);
		Util.waitForAJAX(driver);
		Util.waitForElement(driver, selectedCustomer, 15);
		selectedCustomer.click();
		selectBtnOnCreditBorrower.click();
		Util.waitForLoaderToFinish(driver);
		Util.waitForElement(driver, saveBtnOnCreditBorrower, 15);
		saveBtnOnCreditBorrower.click();
		Util.waitForLoaderToFinish(driver);
		Util.waitForAJAX(driver);
	}

	public boolean verifyActionColumn() {
		Util.waitForAJAX(driver);
		Util.waitForElement(driver, actionColumnOnCredit360, 10);
		if (actionColumnOnCredit360.isDisplayed()) {
			return true;
		} else
			return false;
	}

	public boolean clickActionColumnAndVerifyAddedWorkflow() {
		Util.waitForElement(driver, actionColumnOnCredit360, 15);
		actionColumnOnCredit360.click();
		actions.moveToElement(actionColumnOnCredit360).click().build()
				.perform();
		Util.waitForElement(driver, actionList, 15);
		String str = actionList.getText();
		if (str.equalsIgnoreCase("Credit level workflow")) {
			return true;
		} else
			return false;
	}

	public void clickTaskManagement() {
		Util.waitForAJAX(driver);
		Util.waitForElement(driver, taskMgmt, 20);
		taskMgmt.click();
		Util.waitForLoaderToFinish(driver);
		Util.waitForAJAX(driver);
	}
	
	public void clickFacilitySummary() {
		Util.waitForAJAX(driver);
		Util.waitForElement(driver,facSumLink, 20);
		facSumLink.click();
	}

}
