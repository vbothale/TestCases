package utility;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.google.common.base.Strings;

public class TestCaseExecutor {

	public static WebDriver driver;
	private final static Logger log = Logger.getLogger(TestCaseExecutor.class);
	public static String applicationUrl;

	@Parameters({ "browser" })
	@BeforeTest
	public void setUp(String browser) {
		try {

			driver = WebDriverSetUp.getDriver(browser);
			System.out.println(browser);
		//	applicationUrl = TestDataReader.readValue(_hashEnv,"C:\\Workspace_QA\\TestCases\\java\\demo\\DemoTestNG\\resources\\Env.json");
			driver.get(applicationUrl);
			System.out.println(applicationUrl);

			// This line is added to deal with SSL certificate.
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
	
	// Execute each method from specified class
	public void executeTestCase(Object obj) throws Exception {

		try {
			StringBuffer testCaseMessage = new StringBuffer();
			Method[] methods = TestCaseSorter.getDeclaredMethods(obj
					.getClass());

			for (Method method : methods) {

				String message = null;
				try {
					message = (String) method.invoke(obj, new Object[] {});
				} catch (Exception e) {
					message = e.getCause().getMessage();
				}

				Test ann = method
						.getAnnotation(Test.class);

				Reporter.log("\nStep Name :- " + method.getName());
//				Reporter.log("\nDescription:- " + ann.stepDescription());
//				Reporter.log("\nExpected:- " + ann.expectedResult());

				if (!Strings.isNullOrEmpty(message)) {
					testCaseMessage.append(message);

					Reporter.log("\nStatus:- Fail");
					this.takeScreenShot(method.getName());
					Reporter.log("\nActual:-" + message);
//					if (!ann.continueAfterFailure()) {
//						Assert.fail(testCaseMessage.toString());
//					}
//				} else {
//					Reporter.log("\nStatus:- Pass");
//				}
				Reporter.log("\n");
			}

			if (testCaseMessage.length() != 0) {
				Assert.fail(testCaseMessage.toString());
			}

			}
		}
			catch (Exception e) {
			log.error(e.getMessage());
		}
	}
	
	private void takeScreenShot(String testName) {
		File file = null;
		try {
			System.out.println("Failed test");
			file = new File("test-output/screenshots/" + testName + ".jpg");

			Reporter.log("Screenshot saved at " + file.getAbsolutePath());
			// + "\\reports\\" + testName + ".jpg");

			Reporter.log("<a href='../" + testName + ".jpg' <img src='../"
					+ testName + ".jpg' height='100' width='100'/> </a>");

			File scrnsht = ((TakesScreenshot) TestCaseExecutor.driver)
					.getScreenshotAs(OutputType.FILE);

			FileUtils.copyFile(scrnsht, file);

		} catch (IOException e) {
			log.error(e.getMessage());
		}
	}

}
