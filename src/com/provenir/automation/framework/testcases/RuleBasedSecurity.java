package com.provenir.automation.framework.testcases;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.provenir.automation.framework.helper.AdminPage;
import com.provenir.automation.framework.helper.Collateral360Helper;
import com.provenir.automation.framework.helper.Customer360Helper;
import com.provenir.automation.framework.helper.LoginPage;
import com.provenir.automation.framework.helper.SearchHelper;
import com.provenir.automation.framework.utility.TestCaseExecutor;
import com.provenir.automation.framework.utility.TestDataReader;

public class RuleBasedSecurity extends TestCaseExecutor {

	LoginPage loginPage;
	AdminPage adminPage;
	Customer360Helper customer360Helper;

	public TestDataReader reader = new TestDataReader();

	private String option;
	private HashMap<String, Map<String, String>> _hashLogins = new HashMap<String, Map<String, String>>();

	static Logger log = Logger.getLogger(RuleBasedSecurity.class);

	@BeforeClass
	@Parameters({ "browser" })
	public void beforeMethod(String browserValue) {
		loginPage = new LoginPage(getDriver(browserValue));
		adminPage = new AdminPage(getDriver(browserValue));
		customer360Helper = new Customer360Helper(getDriver(browserValue));
	}

	@BeforeMethod
	public void landingPage() {
		log.info("Login to Prism and search customer");
		reader.readValue(_hashLogins, "resources/Login.json");
		loginPage.login(_hashLogins);
		loginPage = adminPage.clickAdminLink();
		
	}

	@Test(priority = 0)
	public void test1_clickSecuritySettings() {
		adminPage.clickSecuritySettings();
		adminPage.selectRoleFromSecurity(option);
		adminPage.selectCustomer360FromCategoryOnSecurity(option);
	}

}
