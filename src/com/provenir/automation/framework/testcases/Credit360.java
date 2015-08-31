package com.provenir.automation.framework.testcases;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.provenir.automation.framework.helper.Collateral360Helper;
import com.provenir.automation.framework.helper.Credit360Helper;
import com.provenir.automation.framework.helper.LoginPage;
import com.provenir.automation.framework.helper.SearchHelper;
import com.provenir.automation.framework.utility.TestCaseInitializer;
import com.provenir.automation.framework.utility.TestDataReader;

public class Credit360 extends TestCaseInitializer{
	
	LoginPage loginPage;
	SearchHelper searchHelper;
	Credit360Helper credit360Helper;
	
	public TestDataReader reader = new TestDataReader();

	private String option;
	private HashMap<String, Map<String, String>> _hashLogins = new HashMap<String, Map<String, String>>();
	private HashMap<String, Map<String, String>> _hashCustomers = new HashMap<String, Map<String, String>>();

	static Logger log = Logger.getLogger(Credit360.class);
	
	@BeforeMethod
	public void beforeMethod() {
		loginPage = new LoginPage(driver);
		searchHelper = new SearchHelper(driver);
	}
	
	@Test
	public void test1_login() {
		log.info("Login to Prism and search customer");
		reader.readValue(_hashLogins,
				"C:\\New folder\\TestCases\\java\\demo\\DemoTestNG\\resources\\Login.json");
		loginPage.login1(_hashLogins);
		reader.readValue(_hashCustomers,
				"C:\\New folder\\TestCases\\java\\demo\\DemoTestNG\\resources\\Customers.json");
		searchHelper.searchCustomer(_hashCustomers);
		System.out.println("test 0");
	}

}
