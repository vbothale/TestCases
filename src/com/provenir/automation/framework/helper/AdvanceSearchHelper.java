package com.provenir.automation.framework.helper;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.provenir.automation.framework.utility.Util;

public class AdvanceSearchHelper {

	WebDriver driver;

	public AdvanceSearchHelper(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.ID, using = "advLink")
	private WebElement advanceSearchLink;

	@FindBy(how = How.XPATH, using = "//input[contains(@name,'advSrchIp0')]")
	private WebElement creditName;

	@FindBy(how = How.ID, using = "submitCrt")
	private WebElement submitBtn;
	
	@FindBy(how = How.XPATH, using = "//h2[contains(.,'Credit 360')]")
	private WebElement creditTitle;

	@FindBy(how = How.XPATH, using = ".//*[@id='advSrchResult']/div/div/div[2]/div/table/tbody/tr/td[1]")
	private WebElement reqOnGrid;

	private String advanceSearchType = "advSrchTyp";

	public void clickAdvanceSearchLink() {
		Util.waitForAJAX();
		Util.waitForElement(advanceSearchLink, 20);
		advanceSearchLink.click();
		Util.waitForLoaderToFinish();
	}

	public void enterRequestType(String option) {
		Util.enableAllDropdowns();
		Util.waitForElementPresent(By.xpath(advanceSearchType), 20);
		option = "Request Search";
		Util.selectItemFromList(advanceSearchType, option);
	}

	public void enterCreditNameAndSubmit() {
		Util.waitForAJAX();
		Util.waitForElement(creditName, 20);
		creditName.sendKeys("Credit Req 1234");
		Util.waitForElement(submitBtn, 10);
		submitBtn.click();
		Util.waitForLoaderToFinish();
	}

	public void clickReqOnGrid() {
		Util.waitForAJAX();
		Util.waitForElement(reqOnGrid, 30);
		reqOnGrid.click();
		Util.waitForLoaderToFinish();
	}
	
	public Credit360Helper verifyCreditTitle()
	{
		Util.waitForElement(creditTitle, 20);
		String title = creditTitle.getText().trim();
		Assert.assertEquals("Credit 360", title);
		return new Credit360Helper(driver);
	}

}
