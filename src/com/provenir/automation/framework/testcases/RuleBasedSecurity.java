package com.provenir.automation.framework.testcases;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.provenir.automation.framework.helper.AdminPage;
import com.provenir.automation.framework.helper.Collateral360Helper;
import com.provenir.automation.framework.helper.Customer360Helper;
import com.provenir.automation.framework.helper.LoginPage;
import com.provenir.automation.framework.helper.LogoutPage;
import com.provenir.automation.framework.helper.MyRequests;
import com.provenir.automation.framework.helper.SearchHelper;
import com.provenir.automation.framework.utility.TestCaseExecutor;
import com.provenir.automation.framework.utility.TestDataReader;

public class RuleBasedSecurity extends TestCaseExecutor {

	LoginPage loginPage;
	AdminPage adminPage;
	Customer360Helper customer360Helper;
	LogoutPage logout;
	MyRequests myRequests;

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
		logout = new LogoutPage(getDriver(browserValue));
		myRequests = new MyRequests(getDriver(browserValue));
	}

	@Test(priority = 0)
	public void landingPage() {
		log.info("Login to Prism and search customer");
		reader.readValue(_hashLogins, "resources/Login.json");
		loginPage.login(_hashLogins);
		loginPage = adminPage.clickAdminLink();
	}

	@Test(priority = 1)
	public void test1_clickSecuritySettings() throws InterruptedException {
		adminPage.clickSecuritySettings();
		adminPage.selectGroupFromSecurity();
		adminPage.selectCategoryFromSecurity();
	}

	@Test(priority = 2)
	public void test2_enterEditPermission() {
		adminPage.clickEditPermissionOnSecurity();
		adminPage.clickCreateCustomerOnSecurityPage();
	}

	@Test(priority = 3)
	public void test3_selectAnyRuleFromDEAndSave() throws InterruptedException {
		adminPage.selectRule();
		logout = adminPage.clickSaveBtnOnSecuritySettings();
	}

	@Test(priority = 4)
	public void test4_verifySecurityWithOtherUser() {
		loginPage = logout.logoutCL();
		loginPage.clickHere();
		loginPage.login3(_hashLogins);
		myRequests = loginPage.clickMyRequetsLink();
		Assert.assertTrue(myRequests.isCreateCustomerDisplayed());
	}
}
