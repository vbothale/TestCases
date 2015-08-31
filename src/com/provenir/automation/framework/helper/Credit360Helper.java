package com.provenir.automation.framework.helper;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.provenir.automation.framework.utility.Util;

public class Credit360Helper {

	WebDriver driver;

	public Credit360Helper(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.ID, using = "credBorr")
	private WebElement creditBorrowerLink;

	@FindBy(how = How.XPATH, using = ".//*[@id='credBorrowers']/a")
	private WebElement addBtnOfCreditBorrower;

	@FindBy(how = How.XPATH, using = ".//*[@id='SEARCHCUSTFORM']/input[5]")
	private WebElement srchBorrower;

	@FindBy(how = How.ID, using = "imgBtn")
	private WebElement imgBtn;

	@FindBy(how = How.ID, using = "selCustomer")
	private WebElement selectedCustomer;

	@FindBy(how = How.XPATH, using = "//span[contains(.,'Select')]")
	private WebElement selectBtnOnCreditBorrower;

	@FindBy(how = How.XPATH, using = "//span[contains(.,'Save')]")
	private WebElement saveBtnOnCreditBorrower;

	public void clickCreditBorrowerAndAdd() {
		Util.waitForAJAX();
		Util.scrollDown();
		Util.waitForElement(creditBorrowerLink, 20);
		creditBorrowerLink.click();
		Util.waitForLoaderToFinish();
		Util.waitForAJAX();
		Util.waitForElement(addBtnOfCreditBorrower, 20);
		addBtnOfCreditBorrower.click();
		Util.waitForLoaderToFinish();
	}

	public void saveGuarantor() {
		Util.waitForAJAX();
		Util.waitForElement(srchBorrower, 20);
		srchBorrower.sendKeys("intex");
		imgBtn.click();
		Util.waitForLoaderToFinish();
		Util.waitForAJAX();
		Util.waitForElement(selectedCustomer, 20);
		selectedCustomer.click();
		selectBtnOnCreditBorrower.click();
		Util.waitForLoaderToFinish();
		Util.waitForElement(saveBtnOnCreditBorrower, 20);
		saveBtnOnCreditBorrower.click();
		Util.waitForLoaderToFinish();
		Util.waitForAJAX();
	}

}
