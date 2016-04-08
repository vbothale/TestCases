package com.provenir.automation.framework.testcases;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.provenir.automation.framework.helper.AdminPage;
import com.provenir.automation.framework.helper.AdvanceSearchHelper;
import com.provenir.automation.framework.helper.Collateral360Helper;
import com.provenir.automation.framework.helper.Credit360Helper;
import com.provenir.automation.framework.helper.Customer360Helper;
import com.provenir.automation.framework.helper.LoginPage;
import com.provenir.automation.framework.helper.LogoutPage;
import com.provenir.automation.framework.helper.MyRequests;
import com.provenir.automation.framework.helper.SearchHelper;
import com.provenir.automation.framework.utility.TestCaseExecutor;
import com.provenir.automation.framework.utility.TestDataReader;
import com.thoughtworks.selenium.webdriven.commands.IsElementPresent;

public class RuleBasedSecurity extends TestCaseExecutor {

	LoginPage loginPage;
	AdminPage adminPage;
	Customer360Helper customer360Helper;
	LogoutPage logout;
	MyRequests myRequests;
	AdvanceSearchHelper advanceSearch;
	Credit360Helper credit360;

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
		advanceSearch = new AdvanceSearchHelper(getDriver(browserValue));
		credit360 = new Credit360Helper(getDriver(browserValue));
	}

	@Test(priority = 0)
	public void landingPage() throws InterruptedException {
		log.info("Login to Prism and search customer");
		reader.readValue(_hashLogins, "resources/Login.json");
		loginPage.login(_hashLogins);
		loginPage = adminPage.clickAdminLink();

	}

	// // For group
	//
	// @Test(priority = 1)
	// public void test1_clickSecuritySettings() throws InterruptedException {
	// adminPage.clickSecuritySettings();
	// adminPage.selectGroupFromSecurity();
	// adminPage.selectCategoryFromSecurity();
	// }
	//
	// @Test(priority = 2)
	// public void test2_enterEditPermission() {
	// adminPage.clickEditPermissionOnSecurity();
	// adminPage.clickCreateCustomerOnSecurityPage();
	// }
	//
	// @Test(priority = 3)
	// public void test3_selectAnyRuleFromDEAndSave() throws
	// InterruptedException {
	// adminPage.selectRule();
	// logout = adminPage.clickSaveBtnOnSecuritySettings();
	// }
	//
	// @Test(priority = 4)
	// public void test4_verifySecurityWithOtherUser() {
	// loginPage = logout.logoutCL();
	// loginPage.clickHere();
	// loginPage.login3(_hashLogins);
	// myRequests = loginPage.clickMyRequetsLink();
	// myRequests.isCreateCustomerDisplayed();
	// }
	//
	// @Test(priority = 5)
	// public void test5_loginWithOtherUser() throws InterruptedException {
	// logout = myRequests.clickMyRequetsLink();
	// loginPage = logout.logoutCL();
	// loginPage.clickHere();
	// loginPage.login(_hashLogins);
	// loginPage = adminPage.clickAdminLink();
	// }
	//
	// @Test(priority = 6)
	// public void test6_goToSecuritySettingsAndSelectGroup()
	// throws InterruptedException {
	// adminPage.clickSecuritySettings();
	// adminPage.selectRuleBasedGroupFromSecurity();
	// adminPage.selectCredit360AsCategoryFromSecurity();
	// }
	//
	// @Test(priority = 7)
	// public void test7_enterPermission() {
	// adminPage.clickEditPermissionOnSecurity();
	// }
	//
	// @Test(priority = 8)
	// public void test8_selectRuleFromDEAndSave() throws InterruptedException {
	// adminPage.clickBookingDetails();
	// adminPage.select5MRuleForBookingDetails();
	// logout = adminPage.clickSaveBtnOnSecuritySettings();
	// }
	//
	// @Test(priority = 9)
	// public void test9_loginWithOtherUser() {
	// loginPage = logout.logoutCL();
	// loginPage.clickHere();
	// loginPage.login3(_hashLogins);
	// myRequests = loginPage.clickMyRequetsLink();
	// }
	//
	// @Test(priority = 10)
	// public void test10_searchReq() {
	// advanceSearch.clickAdvanceSearchLink();
	// advanceSearch.enterRequestType(option);
	// advanceSearch.searchRequestAndSubmit();
	// credit360 = advanceSearch.clickReqOnGrid();
	// }
	//
	// @Test(priority = 11)
	// public void test11_verifySecurityforOtherUser() {
	// credit360.isBookingSummaryDisplayed();
	// }
	//
	// // For Role
	//
	// @Test(priority = 12)
	// public void test12_login() throws InterruptedException {
	// myRequests = credit360.clickHome();
	// loginPage = logout.logoutCL();
	// loginPage.clickHere();
	// loginPage.login(_hashLogins);
	// loginPage = adminPage.clickAdminLink();
	// }

	@Test(priority = 13)
	public void test13_selectRoleAndCategory() throws InterruptedException {
		adminPage.clickSecuritySettings();
		adminPage.selectRoleFromSecurity();
		adminPage.selectCategoryFromSecurity();
	}

	@Test(priority = 14)
	public void test14_enterEditPermission() {
		adminPage.clickEditPermissionOnSecurity();
		adminPage.clickCreateCustomerOnSecurityPage();
	}

	@Test(priority = 15)
	public void test15_selectRuleFromDEAndSave() throws InterruptedException {
		adminPage.selectRule();
		logout = adminPage.clickSaveBtnOnSecuritySettings();
	}

	@Test(priority = 16)
	public void test16_verifySecurityWithOtherUser() {
		loginPage = logout.logoutCL();
		loginPage.clickHere();
		loginPage.login3(_hashLogins);
		myRequests = loginPage.clickMyRequetsLink();
		myRequests.isCreateCustomerDisplayed();
	}

}
