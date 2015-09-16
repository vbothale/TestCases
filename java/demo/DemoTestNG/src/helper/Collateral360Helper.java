package helper;

import java.util.Enumeration;
import java.util.NoSuchElementException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.*;

import org.testng.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebDriver;







import utility.*;

public class Collateral360Helper {
	
	Properties prop = null;

	
	public void Propertyfile(){
		File file = new File

				("D:\\Workspace_TestCases\\TestCases\\java\\demo\\DemoTestNG\\src\\collateral\\CollateralLocators.properties");
			   Properties prop = new Properties();
				  //Creating InputStream object to read data
		   FileInputStream objInput = null;
				   try {
		   objInput = new FileInputStream(file);
				    //Reading properties key/values in file
			   prop.load(objInput);
				objInput.close();
				    } catch (FileNotFoundException e) {
				     System.out.println(e.getMessage());   
				    } catch (IOException e) {
				   System.out.println(e.getMessage());
				  }
}
//	@FindBy(how = How.XPATH, using = ".//*[@id='ctrl']")
//	public WebElement collateralLink;
	
	public void collateralAdd(WebDriver driver) {
		Util.waitForLoaderToFinish(driver);
		driver.findElement(By.id((prop.getProperty("Address")))).click();
		Util.scrollDown(driver);
		Util.waitForLoaderToFinish(driver);
		Util.waitForAJAX(driver);
	}

	public void clickOnAddBtn(WebDriver driver) {
		Util.waitForAJAX(driver);
		driver.findElement(By.id("ctrl")).click();
		Util.waitForElementPresent(By.xpath(".//*[@id='clientCollateral']/div/a"), 30, driver);
		driver.findElement(By.xpath(".//*[@id='clientCollateral']/div/a")).click();

	}


	public void verifyCollateralTitle(WebDriver driver) {
		Util.waitForLoaderToFinish(driver);
		Util.waitForElementPresent(By.xpath(prop.getProperty("collateral")), 60, driver);
		Util.waitForLoaderToFinish(driver);
		String title = driver.findElement(By.xpath(".//*[@id='c360r']"))
				.getText().trim();
		Boolean isFound = IsElementPresent(driver, By.xpath(".//*[@id='c360r']"));
//			Assert.assertEquals("Basic Collateral Information", title);
			Assert.assertTrue(isFound);
	}

	public Boolean IsElementPresent(WebDriver driver, By by) {
        try
        {
            driver.findElement(by);
            return true;
        }
        catch (NoSuchElementException e) { return false; 
        }
    }
	public void enterCollateralName(WebDriver driver) {
		Util.waitForLoaderToFinish(driver);
		Util.waitForElementPresent(By.id("collAccName"), 40, driver);
		driver.findElement(By.id("collAccName")).sendKeys("Test collateral");
	}

	public void enterColateralCode(WebDriver driver) {
		driver.findElement(By.id("collCd")).sendKeys("coll1");
	}

	public void selectCollateralType(WebDriver driver, String option)
			throws InterruptedException {
		
		Util.enableAllDropdowns(driver);
		Util.waitForLoaderToFinish(driver);
		Util.waitForElementPresent(
				By.xpath("//input[contains(@customname,'collType')]"), 20,
				driver);
		String str = "collType";
		option = "Deposits";
		Util.selectItemFromList(str, option, driver);

	}

	public void selectCollateralSubType(WebDriver driver, String option) {
		Util.enableAllDropdowns(driver);
		Util.waitForLoaderToFinish(driver);
		Util.waitForElementPresent(
				By.xpath("//input[contains(@customname,'collSubType')]"), 20,
				driver);
		String str = "collSubType";
		option = "Deposit Account, External";
		Util.selectItemFromList(str, option, driver);
	}

	public void enterCollateralOwnerName(WebDriver driver) {
		Util.waitForLoaderToFinish(driver);
		driver.findElement(By.id("ownerName")).sendKeys("intex");
		Util.scrollUp(driver);
		driver.findElement(By.id("ownSearch")).click();

		Util.waitForLoaderToFinish(driver);
		Util.waitForElementPresent(
				By.xpath(".//*[@id='partySrchRes']//span[contains(.,'Load')]"),
				40, driver);
		driver.findElement(
				By.xpath(".//*[@id='partySrchRes']//span[contains(.,'Load')]"))
				.click();
	
		Util.waitForAJAX(driver);
	}

	public void enterCollateralPercentage(WebDriver driver) {
		Util.waitForLoaderToFinish(driver);
		driver.findElement(By.id("ownerPer")).sendKeys("100");
	}

	public void setPrimaryCollateralOwner(WebDriver driver) {
		driver.findElement(By.id("selectPrimaryOwner")).click();
	}

	public void clickOnSaveCollateral(WebDriver driver) {
		driver.findElement(By.id("savecolldetails")).click();
		Util.waitForLoaderToFinish(driver);
		if(driver.findElement(By.id("useCurrentCust")).isDisplayed())
		{
			driver.findElement(By.id("useCurrentCust")).click();
			Util.waitForLoaderToFinish(driver);
		}
		Util.waitForAJAX(driver);
	}
	
	

}
