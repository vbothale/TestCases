package com.provenir.automation.framework.testcases;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.provenir.automation.framework.helper.AdminPage;
import com.provenir.automation.framework.helper.AdvanceSearchHelper;
import com.provenir.automation.framework.helper.CollateralInfoPage;
import com.provenir.automation.framework.helper.Credit360Details;
import com.provenir.automation.framework.helper.Credit360Helper;
import com.provenir.automation.framework.helper.CustomerInfoPage;
import com.provenir.automation.framework.helper.LoginPage;
import com.provenir.automation.framework.helper.ManageWorkflow;
import com.provenir.automation.framework.helper.MyRequests;
import com.provenir.automation.framework.helper.NewCreditRequest;
import com.provenir.automation.framework.helper.TransactionInfoPage;
import com.provenir.automation.framework.utility.TestCaseExecutor;
import com.provenir.automation.framework.utility.TestDataReader;

public class FacilityLevelWorkflow extends TestCaseExecutor {

	LoginPage loginPage;
	AdminPage adminPage;
	ManageWorkflow manageWorkflow;
	MyRequests myRequests;
	NewCreditRequest creditRequest;
	CustomerInfoPage customerInfoPage;
	CollateralInfoPage collateralInfoPage;
	TransactionInfoPage transactionInfoPage;
	AdvanceSearchHelper advanceSearch;
	Credit360Helper credit360;
	Credit360Details credit360Details;

	public TestDataReader reader = new TestDataReader();

	private String option;
	private HashMap<String, Map<String, String>> _hashLogins = new HashMap<String, Map<String, String>>();
	private HashMap<String, Map<String, String>> _hashReq = new HashMap<String, Map<String, String>>();

	static Logger log = Logger.getLogger(FacilityLevelWorkflow.class);

	@BeforeClass
	@Parameters({ "browser" })
	public void beforeMethod(String browserValue) {
		loginPage = new LoginPage(getDriver(browserValue));
		adminPage = new AdminPage(getDriver(browserValue));
		myRequests = new MyRequests(getDriver(browserValue));
		creditRequest = new NewCreditRequest(getDriver(browserValue));
		customerInfoPage = new CustomerInfoPage(getDriver(browserValue));
		collateralInfoPage = new CollateralInfoPage(getDriver(browserValue));
		transactionInfoPage = new TransactionInfoPage(getDriver(browserValue));
		advanceSearch = new AdvanceSearchHelper(getDriver(browserValue));
	}

	// @BeforeMethod
	// public void landingPage() {
	// log.info("Login to Prism and search customer");
	// reader.readValue(_hashLogins, "resources/Login.json");
	// loginPage.login(_hashLogins);
	// loginPage = adminPage.clickAdminLink();
	// adminPage.clickManageWorkflows();
	// adminPage.verifyWorkflowSummaryTitle();
	// }

	@Test(priority = 0)
	public void landingPage() {
		log.info("Login to Prism and search customer");
		reader.readValue(_hashLogins, "resources/Login.json");
		loginPage.login(_hashLogins);
		loginPage = adminPage.clickAdminLink();
		adminPage.clickManageWorkflows();
		adminPage.verifyWorkflowSummaryTitle();
	}

	// @Test(priority = 0)
	// public void test1_verifyResultsAccToWorkflowType() {
	// adminPage.selectAndVerifyWorkflowTypeAsCredit();
	// adminPage.selectAndVerifyWorkflowTypeAsFacility();
	// }
	//
	// @Test(priority = 1)
	// public void test2_clickOnAddBtnOfWorkflowSummary() {
	// adminPage.clickAddBtnOnWorkflowSummary();
	// adminPage.verifyWorkflowPageTitle();
	// }
	//
	// @Test(priority = 2)
	// public void test3_verifyMandatoryDetailsOnManageWorkflow() {
	// adminPage.clickAddBtnOnWorkflowSummary();
	// adminPage.verifyWorkflowPageTitle();
	// adminPage.verifyMandatoryDetailsOnManageWorkflow();
	// }

	// @Test(priority = 3)
	// public void test4_clickAddAndSaveFacilityLevelWorkflow() {
	// adminPage.clickAddBtnOnWorkflowSummary();
	//
	// adminPage.enterFacilityWorkflow();
	// adminPage.selectWorkflowTypeAsFacility(option);
	//
	// adminPage.clickAddBtnOnManageWorkflow();
	//
	// adminPage.enterFacilityWorkflow();
	// adminPage.selectTaskName(option);
	// adminPage.enterTaskCode();
	// adminPage.selectRoleAssignment(option);
	// adminPage.clickMilestone();
	// adminPage.enterMilestoneAsOnboarded(option);
	//
	// adminPage.selectTaskName1(option);
	// adminPage.enterTaskCode();
	// adminPage.selectRoleAssignment(option);
	// adminPage.clickMilestone();
	// adminPage.enterMilestoneAsComplianceComplete(option);
	//
	// adminPage.selectTaskName2(option);
	// adminPage.enterTaskCode();
	// adminPage.selectRoleAssignment(option);
	// adminPage.clickMilestone();
	// adminPage.enterMilestoneAsUnderwritingComplete(option);
	//
	// adminPage.selectTaskName3(option);
	// adminPage.enterTaskCode();
	// adminPage.selectRoleAssignment(option);
	// adminPage.clickMilestone();
	// adminPage.enterMilestoneAsFinancialsReviewed(option);
	//
	// adminPage.selectTaskName4(option);
	// adminPage.enterTaskCode();
	// adminPage.selectRoleAssignment(option);
	// adminPage.clickMilestone();
	// adminPage.enterMilestoneAsCompleted(option);
	//
	// adminPage.clickSaveBtnOnWorkflowPage();
	// adminPage.verifyWorkflowIsSavedOrNot();
	// }

	// @Test(priority = 4)
	// public void test5_searchSavedWorkflow() {
	// adminPage.enterFacilityWorkflowNameToSearch();
	// adminPage.clickOnSearchIconOnWorkflowSummary();
	// adminPage.verifySavedWorkflowAsFacility();
	// }

	// @Test(priority = 5)
	// public void test6_updateWorkflowType() {
	// adminPage.enterFacilityWorkflowNameToSearch();
	// adminPage.clickOnSearchIconOnWorkflowSummary();
	// adminPage.clickWorkflowName();
	// adminPage.editWorkflow();
	// adminPage.selectAndVerifyWorkflowTypeAsFacility();
	// adminPage.enterCreditWorkflow();
	// adminPage.clickSaveBtnOnWorkflowPage();
	// adminPage.clickBackBtnOnWorkflow();
	// }

	// @Test(priority = 6)
	// public void test7_searchUpdatedWorkflow() {
	// adminPage.enterCreditWorkflowNameToSearch();
	// adminPage.clickOnSearchIconOnWorkflowSummary();
	// adminPage.verifySavedWorkflowAsCredit();
	// }
	//
	// @Test(priority = 7)
	// public void test8_setUpdatedWorkflowToDefault() {
	// adminPage.enterCreditWorkflowNameToSearch();
	// adminPage.clickOnSearchIconOnWorkflowSummary();
	// adminPage.setWorkflowAsDefault();
	// }
	//
	// @Test(priority = 8)
	// public void test9_verifyAsterixOnDefaultWorkflow() {
	// adminPage.enterCreditWorkflowNameToSearch();
	// adminPage.clickOnSearchIconOnWorkflowSummary();
	// adminPage.verifyAsterixOnSavedWorkflow();
	// }

	@Test(priority = 9)
	public void test10_goToHomePage() {
		adminPage = myRequests.clickHomeLink();
	}

	@Test(priority = 10)
	public void test11_clickNewCreditRequest() {
		creditRequest.newCreditRequestLink();
		creditRequest.getRequestSummaryPgTitle();
	}

	@Test(priority = 11)
	public void test12_verifyDefaultCreditLevelWorkflow() {
		creditRequest.verifyDefaultWorkflowName();
	}

	@Test(priority = 12)
	public void test13_verifySavedWorkflow() {
		creditRequest.enterLendingProcess(option);
		creditRequest.getSavedWorkflowName();
	}

	@Test(priority = 13)
	public void test14_clickTransactionInfoPage() {
		creditRequest.enterCreditName();
		creditRequest.creditAgreeDate();
		creditRequest.creditProjectedClosingDt();
		customerInfoPage = creditRequest.btnNext();
		collateralInfoPage = customerInfoPage.clickNextBtn();
		transactionInfoPage = collateralInfoPage.clickOnNextButton();
	}

	@Test(priority = 14)
	public void test15_verifyDefaultFacilityLevelWorkflow() {
		transactionInfoPage.clickProdCatalogButton();
		transactionInfoPage.verifyDefaultFacilityWorkflow();

	}

	@Test(priority = 15)
	public void test16_verifysavedFacilityWorkflow() {
		transactionInfoPage.selectFacilityWorkflow(option);
		transactionInfoPage.verifySavedFacilityWorkflow();
	}

	@Test(priority = 16)
	public void test17_gotoHomePage() {
		transactionInfoPage = myRequests.clickHomePage();
	}

	@Test(priority = 17)
	public void test18_searchRequest() {
		advanceSearch.clickAdvanceSearchLink();
		advanceSearch.enterRequestType(option);
		advanceSearch.enterCreditNameAndSubmit();
		advanceSearch.clickReqOnGrid();
		credit360 = advanceSearch.verifyCreditTitle();
	}

	@Test(priority = 18)
	public void test19_verifyTaskManagementSection() {
		credit360.clickTaskManagement();
		credit360.verifyActionColumn();
		credit360.clickActionColumnAndVerifyAddedWorkflow();
	}

	@Test(priority = 19)
	public void test20_gotoFacility360() {
		credit360.clickFacilitySummary();
	}

}
