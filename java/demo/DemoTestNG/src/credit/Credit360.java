package credit;

import helper.LoginHelper;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import utility.TestDataReader;
import utility.Util;
import collateral.Collateral360Helper;

public class Credit360 {
	
	LoginHelper loginPage;
	Collateral360Helper collateral360Helper;
	WebDriver driver;
	private String option;
	private TestDataReader reader = new TestDataReader();
	
	private HashMap<String, Map<String, String>> _hashSearch = new HashMap<String, Map<String, String>>();
	private HashMap<String, Map<String, String>> _hashLogins = new HashMap<String, Map<String, String>>();
	
	
	@Parameters({ "browser" })
	
	@BeforeTest
	public void beforeTest(String browser) throws Exception {
	
		reader.readValue(_hashSearch,"C:\\Movies\\TestCases\\java\\demo\\DemoTestNG\\resources\\AdvanceSearch.json");
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
		
	}
	
	@Test
	public void searchRequest(WebDriver driver)
	{
		Util.waitForAJAX(driver);
		Util.waitForElementPresent(By.xpath(".//*[@id='clientCreditReq']/div/a"), 20, driver);
		driver.findElement(By.id(".//*[@id='clientCreditReq']/div/a")).click();
		Util.waitForAJAX(driver);
	}
	
}
