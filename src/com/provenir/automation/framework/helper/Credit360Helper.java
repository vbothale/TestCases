package com.provenir.automation.framework.helper;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.provenir.automation.framework.utility.Util;
import com.sun.jna.platform.win32.WinNT.WELL_KNOWN_SID_TYPE;

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

	@FindBy(how = How.ID, using = "home")
	private WebElement homeLink;

	// @FindBy(how = How.XPATH, using =
	// ".//*[@id='credCreditLine']/div/div/table/tbody/tr[1]/td[6]/a")
	// private WebElement actionMenuOnFacilitySummary;

	@FindBy(how = How.XPATH, using = ".//*[@class='scroll tableGrid']/tbody/tr[2]/td[6]/a")
	private WebElement actionMenuOnFacilitySummary;

	@FindBy(how = How.XPATH, using = ".//*[@id='rightContent']/div[2]/div/div[1]/h2")
	private WebElement creditDetailsTxt;

	@FindBy(how = How.XPATH, using = ".//*[@id='credSumm']")
	private WebElement creditSummary;

	@FindBy(how = How.ID, using = "taskMangmntr")
	private WebElement taskMgmt;

	@FindBy(how = How.XPATH, using = ".//*[@id='credLineSumm']")
	private WebElement facSumLink;

	@FindBy(how = How.XPATH, using = ".//*[@id='DEWORKFLOWDEFFORM']/div/div/ul/li[30]/a/span")
	private WebElement actionList;

	@FindBy(how = How.XPATH, using = ".//*[@id='addCrdLine']")
	private WebElement addBtn;

	@FindBy(how = How.LINK_TEXT, using = "Details")
	private WebElement detailsLnk;

	@FindBy(how = How.LINK_TEXT, using = "Delete")
	private WebElement delete;

	@FindBy(how = How.XPATH, using = ".//*[@id='taskManagmntContainer']//b[contains(.,'Test_facility')]")
	private WebElement verifyWFlow;

	@FindBy(how = How.XPATH, using = ".//*[@id='taskManagmntContainer']/div[1]/a")
	private WebElement expandIconOnTM;

	@FindBy(how = How.XPATH, using = ".//*[@id='taskManagmntContainer']/div[2]/div/div/div[3]/div/div/div[2]/div/div[4]/span")
	private WebElement taskDescOnTM;

	private String creditWorkflowText = ".//*[@id='taskManagmntContainer']/div[1]/div/span/b";
	private String creditTextOnWorkflow = ".//*[@id='taskManagmntContainer']/div[1]/div/a/span";
	private String facilityWorkflowText = ".//*[@id='taskManagmntContainer']/div[3]/div/span/b";
	private String facilityTextOnWorkflow = ".//*[@id='taskManagmntContainer']/div[3]/div/a/span";

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
		Util.waitForLoaderToFinish(driver);
		Util.waitForAJAX(driver);
		Util.waitForElement(driver, actionColumnOnCredit360, 10);
		if (actionColumnOnCredit360.isDisplayed()) {
			Util.waitForAJAX(driver);
			return true;
		} else
			return false;
	}

	public boolean clickActionColumnAndVerifyAddedWorkflow() {
		Util.waitForElement(driver, actionColumnOnCredit360, 15);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", actionColumnOnCredit360);
		
		Util.waitForElement(driver, actionList, 15);
		String str = actionList.getText();
		if (str.equalsIgnoreCase("Credit level workflow")) {
			Util.waitForLoaderToFinish(driver);
			return true;
		} else
			return false;
	}

	public void clickActionMenu() {
		Util.waitForElement(driver, actionColumnOnCredit360, 15);
		actionColumnOnCredit360.click();
	}

	public void clickTaskManagement() {
		Util.waitForAJAX(driver);
		Util.scrollBottom(driver);
		Util.waitForElementPresent(driver, By.id("taskMangmnt"), 30);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", taskMgmt);
		Util.waitForLoaderToFinish(driver);
		Util.waitForLoaderToFinish(driver);
		Util.waitForAJAX(driver);
	}

	public void clickFacilitySummary() {
		Util.waitForAJAX(driver);
		Util.waitForElement(driver, facSumLink, 20);
		facSumLink.click();
	}

	public boolean verifyFacilitySummary() {
		Util.waitForAJAX(driver);
		if (driver.findElement(
				By.xpath(".//*[@id='credCreditLine']/div/div/table/tbody/tr"))
				.isDisplayed()) {
			return true;
		} else {
			return false;
		}
	}

	public void clickAddBtnFacilitySummary() {
		Util.waitForElement(driver, addBtn, 20);
		addBtn.click();
		Util.waitForAJAX(driver);
	}

	public void clickDetailsOnFacilityGrid() {
		Util.waitForAJAX(driver);
		actions.moveToElement(actionMenuOnFacilitySummary).click().perform();
		Util.waitForElement(driver, detailsLnk, 20);
		detailsLnk.click();
		Util.waitForAJAX(driver);
	}

	public Facility360Details clickDetailsOnFacilityGrid1() {
		Util.waitForAJAX(driver);
		actions.moveToElement(actionMenuOnFacilitySummary).click().build()
				.perform();
		Util.waitForElement(driver, detailsLnk, 20);
		detailsLnk.click();
		Util.waitForAJAX(driver);
		return new Facility360Details(driver);
	}

	public boolean verifyCredit360Loaded() {
		Util.waitForElement(driver, creditDetailsTxt, 10);
		if (creditDetailsTxt.isDisplayed()) {
			return true;
		} else
			return false;
	}

	public MyRequests clickHome() {
		Util.waitForLoaderToFinish(driver);
		Util.waitForElement(driver, homeLink, 10);
		homeLink.click();
		Util.waitForAJAX(driver);
		return new MyRequests(driver);
	}

	public boolean verifyWorkflowOrderOnCredit360() {
		if (creditWorkflowText.equalsIgnoreCase("New Request for Money")
				&& creditTextOnWorkflow
						.equalsIgnoreCase("Request HCL Corporation")
				&& facilityWorkflowText
						.equalsIgnoreCase("Facility_New Request for Money")
				&& facilityTextOnWorkflow
						.equalsIgnoreCase("Fac for HCL Corporation")) {
			return true;
		} else
			return false;
	}

	public void clickDeleteOnFacilityDetails() {
		Util.waitForElementPresent(driver, By.xpath(""), 20);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", actionMenuOnFacilitySummary);
		Util.waitForElement(driver, delete, 5);
//		actions.moveToElement(actionMenuOnFacilitySummary).click().perform();
		js.executeScript("arguments[0].click();", delete);

		Util.waitForAJAX(driver);
	}

	public boolean verifyWorkflowDeletedOrNot() {
		Util.waitForLoaderToFinish(driver);
		Util.waitForElement(driver, verifyWFlow, 20);
		String str = verifyWFlow.getText().trim();
		if (str.equalsIgnoreCase("Test_facility")) {
			return true;
		} else
			return false;
	}

	public void clickExpandIconOnTM() {
		Util.waitForAJAX(driver);
		Util.waitForElement(driver, expandIconOnTM, 20);
		expandIconOnTM.click();
		Util.waitForLoaderToFinish(driver);
	}

	public boolean verifyTaskDisplayedOrNot() {
		Util.waitForAJAX(driver);
		String s1 = taskDescOnTM.getText().trim();
		if (s1.equalsIgnoreCase("Task Description")) {
			return true;
		} else
			return false;
	}
	
	// to check element is not present in the page

		public boolean isBookingSummaryDisplayed() {
			List<WebElement> lst = driver.findElements(By
					.xpath("//a[@title='Booking Summary']"));
			if (lst.isEmpty()) {
				System.out.println("element does not exist");
				return true;
			} else
				return false;
		}

}
