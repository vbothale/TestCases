package prism_demo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;


public class BrowserHelper {
	public static WebDriver openBrowser(String browser, WebDriver driver) throws Exception {
		try {
			if (browser.equalsIgnoreCase("Firefox")) {
				driver = new FirefoxDriver();
			} else if (browser.equalsIgnoreCase("chrome")) {
				System.setProperty("webdriver.chrome.driver",
						"C:/Dev/Jars/chromedriver.exe");
				driver = new ChromeDriver();
			} else if (browser.equalsIgnoreCase("IE")) {
				System.setProperty("webdriver.ie.driver",
						"C:/Dev/Jars/IEDriverServer.exe");
				driver = new InternetExplorerDriver();
			}

		} catch (WebDriverException e) {
			System.out.println(e.getMessage());
		}
		return driver;
	}

}
