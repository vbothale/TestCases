package com.provenir.automation.framework.utility;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.base.Function;
import com.provenir.automation.framework.utility.Util;

public class Util {

	WebDriver driver;

	public static final int DEFAULT_ELEMENT_WAIT = 5;
	public static final int DEFAULT_PAGE_WAIT = 5;
	public static final int DEFAULT_AJAX_WAIT = 10;
	public static final int DEFAULT_PAGE_LOAD = 20;

	private static List<WebElement> lstElements = new ArrayList<WebElement>();
	private final static Logger log = Logger.getLogger(Util.class);

	@Deprecated
	public static void clickLink(WebDriver driver, WebElement webElement) {
		((JavascriptExecutor) driver).executeScript("arguments[0].click()",
				webElement);
	}

	@Deprecated
	public static void clickButton(WebDriver driver, WebElement webElement) {
		((JavascriptExecutor) driver).executeScript("arguments[0].click()",
				webElement);
	}

	/**
	 * Waits for the completion of Ajax jQuery processing by checking
	 * "return jQuery.active == 0" condition.
	 */
	public static boolean waitForAJAX(WebDriver driver) {
		boolean jQcondition = false;
		try {
			driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS); // nullify
																			// implicitlyWait()
			new WebDriverWait(driver, DEFAULT_AJAX_WAIT) {
			}.until(new ExpectedCondition<Boolean>() {

				@Override
				public Boolean apply(WebDriver driverObject) {
					return (Boolean) ((JavascriptExecutor) driverObject)
							.executeScript("return jQuery.active == 0");
				}
			});
			jQcondition = (Boolean) ((JavascriptExecutor) driver)
					.executeScript("return jQuery.active == 0");
			driver.manage().timeouts()
					.implicitlyWait(DEFAULT_PAGE_WAIT, TimeUnit.SECONDS); // reset
																			// implicitlyWait
			return jQcondition;
		} catch (Exception e) {
			log.error(e.getMessage());
		}
		return jQcondition;
	}

	/**
	 * Wait for the element to be present in the DOM, and displayed on the page.
	 * And returns the first WebElement using the given method.
	 * 
	 * @return
	 * 
	 */

	public static void waitForElementToLoad(WebDriver driver) {
		List<WebElement> ele = driver.findElements(By.xpath("//div"));

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				.withTimeout(30, TimeUnit.SECONDS)
				.pollingEvery(DEFAULT_PAGE_LOAD, TimeUnit.MILLISECONDS)
				.ignoring(NoSuchElementException.class);

		WebElement e = wait.until(new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver driver) {
				return driver.findElement(By
						.xpath("//img[contains(@src,'loader.gif')]"));
			}
		});

	}

	/**
	 * Wait for the element to be present in the DOM, and displayed on the page.
	 * And if not it again checks for the element using the given method.
	 * 
	 * @return
	 * 
	 */

	public static WebElement waitForElementPresent(WebDriver driver,
			By locator, int timeout) {
		try {
			driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS); // nullify
			// implicitlyWait()
			WebDriverWait wait = new WebDriverWait(driver, timeout);
			wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		} catch (Exception e) {
			log.error(e.getMessage());
		}
		return null;
	}

	/**
	 * Wait for the element to be present in the DOM, regardless of being
	 * displayed or not. And returns the first WebElement using the given
	 * method.
	 */
	public static WebElement waitForElement(WebDriver driver,
			final WebElement locator, int timeOutInSeconds) {
		WebElement element;
		try {
			driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS); // nullify
																			// implicitlyWait()
			
			WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
//			new WebDriverWait(driver,100).until(ExpectedConditions.visibilityOf(locator));
			element = wait.until(ExpectedConditions.visibilityOf(locator));

			return element; // return the element
		} catch (Exception e) {
			log.error(e.getMessage());
		}
		return null;
	}
	
	public static void waitForElementToPresent(WebDriver driver,
			final WebElement locator, int timeOutInSeconds) {
		WebElement element;
		try {
			driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
			new WebDriverWait(driver,timeOutInSeconds).until(ExpectedConditions.visibilityOf(locator));
			
			final By locators = null;
			new WebDriverWait(driver, 180).until(ExpectedConditions
					.invisibilityOfElementLocated(locators));
			
		} catch (Exception e) {
			log.error(e.getMessage());
		}
	}

	/**
	 * Get Current date
	 * 
	 * @return String format (yyyy-MM-dd)
	 */
	public static String getCurrentDate() {
		Calendar cal = Calendar.getInstance();
		DateFormat dForm = new SimpleDateFormat("yyyy-MM-dd");
		return dForm.format(cal.getTime());
	}

	/**
	 * Get Current Year
	 * 
	 * @return String format (yyyy)
	 */
	public static String getCurrentYear() {
		Calendar cal = Calendar.getInstance();
		DateFormat dForm = new SimpleDateFormat("yyyy");
		return dForm.format(cal.getTime());
	}

	/**
	 * Enable all searchable dropdowns to generate customname and customid
	 */
	public static void enableAllDropdowns(WebDriver driver) {
		Actions action = new Actions(driver);
		lstElements = driver.findElements(By
				.xpath(".//span[@class='ui-combobox notYetBind']/a"));
		for (WebElement element : lstElements) {
			action.moveToElement(element).build().perform();
			driver.manage().timeouts()
					.implicitlyWait(70, TimeUnit.MILLISECONDS);
		}
		driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS); // nullify
																		// implicitlyWait()
	}

	/**
	 * Select option from searchable dropdown
	 * 
	 * @param customName
	 *            : custom name of searchable dropdown
	 * @param option
	 *            : value to select
	 */
	public static void selectItemFromList(WebDriver driver, String customName,
			String option) {
		try {
			WebElement searchTxtBox = driver.findElement(By
					.cssSelector("input[customname='" + customName + "']"));

			searchTxtBox.clear();
			searchTxtBox.sendKeys(option);
			Util.waitForElementPresent(driver,
					By.xpath(".//ul[@customid='" + customName + "']/li[1]"), 5);

			driver.findElement(
					By.xpath(".//ul[@customid='" + customName + "']/li[1]"))
					.click();
		} catch (Exception e) {
			e.printStackTrace();
		}
		driver.manage().timeouts().implicitlyWait(0, TimeUnit.MILLISECONDS); // nullify
		// implicitlyWait()
	}

	/**
	 * Select option value from simple dropdown
	 * 
	 * @param locator
	 *            : Location of DDL field
	 * @param option
	 *            : Value To Select
	 */
	public static void selectItemFromList(WebDriver driver, WebElement locator,
			String option) {
		waitForElement(driver, locator, 10);
		Select select = new Select(locator);
		select.selectByVisibleText(option);
	}

	public static void selectCheckBox(WebDriver driver, String checkBoxname,
			int j) {

		for (int i = 0; i <= j; i++) {
			driver.findElement(By.name((checkBoxname + i))).click();
		}

	}

	public static void scrollDown(WebDriver driver) {
		((JavascriptExecutor) driver).executeScript("window.scrollBy(0, 200)");
	}

	public static void scrollBottom(WebDriver driver) {
		((JavascriptExecutor) driver)
				.executeScript("window.scrollTo(0,document.body.scrollHeight)");
	}
	
	public static void scollTop(WebDriver driver)
	{
		((JavascriptExecutor) driver)
		.executeScript("document.body.scrollTop = document.documentElement.scrollTop = 0;");
	}

	public static void scrollUp(WebDriver driver) {
		((JavascriptExecutor) driver).executeScript("window.scrollBy(0, -200)");
	}

	public static void waitForLoaderToFinish(WebDriver driver) {
		try {
			// new WebDriverWait(driver, 180).until(ExpectedConditions
			// .invisibilityOfElementLocated(By
			// .xpath(".//img[contains(@src,'loader.gif')]")));
			
			WebElement ele = driver.findElement(By.xpath(".//*[@id='container']/div[11]/img"));

			new WebDriverWait(driver,100).until(ExpectedConditions.visibilityOf(ele));
			
			new WebDriverWait(driver, 180).until(ExpectedConditions
					.invisibilityOfElementLocated(By
							.xpath(".//*[@id='container']/div[11]/img")));

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	

	public static void waitForElementToDisplayed(WebDriver driver) {
		try {
			waitForAJAX(driver);
			new WebDriverWait(driver, 180).until(ExpectedConditions
					.presenceOfElementLocated(By
							.xpath("//div[@class='left_T_cor']")));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public static boolean isPageLoaded(WebDriver driver) {
		boolean b = false;
		try {
			if (WebDriverSetUp.getDriver(BrowserType.IE) != null) {
				List<WebElement> elements = driver.findElements(By
						.xpath("//div"));
				if (elements.size() > 0) {
					waitForAJAX(driver);
					waitForLoaderToFinish(driver);
					return b = true;
				}
			} else
				waitForLoaderToFinish(driver);
		} catch (IOException e) {

			e.printStackTrace();
		}

		// //Global variable for browser..
		/*
		 * if(browserVar == "IE"){ wait for number of records > 0 } else{ put
		 * existing conddition for FF and chrome }
		 */
		return b;
	}

	public static void waitForWorkflowToLoad(WebDriver driver) {
		try {
			new WebDriverWait(driver, 180).until(ExpectedConditions
					.invisibilityOfElementLocated(By
							.xpath(".//*[@id='loader']/img")));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public static void selectOptionFromDropDown(WebDriver driver,
			String customName, String option) {

		try {

			WebElement searchTxtBox = driver.findElement(By
					.cssSelector("input[name='" + customName + "']"));

			searchTxtBox.clear();
			searchTxtBox.sendKeys(option);

			WebElement ele = driver.findElement(By.xpath(".//ul[@customid='"
					+ customName + "']/li[1]"));
			Select select = new Select(ele);
			select.selectByVisibleText(option);
			ele.click();

		} catch (Exception e) {
			e.printStackTrace();
		}
		driver.manage().timeouts().implicitlyWait(0, TimeUnit.MILLISECONDS); // nullify
		// implicitlyWait()
	}

}
