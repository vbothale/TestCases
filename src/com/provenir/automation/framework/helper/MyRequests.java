package com.provenir.automation.framework.helper;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.provenir.automation.framework.utility.Util;

public class MyRequests {

	WebDriver driver;

	public MyRequests(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.XPATH, using = ".//*[@id='rightContent']/div[@class='green_section']/div[1]/h2")
	private WebElement myDashboardTitle;

	@FindBy(how = How.XPATH, using = ".//table[@class='scroll tableGrid']/tbody/tr[1]/td[2]")
	private WebElement customerRecord;

	@FindBy(how = How.XPATH, using = "//*[@id='data_content']/div/table/tbody/tr[1]/td[1]")
	private WebElement expandIcon;

	@FindBy(how = How.XPATH, using = "//*[@id='data_content']/div/table/tbody/tr[2]/td/div/div/div/div[1]")
	private WebElement lendingProcessTitle;

	@FindBy(how = How.XPATH, using = ".//*[@name='rmDasbrd']/span")
	private WebElement clickMyDashboard;

	@FindBy(how = How.XPATH, using = ".//*[@id='data_content']/div/table/tbody/tr[1]/td[3]/a")
	private WebElement clickReqOnDashboard;

	@FindBy(how = How.XPATH, using = ".//*[@id='data_content']/div/table/tbody/tr[1]/td[2]/a")
	private WebElement clickCustomerOnDashboard;

	@FindBy(how = How.XPATH, using = ".//*[@id='data_content']/div/table/tbody/tr[1]/td[4]/a")
	private WebElement clickFacilityOnDashboard;

	@FindBy(how = How.ID, using = "home")
	private WebElement homeLink;

	private String dashboardRows = "//*[@id='data_content']/div/table/tbody/tr";

	/*
	 * Service
	 */
	public void customerDetail() {
		customerRecord.click();

	}

	public String getMyDashboardTitle() {
		Util.waitForAJAX(driver);
		return myDashboardTitle.getText();
	}

	public int getCountOfAddedCustomerRows(String creditName) {
		List<WebElement> listRows = driver
				.findElements(By.xpath(dashboardRows));
		int cnt = 0;
		for (int i = 1; i <= listRows.size(); i++) {
			WebElement element = driver.findElement(By.xpath(dashboardRows
					+ "[" + i + "]/td[3]"));
			if (element.getText().equals(creditName)) {
				cnt++;
			}
		}
		return cnt;

	}

	public int getCountOfAddedCustomerName(String customerName) {
		List<WebElement> listRows = driver
				.findElements(By.xpath(dashboardRows));
		int cnt = 0;
		for (int i = 1; i <= listRows.size(); i++) {
			WebElement element = driver.findElement(By.xpath(dashboardRows
					+ "[" + i + "]/td[2]"));
			if (element.getText().equals(customerName)) {
				cnt++;

			}
		}
		return cnt;

	}

	public void clickExpandIcon() {
		expandIcon.click();
		Util.waitForAJAX(driver);

	}

	public boolean getLendingProcessTitle(String lendingProcess) {
		Util.waitForElement(driver, lendingProcessTitle, 10);

		String title = lendingProcessTitle.getText();
		String[] temp;
		String delimiter = ": ";
		temp = title.split(delimiter);
		System.out.println("**Passed string" + lendingProcess);
		System.out.println("***" + title);
		System.out.println("***temp" + temp);

		for (int i = 0; i < temp.length; i++) {

			if (temp[i].equalsIgnoreCase(lendingProcess)) {
				return true;
			}

		}

		return false;

	}

	public boolean getFacilityName(String oldFacilityName) {
		List<WebElement> listRows = driver
				.findElements(By.xpath(dashboardRows));

		for (int i = 1; i <= listRows.size(); i++) {
			WebElement addedFacilityName = driver.findElement(By
					.xpath(dashboardRows + "[" + i + "]/td[4]"));

			if (addedFacilityName.getText().equals(oldFacilityName)) {
				return true;
			}
		}

		return false;
	}

	public void clickDshboardLnk() {
		clickMyDashboard.click();
		Util.waitForAJAX(driver);
		Util.waitForAJAX(driver);
	}

	public void clickReqOnDashboard() {
		Util.waitForAJAX(driver);
		Util.waitForElement(driver, clickReqOnDashboard, 20);
		clickReqOnDashboard.click();
		Util.waitForAJAX(driver);
	}

	public void clickCustomerOnDashboard() {
		Util.waitForAJAX(driver);
		Util.waitForElement(driver, clickCustomerOnDashboard, 20);
		clickCustomerOnDashboard.click();
		Util.waitForAJAX(driver);
	}

	public void clickFacilityOnDashboard() {
		Util.waitForAJAX(driver);
		Util.waitForElement(driver, clickFacilityOnDashboard, 20);
		clickFacilityOnDashboard.click();
		Util.waitForAJAX(driver);
	}

	public AdminPage clickHomeLink() {
		Util.waitForElement(driver, homeLink, 10);
		homeLink.click();
		Util.waitForAJAX(driver);
		return new AdminPage(driver);
	}

	public TransactionInfoPage clickHomePage() {
		Util.waitForElement(driver, homeLink, 10);
		homeLink.click();
		Util.waitForAJAX(driver);
		return new TransactionInfoPage(driver);
	}

}
