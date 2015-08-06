package helper;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import utility.Util;

public class Customer360Helper {

	public void clickAddress(WebDriver driver) {
		Util.waitForElementPresent(By.id("addr"), 20, driver);
		driver.findElement(By.id("addr")).click();
		Util.waitForLoaderToFinish(driver);
	}

	public void clickAddBtnOnAddress(WebDriver driver) {
		Util.waitForElementPresent(By.xpath(".//*[@id='clientAddress']/div/a"),
				10, driver);
		driver.findElement(By.xpath(".//*[@id='clientAddress']/div/a")).click();
		Util.waitForLoaderToFinish(driver);
	}

	public void verifyAddressTitle(WebDriver driver) {
		Util.waitForAJAX(driver);
		Util.waitForElementPresent(By.xpath("//h2[contains(.,'Add Address')]"),
				30, driver);
		String title = driver
				.findElement(By.xpath("//h2[contains(.,'Add Address')]"))
				.getText().trim();
		Assert.assertEquals("Add Address", title);
	}

	public void enterAddressType(WebDriver driver, String option) {
		Util.enableAllDropdowns(driver);
		Util.waitForElementPresent(
				By.xpath("//input[contains(@customname,'addrTyp')]"), 20,
				driver);
		String str = "addrTyp";
		option = "Mailing";
		Util.selectItemFromList(str, option, driver);
	}

	public void selectCountry(WebDriver driver, String option) {
		Util.enableAllDropdowns(driver);
		Util.waitForElementPresent(By.xpath("//input[@customname='country']"),
				20, driver);
		String str = "country";
		option = "United States";
		Util.selectItemFromList(str, option, driver);
	}

	public void enterAddressLine1(WebDriver driver) {
		Util.waitForAJAX(driver);
		driver.findElement(By.id("addrLn1")).sendKeys("address line 1");
	}

	public void enterPostalCode(WebDriver driver) {
		Util.waitForAJAX(driver);
		driver.findElement(By.id("postalCd")).sendKeys("10005");
		Util.waitForLoaderToFinish(driver);
	}

	public void enterCity(WebDriver driver) {
		Util.waitForAJAX(driver);
		driver.findElement(By.id("city")).sendKeys("CA");
	}

	public void enterRegion(WebDriver driver, String option) {
		Util.enableAllDropdowns(driver);
		Util.waitForElementPresent(By.xpath("//input[@customname='state']"),
				20, driver);
		String str = "state";
		option = "California";
		Util.selectItemFromList(str, option, driver);
	}

	public void clickSaveOnAddress(WebDriver driver) {
		Util.waitForAJAX(driver);
		driver.findElement(By.xpath("//span[contains(.,'Save')]")).click();
		Util.waitForLoaderToFinish(driver);
		Util.waitForAJAX(driver);
	}

}
