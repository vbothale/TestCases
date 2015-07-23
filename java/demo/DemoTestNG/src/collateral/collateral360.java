package collateral;
import helper.BrowserHelper.*;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Utility.JSONReader;

public class collateral360 {

	public WebDriver driver;
	private String option;
	private JSONReader reader = new JSONReader();
	
	public HashMap<String, Map<String, String>> _hashCustomers = new HashMap<String, Map<String, String>>();
	
	private HashMap<String, Map<String, String>> _hashLogins = new HashMap<String, Map<String, String>>();
	
	@SuppressWarnings("static-access")
	@Parameters({ "browser" })
	@BeforeTest
	public void beforeTest(String browser) throws Exception {
		reader.readJSONToHashMap(_hashCustomers);
//		reader.readJSONToHashMap(_hashLogins);
		driver = helper.BrowserHelper.openBrowser(browser, driver);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		helper.GenericHelper.loginToPrism(driver);
		helper.GenericHelper.waitForLoaderGifToFinish(driver);
		helper.searchHelper.searchRequest(driver);
		
	}

	@AfterTest
	public void afterTest() {
		System.gc();
		driver.quit();
	}
	
	@Test
	public void testRoy() {
		HashMap<String, String> propertiesMap = (HashMap<String, String>) _hashCustomers.get("roy");
		
		System.out.println("First Name: " + propertiesMap.get("fname"));
		System.out.println("Lst Name: " + propertiesMap.get("lname"));
	}
	
	@Test
	public void testParashar() {
		HashMap<String, String> propertiesMap = (HashMap<String, String>) _hashCustomers.get("parashar");
		System.out.println("First Name: " + propertiesMap.get("fname"));
		System.out.println("Lst Name: " + propertiesMap.get("lname"));
	}
	

	@Test
	public void clickOnCollateralAndAdd() {
		collateral360Helper.collateralAdd(driver);
		collateral360Helper.clickOnAddBtn(driver);
	}
	
	

	@Test
	public void verifyCollateralTitle() throws InterruptedException {
		collateral360Helper.verifyCollateralTitle(driver);
	}

	@Test
	public void saveCollateralInformation() throws InterruptedException {
		collateral360Helper.enterCollateralName(driver);
		collateral360Helper.enterColateralCode(driver);
		collateral360Helper.selectCollateralType(driver, option);
		collateral360Helper.selectCollateralSubType(driver, option);
		collateral360Helper.enterCollateralOwnerName(driver);
		collateral360Helper.enterCollateralPercentage(driver);
		collateral360Helper.setPrimaryCollateralOwner(driver);
		collateral360Helper.clickOnSaveCollateral(driver);
	}

}
