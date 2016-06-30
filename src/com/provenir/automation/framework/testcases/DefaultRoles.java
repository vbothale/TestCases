package com.provenir.automation.framework.testcases;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.provenir.automation.framework.helper.AdminPage;
import com.provenir.automation.framework.helper.AdvanceSearchHelper;
import com.provenir.automation.framework.helper.LoginPage;
import com.provenir.automation.framework.helper.MyRequests;
import com.provenir.automation.framework.utility.TestCaseExecutor;
import com.provenir.automation.framework.utility.TestDataReader;

public class DefaultRoles extends TestCaseExecutor {

	LoginPage loginPage;
	AdminPage adminPage;
	MyRequests myRequests;
	AdvanceSearchHelper advanceSearch;

	public TestDataReader reader = new TestDataReader();

	private HashMap<String, Map<String, String>> _hashLogins = new HashMap<String, Map<String, String>>();
	static Logger log = Logger.getLogger(DefaultRoles.class);

	@BeforeClass
	@Parameters({ "browser" })
	public void beforeMethod(String browserValue) {
		loginPage = new LoginPage(getDriver(browserValue));
		adminPage = new AdminPage(getDriver(browserValue));
		myRequests = new MyRequests(getDriver(browserValue));
		advanceSearch = new AdvanceSearchHelper(getDriver(browserValue));
	}

	@Test(priority = 0)
	public void test0_landingPage() throws InterruptedException {
		log.info("Login to Prism and search customer");
		reader.readValue(_hashLogins, "resources/Login.json");
		loginPage.login(_hashLogins);
		loginPage = adminPage.clickAdminLink();
		adminPage.clickTeamRoles();
		Assert.assertTrue(adminPage.verifyTeamRoles());
	}

	@Test(priority = 1)
	public void test1_verifySalesAdmin() throws InterruptedException {
		Thread.sleep(4000);
		adminPage.enterRole1();
		Assert.assertEquals(adminPage.getTeamRole(), "SALESADMN");
	}

	@Test(priority = 2)
	public void test2_verifyLoanOfficer() throws InterruptedException {
		Thread.sleep(2000);
		adminPage.enterRole2();
		Assert.assertEquals(adminPage.getTeamRole(), "LOANOFCR");
	}

	@Test(priority = 3)
	public void test3_verifySalesManager() throws InterruptedException {
		Thread.sleep(2000);
		adminPage.enterRole3();
		Assert.assertEquals(adminPage.getTeamRole(), "SALESMNGR");
	}

	@Test(priority = 4)
	public void test4_verifySalesExecutive() throws InterruptedException {
		Thread.sleep(2000);
		adminPage.enterRole4();
		Assert.assertEquals(adminPage.getTeamRole(), "SALESEXCTV");
	}

	@Test(priority = 5)
	public void test5_verifyRelationshipManager() throws InterruptedException {
		Thread.sleep(2000);
		adminPage.enterRole5();
		Assert.assertEquals(adminPage.getTeamRole(), "RELNMGR");
	}

	@Test(priority = 6)
	public void test6_verifyCreditAdmin() throws InterruptedException {
		Thread.sleep(2000);
		adminPage.enterRole6();
		Assert.assertEquals(adminPage.getTeamRole(), "CRDTADMN");
	}

	@Test(priority = 7)
	public void test7_verifyCreditAnalyst() throws InterruptedException {
		Thread.sleep(2000);
		adminPage.enterRole7();
		Assert.assertEquals(adminPage.getTeamRole(), "CRDANLST");
	}

	@Test(priority = 8)
	public void test8_verifySrCreditAnalyst() throws InterruptedException {
		Thread.sleep(2000);
		adminPage.enterRole8();
		Assert.assertEquals(adminPage.getTeamRole(), "SRCRDTANLSYST");
	}

	@Test(priority = 9)
	public void test9_verifyCreditOfficer() throws InterruptedException {
		Thread.sleep(2000);
		adminPage.enterRole9();
		Assert.assertEquals(adminPage.getRole(), "CREDOFFICER");
	}

	@Test(priority = 10)
	public void test10_verifySrCreditOfficer() throws InterruptedException {
		Thread.sleep(2000);
		adminPage.enterRole10();
		Assert.assertEquals(adminPage.getTeamRole(), "SRCREDOFFICER");
	}

	@Test(priority = 11)
	public void test11_verifyChiefCreditOfficer() throws InterruptedException {
		Thread.sleep(2000);
		adminPage.enterRole11();
		Assert.assertEquals(adminPage.getTeamRole(), "CHIEFCREDOFFICER");
	}

	@Test(priority = 12)
	public void test12_verifyOperationsManager() throws InterruptedException {
		Thread.sleep(2000);
		adminPage.enterRole12();
		Assert.assertEquals(adminPage.getTeamRole(), "OPRTNMNGR");
	}

	@Test(priority = 13)
	public void test13_verifyPortfolioManager() throws InterruptedException {
		Thread.sleep(2000);
		adminPage.enterRole13();
		Assert.assertEquals(adminPage.getTeamRole(), "PRTFLIOMNGR");
	}

	@Test(priority = 14)
	public void test14_verifyPortfolioAdmin() throws InterruptedException {
		Thread.sleep(2000);
		adminPage.enterRole14();
		Assert.assertEquals(adminPage.getTeamRole(), "PRTFLIOADMN");
	}

	@Test(priority = 15)
	public void test15_verifySecurityOfficer() throws InterruptedException {
		Thread.sleep(2000);
		adminPage.enterRole15();
		Assert.assertEquals(adminPage.getTeamRole(), "SCRTYOFSR");
	}

	@Test(priority = 16)
	public void test16_verifyComplianceAnalyst() throws InterruptedException {
		Thread.sleep(2000);
		adminPage.enterRole16();
		Assert.assertEquals(adminPage.getTeamRole(), "CMPLIANSANLSYST");
	}

	@Test(priority = 17)
	public void test17_verifyDocManager() throws InterruptedException {
		Thread.sleep(2000);
		adminPage.enterRole17();
		Assert.assertEquals(adminPage.getTeamRole(), "DOCMNGR");
	}

	@Test(priority = 18)
	public void test18_verifyDocSpecialist() throws InterruptedException {
		Thread.sleep(2000);
		adminPage.enterRole18();
		Assert.assertEquals(adminPage.getTeamRole(), "DOCSPCLIST");
	}

	@Test(priority = 19)
	public void test19_verifyCollateralManager() throws InterruptedException {
		Thread.sleep(2000);
		adminPage.enterRole19();
		Assert.assertEquals(adminPage.getTeamRole(), "COLLATRLMNGR");
	}

	@Test(priority = 20)
	public void test20_verifyCollateralAnalyst() throws InterruptedException {
		Thread.sleep(2000);
		adminPage.enterRole20();
		Assert.assertEquals(adminPage.getTeamRole(), "COLLATRLANALSYST");
	}

	@Test(priority = 21)
	public void test21_verifyUCCSpecialist() throws InterruptedException {
		Thread.sleep(2000);
		adminPage.enterRole21();
		Assert.assertEquals(adminPage.getTeamRole(), "UCCSPCLST");
	}

	@Test(priority = 22)
	public void test22_verifyImagingSpecialist() throws InterruptedException {
		Thread.sleep(2000);
		adminPage.enterRole22();
		Assert.assertEquals(adminPage.getTeamRole(), "IMGINGSPCLST");
	}

	@Test(priority = 23)
	public void test23_verifyFundingSpecialist() throws InterruptedException {
		Thread.sleep(2000);
		adminPage.enterRole23();
		Assert.assertEquals(adminPage.getTeamRole(), "FNDINGSPCLST");
	}

	@Test(priority = 24)
	public void test24_verifyBookingSpecialist() throws InterruptedException {
		Thread.sleep(2000);
		adminPage.enterRole24();
		Assert.assertEquals(adminPage.getTeamRole(), "BOKINGSPCLST");
	}

	@Test(priority = 25)
	public void test25_verifyProvenirAdmin() throws InterruptedException {
		Thread.sleep(2000);
		adminPage.enterRole25();
		Assert.assertEquals(adminPage.getTeamRole(), "PROVADMIN");
	}

	@Test(priority = 26)
	public void test26_verifyCreditRiskManager() throws InterruptedException {
		Thread.sleep(2000);
		adminPage.enterRole26();
		Assert.assertEquals(adminPage.getTeamRole(), "CRDRISKMGR");
	}

	@Test(priority = 27)
	public void test27_verifyCompliance() throws InterruptedException {
		Thread.sleep(2000);
		adminPage.enterRole27();
		Assert.assertEquals(adminPage.getRole(), "COMPLIANCE");
	}

	@Test(priority = 28)
	public void test28_verifySmallBusinessBankOfficer() throws InterruptedException {
		Thread.sleep(2000);
		adminPage.enterRole28();
		Assert.assertEquals(adminPage.getTeamRole(), "SBBO");
	}

	@Test(priority = 29)
	public void test29_verifyUnderwriter() throws InterruptedException {
		Thread.sleep(2000);
		adminPage.enterRole29();
		Assert.assertEquals(adminPage.getRole(), "UNDERWRITER");
	}

	@Test(priority = 30)
	public void test30_verifySmallBusinessAnalyst() throws InterruptedException {
		Thread.sleep(2000);
		adminPage.enterRole30();
		Assert.assertEquals(adminPage.getTeamRole(), "SBANALYST");
	}

	@Test(priority = 31)
	public void test31_verifySmallBusinessUnderwriter() throws InterruptedException {
		Thread.sleep(2000);
		adminPage.enterRole31();
		Assert.assertEquals(adminPage.getTeamRole(), "SBUW");
	}

	@Test(priority = 32)
	public void test32_verifySmallBusinessCloser() throws InterruptedException {
		Thread.sleep(2000);
		adminPage.enterRole32();
		Assert.assertEquals(adminPage.getTeamRole(), "SBCLOSER");
	}

}
