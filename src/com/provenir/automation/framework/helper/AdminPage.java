package com.provenir.automation.framework.helper;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.provenir.automation.framework.utility.Util;

public class AdminPage {

	WebDriver driver;
	Actions actions = null;

	public AdminPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.ID, using = "PGADMIN")
	private WebElement adminLink;

	@FindBy(how = How.XPATH, using = "//span[contains(.,'Security Settings')]")
	private WebElement securitySettings;

	@FindBy(how = How.XPATH, using = ".//*[@id='roleSec']/div[2]/span/input")
	private WebElement role;

	@FindBy(how = How.XPATH, using = ".//*[@id='securityContainer']/div[2]/div[2]/span/input")
	private WebElement category;

	@FindBy(how = How.XPATH, using = "//span[contains(.,'Manage Workflows')]")
	private WebElement manageWorkflows;

	@FindBy(how = How.XPATH, using = "//a[contains(.,'Add')]")
	private WebElement addOnManageWorkflows;

	@FindBy(how = How.XPATH, using = ".//*[@id='content']/tbody/tr/td[3]/div/div[1]/div[1]/a[2]/span")
	private WebElement verifyWorkflowPage;

	@FindBy(how = How.XPATH, using = "//a[contains(@title,'Save')]")
	private WebElement saveWorkflow;

	@FindBy(how = How.ID, using = "nameError")
	private WebElement errMsgOnManageWorkflow;

	@FindBy(how = How.XPATH, using = "//a[contains(@title,'Add')]")
	private WebElement addBtnOnWorkflowPage;

	@FindBy(how = How.XPATH, using = "//a[contains(@title,'Remove')]")
	private WebElement deleteBtnOnWorkflowPage;

	@FindBy(how = How.ID, using = ".//*[@id='processGrid']/div[2]/div[5]/div/div/div[2]")
	private WebElement taskNameOnGrid;

	@FindBy(how = How.XPATH, using = ".//*[@id='content']/tbody/tr/td[3]/div/div/div[1]/h2")
	private WebElement workflowSummaryTitle;

	@FindBy(how = How.ID, using = ".//*[@id='processGrid']/div[2]/div[5]/div/div/div[3]")
	private WebElement taskCodeOnGrid;

	@FindBy(how = How.ID, using = ".//*[@id='processGrid']/div[2]/div[5]/div/div/div[5]")
	private WebElement roleAssignmentOnGrid;

	@FindBy(how = How.ID, using = ".//*[@id='processGrid']/div[2]/div[5]/div/div/div[5]/select[@id='roleListDD']")
	private WebElement roleAssignment;

	// @FindBy(how = How.XPATH, using =
	// ".//*[@id='processGrid']/div[2]/div[5]/div/div/div[2]/select[@id='taskListDD']")
	// private WebElement taskName;

	@FindBy(how = How.XPATH, using = ".//*[@id='taskListDD']")
	private WebElement taskName;

	@FindBy(how = How.XPATH, using = ".//*[@id='processGrid']/div[2]/div[5]/div/div/div[9]")
	private WebElement milestoneOnGrid;

	@FindBy(how = How.XPATH, using = ".//*[@id='processGrid']/div[2]/div[5]/div/div/div[9]/input")
	private WebElement milestone;

	@FindBy(how = How.XPATH, using = ".//*[@id='processGrid']/div[2]/div[5]/div/div/div[10]")
	private WebElement milestoneNameOnGrid;

	@FindBy(how = How.XPATH, using = ".//*[@id='processGrid']/div[2]/div[5]/div/div/div[10]/select")
	private WebElement milestoneName;

	@FindBy(how = How.XPATH, using = "//a[contains(@title,'Indent')]")
	private WebElement indent;

	@FindBy(how = How.XPATH, using = "//a[contains(@title,'Outdent')]")
	private WebElement outdent;

	@FindBy(how = How.XPATH, using = "//a[contains(@title,'Cancel')]")
	private WebElement cancelOnManageWorkflow;

	@FindBy(how = How.ID, using = "wfName")
	private WebElement creditWorkflow;

	@FindBy(how = How.ID, using = "wfName")
	private WebElement facilityWorkflow;

	@FindBy(how = How.ID, using = "srchWfName")
	private WebElement srchboxOnWorkflowSummary;

	@FindBy(how = How.ID, using = "imgSearchWorkflow")
	private WebElement srchIconOnWorkflowSummary;

	@FindBy(how = How.XPATH, using = ".//*[@id='myGrid']/div/div[5]/div/div/div[1]")
	private WebElement workflowName;

	@FindBy(how = How.XPATH, using = ".//*[@id='myGrid']/div/div[5]/div/div/div[2]")
	private WebElement savedWorkflowType;

//	@FindBy(how = How.XPATH, using = ".//*[@id='myGrid']/div/div[5]/div/div/div[4]/a")
//	private WebElement actionMenuOnSearchedWorkflow;
	
	@FindBy(how = How.XPATH, using = ".//*[@class='slickActionmenu_icon']")
	private WebElement actionMenuOnSearchedWorkflow;

	@FindBy(how = How.LINK_TEXT, using = "Set As Default")
	private WebElement setWorkflowAsDefault;

	@FindBy(how = How.LINK_TEXT, using = "Edit")
	private WebElement editWorkflow;

	@FindBy(how = How.XPATH, using = ".//*[@id='valdationMsg']/div/h2")
	private WebElement aftersaveConfirmation;

	@FindBy(how = How.XPATH, using = ".//*[@id='myGrid']/div[2]/div[2]/div/div[2]/span[2]")
	private WebElement selectWorkflowTypeInWorkflowSummary;

	@FindBy(how = How.ID, using = "backBC")
	private WebElement backBtnOnWorkflow;

	private String roleOnSecurity = ".//*[@id='roleSec']/div[2]/span/input";
	private String workflowType = "processTypeCd";

	public LoginPage clickAdminLink() {
		Util.waitForElement(driver, adminLink, 15);
		adminLink.click();
		Util.waitForAJAX(driver);
		return new LoginPage(driver);
	}

	public void clickManageWorkflows() {
		Util.waitForElement(driver, manageWorkflows, 10);
		manageWorkflows.click();
		Util.waitForLoaderToFinish(driver);
		Util.waitForAJAX(driver);
	}

	public void clickAddBtnOnWorkflowSummary() {
		Util.waitForElement(driver, addOnManageWorkflows, 10);
		addOnManageWorkflows.click();
		Util.waitForAJAX(driver);
	}

	public ManageWorkflow clickAddBtnOnWorkflowSumm() {
		Util.waitForElement(driver, addOnManageWorkflows, 10);
		addOnManageWorkflows.click();
		Util.waitForAJAX(driver);
		return new ManageWorkflow(driver);
	}

	public void clickSecuritySettings() {
		Util.waitForElement(driver, securitySettings, 10);
		securitySettings.click();
		Util.waitForAJAX(driver);
	}

	// public void selectRoleFromSecurity(String option) {
	// Util.waitForAJAX(driver);
	// Util.enableAllDropdowns(driver);
	// Util.waitForElementPresent(driver,
	// By.xpath(".//*[@id='roleSec']/div[2]/span/input"), 10);
	//
	// option = "Auto Engineer";
	// Util.selectOptionFromDropDown(driver, getRoles(), option);
	// Util.waitForAJAX(driver);
	// }

	public void selectCustomer360FromCategoryOnSecurity(String option) {
		Util.waitForAJAX(driver);
		Util.enableAllDropdowns(driver);
		Util.waitForElementPresent(
				driver,
				By.xpath(".//*[@id='securityContainer']/div[2]/div[2]/span/input"),
				10);
		option = "Customer360";
		Util.selectItemFromList(driver, category, option);
		Util.waitForAJAX(driver);
	}

	public String getRoles() {
		WebElement ele = driver.findElement(By.name("securityCd"));
		String s = ele.getAttribute("name");
		System.out.println("***********" + s);
		return s;
	}

	public void selectRoleFromSecurity(String option) {
		Util.waitForAJAX(driver);
		Util.enableAllDropdowns(driver);
		Util.waitForElementPresent(driver, By.xpath(".//*[@id='roles']"), 20);
		WebElement ele = driver.findElement(By.xpath(".//*[@id='roles']"));
		Select sel = new Select(ele);
		sel.selectByVisibleText("Auto Engineer");
		WebElement ele1 = driver.findElement(By
				.xpath("//strong[contains(.,'Auto Engineer')]"));
		ele1.click();
		Util.waitForAJAX(driver);
	}

	public void verifyWorkflowPageTitle() {
		Util.waitForAJAX(driver);
		Util.waitForElement(driver, verifyWorkflowPage, 10);
		String title = verifyWorkflowPage.getText().trim();
		Assert.assertEquals("Process Details", title);
	}

	public boolean verifyMandatoryDetailsOnManageWorkflow() {
		saveWorkflow.click();
		if (errMsgOnManageWorkflow.isDisplayed()) {
			return true;
		} else
			return false;
	}

	public void clickAddBtnOnManageWorkflow() {
		Util.waitForElement(driver, addBtnOnWorkflowPage, 10);
		addBtnOnWorkflowPage.click();
	}

	public void selectTaskName(String option) {
		Util.waitForAJAX(driver);
		Util.waitForElementPresent(driver, By
				.xpath(".//*[@id='processGrid']/div[2]/div[5]/div/div/div[2]"),
				15);
		// WebElement ele =
		// driver.findElement(By.xpath(".//*[@id='processGrid']/div[2]/div[5]/div/div/div[1]/input"));
		// ele.click();
		taskNameOnGrid.click();
		option = "Add Customer Address";
		Util.selectItemFromList(driver, taskName, option);
	}

	public void selectTaskName1(String option) {
		Util.waitForElement(driver, taskNameOnGrid, 10);
		taskNameOnGrid.click();
		option = "Annual Review Documents";
		Util.selectItemFromList(driver, taskName, option);
	}

	public void selectTaskName2(String option) {
		Util.waitForElement(driver, taskNameOnGrid, 10);
		taskNameOnGrid.click();
		option = "Compliance";
		Util.selectItemFromList(driver, taskName, option);
	}

	public void selectTaskName3(String option) {
		Util.waitForElement(driver, taskNameOnGrid, 10);
		taskNameOnGrid.click();
		option = "General Task";
		Util.selectItemFromList(driver, taskName, option);
	}

	public void selectTaskName4(String option) {
		Util.waitForElement(driver, taskNameOnGrid, 10);
		taskNameOnGrid.click();
		option = "ABCQueue";
		Util.selectItemFromList(driver, taskName, option);
	}

	public void enterTaskCode() {
		Util.waitForElement(driver, taskCodeOnGrid, 5);
		taskCodeOnGrid.click();
	}

	public void selectRoleAssignment(String option) {
		Util.waitForElement(driver, roleAssignmentOnGrid, 5);
		roleAssignmentOnGrid.click();
		option = "Automation Engineer";
		Util.selectItemFromList(driver, roleAssignment, option);
	}

	public void clickMilestone() {
		Util.waitForElement(driver, milestoneOnGrid, 5);
		milestoneOnGrid.click();
		milestone.click();
	}

	public void enterMilestoneAsOnboarded(String option) {
		Util.waitForElement(driver, milestoneName, 5);
		option = "Onboarded";
		Util.selectItemFromList(driver, milestoneName, option);
	}

	public void enterMilestoneAsComplianceComplete(String option) {
		Util.waitForElement(driver, milestoneName, 5);
		option = "Compliance Complete";
		Util.selectItemFromList(driver, milestoneName, option);
	}

	public void enterMilestoneAsUnderwritingComplete(String option) {
		Util.waitForElement(driver, milestoneName, 5);
		option = "Underwriting Complete";
		Util.selectItemFromList(driver, milestoneName, option);
	}

	public void enterMilestoneAsFinancialsReviewed(String option) {
		Util.waitForElement(driver, milestoneName, 5);
		option = "Financials Reviewed";
		Util.selectItemFromList(driver, milestoneName, option);
	}

	public void enterMilestoneAsPreliminaryAcceptance(String option) {
		Util.waitForElement(driver, milestoneName, 5);
		option = "Preliminary Acceptance";
		Util.selectItemFromList(driver, milestoneName, option);
	}

	public void enterMilestoneAsReadyForReview(String option) {
		Util.waitForElement(driver, milestoneName, 5);
		option = "Ready for Review";
		Util.selectItemFromList(driver, milestoneName, option);
	}

	public void enterMilestoneAsCompleted(String option) {
		Util.waitForElement(driver, milestoneName, 5);
		option = "Completed";
		Util.selectItemFromList(driver, milestoneName, option);
	}

	public void selectWorkflowTypeAsCredit(String option) {
		Util.waitForElementPresent(driver, By.xpath(workflowType), 10);
		option = "Credit";
		Util.selectItemFromList(driver, workflowType, option);
	}

	public void selectWorkflowTypeAsFacility(String option) {
		Util.waitForElementPresent(driver, By.xpath(workflowType), 10);
		option = "Facility";
		Util.selectItemFromList(driver, workflowType, option);
	}

	public boolean verifyWorkflowTypeAsCredit(String option) {
		selectWorkflowTypeAsCredit(option);
		String s = driver
				.findElement(
						By.xpath(".//*[@id='processGrid']/div[1]/div[2]/span/input"))
				.getText().trim();
		if (s.contains(option)) {
			return true;
		} else
			return false;
	}

	public boolean verifyWorkflowTypeAsFacility(String option) {
		selectWorkflowTypeAsCredit(option);
		String s = driver
				.findElement(
						By.xpath(".//*[@id='processGrid']/div[1]/div[2]/span/input"))
				.getText().trim();
		if (s.contains(option)) {
			return true;
		} else
			return false;
	}

	public void clickOnSearchIconOnWorkflowSummary() {
		Util.waitForElement(driver, srchIconOnWorkflowSummary, 5);
		srchIconOnWorkflowSummary.click();
		Util.waitForAJAX(driver);
	}

	public void enterCreditWorkflowNameToSearch() {
		Util.waitForElement(driver, srchboxOnWorkflowSummary, 15);
		srchboxOnWorkflowSummary.clear();
		srchboxOnWorkflowSummary.sendKeys("Credit level workflow");
	}

	public void enterFacilityWorkflowNameToSearch() {
		Util.waitForElement(driver, srchboxOnWorkflowSummary, 15);
		srchboxOnWorkflowSummary.clear();
		srchboxOnWorkflowSummary.sendKeys("Facility level workflow");
	}

	public boolean verifySavedWorkflowAsCredit() {
		Util.waitForAJAX(driver);
		Util.waitForElement(driver, workflowName, 10);
		String s1 = workflowName.getText().trim();
		String s2 = savedWorkflowType.getText().trim();
		if (s1.equalsIgnoreCase("Credit level workflow")
				&& s2.equalsIgnoreCase("Credit")) {
			return true;
		} else
			return false;
	}

	public boolean verifySavedWorkflowAsFacility() {
		Util.waitForAJAX(driver);
		Util.waitForElement(driver, workflowName, 10);
		String s1 = workflowName.getText().trim();
		String s2 = savedWorkflowType.getText().trim();
		if (s1.equalsIgnoreCase("Facility level workflow")
				&& s2.equalsIgnoreCase("Facility")) {
			return true;
		} else
			return false;
	}

	public boolean verifyActionMenuPresentOnWorkflow() {
		if (actionMenuOnSearchedWorkflow.isDisplayed()) {
			return true;
		} else
			return false;
	}

	public void setWorkflowAsDefault() {
		Util.waitForAJAX(driver);
		Util.waitForElement(driver, actionMenuOnSearchedWorkflow, 10);
		actions.moveToElement(actionMenuOnSearchedWorkflow).click().build()
				.perform();
		Util.waitForElement(driver, setWorkflowAsDefault, 10);
		setWorkflowAsDefault.click();
		Util.waitForAJAX(driver);
	}

	public void editWorkflow() {
		Util.waitForAJAX(driver);
		Util.waitForElement(driver, actionMenuOnSearchedWorkflow, 10);
		actions.moveToElement(actionMenuOnSearchedWorkflow).click().build().perform();
		Util.waitForElement(driver, editWorkflow, 10);
		editWorkflow.click();
		Util.waitForAJAX(driver);
	}

	public boolean verifyWorkflowSummaryTitle() {
		Util.waitForAJAX(driver);
		Util.waitForElement(driver, workflowSummaryTitle, 10);
		if (workflowSummaryTitle.isDisplayed()) {
			workflowSummaryTitle.click();
			return true;
		} else
			return false;
	}

	public void enterCreditWorkflow() {
		Util.waitForElement(driver, creditWorkflow, 10);
		creditWorkflow.clear();
		creditWorkflow.sendKeys("Credit level workflow");
	}

	public void enterFacilityWorkflow() {
		Util.waitForElement(driver, facilityWorkflow, 10);
		facilityWorkflow.clear();
		facilityWorkflow.sendKeys("Facility level workflow");
	}

	public void clickSaveBtnOnWorkflowPage() {
		Util.waitForElement(driver, saveWorkflow, 15);
		saveWorkflow.click();
		Util.waitForAJAX(driver);
	}

	public boolean verifyWorkflowIsSavedOrNot() {
		Util.waitForElement(driver, aftersaveConfirmation, 5);
		if (aftersaveConfirmation.isDisplayed()) {
			return true;
		} else
			return false;
	}

	public boolean selectAndVerifyWorkflowTypeAsCredit() {
		Util.waitForAJAX(driver);
		Util.waitForElementPresent(
				driver,
				By.xpath(".//*[@id='myGrid']/div[2]/div[2]/div/div[2]/span[2]"),
				10);
		// selectWorkflowTypeInWorkflowSummary.click();
		selectWorkflowTypeInWorkflowSummary.click();
		Util.waitForAJAX(driver);
		if (driver
				.findElement(
						By.xpath(".//*[@id='myGrid']/div[2]/div[5]/div/div[1]/div[2]"))
				.getText().trim().contains("Credit")) {
			return true;
		} else
			return false;
	}

	public boolean selectAndVerifyWorkflowTypeAsFacility() {
		Util.waitForAJAX(driver);
		Util.waitForElementPresent(
				driver,
				By.xpath(".//*[@id='myGrid']/div[2]/div[2]/div/div[2]/span[2]"),
				10);
		selectWorkflowTypeInWorkflowSummary.click();
		Util.waitForAJAX(driver);
		if (driver
				.findElement(
						By.xpath(".//*[@id='myGrid']/div[2]/div[5]/div/div[1]/div[2]"))
				.getText().trim().contains("Facility")) {
			return true;
		} else
			return false;
	}

	public void clickBackBtnOnWorkflow() {
		Util.waitForElement(driver, backBtnOnWorkflow, 10);
		backBtnOnWorkflow.click();
		Util.waitForLoaderToFinish(driver);
	}

	public boolean verifyAsterixOnSavedWorkflow() {
		Util.waitForAJAX(driver);
		Util.waitForElement(driver, workflowName, 10);
		String s1 = workflowName.getText().trim();
		if (s1.contains("*")) {
			return true;
		} else
			return false;
	}

	public void clickWorkflowName() {
		Util.waitForAJAX(driver);
		workflowSummaryTitle.click();
	}

}
