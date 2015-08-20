package customer;
import helper.Customer360Helper;
import helper.LoginHelper;
import helper.SearchHelper;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import utility.TestDataReader;
import utility.Util;
import utility.WebDriverSetUp;

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
	
		reader.readValue(_hashCustomers,"D:\\workspace_selenium\\TestCases\\java\\demo\\DemoTestNG\\resources\\Customers.json");
		reader.readValue(_hashLogins,"D:\\workspace_selenium\\TestCases\\java\\demo\\DemoTestNG\\resources\\Login.json");
		
		//browser being initialized/called 
		driver = utility.WebDriverSetUp.getDriver(browser);
		driver.manage().window().maximize();
		
		//deletes the cache
		driver.manage().deleteAllCookies();
		
		loginPage = new LoginHelper();
		loginPage.login(driver, _hashLogins);
		
		Util.waitForLoaderToFinish(driver);
		//search for customer
		searchHelper.searchCustomer(driver,_hashCustomers);
	}
	
	@Test
	public void clickAddressAndAdd()
	{
		customer360Hepler = new Customer360Helper();
		customer360Hepler.clickAddress(driver);
		customer360Hepler.clickAddBtnOnAddress(driver);
	}
	
	@Test
	public void verifyAddressTitleOnAddressPage()
	{
		customer360Hepler = new Customer360Helper();
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
