package com.provenir.automation.framework.utility;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.PropertyConfigurator;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.provenir.automation.framework.utility.TestDataReader;
import com.provenir.automation.framework.utility.TestCaseInitializer;
import com.provenir.automation.framework.utility.WebDriverSetUp;

public class TestCaseInitializer {

	protected static WebDriver driver;
	private final static Logger log = Logger.getLogger(TestCaseInitializer.class);
	public static Properties localProperties = new Properties();
	public static String applicationUrl;
	public static TestDataReader reader = new TestDataReader();
	public static String browserValue;

	public TestCaseInitializer() {
		setUp(browserValue);
	}
	
	@BeforeTest
	@Parameters({ "browser"})
	public void setUp(String browserValue) {
		try {
			driver = WebDriverSetUp.getDriver(browserValue);

			driver.get(applicationUrl);

			if (driver instanceof InternetExplorerDriver) {
				driver.navigate()
						.to("javascript:document.getElementById('overridelink').click()");
			}

			driver.manage().window().maximize();
		
		} catch (Exception e) {
			log.error(e.getMessage());
		}
	}

	@AfterTest
	public static void tearDown() {
		driver.close();
		driver.quit();
		System.gc();
	}


	@BeforeSuite
	public void initialize() throws IOException, FileNotFoundException {
		File env = new File("src/com/provenir/automation/framework/config/Env.properties");

		localProperties.load(new FileReader(env));
		
		applicationUrl = localProperties.getProperty("QA");
		System.out.println("url	=	" + applicationUrl);

		PropertyConfigurator
				.configure("src/com/provenir/automation/framework/config/log4j.properties");
	}
	

}
