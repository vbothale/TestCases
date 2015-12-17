package com.provenir.automation.framework.helper;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.provenir.automation.framework.utility.Util;

public class ManageWorkflow {
	
	WebDriver driver;
	Actions actions = null;

	public ManageWorkflow(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
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

	@FindBy(how = How.XPATH, using = ".//*[@id='myGrid']/div/div[5]/div/div/div[4]/a")
	private WebElement actionMenuOnSearchedWorkflow;

	@FindBy(how = How.LINK_TEXT, using = "Set As Default")
	private WebElement setWorkflowAsDefault;

	@FindBy(how = How.XPATH, using = ".//*[@id='valdationMsg']/div/h2")
	private WebElement aftersaveConfirmation;

	@FindBy(how = How.XPATH, using = ".//*[@id='myGrid']/div[2]/div[2]/div/div[2]/span[2]")
	private WebElement selectWorkflowTypeInWorkflowSummary;
	
	@FindBy(how = How.XPATH, using = "//a[contains(@title,'Add')]")
	private WebElement addBtnOnWorkflowPage;
	
	@FindBy(how = How.XPATH, using = "//a[contains(@title,'Save')]")
	private WebElement saveWorkflow;
	
	@FindBy(how = How.ID, using = ".//*[@id='processGrid']/div[2]/div[5]/div/div/div[2]")
	private WebElement taskNameOnGrid;
	
	@FindBy(how = How.XPATH, using = ".//*[@id='processGrid']/div[2]/div[5]/div/div/div[2]/select[@id='taskListDD']")
	private WebElement taskName;
	
	private String workflowType = "processTypeCd";
	
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
	
	public void selectWorkflowTypeAsFacility(String option) {
		Util.waitForElementPresent(driver, By.xpath(workflowType), 10);
		option = "Facility";
		Util.selectItemFromList(driver, workflowType, option);
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
		taskNameOnGrid.click();
		option = "Add Customer Address";
		Util.selectItemFromList(driver, taskName, option);
	}

}
