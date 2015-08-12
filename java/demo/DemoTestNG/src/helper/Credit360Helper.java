package helper;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import utility.Util;

public class Credit360Helper {
	
	WebDriver driver;
	
	public Credit360Helper(WebDriver driver)
	{
		this.driver = driver;
	}

	public void verifyCreditTitle() {
		Util.waitForElementPresent(By.xpath("//h2[contains(.,'Credit 360')]"),
				20, driver);
		String title = driver
				.findElement(By.xpath("//h2[contains(.,'Credit 360')]"))
				.getText().trim();
		Assert.assertEquals("Credit 360", title);
	}
	
	public static void clickCreditBorrowerAndAdd(WebDriver driver)
	{
		Util.waitForAJAX(driver);
		Util.waitForElementPresent(By.id("credBorr"), 20, driver);
		driver.findElement(By.id("credBorr")).click();
		Util.waitForLoaderToFinish(driver);
		Util.waitForAJAX(driver);
		Util.waitForElementPresent(By.xpath(".//*[@id='credBorrowers']/a"), 20, driver);
		driver.findElement(By.xpath(".//*[@id='credBorrowers']/a")).click();
		Util.waitForLoaderToFinish(driver);
	}
	
	public static void saveGuarantor(WebDriver driver)
	{
		Util.waitForElementPresent(By.xpath(".//*[@id='rightContent']/div[2]/div[2]/div/div/div/form/input[4]"), 15, driver);
		driver.findElement(By.xpath(".//*[@id='rightContent']/div[2]/div[2]/div/div/div/form/input[4]")).sendKeys("intex");
		driver.findElement(By.id("imgBtn")).click();
		Util.waitForLoaderToFinish(driver);
		Util.waitForAJAX(driver);
		driver.findElement(By.name("selCustomer")).click();
		driver.findElement(By.xpath("//span[contains(.,'Select')]")).click();
		Util.waitForLoaderToFinish(driver);
		driver.findElement(By.xpath("//span[contains(.,'Save')]")).click();
		Util.waitForLoaderToFinish(driver);
		Util.waitForAJAX(driver);
	}

}
