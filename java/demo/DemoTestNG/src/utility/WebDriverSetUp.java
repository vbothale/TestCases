package utility;

import java.io.File;
import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class WebDriverSetUp {

	@SuppressWarnings("null")
	public static WebDriver getDriver(String browserType) throws IOException {
		WebDriver driver = null;

		InternetExplorerDriverService IEservice;
		ChromeDriverService chromeService;
		DesiredCapabilities capabilities;

		switch (browserType) {
		case "Firefox":
			driver = new FirefoxDriver();
			break;

		case "InternetExplorer":
			   File file = new File("src/drivers/IEDriverServer.exe");
			  
			   
			      IEservice = new InternetExplorerDriverService.Builder()
			      .usingDriverExecutable(file).usingAnyFreePort()
			      .build();
			      IEservice.start();
			      
			   //   System.setProperty("webdriver.ie.driver", file.getAbsolutePath());
			      
			      capabilities = DesiredCapabilities.internetExplorer();
			      capabilities
			    .setCapability(
			      InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,
			      true);
			  capabilities.setCapability("ignoreZoomSetting", true);

			      driver = new RemoteWebDriver(IEservice.getUrl(),capabilities);
			      break;

		case "Chrome":
			File fileChrome = new File(
					"src/drivers/chromedriver.exe");
			chromeService = new ChromeDriverService.Builder()
					.usingDriverExecutable(fileChrome).usingAnyFreePort()
					.build();
			chromeService.start();
			capabilities = DesiredCapabilities.chrome();
			driver = new RemoteWebDriver(chromeService.getUrl(), capabilities);

			break;
		default:
			driver = new FirefoxDriver();
			break;

		}
		return driver;
	}

}
