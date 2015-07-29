package collateral;
import helper.LoginHelper;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Utility.TestDataReader;
import Utility.WebDriverSetUp;

public class Collateral360 {

	LoginHelper loginPage;
	Collateral360Helper collateral360Helper;
	WebDriver driver;
	private String option;
	private TestDataReader reader = new TestDataReader();
	
	private HashMap<String, Map<String, String>> _hashCustomers = new HashMap<String, Map<String, String>>();
	private HashMap<String, Map<String, String>> _hashLogins = new HashMap<String, Map<String, String>>();
	
	
	@Parameters({ "browser" })
	
	@BeforeTest
	public void beforeTest(String browser) throws Exception {
		
		reader.readValue(_hashCustomers,"C:\\Workspace_QA\\TestCases\\java\\demo\\DemoTestNG\\resources\\Customers.json");
		reader.readValue(_hashLogins,"C:\\Workspace_QA\\TestCases\\java\\demo\\DemoTestNG\\resources\\Login.json");
		
		//browser being initialized/called 
		driver = Utility.WebDriverSetUp.getDriver(browser);
		driver.manage().window().maximize();
		
		//deletes the cache
		driver.manage().deleteAllCookies();
		
		helper.LoginHelper.loginToPrism(driver,_hashLogins);
//		loginPage = new LoginHelper(driver);
//		loginPage.clickLoginBtn(driver);
//		loginPage.clickLogin(driver);
		
		Utility.Util.waitForLoaderToFinish(driver);
		
		//search for customer
		helper.SearchHelper.searchCustomer(driver,_hashCustomers);
		
	}
	
	@Test
	public void clickOnCollateralAndAdd() {
		collateral360Helper = new Collateral360Helper();
		collateral360Helper.collateralAdd(driver);
		collateral360Helper.clickOnAddBtn(driver);
	}
	

	@Test
	public void verifyCollateralTitle() throws InterruptedException {
		Collateral360Helper.verifyCollateralTitle(driver);
	}

	@Test
	public void saveCollateralInformation() throws InterruptedException {
		Collateral360Helper.enterCollateralName(driver);
		Collateral360Helper.enterColateralCode(driver);
		Collateral360Helper.selectCollateralType(driver, option);
		Collateral360Helper.selectCollateralSubType(driver, option);
		Collateral360Helper.enterCollateralOwnerName(driver);
		Collateral360Helper.enterCollateralPercentage(driver);
		Collateral360Helper.setPrimaryCollateralOwner(driver);
		Collateral360Helper.clickOnSaveCollateral(driver);
	}
	
	@AfterTest
	public void afterTest() {
		driver.close();
		driver.quit();
		System.gc();
	}

}
