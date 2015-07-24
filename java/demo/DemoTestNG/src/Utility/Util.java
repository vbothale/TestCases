package Utility;

import helper.GenericHelper;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Util {
	private static List<WebElement> lstElements = new ArrayList<WebElement>();

	public static void waitForLoaderToFinish(WebDriver driver) {
		try {
			new WebDriverWait(driver, 180).until(ExpectedConditions
					.invisibilityOfElementLocated(By
							.xpath(".//img[contains(@src,'loader.gif')]")));
			// System.out.println("loader no longer exists");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public static void enableAllDropdowns(WebDriver driver) {

		Actions action = new Actions(driver);
		lstElements = driver.findElements(By
				.xpath(".//span[@class='ui-combobox notYetBind']/a"));
		for (WebElement element : lstElements) {
			action.moveToElement(element).build().perform();
			driver.manage().timeouts()
					.implicitlyWait(70, TimeUnit.MILLISECONDS);
		}
		driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
	}

	public static void selectItemFromList(String customName, String option,
			WebDriver driver) {
		try {
			WebElement searchTxtBox = driver.findElement(By
					.cssSelector("input[customname='" + customName + "']"));

			searchTxtBox.clear();
			searchTxtBox.sendKeys(option);
			GenericHelper.waitForElementPresent(
					By.xpath(".//ul[@customid='" + customName + "']/li[1]"), 5,
					driver);

			driver.findElement(
					By.xpath(".//ul[@customid='" + customName + "']/li[1]"))
					.click();
		} catch (Exception e) {
			e.printStackTrace();
		}
		driver.manage().timeouts().implicitlyWait(0, TimeUnit.MILLISECONDS); // nullify
		// implicitlyWait()
	}

	public static WebElement waitForElementPresent(By locator, int timeout,
			WebDriver driver) {
		try {
			driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS); // nullify
			// implicitlyWait()
			WebDriverWait wait = new WebDriverWait(driver, timeout);
			wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static WebElement waitForElement(final WebElement locator,
			int timeOutInSeconds, WebDriver driver) {
		WebElement element;
		try {
			driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS); // nullify
																			// implicitlyWait()

			WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
			element = wait.until(ExpectedConditions.visibilityOf(locator));

			return element; // return the element
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	// Get Current date
	public static String getCurrentDate() {
		Calendar cal = Calendar.getInstance();
		DateFormat dForm = new SimpleDateFormat("yyyy-MM-dd");
		return dForm.format(cal.getTime());
	}

	// Get Current Year
	public static String getCurrentYear() {
		Calendar cal = Calendar.getInstance();
		DateFormat dForm = new SimpleDateFormat("yyyy");
		return dForm.format(cal.getTime());
	}

	public static void scrollDown(WebDriver driver) {
		((JavascriptExecutor) driver).executeScript("window.scrollBy(0, 200)");
	}

	public static void scrollUp(WebDriver driver) {
		((JavascriptExecutor) driver).executeScript("window.scrollBy(0, -200)");
	}

	public static void selectCheckBox(String checkBoxname, int j,
			WebDriver driver) {
		for (int i = 0; i <= j; i++) {
			driver.findElement(By.name((checkBoxname + i))).click();
		}
	}

}
