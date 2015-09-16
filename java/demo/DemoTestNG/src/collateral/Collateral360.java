package collateral;
import helper.Collateral360Helper;
import helper.LoginHelper;
import helper.SearchHelper;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import utility.TestDataReader;
import utility.Util;
import utility.WebDriverSetUp;
import customer.Customer360;

public class Collateral360 extends org.testng.reporters.EmailableReporter{

	LoginHelper loginPage;
	Collateral360Helper collateral360Helper;
	SearchHelper searchHelper;
	
	WebDriver driver;
	private String option;
	private TestDataReader reader = new TestDataReader();
	
	static Logger log = Logger.getLogger(Collateral360.class);
	
	private HashMap<String, Map<String, String>> _hashCustomers = new HashMap<String, Map<String, String>>();
	private HashMap<String, Map<String, String>> _hashLogins = new HashMap<String, Map<String, String>>();
	
	
	@SuppressWarnings("static-access")
	@Parameters({ "browser" })
	
	@BeforeTest
	public void beforeTest(String browser) throws Exception {
		try{
			reader.readValue(_hashCustomers,"D:\\Workspace_TestCases\\TestCases\\java\\demo\\DemoTestNG\\resources\\Customers.json");
			reader.readValue(_hashLogins,"D:\\Workspace_TestCases\\TestCases\\java\\demo\\DemoTestNG\\resources\\Login.json");
		}catch(Exception e){
			log.error(e);
		}
		
		//browser being initialized/called 
		driver = utility.WebDriverSetUp.getDriver(browser);
		driver.manage().window().maximize();
		
		//deletes the cache
		driver.manage().deleteAllCookies();
		
		loginPage.loginToPrism(driver, _hashLogins);
		
		Util.waitForLoaderToFinish(driver);
		
		//search for customer
		searchHelper.searchCustomer(driver,_hashCustomers);
		
	 File file = new File("D:\\Workspace_TestCases\\TestCases\\java\\demo\\DemoTestNG\\src\\collateral\\CollateralLocators.properties");
	   Properties prop = new Properties();
			  //Creating InputStream object to read data
	   FileInputStream objInput = null;
			   try {
	   objInput = new FileInputStream(file);
			    //Reading properties key/values in file
		   prop.load(objInput);
			objInput.close();
			    } catch (FileNotFoundException e) {
			     System.out.println(e.getMessage());   
			    } catch (IOException e) {
			   System.out.println(e.getMessage());
			  }
		   
	}
	
	@Test(priority=0)
	public void verifyCollateralTitleOnCollateral() {
		collateral360Helper = new Collateral360Helper();
		collateral360Helper.Propertyfile();
		collateral360Helper.collateralAdd(driver);
		collateral360Helper.clickOnAddBtn(driver);
		collateral360Helper.verifyCollateralTitle(driver);
		System.out.println("test 1");
	}
	

	@Test(priority=1)
	public void saveCollateralDetails() throws InterruptedException {
		collateral360Helper.enterCollateralName(driver);
		collateral360Helper.enterColateralCode(driver);
		collateral360Helper.selectCollateralType(driver, option);
		collateral360Helper.selectCollateralSubType(driver, option);
		collateral360Helper.enterCollateralOwnerName(driver);
		collateral360Helper.enterCollateralPercentage(driver);
		collateral360Helper.setPrimaryCollateralOwner(driver);
		collateral360Helper.clickOnSaveCollateral(driver);
		System.out.println("test 2");
	}

	
	
	@AfterTest
	public void afterTest() {
		driver.close();
		driver.quit();
		System.gc();
	}

}
