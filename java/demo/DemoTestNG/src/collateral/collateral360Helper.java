package collateral;

import java.sql.Driver;
import java.lang.*;

import junit.framework.Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebDriver;

public class collateral360Helper {

	public static void collateralAdd(WebDriver driver) {
		GenericHelper.waitForLoaderGifToFinish(driver);
		driver.findElement(By.id("ctrl")).click();
		GenericHelper.waitForLoaderGifToFinish(driver);
	}

	public static void clickOnAddBtn(WebDriver driver) {
		new WebDriverWait(driver, 180)
				.until(ExpectedConditions.visibilityOfElementLocated(By
						.xpath(".//*[@id='addAddrRow2']")));
		driver.findElement(By.id("addAddrRow2")).click();

	}

	@SuppressWarnings("deprecation")
	public static void verifyCollateralTitle(WebDriver driver) {
		new WebDriverWait(driver, 180).until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath(".//*[@id='c360r']")));
		GenericHelper.waitForLoaderGifToFinish(driver);
		String title = driver.findElement(By.xpath(".//*[@id='c360r']"))
				.getText().trim();
		Assert.assertEquals(title, "Basic Collateral Information");
	}

	public static void enterCollateralName(WebDriver driver) {
		GenericHelper.waitForLoaderGifToFinish(driver);
		new WebDriverWait(driver, 180).until(ExpectedConditions
				.visibilityOfElementLocated(By.id("collAccName")));
		driver.findElement(By.id("collAccName")).sendKeys("Test collateral");
	}

	public static void enterColateralCode(WebDriver driver) {
		driver.findElement(By.id("collCd")).sendKeys("coll1");
	}

	public static void selectCollateralType(WebDriver driver) throws InterruptedException {
//		new WebDriverWait(driver, 180).until(ExpectedConditions
//				.visibilityOfElementLocated(By.xpath(".//*[@id='collType']")));
		
		WebElement ele = driver.findElement(By.xpath(".//*[@id='collType']"));
		WebElement ele1 = ele.findElement(By.xpath(".."));
		WebElement ele2 = ele1.findElement(By.xpath(".//input"));
//		Select sel = new Select(driver.findElement(By.xpath("//input[contains(@customname,'collType')]")));
		ele2.sendKeys("Real Estate");
		ele2.wait(3000);
//		ele2.sendKeys(Keys.ARROW_DOWN);
//		ele2.sendKeys(Keys.ENTER);
		GenericHelper.waitForLoaderGifToFinish(driver);

	}

	public static void selectCollateralSubType(WebDriver driver) {
		GenericHelper.waitForLoaderGifToFinish(driver);
		Select sel = new Select(driver.findElement(By.name("collSubType")));
		sel.selectByValue("Automotive Facility");
	}

}
