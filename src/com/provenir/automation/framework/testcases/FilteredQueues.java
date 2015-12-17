package com.provenir.automation.framework.testcases;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.provenir.automation.framework.helper.CollateralInfoPage;
import com.provenir.automation.framework.helper.Credit360Details;
import com.provenir.automation.framework.helper.Credit360Helper;
import com.provenir.automation.framework.helper.CustomerInfoPage;
import com.provenir.automation.framework.helper.Facility360Details;
import com.provenir.automation.framework.helper.LoginPage;
import com.provenir.automation.framework.helper.MyRequests;
import com.provenir.automation.framework.helper.NewCreditRequest;
import com.provenir.automation.framework.helper.SearchHelper;
import com.provenir.automation.framework.helper.TransactionInfoPage;
import com.provenir.automation.framework.utility.TestCaseExecutor;
import com.provenir.automation.framework.utility.TestDataReader;

public class FilteredQueues extends TestCaseExecutor {

	LoginPage loginPage;
	MyRequests myRequests;
	NewCreditRequest creditRequest;
	CustomerInfoPage customerInfoPage;
	CollateralInfoPage collateralInfoPage;
	TransactionInfoPage transactionInfoPage;
	Credit360Helper credit360;
	Credit360Details credit360Details;
	Facility360Details facility360;
	SearchHelper searchHelper;

	public TestDataReader reader = new TestDataReader();

	private String option;
	private HashMap<String, Map<String, String>> _hashLogins = new HashMap<String, Map<String, String>>();

	static Logger log = Logger.getLogger(FacilityLevelWorkflow.class);

	@BeforeClass
	@Parameters({ "browser" })
	public void beforeMethod(String browserValue) {
		loginPage = new LoginPage(getDriver(browserValue));
		myRequests = new MyRequests(getDriver(browserValue));
	}

	@Test(priority = 0)
	public void test1_landingPage() {
		log.info("Login to Prism and search customer");
		reader.readValue(_hashLogins, "resources/Login.json");
		loginPage.login(_hashLogins);
	}

	@Test(priority = 1)
	public void test2_verifyFiltersOnMyRequestsPage() {
		myRequests = loginPage.clickMyRequetsLink();
		myRequests.verifyAllFiltersDisplayed();
		myRequests.verifyFilterBtnDisplayed();
		myRequests.verifyPageIndicatorsDisplayed();
	}

	@Test(priority = 2)
	public void test3_verifyDefaultValuesOfFilters() {
		myRequests.verifyDefaultValues();
	}

	@Test(priority = 3)
	public void test4_verifyFiltersFunctionality() {
		myRequests.selectWorkflowMilestone();
		myRequests.selectDecisionMilestone();
		myRequests.enterFromDate();
		myRequests.enterToDate();
		myRequests.clickFilterBtn();
	}

	@Test(priority = 4)
	public void test5_verifyInitialWorkflowStatusOfNewlyCreatedRequest() {
		myRequests.clickHome();
		myRequests.selectWorkflowMilestone();
		myRequests.verifyWorkflowStatusAsInProgress();
		myRequests.clickFilterBtn();
	}

	@Test(priority = 5)
	public void test6_verifyInitialDecisionStatusOfNewlyCreatedRequest() {
		myRequests.selectDecisionMilestoneAsUndecided();
		myRequests.verifyDecisionStatusAsUndecided();
		myRequests.clickFilterBtn();
	}

	@Test(priority = 6)
	public void test7_verifyReqCount() {
		myRequests.verifyReqCount();
	}
	
	@Test(priority = 7)
	public void test8_verifyHeaderOnTMActAsHyperlink()
	{
		credit360 = myRequests.clickOnAnyReqFromDashboard();
		
	}

}
