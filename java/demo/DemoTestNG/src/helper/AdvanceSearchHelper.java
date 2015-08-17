package helper;

import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import utility.Util;
import Page.LoginPage;

public class AdvanceSearchHelper {
	
	WebDriver driver;

	public AdvanceSearchHelper(WebDriver driver) {
		this.driver = driver;
		// TODO Auto-generated constructor stub
	}

	public static void clickOnAdvanceSearchLink(WebDriver driver) {
		Util.waitForAJAX(driver);
		Util.waitForElementPresent(By.id("advLink"), 20, driver);
		driver.findElement(By.id("advLink")).click();
		Util.waitForLoaderToFinish(driver);
	}

	public static void enterRequestType(WebDriver driver, String option) {
		Util.enableAllDropdowns(driver);
		Util.waitForElementPresent(
				By.xpath("//input[@customname='advSrchTyp']"), 20, driver);
		String str = "advSrchTyp";
		option = "Request Search";
		Util.selectItemFromList(str, option, driver);
	}

	public static void enterCreditNameAndSubmit(WebDriver driver) {
		Util.waitForAJAX(driver);
		Util.waitForElementPresent(
				By.xpath("//input[contains(@name,'advSrchIp0')]"), 20, driver);
		driver.findElement(By.xpath("//input[contains(@name,'advSrchIp0')]"))
				.sendKeys("Credit Req 1234");
		Util.waitForElementPresent(By.id("submitCrt"), 20, driver);
		driver.findElement(By.id("submitCrt")).click();
		Util.waitForLoaderToFinish(driver);
	}

	public static void clickReqOnGrid(WebDriver driver) {
		Util.waitForAJAX(driver);
		Util.waitForElementPresent(
				By.xpath(".//*[@id='advSrchResult']/div/div/div[2]/div/table/tbody/tr/td[1]"),
				30, driver);
		driver.findElement(
				By.xpath(".//*[@id='advSrchResult']/div/div/div[2]/div/table/tbody/tr/td[1]"))
				.click();
		Util.waitForLoaderToFinish(driver);
	}
	
	public static Credit360Helper verifyCreditTitle(WebDriver driver) {
	
		Util.waitForElementPresent(By.xpath("//h2[contains(.,'Credit 360')]"),
				20, driver);
		String title = driver
				.findElement(By.xpath("//h2[contains(.,'Credit 360')]"))
				.getText().trim();
		Assert.assertEquals("Credit 360", title);
		
		Boolean isFound = IsElementPresent(driver, By.xpath(".//*[@id='c360r']"));
		Assert.assertEquals("Basic Collateral Information", title);
		Assert.assertTrue(isFound);
		return new Credit360Helper(driver);
	}
	

	public static Boolean IsElementPresent(WebDriver driver, By by) {
        try
        {
            driver.findElement(by);
            return true;
        }
        catch (NoSuchElementException e) { return false; 
        }

		}
}