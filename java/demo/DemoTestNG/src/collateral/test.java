package collateral;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

public class test {
	
	WebDriver driver;
	
	@Parameters({ "browser" })
	@BeforeTest
	public void beforeTest(String browser) throws Exception {
		
		driver = utility.WebDriverSetUp.getDriver(browser);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.get("http://www.google.com");
		System.out.println("Google.......................");
	}

}
