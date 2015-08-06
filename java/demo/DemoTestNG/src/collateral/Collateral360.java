package collateral;
import helper.Collateral360Helper;
import helper.LoginHelper;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import customer.Customer360;
import utility.TestDataReader;
import utility.WebDriverSetUp;

public class Collateral360 extends org.testng.reporters.EmailableReporter{

	LoginHelper loginPage;
	Collateral360Helper collateral360Helper;
	WebDriver driver;
	private String option;
	private TestDataReader reader = new TestDataReader();
	
	static Logger log = Logger.getLogger(Collateral360.class);
	
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
		
		helper.LoginHelper.loginToPrism(driver,_hashLogins);
//		loginPage = new LoginHelper(driver);
//		loginPage.clickLoginBtn(driver);
//		loginPage.clickLogin(driver);
		
		utility.Util.waitForLoaderToFinish(driver);
		
		//search for customer
		helper.SearchHelper.searchCustomer(driver,_hashCustomers);
		
	}
	
	@Test(priority=0)
	public void clickOnCollateralAndAdd() {
		collateral360Helper = new Collateral360Helper();
		collateral360Helper.collateralAdd(driver);
		collateral360Helper.clickOnAddBtn(driver);
		System.out.println("test 1");
	}
	

	@Test(priority=1)
	public void verifyCollateralTitle() throws InterruptedException {
		Collateral360Helper.verifyCollateralTitle(driver);
		System.out.println("test 2");
	}

	@Test(priority=2)
	public void saveCollateralInformation() throws InterruptedException {
		Collateral360Helper.enterCollateralName(driver);
		Collateral360Helper.enterColateralCode(driver);
		Collateral360Helper.selectCollateralType(driver, option);
		Collateral360Helper.selectCollateralSubType(driver, option);
		Collateral360Helper.enterCollateralOwnerName(driver);
		Collateral360Helper.enterCollateralPercentage(driver);
		Collateral360Helper.setPrimaryCollateralOwner(driver);
		Collateral360Helper.clickOnSaveCollateral(driver);
		System.out.println("test 3");
	}
	
	@AfterTest
	public void afterTest() {
//		driver.close();
//		driver.quit();
//		System.gc();
	}

}
