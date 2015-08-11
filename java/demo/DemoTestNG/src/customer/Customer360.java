package customer;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import utility.Test;
import utility.TestDataReader;
import Page.LoginPage;
import static utility.TestDataReader.*;

public class Customer360 extends
org.testng.reporters.EmailableReporter{
	
	LoginPage loginPage;
	private TestDataReader reader = new TestDataReader();
	
	private HashMap<String, Map<String, String>> _hashCustomers = new HashMap<String, Map<String, String>>();
	private HashMap<String, Map<String, String>> _hashLogins = new HashMap<String, Map<String, String>>();
	
	public Customer360(WebDriver driver) {
		loginPage = new LoginPage(driver);
	}
	
	static Logger log = Logger.getLogger(Customer360.class);
	
	
	
	@Test
	public void step_001_verifySuccessfullogin() {
		log.info("Verify the login functionality");
		reader.readValue(_hashCustomers,"C:\\Movies\\TestCases\\java\\demo\\DemoTestNG\\resources\\Customers.json");
		reader.readValue(_hashLogins,"C:\\Movies\\TestCases\\java\\demo\\DemoTestNG\\resources\\Login.json");
		
	}

}
