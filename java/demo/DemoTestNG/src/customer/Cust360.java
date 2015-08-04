package customer;
import helper.LoginHelper;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import utility.TestDataReader;
import utility.Util;
import utility.WebDriverSetUp;

public class Cust360 {

	LoginHelper loginPage;

	WebDriver driver;
	private String option;
	private TestDataReader reader = new TestDataReader();
	
	private HashMap<String, Map<String, String>> _hashCustomers = new HashMap<String, Map<String, String>>();
	private HashMap<String, Map<String, String>> _hashLogins = new HashMap<String, Map<String, String>>();
	
	
	@Parameters({ "browser" })
	
	@BeforeTest
	public void beforeTest(String browser) throws Exception {
	
		reader.readValue(_hashCustomers,"C:\\Movies\\TestCases\\java\\demo\\DemoTestNG\\resources\\Customers.json");
		reader.readValue(_hashLogins,"C:\\Movies\\TestCases\\java\\demo\\DemoTestNG\\resources\\Login.json");
		
		//browser being initialized/called 
		driver = utility.WebDriverSetUp.getDriver(browser);
		driver.manage().window().maximize();
		
		//deletes the cache
		driver.manage().deleteAllCookies();
		
		LoginHelper.login(driver, _hashLogins);
//		helper.LoginHelper.login(driver,_hashLogins);
//		loginPage = new LoginHelper(driver);
//		loginPage.clickLoginBtn(driver);
//		loginPage.clickLogin(driver);
		
		utility.Util.waitForLoaderToFinish(driver);
		//search for customer
		helper.SearchHelper.searchCustomer(driver,_hashCustomers);
		Util.waitForAJAX(driver);
	}
	
	
	@AfterTest
	public void afterTest() {
		driver.close();
		driver.quit();
		System.gc();
	}

}
