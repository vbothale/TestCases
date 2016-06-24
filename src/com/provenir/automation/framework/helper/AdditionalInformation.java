package com.provenir.automation.framework.helper;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.provenir.automation.framework.utility.Util;

public class AdditionalInformation {

	WebDriver driver;
	Actions actions = null;

	public AdditionalInformation(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	private String quesObligation = "quesOthObli";
	private String quesBankrupt = "quesBussBankRupt";
	private String quesGuarantor = "quesIsGurantToAnyOthr";
	private String quesTaxesOwned = "quesTaxesOwed";
	private String quesAnyDegree = "quesAnyAgreeChgOwnship";
	private String quesBusinessTax = "quesBusiTaxLien";
	private String quesRelatedParty = "quesPratyExeDirPrin";
	private String quesBusinessOwn = "quesBusinessOwnOrLien";

	@FindBy(how = How.XPATH, using = "//h1[contains(.,'Additional Information')]")
	private WebElement additionalInfoTitle;

	@FindBy(how = How.ID, using = "saveBBQuestionaire")
	private WebElement saveOnAdditionalInfo;

	@FindBy(how = How.ID, using = "nextBtn")
	private WebElement nextBtn;

	public boolean verifyAdditionalInformationTitle() {
		Util.waitForAJAX(driver);
		if (additionalInfoTitle.isDisplayed())
			return true;
		else
			return false;
	}

	public void clickSaveOnAdditionalInformation() {
		Util.waitForElement(driver, saveOnAdditionalInfo, 10);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", saveOnAdditionalInfo);
		Util.waitForAJAX(driver);
		Util.waitForLoaderToFinish(driver);
	}

	public SummaryOfApplication clickNextButton() {
		Util.waitForElement(driver, nextBtn, 10);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", nextBtn);
		Util.waitForAJAX(driver);
		Util.waitForLoaderToFinish(driver);
		return new SummaryOfApplication(driver);
	}

	public void selectQuesObligation(String answer) {
		Util.enableAllDropdowns(driver);
		Util.waitForElementPresent(driver, By.xpath(quesObligation), 10);
		Util.selectItemFromList(driver, quesObligation, answer);
	}

	public void selectQuesBankrupt(String answer) {
		Util.selectItemFromList(driver, quesBankrupt, answer);
	}

	public void selectQuesGuarantor(String answer) {
		Util.selectItemFromList(driver, quesGuarantor, answer);
	}

	public void selectQuesTaxesOwned(String answer) {
		Util.selectItemFromList(driver, quesTaxesOwned, answer);
	}

	public void selectQuesOwnership(String answer) {
		Util.selectItemFromList(driver, quesAnyDegree, answer);
	}

}
