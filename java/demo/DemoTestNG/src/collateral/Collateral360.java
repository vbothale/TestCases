package collateral;
import helper.LoginHelper;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Utility.JSONReader;
import Utility.WebDriverSetUp;

public class Collateral360 {

	LoginHelper loginPage;
	WebDriver driver;
	private String option;
	private JSONReader reader = new JSONReader();
	
	private HashMap<String, Map<String, String>> _hashCustomers = new HashMap<String, Map<String, String>>();
	private HashMap<String, Map<String, String>> _hashLogins = new HashMap<String, Map<String, String>>();
	
	
	@Parameters({ "browser" })
	@BeforeTest
	public void beforeTest(String browser) throws Exception {
		
		reader.readJSONToHashMap(_hashCustomers,"C:\\Workspace_QA\\TestCases\\java\\demo\\DemoTestNG\\resources\\Customers.json");
		reader.readJSONToHashMap(_hashLogins,"C:\\Workspace_QA\\TestCases\\java\\demo\\DemoTestNG\\resources\\Login.json");
		
		driver = Utility.WebDriverSetUp.getDriver(browser);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		helper.LoginHelper.loginToPrism(driver,_hashLogins);
		loginPage = new LoginHelper(driver);
//		loginPage.clickLoginBtn(driver);
		loginPage.clickLogin(driver);
		helper.GenericHelper.waitForLoaderGifToFinish(driver);
		helper.SearchHelper.searchCustomer(driver,_hashCustomers);
		
	}

	@AfterTest
	public void afterTest() {
		System.gc();
		driver.quit();
	}
	

	@Test
	public void clickOnCollateralAndAdd() {
		Collateral360Helper cltrl= new Collateral360Helper();
		cltrl.collateralAdd(driver);
		Collateral360Helper.clickOnAddBtn(driver);
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

}
