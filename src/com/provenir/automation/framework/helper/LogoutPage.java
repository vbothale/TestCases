package com.provenir.automation.framework.helper;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.provenir.automation.framework.utility.Util;

public class LogoutPage {

	WebDriver driver;
	Actions actions = null;

	public LogoutPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.ID, using = "arrow_logout")
	private WebElement logoutArrow;

	@FindBy(how = How.XPATH, using = "//a[@id='logout1']")
	private WebElement logout;



	public LoginPage logoutCL() {
		Actions action = new Actions(driver);
		action.moveToElement(logoutArrow);
		action.click().build().perform();
		logout.click();
		return new LoginPage(driver);
	}

	public AdminPage logout() {
		Actions action = new Actions(driver);
		action.moveToElement(logoutArrow);
		action.click().build().perform();
		logout.click();
		return new AdminPage(driver);
	}

}
