package customer;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import utility.TestStepDetails;
import Page.LoginPage;
import static Page.TestCasesDriver.localProperties;
import static utility.TestDataReader.*;

public class Customer360 extends
org.testng.reporters.EmailableReporter{
	
	LoginPage loginPage;
	
	public Customer360(WebDriver driver) {
		loginPage = new LoginPage(driver);
	}
	
	static Logger log = Logger.getLogger(Customer360.class);
	
	@TestStepDetails(continueAfterFailure = false, expectedResult = "On clicking New Credit Request link Credit Summary screen should be displayed.", stepDescription = "Verify the login functionality and click on New Credit Request link")
	public void step_001_verifySuccessfullogin() {
		log.info("Verify the login functionality");
	}

}
