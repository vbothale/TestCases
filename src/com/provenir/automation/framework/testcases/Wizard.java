package com.provenir.automation.framework.testcases;

import java.util.HashMap;
import java.util.Map;

import javax.sql.rowset.spi.TransactionalWriter;

import org.apache.log4j.Logger;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.provenir.automation.framework.helper.Collateral360Helper;
import com.provenir.automation.framework.helper.CollateralInfoPage;
import com.provenir.automation.framework.helper.Credit360Helper;
import com.provenir.automation.framework.helper.Customer360Details;
import com.provenir.automation.framework.helper.Customer360Helper;
import com.provenir.automation.framework.helper.CustomerInfoPage;
import com.provenir.automation.framework.helper.LoginPage;
import com.provenir.automation.framework.helper.MyRequests;
import com.provenir.automation.framework.helper.NewCreditRequest;
import com.provenir.automation.framework.helper.SearchHelper;
import com.provenir.automation.framework.helper.TransactionInfoPage;
import com.provenir.automation.framework.helper.UserTeamInfoPage;
import com.provenir.automation.framework.utility.TestCaseExecutor;
import com.provenir.automation.framework.utility.TestDataReader;

public class Wizard extends TestCaseExecutor {

	LoginPage loginPage;
	SearchHelper searchHelper;
	CollateralInfoPage collateralInfoPage;
	Customer360Details customer360;
	Credit360Helper credit360Helper;
	MyRequests myRequests;
	CustomerInfoPage customerInfoPage;
	NewCreditRequest newCreditRequest;
	TransactionInfoPage transactionInfoPage;
	UserTeamInfoPage userTeamInfoPage;

	public TestDataReader reader = new TestDataReader();

	private String option;
	private String creditName = "Credit";
	private HashMap<String, Map<String, String>> _hashLogins = new HashMap<String, Map<String, String>>();
	private HashMap<String, Map<String, String>> _hashWizard = new HashMap<String, Map<String, String>>();

	static Logger log = Logger.getLogger(Collateral360.class);

	@BeforeClass
	@Parameters({ "browser" })
	public void beforeMethod(String browserValue) {
		loginPage = new LoginPage(getDriver(browserValue));
		searchHelper = new SearchHelper(getDriver(browserValue));
		customer360 = new Customer360Details(getDriver(browserValue));
		customerInfoPage = new CustomerInfoPage(getDriver(browserValue));
		collateralInfoPage = new CollateralInfoPage(getDriver(browserValue));
		myRequests = new MyRequests(getDriver(browserValue));
		newCreditRequest = new NewCreditRequest(getDriver(browserValue));
		transactionInfoPage = new TransactionInfoPage(getDriver(browserValue));
		userTeamInfoPage = new UserTeamInfoPage(getDriver(browserValue));

	}

	@BeforeMethod
	public void landingPage() {
		log.info("Login to Prism and search customer");
		reader.readValue(_hashLogins, "resources/Login.json");
		loginPage.login(_hashLogins);
	}

	@Test(priority = 0)
	public void test1_clickOnNewCreditRequest() {
		log.info("Verify Request Summary title on Wizard 1st step");
		newCreditRequest.newCreditRequestLink();
		newCreditRequest.getRequestSummaryPgTitle();
	}

	@Test(priority = 1)
	public void test1_saveCreditDetails() {
		log.info("Save Request Summary details on Wizard 1st step");
		reader.readValue(_hashWizard, "resources/Wizard.json");
		int Randomnumber = (int) (Math.random() * 1111);
		creditName = creditName + Randomnumber;
		newCreditRequest.creditName(_hashWizard);
		newCreditRequest.creditApplicationDate();
		newCreditRequest.enterAggrementDate(_hashWizard);
		newCreditRequest.creditProjectedClosingDt();
		customerInfoPage = newCreditRequest.btnNext();
	}

}
