package search_demo;

import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

public class SearchTest {
	private WebDriver driver;
	@Parameters({ "browser" })
	
	@BeforeTest
	public void beforeTest(String browser) throws Exception {
		driver = BrowserHelper.openBrowser(browser, driver);
	}

	@AfterTest
	public void afterTest() {
		driver.quit();
	}

	@Test
	public void testSearchforObama() throws Exception {
		String searchValue = "obama";
		String resultText = "About 543,000,000 results";
		SearchHelper.enterSearchTerm(driver, searchValue, resultText);
	}

	@Test
	public void testSearchforBush() throws Exception {
		String searchValue = "bush";
		String resultText = "About 351,000,000 results";
		SearchHelper.enterSearchTerm(driver, searchValue, resultText);
	}
	
	@Test
	public void testSearchforClinton() throws Exception {
		String searchValue = "clinton";
		String resultText = "About 258,000,000 results";
		SearchHelper.enterSearchTerm(driver, searchValue, resultText);
	}
	 

}
