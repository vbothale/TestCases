package com.provenir.automation.framework.helper;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.provenir.automation.framework.utility.Util;

public class UserTeamInfoPage {
	
	WebDriver driver;

	// Constructor
	public UserTeamInfoPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.XPATH, using = "//ul[@id='breadCrumbMainNav_new']/li[@id='usrTmInfo']")
	private WebElement userTeamInfoTitle;

	@FindBy(how = How.XPATH, using = "//form[@id='UPSERTCREDITTEAMFORM']/div[@class='main_content_div']/div[3]/div[1]/a[@id='addNewCredTeam']")
	private WebElement addNewCreditTeam;

	@FindBy(how = How.XPATH, using = "//div[@id='creditTeamDetails']/div/table/tbody/tr")
	private List<WebElement> lstOfRoles;

	@FindBy(how = How.XPATH, using = "//form[@id='UPSERTCREDITTEAMFORM']/div[@class='main_content_div']/div[3]/div[2]/a[@id='backBtn']")
	private WebElement backBtn;

	@FindBy(how = How.XPATH, using = "//form[@id='UPSERTCREDITTEAMFORM']/div[@class='main_content_div']/div[3]/div[2]/a[@id='finishDataEntry']")
	private WebElement finishBtn;

	@FindBy(how = How.XPATH, using = ".//*[@id='teamMbrError']")
	private WebElement teamMbrErrorMsg;

	@FindBy(how = How.XPATH, using = "//form[@id='UPSERTCREDITTEAMFORM']/div[@class='main_content_div']/div[3]/div[1]/a[@id='savecreddetails']")
	private WebElement saveBtn;

	@FindBy(how = How.CSS, using = "generalData100per nobrd>h4>span>a")
	public WebElement requestNumberLink;

	@FindBy(how = How.CSS, using = "//div[@class='sub_content_div']/div[2]/div[@id='presales']/ul[@class=padL10']/li/a[@id='mydashBoard']")
	public WebElement myDashobard;

	@FindBy(how = How.XPATH, using = "//*[@id='removeNewCredTeam']/span/span")
	public WebElement deleteBtn;

	private String role = "roleCd";
	private String newMemberNameTextBox = "//div[@id='creditTeamDetails']/div/table/tbody/tr";
	private String wizardCompletePopup = ".//*[@id='presales']/ul/li";

	// Service Methods
	public String getUserTeamInfoTitle() {
		Util.waitForAJAX(driver);
		return userTeamInfoTitle.getText();
	}

	public UserTeamInfoPage clickAddNewButton() {
		addNewCreditTeam.click();
		Util.waitForAJAX(driver);
		return this;
	}

	public UserTeamInfoPage clickFinishButton() {
		Util.waitForElement(driver,finishBtn, 20);
		finishBtn.click();
		Util.waitForAJAX(driver);
		return this;
	}

	public int cntOfRoles() {

		return lstOfRoles.size();
	}

	public void selectRole(String roleValue) {
		role = role + (cntOfRoles() - 1);

		WebElement element = driver.findElement(By.xpath("//select[@name='"
				+ role + "']"));
		Util.selectItemFromList(driver,element, roleValue);
	}

	public void enterTeamMemberName(String memberName) {

		driver.findElement(
				By.xpath(newMemberNameTextBox + "[" + cntOfRoles() + "]"
						+ "/td[2]/span/input")).sendKeys(memberName);

		Util.waitForAJAX(driver);
		if (driver.findElement(By.xpath(newMemberNameTextBox + "["
				+ cntOfRoles() + "]" + "/td[2]/span/div[1]/div[1]/ul/li")) != null) {
			WebElement l1 = driver.findElement(By.xpath(newMemberNameTextBox
					+ "[" + cntOfRoles() + "]"
					+ "/td[2]/span/div[1]/div[1]/ul/li"));

			l1.click();
		}
	}

	public boolean verifyTeamMemberName(String teamMemberName) {
		String addedTeamMemeberName = driver
				.findElement(
						By.xpath(newMemberNameTextBox + "[" + cntOfRoles()
								+ "]/td[2]")).getText();

		if (addedTeamMemeberName.contains(teamMemberName)) {
			return true;
		}

		return false;
	}

	public UserTeamInfoPage clickSaveButton() {
		saveBtn.click();
		Util.waitForAJAX(driver);
		return this;
	}

	public boolean isAddedRolePresent(String role) {
		Util.waitForAJAX(driver);
		List<WebElement> lstMembers = driver.findElements(By
				.xpath(newMemberNameTextBox));
		for (int i = 1; i <= lstMembers.size(); i++) {
			if (driver
					.findElement(
							By.xpath(newMemberNameTextBox
									+ "['"
									+ i
									+ "']/td[1]/select/option[@selected='selected']"))
					.getText().contains(role)) {
				return true;
			}
		}
		return false;
	}

	public boolean isAddedTeamMemberPresent(String memberName) {
		Util.waitForAJAX(driver);
		return false;
	}

	public TransactionInfoPage clickBackButton() {
		backBtn.click();
		Util.waitForAJAX(driver);
		return new TransactionInfoPage(driver);
	}

	public boolean verifyLinks() {
		Util.waitForElementPresent(driver,By.xpath(wizardCompletePopup), 10);
		List<WebElement> elementList = driver.findElements(By
				.xpath(wizardCompletePopup));

		List<String> lstLinks = new ArrayList<String>();

		for (int i = 1; i <= elementList.size(); i++) {
			lstLinks.add(driver.findElement(
					By.xpath(wizardCompletePopup + "[" + i + "]/a")).getText());
		}

		for (String linkText : lstLinks) {
			if (linkText.contains("My Tasks")
					|| linkText.contains("New Credit Request")
					|| linkText.contains("My Dashboard")) {
				return true;
			}
		}
		return false;
	}

	public MyRequests clickMyDashboardLink() {
		Util.waitForAJAX(driver);
		Util.waitForElementPresent(driver,By.xpath(wizardCompletePopup), 10);
		List<WebElement> elementList = driver.findElements(By
				.xpath(wizardCompletePopup));
		WebElement element = null;
		for (int i = 1; i <= elementList.size(); i++) {
			element = driver.findElement(By.xpath(wizardCompletePopup + "[" + i
					+ "]/a"));
			Util.waitForElement(driver,element, 5);
			if (element.getText().contains("My Dashboard")) {
				element.click();
			}
		}
		Util.waitForAJAX(driver);
		return new MyRequests(driver);
	}

	public Customer360Details clickCustomerLink(String custName) {
		Util.waitForAJAX(driver);
		Util.waitForElementPresent(driver,By.xpath(wizardCompletePopup), 20);
		List<WebElement> elementList = driver.findElements(By
				.xpath(wizardCompletePopup));
		WebElement element = null;
		for (int i = 1; i <= elementList.size(); i++) {
			element = driver.findElement(By.xpath(wizardCompletePopup + "[" + i
					+ "]/a"));
			Util.waitForElement(driver,element, 20);
			if (element.getText().contains(custName)) {
				element.click();
			}
		}
		Util.waitForAJAX(driver);
		return new Customer360Details(driver);
	}

	public boolean isTeamMbrErrorMsg() {
		Util.waitForElement(driver,teamMbrErrorMsg, 5);
		if (teamMbrErrorMsg.getText().contains(
				"This Role is already present.Please select different Role")) {

			return true;
		} else {
			return false;
		}
	}

	public boolean isTeamMbrErrorMsg2() {
		Util.waitForElement(driver,teamMbrErrorMsg, 5);
		if (teamMbrErrorMsg.getText().contains(
				"Both the team members should not be same in row no.")) {
			return true;
		} else {
			return false;
		}
	}

}
