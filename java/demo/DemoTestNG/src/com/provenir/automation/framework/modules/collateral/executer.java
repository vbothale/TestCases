package com.provenir.automation.framework.modules.collateral;


//	import java.util.HashMap;
//	import java.util.Map;
//	import net.sourceforge.htmlunit.corejs.javascript.tools.debugger.Main;
//	import org.apache.log4j.Logger;
//	import org.apache.log4j.PropertyConfigurator;
//	import org.openqa.selenium.WebDriver;
//	import org.openqa.selenium.support.PageFactory;
//	import org.testng.annotations.AfterTest;
//	import org.testng.annotations.BeforeTest;
//	import org.testng.annotations.Parameters;
//	import org.testng.annotations.Test;
//
//	import com.provenir.automation.framework.helperClass.LoginHelper;
//	import com.provenir.automation.framework.utility.TestDataReader;
//	import com.provenir.automation.framework.utility.TestStepDetails;
//	import com.provenir.automation.framework.utility.WebDriverSetUp;
//	import com.relevantcodes.extentreports.ExtentReports;
//	import com.relevantcodes.extentreports.LogStatus;
//
//	public class executer {
//
//		LoginHelper loginPage;
//		Collateral360Helper collateral360Helper;
//		
//		WebDriver driver;
//		private String option;
//		private TestDataReader reader = new TestDataReader();
//		
//		private HashMap<String, Map<String, String>> _hashCustomers = new HashMap<String, Map<String, String>>();
//		private HashMap<String, Map<String, String>> _hashLogins = new HashMap<String, Map<String, String>>();
//		//ExtentReports report = ExtentReports.get(Collateral360.class);
//		static Logger log = Logger.getLogger(Collateral360.class);
//		@Parameters({ "browser" })
//		
//		@BeforeTest
//		public void beforeTest(String browser) throws Exception {
//			
//			//ExtentReports report = ExtentReports.get(Collateral360.class);
////			report.init("D:\\Softwares\\downloads\\extentreports-java-1.41.jar\\CustomizedReport.html", true);
////			
////			report.startTest("verifyCollateralTitle");
////			report.startTest("clickOnCollateralAndAdd");
////			report.startTest("saveCollateralInformation");
//			
//		
//			reader.readValue(_hashCustomers,"D:\\Workspace_TestCases\\TestCases\\java\\demo\\DemoTestNG\\resources\\Customers.json");
//			reader.readValue(_hashLogins,"D:\\Workspace_TestCases\\TestCases\\java\\demo\\DemoTestNG\\resources\\Login.json");
//			
//			//browser being initialized/called 
//			driver = com.provenir.automation.framework.utility.WebDriverSetUp.getDriver(browser);
//			driver.manage().window().maximize();
//			PropertyConfigurator
//			.configure("src/config/log4j.properties");
//	
//			driver.manage().deleteAllCookies();
//			
//			com.provenir.automation.framework.helperClass.LoginHelper.loginToPrism(driver,_hashLogins);
//			
//			//report.log(LogStatus.PASS, "Login Successful");
//
//			com.provenir.automation.framework.utility.Util.waitForLoaderToFinish(driver);
//			
//		
//			com.provenir.automation.framework.helperClass.SearchHelper.searchCustomer(driver,_hashCustomers);
//		}
//		
//		
//		@Test(dependsOnMethods = "clickOnCollateralAndAdd")
//		
//		public void verifyCollateralTitle() throws InterruptedException {
//		
//			log.info("Verify the  Collateral Title");
//		Collateral360Helper.verifyCollateralTitle(driver);
//		//report.log(LogStatus.PASS, "Collectral Title is Successfully verified");
//		System.out.println("test 2");
//		}
//		
//		@Test(dependsOnMethods = "verifyCollateralTitle")
//	//@TestStepDetails(continueAfterFailure = false, expectedResult = "On clicking New Credit Request link Credit Summary screen should be displayed.", stepDescription = "Verify the login functionality and click on New Credit Request link")
//		public void saveCollateralInformation() throws InterruptedException {
//			log.info("Verify the save Collateral Information");
//			Collateral360Helper.enterCollateralName(driver);
//			Collateral360Helper.enterColateralCode(driver);
//			Collateral360Helper.selectCollateralType(driver, option);
//			Collateral360Helper.selectCollateralSubType(driver, option);
//			Collateral360Helper.enterCollateralOwnerName(driver);
//			Collateral360Helper.enterCollateralPercentage(driver);
//			Collateral360Helper.setPrimaryCollateralOwner(driver);
//			Collateral360Helper.clickOnSaveCollateral(driver);
//		//	report.log(LogStatus.PASS, "Collectral Added is Successfully");
//		System.out.println("test 3");
//		}
//
//		@Test
//		public void clickOnCollateralAndAdd() {
//			
//		log.info("Verify the login functionality and clickOnCollateralAndAdd ");
//		collateral360Helper = new Collateral360Helper();
//		collateral360Helper.collateralAdd(driver);
//		collateral360Helper.clickOnAddBtn(driver);
//		
//		//report.log(LogStatus.PASS, "Collectral is Searched");
//		System.out.println("test 1");
//	}
//
//		
//		
//	@AfterTest
//		public void afterTest() {
////			driver.close();
////			driver.quit();
////			System.gc();
//		}
//
//	}

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;


	public class executer {
	
		
		 public SoftAssert softAssert = new SoftAssert();
		 public ExtentTest t;
		 public WebDriver driver;
		 
		 @BeforeTest
		
		public void starttest(){
		ExtentReports report = ExtentReports.get(executer.class);
		// public ExtentReports extent = ExtentManger.getInstance();
		t.log(LogStatus.INFO, "Launching browser");
        driver = new FirefoxDriver();
        
        t.log(LogStatus.INFO, "Navigating to google.com");
        driver.get("http://google.com");
		}
		    @Test(priority=0)
		    public void googleWithoutAssert() {
		    

		            
		        try
		        {
		            driver.findElement(By.cssSelector("input[value*='Google Search']"));
		            t.log(LogStatus.PASS, "Search button displayed");
		        }
		        catch (NoSuchElementException e)
		        {
		            t.log(LogStatus.FAIL, "<pre>" + e.toString() + "</pre>");
		            throw e;
		        }
		    }

		   
		    private Boolean IsElementPresent(WebDriver driver, By by) {
		        try
		        {
		            driver.findElement(by);
		            return true;
		        }
		        catch (NoSuchElementException e) { return false; }
		    }

		    @AfterTest
		    public void afterMethod() {
		    
				//    driver.quit();
		    	
		    	
		    }
		}

