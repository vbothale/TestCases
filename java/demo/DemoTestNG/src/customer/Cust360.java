package customer;
import helper.Customer360Helper;
import helper.LoginHelper;
import helper.SearchHelper;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import utility.TestDataReader;
import utility.Util;

public class Cust360 extends org.testng.reporters.EmailableReporter{

	LoginHelper loginPage;
	Customer360Helper customer360Hepler;
	SearchHelper searchHelper;

	WebDriver driver;
	private String option;
	private TestDataReader reader = new TestDataReader();
	
	private HashMap<String, Map<String, String>> _hashCustomers = new HashMap<String, Map<String, String>>();
	private HashMap<String, Map<String, String>> _hashLogins = new HashMap<String, Map<String, String>>();
	
	
	@SuppressWarnings("static-access")
	@Parameters({ "browser" })
	
	@BeforeTest
	public void beforeTest(String browser) throws Exception {
	
		reader.readValue(_hashCustomers,"C:\\New folder\\TestCases\\java\\demo\\DemoTestNG\\resources\\Customers.json");
		reader.readValue(_hashLogins,"C:\\New folder\\TestCases\\java\\demo\\DemoTestNG\\resources\\Login.json");
		
		PropertyConfigurator
		.configure("src/configs/log4j.properties");
		 
		driver = utility.WebDriverSetUp.getDriver(browser);
		driver.manage().window().maximize();
		
		driver.manage().deleteAllCookies();
		
		loginPage = new LoginHelper();
		loginPage.login(driver, _hashLogins);
		
		Util.waitForLoaderToFinish(driver);
		searchHelper.searchCustomer(driver,_hashCustomers);
	}
	
	@Test
	public void clickAddressAndAdd()
	{
		customer360Hepler = new Customer360Helper(driver);
		customer360Hepler.clickAddress(driver);
		customer360Hepler.clickAddBtnOnAddress(driver);
		customer360Hepler.verifyAddressTitle(driver);
	}
	
	@Test
	public void saveAddress()
	{
		customer360Hepler.enterAddressType(driver,option);
		customer360Hepler.selectCountry(driver, option);
		customer360Hepler.enterAddressLine1(driver);
		customer360Hepler.enterPostalCode(driver);
		customer360Hepler.enterCity(driver);
		customer360Hepler.enterRegion(driver, option);
		customer360Hepler.clickSaveOnAddress(driver);
	}
	
	
	@AfterTest
	public void afterTest() {
		driver.close();
		driver.quit();
		System.gc();
	}

}
