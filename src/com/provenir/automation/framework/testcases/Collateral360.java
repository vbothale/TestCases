package com.provenir.automation.framework.testcases;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.provenir.automation.framework.helper.Collateral360Helper;
import com.provenir.automation.framework.helper.LoginPage;
import com.provenir.automation.framework.helper.SearchHelper;
import com.provenir.automation.framework.utility.TestCaseInitializer;
import com.provenir.automation.framework.utility.TestDataReader;

public class Collateral360 extends TestCaseInitializer {

	LoginPage loginPage;
	SearchHelper searchHelper;
	Collateral360Helper collateral360Helper;

	public TestDataReader reader = new TestDataReader();

	private String option;
	private HashMap<String, Map<String, String>> _hashLogins = new HashMap<String, Map<String, String>>();
	private HashMap<String, Map<String, String>> _hashCustomers = new HashMap<String, Map<String, String>>();

	static Logger log = Logger.getLogger(Collateral360.class);

	@BeforeMethod
	public void beforeMethod() {
		loginPage = new LoginPage(driver);
		searchHelper = new SearchHelper(driver);
		collateral360Helper = new Collateral360Helper(driver);
	}

	@Test
	public void test1_login() throws InterruptedException {
		log.info("Login to Prism and search customer");
		reader.readValue(_hashLogins,
				"C:\\New folder\\TestCases\\java\\demo\\DemoTestNG\\resources\\Login.json");
		loginPage.login(_hashLogins);
		reader.readValue(_hashCustomers,
				"C:\\New folder\\TestCases\\java\\demo\\DemoTestNG\\resources\\Customers.json");
		searchHelper.searchCustomer(_hashCustomers);
		collateral360Helper.clickCollateralLink();
		collateral360Helper.clickOnAddCollateralLink();
		System.out.println("test 0");
	}

	@Test
	public void test2_clickOnCollateralAndAdd() throws InterruptedException {
		log.info("Click on collateral and Add");
		System.out.println("test 1");
		collateral360Helper.verifyCollateralTitle();
	}

	@Test
	public void test3_verifyCollateralTitle() {
		collateral360Helper.enterCollateralName();
		collateral360Helper.enterCollateralCode();
		collateral360Helper.selectCollType(option);
		collateral360Helper.selectCollSubType(option);
		collateral360Helper.enterCollateralOwnerName();
		collateral360Helper.enterCollateralPercentage();
		collateral360Helper.setPrimaryCollateralOwner();
		collateral360Helper.clickOnSaveCollateral();
		System.out.println("test 2");
	}

}
