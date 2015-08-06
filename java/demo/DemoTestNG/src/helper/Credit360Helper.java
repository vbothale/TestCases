package helper;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import utility.Util;

public class Credit360Helper {

	public void clickOnAdvanceSearchLink(WebDriver driver) {
		Util.waitForAJAX(driver);
		Util.waitForElementPresent(By.id("advLink"), 20, driver);
		driver.findElement(By.id("advLink")).click();
		Util.waitForLoaderToFinish(driver);
	}

	public void enterRequestType(WebDriver driver, String option) {
		Util.enableAllDropdowns(driver);
		Util.waitForElementPresent(
				By.xpath("//input[@customname='advSrchTyp']"), 20, driver);
		String str = "advSrchTyp";
		option = "Request Search";
		Util.selectItemFromList(str, option, driver);
	}
	
	public void enterCreditNameAndSubmit(WebDriver driver)
	{
		Util.waitForAJAX(driver);
		Util.waitForElementPresent(By.xpath("//input[contains(@name,'advSrchIp0')]"), 20, driver);
		driver.findElement(By.xpath("//input[contains(@name,'advSrchIp0')]")).sendKeys("Credit 1234");
		driver.findElement(By.id("submitCrt")).click();
		Util.waitForLoaderToFinish(driver);
	}
	
	public void clickOnSearchedReqOnGrid(WebDriver driver)
	{
		
	}

}
