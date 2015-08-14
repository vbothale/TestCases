package com.provenir.automation.framework.modules.collateral;

import java.util.HashMap;
import java.util.Map;

import net.sourceforge.htmlunit.corejs.javascript.tools.debugger.Main;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.provenir.automation.framework.helperClass.LoginHelper;
import com.provenir.automation.framework.utility.TestDataReader;
import com.provenir.automation.framework.utility.TestStepDetails;
import com.provenir.automation.framework.utility.WebDriverSetUp;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.LogStatus;

public class  ExecuteCollateral{

	LoginHelper loginPage;
	Collateral360Helper collateral360Helper;

	Collateral360 collateral;
	
	
	
	WebDriver driver;
	private String option;
	private TestDataReader reader = new TestDataReader();
	
	private HashMap<String, Map<String, String>> _hashCustomers = new HashMap<String, Map<String, String>>();
	private HashMap<String, Map<String, String>> _hashLogins = new HashMap<String, Map<String, String>>();
	ExtentReports report = ExtentReports.get(Collateral360.class);
	static Logger log = Logger.getLogger(Collateral360.class);
	@Parameters({ "browser" })
	
	@BeforeTest
	public void beforeTest(String browser) throws Exception {
		
		ExtentReports report = ExtentReports.get(Collateral360.class);
		report.init("D:\\Softwares\\downloads\\extentreports-java-1.41.jar\\CustomizedReport.html", true);
		
		report.startTest("verifyCollateralTitle");
		report.startTest("clickOnCollateralAndAdd");
		report.startTest("saveCollateralInformation");
		
	
		reader.readValue(_hashCustomers,"D:\\Workspace_TestCases\\TestCases\\java\\demo\\DemoTestNG\\resources\\Customers.json");
		reader.readValue(_hashLogins,"D:\\Workspace_TestCases\\TestCases\\java\\demo\\DemoTestNG\\resources\\Login.json");
		
		//browser being initialized/called 
		driver = com.provenir.automation.framework.utility.WebDriverSetUp.getDriver(browser);
		driver.manage().window().maximize();
		PropertyConfigurator
		.configure("src/config/log4j.properties");
	report.log(LogStatus.FAIL, "Browser is UP");
		driver.manage().deleteAllCookies();
		
		com.provenir.automation.framework.helperClass.LoginHelper.loginToPrism(driver,_hashLogins);
		
		report.log(LogStatus.PASS, "Login Successful");

		com.provenir.automation.framework.utility.Util.waitForLoaderToFinish(driver);
		
	
		com.provenir.automation.framework.helperClass.SearchHelper.searchCustomer(driver,_hashCustomers);
	}
	


	
	@Test
	
	public void ExecuteColl() throws InterruptedException{
	
		
		collateral.clickOnCollateralAndAdd();
		collateral.verifyCollateralTitle();
	
	collateral.saveCollateralInformation();
	}
	
	@AfterTest
	
	public void afterTest() {
//		driver.close();
//		driver.quit();
//		System.gc();
	}

	
	
}
