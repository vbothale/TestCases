package Page;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.PropertyConfigurator;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import utility.TestCaseExecutor;
import utility.TestDataReader;

public class TestCasesDriver extends TestCaseExecutor {

	public static Properties localProperties = new Properties();
//	public static String browser;
//	public static String applicationUrl;
	public static TestDataReader reader = new TestDataReader();
//	public static TestDataReader demofile = new TestDataReader();
	public static String pdfPath;

	// public static File file = new File("Framework/upload/jmeter.pdf");

	@BeforeSuite
	@Parameters({ "environment"})
	public void initialize(
			@Optional("src/resources/DevTestData.properties") String env)
//			@Optional("src/resources/Login.json") String xmlPath)
//			@Optional("src/main/java/com/provenir/automation/framework/config/ProvenirDemoTestData.xml") String newxmlPath)

	throws FileNotFoundException, IOException {
		localProperties.load(new FileInputStream(env));
		applicationUrl = localProperties.getProperty("url");
//		browser = localProperties.getProperty("browser");
//		reader.init(xmlPath);
//		demofile.init(newxmlPath);

		PropertyConfigurator
				.configure("src/main/java/com/provenir/automation/framework/config/log4j.properties");
//		System.out.println(browser);
//		System.out.println(applicationUrl);
	}
	
}
