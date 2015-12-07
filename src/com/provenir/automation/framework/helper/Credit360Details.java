package com.provenir.automation.framework.helper;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.provenir.automation.framework.utility.Util;

public class Credit360Details {

	WebDriver driver;
	Actions actions = null;

	public Credit360Details(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how = How.XPATH, using = ".//*[@name='creditNm']")
	private WebElement creditName;

	@FindBy(how = How.XPATH, using = ".//*[@id='savecreddetails']")
	private WebElement saveCrdDetails;

	@FindBy(how = How.XPATH, using = ".//*[@id='creditAppliDt']")
	private WebElement creditApplicationDate;

	@FindBy(how = How.XPATH, using = ".//*[@id='creditAgreeDt']")
	private WebElement creditAgreeDate;

	@FindBy(how = How.XPATH, using = ".//*[@id='creditProjClsDt']")
	private WebElement creditProjectedClosingDt;

	@FindBy(how = How.XPATH, using = ".//*[@name='credAmtPropAmt']")
	private WebElement crdProposedAmt;

	@FindBy(how = How.XPATH, using = ".//*[@id='creditNm']")
	private WebElement creditNameValue;

	@FindBy(how = How.XPATH, using = ".//*[@name='credAmtCurrProjClsAmot']")
	private WebElement crdCurrProjClsAmt;

	@FindBy(how = How.XPATH, using = ".//*[@name='credAmtClsAmt']")
	private WebElement crdClosesAmt;

	@FindBy(how = How.XPATH, using = ".//*[@name='bankShrPropAmt']")
	private WebElement bnkShareProposedAmt;

	@FindBy(how = How.XPATH, using = ".//*[@name='bankShrCurrProjClsAmot']")
	private WebElement bnkShareCurrProjClsAmt;

	@FindBy(how = How.XPATH, using = ".//*[@name='bankShrClsAmt']")
	private WebElement bnkShareClosesAmt;

	@FindBy(how = How.XPATH, using = ".//*[@id='UPSERTCUSTCREDREQFORM']/div[@class='sub_content_div']/div[contains(@class,'button')]/a")
	private WebElement editCrdDetails;

	@FindBy(how = How.XPATH, using = ".//*[@id='UPSERTCUSTCREDREQFORM']/div[@class='sub_content_div']/div[contains(@class,'button')]/a[1]")
	private WebElement cancelCrdDetails;

	@FindBy(how = How.XPATH, using = ".//*[@id='backBC']")
	private WebElement backBreadCrumBtn;

	@FindBy(how = How.XPATH, using = ".//*[@class='breadcrumbText']")
	private WebElement breadCrumText;

	@FindBy(how = How.XPATH, using = ".//*[@id='rightContent']/div[2]/div/div[1]/h2")
	private WebElement creditDetailsTxt;

	@FindBy(how = How.XPATH, using = ".//*[@id='UPSERTCUSTCREDREQFORM']/div/div[1]/div[2]/label[2]")
	private WebElement creditNo;

	@FindBy(how = How.XPATH, using = "//*[text()='*']")
	private List<WebElement> asterisk;

	@FindBy(how = How.XPATH, using = ".//*[@class='error']")
	private WebElement errorMsgText;

	@FindBy(how = How.XPATH, using = ".//*[@id='data_content']/div/table/tbody/tr[1]/td[3]")
	private WebElement clickReqOnDashboard;

	@FindBy(how = How.XPATH, using = ".//*[@id='credCollPool']")
	private WebElement clickCollateralPool;

	@FindBy(how = How.XPATH, using = ".//*[@name='addCollPool']")
	private WebElement addCollateralPool;

	@FindBy(how = How.XPATH, using = ".//*[@id='credCollateralPool']/div[@class='data_content']/div/table/tbody/tr/td[5]/a")
	private WebElement actionMenuCollateralPool;

	@FindBy(how = How.LINK_TEXT, using = "Details")
	private WebElement detailsLnk;

	@FindBy(how = How.XPATH, using = ".//*[@id='container']/div[8]/div/div/div/ul/li[1]/a")
	private WebElement detailsLink;

	@FindBy(how = How.XPATH, using = ".//*[@id='credTeam']")
	private WebElement clickCreditTeam;

	@FindBy(how = How.XPATH, using = ".//*[@id='CrdTeamDetails']/form/div[2]/table/tbody/tr[1]/td[8]/a")
	private WebElement addBtnCreditTeam;

	@FindBy(how = How.LINK_TEXT, using = "Add")
	private WebElement addLnk;

	@FindBy(how = How.XPATH, using = ".//*[@id='CrdTeamDetails']/form/div/table/tbody/tr")
	private List<WebElement> lstOfRoles;

	@FindBy(how = How.XPATH, using = ".//*[@id='CrdTeamDetails']/form/div[2]/a[2]")
	private WebElement saveBtnCreditTeam;

	@FindBy(how = How.XPATH, using = ".//*[@id='credFee']")
	private WebElement clickFees;

	@FindBy(how = How.XPATH, using = ".//*[@id='addFees']")
	private WebElement addFeesBtn;

	@FindBy(how = How.XPATH, using = ".//*[@id='buttonDiv']/a[2]")
	private WebElement saveFeesBtn;

	@FindBy(how = How.XPATH, using = ".//*[@id='otherFeeName']")
	private WebElement otherFeeName;

	@FindBy(how = How.XPATH, using = ".//*[@name='feeNm']")
	private WebElement selectFeeName;

	@FindBy(how = How.XPATH, using = ".//*[@id='feeBal']")
	private WebElement feeAmount;

	@FindBy(how = How.XPATH, using = ".//*[@id='intPar']")
	private WebElement interestedPartiesLink;

	@FindBy(how = How.XPATH, using = ".//*[@id='credIntrParty']")
	private WebElement addInterestedParties;

	@FindBy(how = How.XPATH, using = ".//*[@id='rightContent']/div[2]/div[2]/div[2]/div/div/form/input[@name='srchTxt']")
	private WebElement searchCust;

	@FindBy(how = How.XPATH, using = ".//*[@id='imgBtn']")
	private WebElement srchBtn;

	@FindBy(how = How.XPATH, using = ".//*[@id='searchData']/div/div/div[2]/a")
	private WebElement selectBtn;

	@FindBy(how = How.XPATH, using = ".//*[@id='imgSave']")
	private WebElement saveBtn;

	@FindBy(how = How.XPATH, using = ".//*[@id='popupContentDupCust']/div[2]/div[4]/div[2]/a/b")
	private WebElement proceedBtn;

	@FindBy(how = How.XPATH, using = ".//*[@id='UPSERTREQBORRFORM']/div[1]/div[1]/table/tbody/tr[1]/td[1]/input")
	private WebElement radioBtn;

	@FindBy(how = How.XPATH, using = ".//*[@id='credLineSumm']")
	private WebElement facSumLink;

	@FindBy(how = How.XPATH, using = ".//*[@id='addCrdLine']")
	private WebElement addBtn;

	@FindBy(how = How.XPATH, using = ".//*[@id='addAddrRow']")
	private WebElement addBtnFeeTermStruct;

	@FindBy(how = How.XPATH, using = ".//*[@id='acc_info']/div[2]/div[2]/div/a/div")
	private WebElement commentBubble;

	@FindBy(how = How.XPATH, using = ".//*[@id='totalNoOfCommentsLabel']")
	private WebElement commentNotification;

	@FindBy(how = How.XPATH, using = ".//*[@id='FRMCOMMENTS']/div/label")
	private WebElement categoryLabelOnComment;

	@FindBy(how = How.XPATH, using = ".//*[@id='FRMCOMMENTS']/div/div[1]/label")
	private WebElement sectionLabelOnComment;

	@FindBy(how = How.XPATH, using = ".//*[@id='FRMCOMMENTS']/div/div[2]/div[2]/a/span")
	private WebElement addBtnOnCommentNotification;

	@FindBy(how = How.XPATH, using = ".//*[@id='FRMCOMMENTS']/div/div[2]/div[1]/div")
	private WebElement addSectionOnCommentNotification;

	@FindBy(how = How.XPATH, using = ".//*[@id='editRichText']/div[2]/div")
	private WebElement commentPopup;

	@FindBy(how = How.XPATH, using = ".//*[@id='cke_contents_richTxt']/iframe")
	private WebElement commentPopupEditingSection;

	@FindBy(how = How.XPATH, using = ".//*[@id='editRichText']/div[2]/div/table/thead/tr[2]/td/div/a[2]")
	private WebElement okBtnOnCommentPopup;

	@FindBy(how = How.XPATH, using = ".//*[@id='editRichText']/div[2]/div/table/thead/tr[2]/td/div/a[1]")
	private WebElement cancelBtnOnommentPopup;

	@FindBy(how = How.XPATH, using = ".//*[@id='dragbar']/h2")
	private WebElement commentPopupText;

	@FindBy(how = How.XPATH, using = ".//*[@id='dragbar']/a")
	private WebElement cancelBtnOnCommentPopup;

	@FindBy(how = How.XPATH, using = ".//*[@id='result_div']")
	private WebElement scrollbarSection;

	@FindBy(how = How.XPATH, using = ".//*[@id='taskMangmnt']")
	private WebElement taskManagementLink;

	@FindBy(how = How.XPATH, using = ".//*[@id='taskManagmntContainer']/div/div/div[4]/div/div/div[5]/div/div[2]/div[10]/a")
	private WebElement commentTaskMgmt;

	@FindBy(how = How.XPATH, using = ".//*[@id='FRMADDTSKCOMMENTS']/div/div[2]/div/div[1]/div/div[2]/div")
	private WebElement commentPopupTextBox;

	@FindBy(how = How.XPATH, using = ".//*[@id='dragbar']/div/a")
	private WebElement commentPopupCloseBtn;

	@FindBy(how = How.XPATH, using = ".//*[@id='FRMADDTSKCOMMENTS']/div/div[2]/div/div[2]/a[2]")
	private WebElement commentPopupSaveBtn;

	@FindBy(how = How.XPATH, using = ".//*[@id='FRMADDTSKCOMMENTS']/div/div[2]/div/div[2]/a[1]")
	private WebElement commentPopupCancelBtn;

	@FindBy(how = How.XPATH, using = ".//*[@id='editRichText']/div[2]/div/table/thead/tr[2]/td/div/a[2]")
	private WebElement commentEditorOkBtn;

	@FindBy(how = How.XPATH, using = ".//*[@id='editRichText']/div[2]/div/table/thead/tr[2]/td/div/a[1]")
	private WebElement commentEditorCancelBtn;

	@FindBy(how = How.XPATH, using = ".//*[@id='cke_contents_richTxt']/iframe")
	private WebElement commentEditorBody;

	@FindBy(how = How.XPATH, using = ".//*[@id='cSectionId']")
	private WebElement sectionOnCommentBubble;

	// @FindBy(how = How.XPATH, using =
	// ".//*[@id='taskManagmntContainer']/div/div/div[4]/div/div/div[5]/div/div[2]/div[1]/span[2]")
	// private WebElement expandTaskOnTaskMgmt;

	@FindBy(how = How.XPATH, using = ".//*[@id='taskManagmntContainer']/div/div/div[4]/div/div/div[5]/div/div[1]/div[1]/span[2]")
	private WebElement expandTaskOnTaskMgmt;

	@FindBy(how = How.XPATH, using = ".//*[@id='taskManagmntContainer']/div/div/div[4]/div/div/div[5]/div/div[3]/div[12]/a")
	private WebElement actionMenu2OnTaskMgmt;

	@FindBy(how = How.XPATH, using = ".//*[@id='taskManagmntContainer']/div/div/div[4]/div/div/div[5]/div/div[2]/div[12]/a")
	private WebElement actionMenuOnTaskMgmt;

	@FindBy(how = How.XPATH, using = " .//*[@id='taskManagmntContainer']/div/div/div[4]/div/div/div[5]/div/div[3]/div[11]/a")
	private WebElement subTask2OnTaskMgmt;

	@FindBy(how = How.XPATH, using = " .//*[@id='taskManagmntContainer']/div/div/div[4]/div/div/div[5]/div/div[2]/div[11]/a")
	private WebElement subTaskOnTaskMgmt;

	// @FindBy(how = How.XPATH, using =
	// ".//*[@id='container']/div[9]/div/div/div/ul/li[2]/a")
	// private WebElement reassignToMeLnk;

	@FindBy(how = How.LINK_TEXT, using = "Reassign to me")
	private WebElement reassignToMeLnk;

	@FindBy(how = How.LINK_TEXT, using = "Reassign To Queue")
	private WebElement reassignToQueueLink;

	@FindBy(how = How.LINK_TEXT, using = "Reassign Task")
	private WebElement reassignTaskLink;

	@FindBy(how = How.XPATH, using = ".//*[@id='saveTask']/span")
	private WebElement saveOnReassignToMe;

	@FindBy(how = How.XPATH, using = ".//*[@id='busyDivLoader']")
	private WebElement reassignTaskPopup;

	@FindBy(how = How.XPATH, using = ".//*[@id='onwerGrp']")
	private WebElement groupDropDownInReassignOwner;

	@FindBy(how = How.XPATH, using = ".//*[@id='ownerUsrId']/input")
	private WebElement ownerInReassignOwner;

	@FindBy(how = How.XPATH, using = ".//*[@id='ownerUsrId']/div/div/ul/li")
	private WebElement searchedOwnerInReassignOwner;

	@FindBy(how = How.XPATH, using = ".//*[@id='credCreditLine']/div/div/table/tbody/tr[1]/td[6]/a")
	private WebElement actionMenuOnFacilitySummary;

	@FindBy(how = How.XPATH, using = ".//*[@id='srchTxt']")
	private WebElement enterRecord;

	@FindBy(how = How.XPATH, using = ".//*[@id='img']")
	private WebElement searchRecord;

	@FindBy(how = How.XPATH, using = ".//*[@id='openPopup']/div[2]/div")
	private WebElement globalSearchPopup;

	@FindBy(how = How.XPATH, using = ".//*[@id='dragbar']/h2")
	private WebElement globalSearchText;

	@FindBy(how = How.XPATH, using = ".//*[@id='requestSrchRes']/div[3]/div/table/tbody/tr/td[3]")
	private WebElement matchingRecord;

	@FindBy(how = How.XPATH, using = ".//*[@id='popup_cancel_icon']")
	private WebElement cancelBtn;

	@FindBy(how = How.XPATH, using = ".//*[@id='credLineSummr']/div/a")
	private WebElement fac;

	@FindBy(how = How.XPATH, using = ".//*[@id='credSumm']")
	private WebElement creditSummary;

	private String backToPage = "//div[contains(@class,'breadcrumbGrid')]/ul/li";
	private WebElement element = null;
	private String verifyCrdTeam = ".//*[@id='CrdTeamDetails']/form/div/table/tbody/tr";
	private String role = "roleCd";
	private String feesGrid = ".//*[@id='data_content']/div/table/tbody/tr";
	private String feeCategory = "otherFeeCategory";
	private String feeType = "feeTyp";
	private String feeCurrency = "feeCurr";
	private String feeGrid = ".//*[@id='data_content']/div/table/tbody/tr";
	private String interestedPartiesGrid = ".//*[@id='interestedParties']/div/div/div/table/tbody/tr";

	private String collateralPoolGrid = ".//*[@id='credCollateralPool']/div/div/table/tbody/tr";
	private String creditTeamGrid = ".//*[@id='CrdTeamDetails']/form/div/table/tbody/tr";
	private String newMemberNameTextBox = ".//*[@id='CrdTeamDetails']/form/div[1]/table/tbody/tr";
	private String verifyFeeName = ".//*[@id='UPSERTFEESFORM']/div/div[1]/div/h2";
	private String verifyInterestedParties = ".//*[@id='rightContent']/div[2]/div[1]/h2";

	private int commentCnt;
	private int cnt = 0;

	// get current date and format as yyyy-mm-dd
	final Calendar cal = Calendar.getInstance();
	final DateFormat dForm = new SimpleDateFormat("yyyy-MM-dd");

	List<WebElement> lstWebElements = null;

	public boolean verifyCreditName() {
		return creditName.isDisplayed();
	}

	public void enterCreditName(String value) {
		creditName.clear();
		creditName.sendKeys(value);
	}

	public Credit360Details clickSaveCrdDetails() {
		Util.scrollUp(driver);
		saveCrdDetails.click();
		Util.waitForAJAX(driver);
		return this;
	}

	public void creditApplicationDate() {
		creditApplicationDate.clear();
		Util.scrollUp(driver);
		creditApplicationDate.sendKeys(Util.getCurrentDate());
	}

	public void creditAgreeDate() {
		creditAgreeDate.clear();
		cal.add(Calendar.DATE, 10);
		final String agreeDate = dForm.format(cal.getTime());
		Util.scrollUp(driver);
		creditAgreeDate.sendKeys(agreeDate);
	}

	public void creditProjectedClosingDt() {

		final String closingDate = dForm.format(cal.getTime());
		creditProjectedClosingDt.clear();
		Util.scrollUp(driver);
		creditProjectedClosingDt.sendKeys(closingDate);
		creditProjectedClosingDt.click();
	}

	public void enterCrdProposedAmt(String value) {
		crdProposedAmt.sendKeys(value);
	}

	public void enterCrdCurrProjClsAmt(String value) {
		crdCurrProjClsAmt.sendKeys(value);
	}

	public void enterCrdClosesAmt(String value) {
		Util.scrollUp(driver);
		crdClosesAmt.sendKeys(value);
	}

	public void enterBnkShareProposedAmt(String value) {
		bnkShareProposedAmt.sendKeys(value);
	}

	public void enterBnkShareCurrProjClsAmt(String value) {
		Util.scrollUp(driver);
		bnkShareCurrProjClsAmt.sendKeys(value);
	}

	public void enterBnkShareClosesAmt(String value) {
		bnkShareClosesAmt.sendKeys(value);
	}

	public String getCreditName() {
		Util.waitForElement(driver,creditNameValue, 10);
		return creditNameValue.getText();
	}

	// public String getCreditNumber() {
	// return creditNumber.getText();
	// }

	public Credit360Details clickEditCrdDetails() {
		Util.waitForElement(driver,editCrdDetails, 5);
		editCrdDetails.click();
		Util.waitForAJAX(driver);
		return this;
	}

	public Credit360Details clickCancelCrdDetails() {
		cancelCrdDetails.click();
		Util.waitForAJAX(driver);
		return this;
	}

	public Credit360Details clickBackBreadCrum(String pageName) {
		Actions action = new Actions(driver);
		action.moveToElement(breadCrumText).build().perform();
		Util.waitForElementPresent(driver,By.xpath(backToPage), 30);
		List<WebElement> lstPages = driver.findElements(By.xpath(backToPage));

		for (int i = 1; i <= lstPages.size(); i++) {
			element = driver.findElement(By.xpath(backToPage + "[" + i
					+ "]/a[@id='breadCrumbLnk']"));
			if (element.getText().equalsIgnoreCase(pageName)) {

				element.click();
			}
		}
		// backBreadCrumBtn.click();
		Util.waitForAJAX(driver);
		return new Credit360Details(driver);
	}

	public String getCreditDetailsTxt() {
		Util.waitForAJAX(driver);
		return creditDetailsTxt.getText();
	}

	public Credit360Details clickCreditSummaryEditBtn() {
		Util.waitForElement(driver,editCrdDetails, 5);
		editCrdDetails.click();
		Util.waitForAJAX(driver);
		return this;
	}

	public boolean verifyCustDtlsSaveCancelBtn() {
		if (saveCrdDetails.isDisplayed() && cancelCrdDetails.isDisplayed()) {
			return true;
		} else {
			return false;
		}
	}

	public String getCreditNoOnDetails() {
		Util.waitForElement(driver,creditNo, 20);
		return creditNo.getText();
	}

	public String getCreditNameOnCreditSummary() {
		return creditName.getAttribute("value");
	}

	public int getAsteriskCntOnCreditSummary() {
		return asterisk.size();
	}

	public boolean isErrorMsgPresent() {
		if (errorMsgText.getText().equalsIgnoreCase("This field is required.")) {
			return true;
		} else {
			return false;
		}
	}

	public boolean VerifyCreditText() {
		if (creditDetailsTxt.isDisplayed()) {
			return true;
		} else
			return false;
	}

	public boolean VerifyReqOnDashboard() {
		Util.waitForAJAX(driver);
		if (driver.findElement(By.xpath(".//*[@id='credSummr']/div/a"))
				.isDisplayed()) {
			return true;
		} else
			return false;
	}

	public boolean VerifyCreditInformation() {
		Util.waitForAJAX(driver);
		if (driver
				.findElement(
						By.xpath(".//*[@id='UPSERTCUSTCREDREQFORM']/div/div[1]/div[2]/label[2]"))
				.isDisplayed()) {
			return true;
		} else {
			return false;
		}
	}

	public void clearCreditApplicationDate() {
		creditApplicationDate.clear();
	}

	public void clearCreditAgreeDate() {
		creditAgreeDate.clear();
	}

	public void clearCreditProjectedClosingDt() {
		creditProjectedClosingDt.clear();
	}

	public void clickCollateralPool() {
		Util.waitForElement(driver,clickCollateralPool, 20);
		clickCollateralPool.click();
	}

	public boolean VerifyCollateralPool() {
		Util.waitForAJAX(driver);
		if (driver
				.findElement(
						By.xpath(".//*[@id='credCollateralPool']/div/div/table/tbody/tr"))
				.isDisplayed()) {
			return true;
		} else {
			return false;
		}
	}

//	public Collateral360Details addCollateralPool() {
//		Util.waitForElement(driver,addCollateralPool, 20);
//		addCollateralPool.click();
//		Util.waitForAJAX(driver);
//		return new Collateral360Details(driver);
//	}

	public boolean isCollateralPoolPresentOnGrid(String value) {
		Util.waitForAJAX(driver);
		Util.waitForElementPresent(driver,By.xpath(collateralPoolGrid), 20);
		element = null;
		List<WebElement> lstCustNamesFromGrid = driver.findElements(By
				.xpath(collateralPoolGrid));

		for (int i = 1; i <= lstCustNamesFromGrid.size(); i++) {
			element = driver.findElement(By.xpath(collateralPoolGrid + "[" + i
					+ "]/td[1]"));
			Util.waitForElement(driver,element, 20);
			if (element.getText().equalsIgnoreCase(value)) {
				return true;
			}
		}
		return false;
	}

//	public Collateral360Details clickDetailsIconOfCollateralPool() {
//		Util.waitForAJAX();
//		actions.moveToElement(actionMenuCollateralPool).click().perform();
//		Util.waitForElement(detailsLnk, 20);
//		detailsLnk.click();
//		Util.waitForAJAX();
//		return new Collateral360Details(driver);
//	}

	public void clickCreditTeamLink() {
		Util.waitForElement(driver,clickCreditTeam, 20);
		clickCreditTeam.click();
	}

	public boolean VerifyCreditTeam() {
		Util.waitForAJAX(driver);
		if (driver.findElement(By.xpath(verifyCrdTeam)).isDisplayed()) {
			return true;
		} else {
			return false;
		}
	}

	public void clickAddBtnCreditTeam() {
		Util.waitForAJAX(driver);
		actions.moveToElement(addBtnCreditTeam).click().perform();
		Util.waitForElement(driver,addLnk, 20);
		addLnk.click();
		Util.waitForAJAX(driver);
		// return new Credit360Details(driver);
	}

	private int getNoOfRecordsInGrid(String xpathGridLocator) {
		int rowCnt = 0;
		lstWebElements = driver.findElements(By.xpath(xpathGridLocator));
		for (WebElement ele : lstWebElements) {
			if (ele.getText().equals("No Data Available")) {
				rowCnt = lstWebElements.size() - 1;
			} else {
				rowCnt = lstWebElements.size();
			}
		}
		return rowCnt;
	}

	public int getNoOfRecords() {
		Util.waitForElementPresent(driver,By.xpath(creditTeamGrid), 20);
		return getNoOfRecordsInGrid(creditTeamGrid);
	}

	public int cntOfRoles() {
		return lstOfRoles.size();
	}

	public void selectRole(String roleValue) {
		role = role + (cntOfRoles() - 1);

		WebElement element = driver.findElement(By.xpath("//select[@name='"
				+ role + "']"));
		Util.waitForElementPresent(driver,By.xpath("//select[@name='" + role + "']"),
				60);
		Util.selectItemFromList(driver,element, roleValue);
	}

	public void enterTeamMemberName(String memberName) {
		driver.findElement(
				By.xpath(newMemberNameTextBox + "[" + cntOfRoles() + "]"
						+ "/td[2]/span/input")).sendKeys(memberName);
		Util.waitForAJAX(driver);
		if (driver.findElement(By.xpath(newMemberNameTextBox + "["
				+ cntOfRoles() + "]" + "/td[2]/span/div[1]/div[1]/ul/li")) != null) {
			WebElement ele = driver.findElement(By.xpath(newMemberNameTextBox
					+ "[" + cntOfRoles() + "]"
					+ "/td[2]/span/div[1]/div[1]/ul/li"));

			ele.click();
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

	public void clickSaveOnCreditTeam() {
		Util.waitForElement(driver,saveBtnCreditTeam, 20);
		saveBtnCreditTeam.click();
	}

	public void clickFeesLink() {
		Util.waitForElement(driver,clickFees, 20);
		clickFees.click();
	}

	public boolean VerifyFees() {
		Util.waitForAJAX(driver);
		if (driver.findElement(By.xpath(feesGrid)).isDisplayed()) {
			return true;
		} else {
			return false;
		}
	}

	public void clickAddBtnOnFees() {
		Util.waitForElement(driver,addFeesBtn, 20);
		addFeesBtn.click();
		Util.waitForAJAX(driver);
	}

	public boolean isFeesNamePresent() {
		Util.waitForAJAX(driver);
		if (driver.findElement(By.xpath(verifyFeeName)).isDisplayed()) {
			return true;
		} else {
			return false;
		}

	}

	public void clickSaveBtnOnFees() {
		Util.waitForElement(driver,saveFeesBtn, 20);
		saveFeesBtn.click();
		Util.waitForAJAX(driver);
	}

	public void enterOtherFeeName(String value) {
		Util.waitForElement(driver,otherFeeName, 20);
		otherFeeName.clear();
		otherFeeName.sendKeys(value);
	}

	public void selectFeeName(String value) {

		Util.selectItemFromList(driver,selectFeeName, value);
		Util.waitForAJAX(driver);
	}

	public void selectFeeCategory(String value) {
		Util.enableAllDropdowns(driver);
		Util.waitForElementPresent(driver,By.xpath(feeCategory), 10);
		Util.selectItemFromList(driver,feeCategory, value);
		Util.waitForAJAX(driver);
	}

	public void selectFeeType(String value) {
		Util.enableAllDropdowns(driver);
		Util.waitForElementPresent(driver,By.xpath(feeType), 10);
		Util.selectItemFromList(driver,feeType, value);
		Util.waitForAJAX(driver);
	}

	public void selectCurrency(String value) {
		Util.enableAllDropdowns(driver);
		Util.selectItemFromList(driver,feeCurrency, value);
		Util.waitForAJAX(driver);
	}

	public void enterFeeAmount(String value) {
//		Util.waitForElement(feeAmount, 20);
		Util.waitForElementPresent(driver,By.xpath(".//*[@id='feeBal']"), 30);
		feeAmount.clear();
		feeAmount.sendKeys(value);
	}

	public boolean isFeeNamePresentOnGrid(String value) {
		Util.waitForElementPresent(driver,By.xpath(feeGrid), 20);
		element = null;
		List<WebElement> lstCustNamesFromGrid = driver.findElements(By
				.xpath(feeGrid));
		for (int i = 1; i <= lstCustNamesFromGrid.size(); i++) {
			element = driver.findElement(By
					.xpath(feeGrid + "[" + i + "]/td[1]"));
			Util.waitForElement(driver,element, 20);
			if (element.getText().contains(value)) {
				return true;
			}
		}
		return false;
	}

	public void clickInterestedParties() {
		Util.waitForElement(driver,interestedPartiesLink, 20);
		interestedPartiesLink.click();
	}

	public boolean VerifyInterestedParties() {
		Util.waitForAJAX(driver);
		if (driver.findElement(By.xpath(interestedPartiesGrid)).isDisplayed()) {
			return true;
		} else {
			return false;
		}
	}

	public void clickAddBtnInterestedParties() {
		Util.waitForElement(driver,addInterestedParties, 20);
		addInterestedParties.click();
		Util.waitForAJAX(driver);
	}

	public boolean isInterestedPartiesNamePresent() {
		Util.waitForAJAX(driver);
		if (driver.findElement(By.xpath(verifyInterestedParties)).isDisplayed()) {
			return true;
		} else {
			return false;
		}

	}

	public void enterCustForInterestedParty(String value) {
		Util.waitForElement(driver,searchCust, 20);
		searchCust.sendKeys(value);
	}

	public void clickSrchBtn() {
		Util.waitForElement(driver,srchBtn, 20);
		srchBtn.click();
		Util.waitForAJAX(driver);
	}

	public void selectCustForInterestedParties() {
		Util.waitForAJAX(driver);
		Util.waitForElementPresent(driver,
				By.xpath(".//*[@id='UPSERTREQBORRFORM']/div[1]/div[1]/table/tbody/tr[1]"),
				20);
		radioBtn.click();
		Util.waitForAJAX(driver);
	}

	public void clickSelectBtn() {
		Util.waitForElement(driver,selectBtn, 20);
		selectBtn.click();
		Util.waitForAJAX(driver);
	}

	public void clickSaveInterestedParties() {
		Util.waitForElement(driver,saveBtn, 20);
		saveBtn.click();
		Util.waitForAJAX(driver);
	}

	public void clickProceedBtnOnInterestedParties() {
		Util.waitForElement(driver,proceedBtn, 20);
		proceedBtn.click();
		Util.waitForAJAX(driver);
	}

	public boolean isInterestedPartiesPresentOnGrid(String value) {
		Util.waitForElementPresent(driver,By.xpath(interestedPartiesGrid), 20);
		element = null;
		List<WebElement> lstCustNamesFromGrid = driver.findElements(By
				.xpath(interestedPartiesGrid));
		for (int i = 1; i <= lstCustNamesFromGrid.size(); i++) {
			element = driver.findElement(By.xpath(interestedPartiesGrid + "["
					+ i + "]/td[2]"));
			Util.waitForElement(driver,element, 20);
			if (element.getText().contains(value)) {
				return true;
			}
		}
		return false;
	}

	public void clickFacilitySummary() {
		Util.waitForAJAX(driver);
		Util.waitForElement(driver,facSumLink, 20);
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
		Util.waitForElement(driver,addBtn, 20);
		addBtn.click();
		Util.waitForAJAX(driver);
	}

	public boolean isCommentBubbleDisplayed() {
		Util.waitForElement(driver,commentBubble, 20);
		if (commentBubble.isDisplayed()) {
			return true;
		} else
			return false;
	}

	public void clickComment() {
		Util.waitForElement(driver,commentBubble, 10);
		commentBubble.click();
	}

	public void clickOnCommentNotification() {
		Util.waitForElement(driver,commentNotification, 15);
		commentNotification.click();
		Util.waitForAJAX(driver);
	}

	public boolean isCommentPopupOpened() {
		if (categoryLabelOnComment.isDisplayed()
				&& sectionLabelOnComment.isDisplayed()) {
			return true;
		} else
			return false;
	}

	public void clickSectionLablel() {
		Util.waitForElement(driver,sectionLabelOnComment, 10);
		sectionLabelOnComment.click();
	}

	public void clickAddSectionOnCommentNotification() {
		Util.waitForElement(driver,addSectionOnCommentNotification, 15);
		addSectionOnCommentNotification.click();
		Util.waitForAJAX(driver);
	}

	public boolean isCommentEditorDisplayed() {
		if (commentPopup.isDisplayed() && commentPopupText.isDisplayed()) {
			return true;
		} else
			return false;
	}

	public void enterTextOnCommentPopup(String value) {
		Util.waitForElement(driver,commentPopupEditingSection, 20);
		commentPopupEditingSection.sendKeys(value);
	}

	public void clickOkBtnOnCommentPopup() {
		Util.waitForElement(driver,okBtnOnCommentPopup, 10);
		okBtnOnCommentPopup.click();
		Util.waitForAJAX(driver);
	}

	public String getAddedTextOnCommentPopup() {
		return addSectionOnCommentNotification.getText();
	}

	public void clickAddBtnOnCommentBubble() {
		Util.waitForElement(driver,addBtnOnCommentNotification, 15);
		addBtnOnCommentNotification.click();
		Util.waitForAJAX(driver);
	}

	public boolean isAddedCommentDisplayed(String value1, String value2) {
		Util.waitForElementPresent(driver,By.xpath(".//*[@id='commentDiv']"), 10);
		if (driver
				.findElement(
						By.xpath(".//*[@id='result_div']/div/div/div/div/p"))
				.getText().contains(value1)
				&& driver
						.findElement(
								By.xpath(".//*[@id='result_div']/div/div/div/div/div/span[1]"))
						.getText().contains(value2)) {
			return true;
		} else
			return false;
	}

	// public int getCountOfAddedComment(String value) {
	// int cnt = 0;
	//
	// if (driver
	// .findElement(
	// By.xpath(".//*[@id='acc_info']/div[2]/div[2]/div/a/div/b/label"))
	// .getText().contains(value)) {
	// cnt++;
	// }
	//
	// return cnt;
	// }

	public int getCountOfAddedComment(String value) {
		String str = driver
				.findElement(
						By.xpath(".//*[@id='acc_info']/div[2]/div[2]/div/a/div/b/label"))
				.getText();
		str = str.replace('(', ' ').replace(')', ' ').trim();
		if (str.contains(value)) {
			cnt = Integer.parseInt(str);

		}
		return cnt;
	}

	public int getCommentCount() {
		return commentCnt;
	}

	@SuppressWarnings("unchecked")
	public int verifyCommentCount() {
		lstWebElements = driver.findElements(By
				.xpath(".//*[@id='result_div']/div/div"));
		for (int i = 1; i <= lstWebElements.size(); i++) {
			return lstWebElements.size();
		}
		return commentCnt;
	}

	public boolean verifyScrollBar() {
		if (scrollbarSection.isDisplayed()) {
			WebElement scrollbar = driver.findElement(By
					.xpath(".//*[@id='result_div']"));
			scrollbar.sendKeys(Keys.PAGE_DOWN);
			return true;
		} else
			return false;
	}

	public void clickTaskManagementLink() {
		Util.waitForElement(driver,taskManagementLink, 20);
		taskManagementLink.click();
		Util.waitForAJAX(driver);
		Util.waitForLoaderToFinish(driver);
		Util.waitForAJAX(driver);
	}

	public boolean isTaskManagementDisplayed() {
		Util.waitForAJAX(driver);
		Util.waitForAJAX(driver);
		if (driver
				.findElement(
						By.xpath(".//*[@class='main_content_div taskMgmtblock']/div[1]"))
				.isDisplayed()) {
			return true;
		} else
			return false;
	}

	public boolean verifyCommentColumnOnTaskManagement() {
		if (commentTaskMgmt.isDisplayed()) {
			return true;
		} else
			return false;
	}

	public void clickCommentColumnOnTaskManagement() {
		Util.waitForElement(driver,commentTaskMgmt, 30);
		commentTaskMgmt.click();
		Util.waitForAJAX(driver);
	}

	public boolean isCommentPopupDisplayed() {
		if (commentPopupText.isDisplayed()) {
			return true;
		} else
			return false;
	}

	public void clickOnCommentPopup() {
		Util.waitForElement(driver,commentPopupTextBox, 15);
		commentPopupTextBox.click();
		Util.waitForAJAX(driver);
	}

	public void clickSaveBtnOnCommentPopup() {
		Util.waitForElement(driver,commentPopupSaveBtn, 15);
		commentPopupSaveBtn.click();
		Util.waitForAJAX(driver);
		Util.waitForAJAX(driver);
		Util.waitForAJAX(driver);
	}

	public boolean isCommentPopupNotDisplayed() {
		Util.waitForAJAX(driver);
		if (!commentPopupText.isDisplayed()) {
			return true;
		} else
			return false;
	}

	public boolean isAddedCommentDisplayedOnTaskManagement(String value1,
			String value2) {
		Util.waitForElementPresent(driver,
				By.xpath(".//*[@id='FRMADDTSKCOMMENTS']/div"), 10);
		if (driver
				.findElement(
						By.xpath(".//*[@id='FRMADDTSKCOMMENTS']/div/div[2]/div[1]/div[1]/div/div/p"))
				.getText().contains(value1)
				&& driver
						.findElement(
								By.xpath(".//*[@id='FRMADDTSKCOMMENTS']/div/div[2]/div[1]/div[1]/div/div/div/span[1]"))
						.getText().contains(value2)) {
			return true;
		} else
			return false;
	}

	public int getCountOfAddedCommentOnTaskManagement(String value) {
		int cnt = 0;

		if (driver
				.findElement(
						By.xpath(".//*[@id='myGrid_1429604954127']/div[5]/div/div[1]/div[11]/a/span"))
				.getText().contains(value)) {
			cnt++;
		}

		return cnt;
	}

	public void clickOnExpandButtonOnTaskManagement() {
		Util.waitForElement(driver,expandTaskOnTaskMgmt, 20);
		expandTaskOnTaskMgmt.click();
		Util.waitForAJAX(driver);
	}

	public void clickReassignToMe() {
		actions.moveToElement(actionMenu2OnTaskMgmt).click().perform();
		Util.waitForElement(driver,reassignToMeLnk, 15);
		reassignToMeLnk.click();
		Util.waitForAJAX(driver);
	}

	public void clickReassignToQueue() {
		actions.moveToElement(actionMenu2OnTaskMgmt).click().perform();
		Util.waitForElement(driver,reassignToQueueLink, 15);
		reassignToQueueLink.click();
		Util.waitForAJAX(driver);
	}

	public void clickReassignTask() {
		actions.moveToElement(actionMenuOnTaskMgmt).click().perform();
		Util.waitForElement(driver,reassignTaskLink, 15);
		reassignTaskLink.click();
		Util.waitForAJAX(driver);
	}

	public void clickSaveOnReassignToMe() {
		Util.waitForElement(driver,saveOnReassignToMe, 20);
		saveOnReassignToMe.click();
		Util.waitForAJAX(driver);
		Util.waitForAJAX(driver);
	}

	public void clickSubTaskOnTaskManagement() {
		Util.waitForAJAX(driver);
		Util.waitForElement(driver,subTaskOnTaskMgmt, 15);
		subTaskOnTaskMgmt.click();
	}

	public void clickSubTask2OnTaskManagement() {
		Util.waitForAJAX(driver);
		Util.waitForElement(driver,subTask2OnTaskMgmt, 15);
		subTaskOnTaskMgmt.click();
	}

	public void clickCommentColumnOfSubTaskOnTaskManagement() {
		Util.waitForElement(driver,subTaskOnTaskMgmt, 15);
		subTaskOnTaskMgmt.click();
		Util.waitForAJAX(driver);
	}

	public boolean verifyPopUpOnReassignTask() {
		Util.waitForAJAX(driver);
		Util.waitForAJAX(driver);
		if (reassignTaskPopup.isDisplayed() && commentPopupText.isDisplayed()) {
			return true;
		} else
			return false;
	}

	public void enterGroupNameOnReassignTask(String value) {
		Util.waitForElement(driver,groupDropDownInReassignOwner, 20);
		Util.selectItemFromList(driver,groupDropDownInReassignOwner, value);
	}

	public void enterOwnerNameOnReassignTask(String value) {
		Util.waitForElement(driver,ownerInReassignOwner, 10);
		ownerInReassignOwner.sendKeys(value);
		Util.waitForAJAX(driver);
	}

	public void clickSearchedOwnerOnReassignTask() {
		Util.waitForElement(driver,searchedOwnerInReassignOwner, 30);
		searchedOwnerInReassignOwner.click();
		Util.waitForAJAX(driver);
	}

	public void clickDetailsOnFacilityDetails() {
		actions.moveToElement(actionMenuOnFacilitySummary).click().perform();
		Util.waitForElement(driver,detailsLnk, 20);
		detailsLnk.click();
		Util.waitForAJAX(driver);
	}

	public void clickFacilityDetails() {
		Util.waitForElementPresent(driver,
				By.xpath(".//*[@id='credCreditLine']/div/div/table/tbody/tr[1]/td[6]/a"),
				20);
		actions.moveToElement(actionMenuOnFacilitySummary).click().perform();
		Util.waitForElement(driver,detailsLnk, 15);
		detailsLnk.click();
		Util.waitForAJAX(driver);
	}

	public void enterRecord(String value) {
		Util.waitForElement(driver,enterRecord, 15);
		enterRecord.sendKeys(value);
	}

	public void clickSearchBtn() {
		Util.waitForElement(driver,searchRecord, 15);
		searchRecord.click();
		Util.waitForAJAX(driver);
		Util.waitForAJAX(driver);
	}

	public boolean isGlobalSearchPopupDisplayed() {
		if (globalSearchPopup.isDisplayed() && globalSearchText.isDisplayed()) {
			return true;
		} else
			return false;
	}

	public boolean verifySearchedRecord(String value) {
		Util.waitForAJAX(driver);

		Util.waitForElementPresent(driver,
				By.xpath("//*[@id='requestSrchRes']/div[3]/div/table/tbody/tr/td[3]"),
				60);
		String str = driver
				.findElement(
						By.xpath(".//*[@id='requestSrchRes']/div[3]/div/table/tbody/tr/td[3]"))
				.getText();
		if (str.contains(value)) {
			return true;
		} else
			return false;
	}

//	public LogoutPage clickCancelBtnOnGlobalSearchPopup() {
//		Util.waitForElement(cancelBtn, 10);
//		cancelBtn.click();
//		Util.waitForAJAX();
//		return new LogoutPage(driver);
//	}

	public void clickCloseBtnOnCommentPopupOnTaskManagement() {
		Util.waitForElement(driver,commentPopupCloseBtn, 15);
		commentPopupCloseBtn.click();
		Util.waitForAJAX(driver);
	}

	public void clickFac() {
		Util.waitForElement(driver,fac, 10);
		fac.click();
		Util.waitForAJAX(driver);
	}

	public void clickAllOptionOnCommentBubble(String value) {
		Util.waitForElement(driver,sectionOnCommentBubble, 15);
		Util.selectItemFromList(driver,sectionOnCommentBubble, value);
		Util.waitForAJAX(driver);
	}

	public void clickCreditSummary() {
		Util.waitForElement(driver,creditSummary, 15);
		creditSummary.click();
		Util.waitForAJAX(driver);
	}

}
