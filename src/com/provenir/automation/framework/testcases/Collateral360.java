package com.provenir.automation.framework.testcases;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.provenir.automation.framework.helper.Collateral360Helper;
import com.provenir.automation.framework.helper.Customer360Helper;
import com.provenir.automation.framework.helper.LoginPage;
import com.provenir.automation.framework.helper.SearchHelper;
import com.provenir.automation.framework.utility.TestCaseExecutor;
import com.provenir.automation.framework.utility.TestDataReader;

public class Collateral360 extends TestCaseExecutor {

	LoginPage loginPage;
	SearchHelper searchHelper;
	Collateral360Helper collateral360Helper;
	Customer360Helper customer360Helper;

	public TestDataReader reader = new TestDataReader();

	private String option;
	private HashMap<String, Map<String, String>> _hashLogins = new HashMap<String, Map<String, String>>();
	private HashMap<String, Map<String, String>> _hashCustomers = new HashMap<String, Map<String, String>>();
	private HashMap<String, Map<String, String>> _hashReq = new HashMap<String, Map<String, String>>();
	private HashMap<String, Map<String, String>> _hashFacility = new HashMap<String, Map<String, String>>();

	static Logger log = Logger.getLogger(Collateral360.class);

	@BeforeClass
	@Parameters({ "browser" })
	public void beforeMethod(String browserValue) {
		loginPage = new LoginPage(getDriver(browserValue));
		searchHelper = new SearchHelper(getDriver(browserValue));
		collateral360Helper = new Collateral360Helper(getDriver(browserValue));
		customer360Helper = new Customer360Helper(getDriver(browserValue));
	}

	@Test(priority = 0)
	public void test0_landingPage() {
		log.info("Login to Prism and search customer");
		reader.readValue(_hashLogins, "resources/Login.json");
		loginPage.login(_hashLogins);
	}

	@Test(priority = 1)
	public void test1_gotoCollateral360() throws InterruptedException {
		log.info("Click on collateral and Add");
		reader.readValue(_hashCustomers, "resources/Customers.json");
		searchHelper.searchCustomer(_hashCustomers);
		collateral360Helper.clickCollateralLink();
		collateral360Helper.clickOnAddCollateralLink();
		System.out.println("test 0");
	}

	@Test(priority = 2)
	public void test2_verifyCollateralTitle() throws InterruptedException {
		log.info("Click on collateral and Add");
		collateral360Helper.verifyCollateralTitle();
		System.out.println("test 1");
	}

	@Test(priority = 3)
	public void test3_saveCollateralDetails() {
		collateral360Helper.enterCollateralName();
		collateral360Helper.enterCollateralCode();
		collateral360Helper.selectCollType(option);
		collateral360Helper.selectCollSubType(option);
		collateral360Helper.enterCollateralOwnerName();
		collateral360Helper.enterCollateralPercentage();
		collateral360Helper.setPrimaryCollateralOwner();
		collateral360Helper.clickSaveCollateral();
		System.out.println("test 2");
	}

	@Test(priority = 4)
	public void test4_verifyLeftHandNavigationForVehicle() {
		customer360Helper = collateral360Helper.clickBackButton();
		collateral360Helper.clickOnAddBtn();
		collateral360Helper.selectCollateralTypeAsVehicle(option);
		collateral360Helper.verifyLeftHandMenuOnCollateralTypeAsVehicle();
	}

	@Test(priority = 5)
	public void test5_verifyLeftHandNavigationForShares() {
		customer360Helper = collateral360Helper.clickBackButton();
		collateral360Helper.clickOnAddBtn();
		collateral360Helper.selectCollateralTypeAsShares(option);
		collateral360Helper.verifyLeftHandMenuOnCollateralTypeAsShares();
	}

	@Test(priority = 6)
	public void test6_verifyLeftHandNavigationForAccountsReceivable() {
		customer360Helper = collateral360Helper.clickBackButton();
		collateral360Helper.clickOnAddBtn();
		collateral360Helper.selectCollateralTypeAsAccountsReceivable(option);
		collateral360Helper
				.verifyLeftHandMenuOnCollateralTypeAsAccountsReceivable();
	}

	@Test(priority = 7)
	public void test7_verifyLeftHandNavigationForRealEstate() {
		customer360Helper = collateral360Helper.clickBackButton();
		collateral360Helper.clickOnAddBtn();
		collateral360Helper.selectCollateralTypeAsRealEstate(option);
		collateral360Helper.verifyLeftHandMenuOnCollateralTypeAsRealEstate();
	}

	// Titled Motor Vehicle

	@Test(priority = 8)
	public void test8_saveCollateralDetailsAsVehicle() {
		collateral360Helper.enterCollateralName();
		collateral360Helper.enterCollateralCode();
		collateral360Helper.selectCollateralTypeAsVehicle(option);
		collateral360Helper
				.selectCollateralSubTypeAsTitledMotorVehicles(option);
		collateral360Helper.enterMovable(option);

		collateral360Helper.enterCity();
		collateral360Helper.enterStreet();
		collateral360Helper.enterCountry(option);
		collateral360Helper.enterNumber();
		collateral360Helper.enterZipCode();

		collateral360Helper.enterCollateralOwnerName();
		collateral360Helper.enterCollateralPercentage();
		collateral360Helper.setPrimaryCollateralOwner();
		// collateral360Helper.clickOnSaveCollateral();
		collateral360Helper.clickSaveCollateral();
		// collateral360Helper.clickOnProceedBtn();

		
	}

	@Test(priority = 9)
	public void test9_verifyActionMenuDisplayedOnVehicle()
			throws InterruptedException {

		collateral360Helper.clickOnTitledMotorVehicleSection();
		collateral360Helper.clickEditOnTitledMotorVehicle();
		collateral360Helper.addOnTitledMotorVehicle();
		collateral360Helper.verifyActionMenuPresentOnTitledMotorVehicle();
	}

	@Test(priority = 10)
	public void test11_saveOnTitledMotorVehicle() {
		collateral360Helper.saveTitledMotorVehicleDetails();
	}

	@Test(priority = 11)
	public void test12_updateTitledMotorVehicle() {
		collateral360Helper.clickEditOnTitledMotorVehicle();
		collateral360Helper.updateTitledMotorVehicle();
	}

	@Test(priority = 12)
	public void test13_deleteTitledMotorVehicleInfo() {
		collateral360Helper.clickDeleteOnTitledMotorVehicle();
	}

	@Test(priority = 13)
	public void test14_cancelOnTitledMotorVehicle() {
		collateral360Helper.clickEditOnTitledMotorVehicle();
		collateral360Helper.addOnTitledMotorVehicle();
		collateral360Helper.cancelTitledMotorVehicle();
	}

	// UCC

	@Test(priority = 14)
	public void test15_gotoCollateralPool() {
		log.info("Go to collateral pool to add facility");
		reader.readValue(_hashFacility, "resources/Facility.json");
		searchHelper.searchFacility(_hashFacility);
		collateral360Helper.clickOnCollateralPool();
		collateral360Helper.clickDetailsOnCollateralPool();
		collateral360Helper.clickCollateralAccounts();
		collateral360Helper.clickDetailsOnCollateralAccounts();
	}

	@Test(priority = 15)
	public void test16_saveCollateralDetailsAsUCC() {
		collateral360Helper.editOnBasicCollateralInformation();
		collateral360Helper.enterCollateralName();
		collateral360Helper.selectCollateralTypeAsAccountsReceivable(option);
		collateral360Helper.selectCollateralSubTypeASAccountsReceivable(option);
		collateral360Helper.enterDaysUntilNextReview();
		collateral360Helper.clickSaveCollateral();
	}

	@Test(priority = 16)
	public void test17_verifyDeleteOnUCC() {
		collateral360Helper.clickOnUCC();
		collateral360Helper.clickDeleteOnUCC();
	}

	@Test(priority = 17)
	public void test18_verifyActionMenuDisplayedOnUCC() {
		collateral360Helper.clickEditAndAddOnUCC();
		collateral360Helper.verifyActionMenuOnUCC();

	}

	@Test(priority = 18)
	public void test19_verifyMandatoryDetailsOnUCCUCC() {
		collateral360Helper.verifyMandatoryDetailsOnUCC();

	}

	@Test(priority = 19)
	public void test20_saveUCC() {
		collateral360Helper.saveUCC(option);

	}

	@Test(priority = 20)
	public void test21_updateUCC() {
		collateral360Helper.updateUCC(option);
	}

	@Test(priority = 21)
	public void test22_cancelUCCDetails() {
		collateral360Helper.clickEditAndAddOnUCC();
		collateral360Helper.cancelUCC(option);
	}

	// Shares/Stocks/Bonds/Mutual Funds

	@Test(priority = 22)
	public void test23_gotoCollateral360() {
		log.info("Go to collateral pool");
		reader.readValue(_hashFacility, "resources/Facility.json");
		searchHelper.searchFacility(_hashFacility);
		collateral360Helper.clickOnCollateralPool();
		collateral360Helper.clickDetailsOnCollateralPool();
		collateral360Helper.clickCollateralAccounts();
		collateral360Helper.clickDetailsOnCollateralAccounts();
	}

	// Verify Certified Stocks or Mutual Funds section

	@Test(priority = 23)
	public void test24_verifyMutualFundsSection() {
		collateral360Helper.editOnBasicCollateralInformation();
		collateral360Helper.enterCollateralName();
		collateral360Helper.selectCollateralTypeAsShares(option);
//		collateral360Helper.selectCollateralSubTypeAsGovBonds(option);
		collateral360Helper.clickSaveCollateral();
		// collateral360Helper.clickOnProceedBtn();
	}

	@Test(priority = 24)
	public void test25_verifyMandatoryFieldsOnMutualFunds() {
		collateral360Helper.clickOnShares();
		collateral360Helper.clickOnEDitBtnOfShares();
		collateral360Helper.selectShareTypeAsMutualFunds(option);
	}

	@Test(priority = 25)
	public void test26_saveOnMutualFunds() {
		collateral360Helper.selectShareTypeAsMutualFunds(option);
		collateral360Helper.enterAccountPledged(option);
		collateral360Helper.clickOnSaveBtnOfShares();
	}

	@Test(priority = 26)
	public void test27_updateMutualFunds() {
		collateral360Helper.clickOnEDitBtnOfShares();
		collateral360Helper.enterMarginRate();
		collateral360Helper.clickOnSaveBtnOfShares();
	}

	@Test(priority = 27)
	public void test28_cancelMutualFunds() {
		collateral360Helper.clickOnEDitBtnOfShares();
		collateral360Helper.enterNoOfCertificate();
		collateral360Helper.enterCertificateNumber();
		collateral360Helper.clickCancelOnShares();
	}

	// Verify Certified Bonds section

	@Test(priority = 28)
	public void test29_verifyCertificatedBondsSection() {
		collateral360Helper.clickOnEDitBtnOfShares();
		collateral360Helper.selectShareTypeAsCertificatedBonds(option);
		collateral360Helper.verifyCertificatedBonds();
	}

	@Test(priority = 29)
	public void test30_saveOnCertifiedBonds() {
		collateral360Helper.selectShareTypeAsCertificatedBonds(option);
		collateral360Helper.enterAccountPledged(option);
		collateral360Helper.enterMarginRate();
		collateral360Helper.clickOnSaveBtnOfShares();
	}

	@Test(priority = 30)
	public void test31_updateCertifiedBonds() {
		collateral360Helper.clickOnEDitBtnOfShares();
		collateral360Helper.enterIssuer();
		collateral360Helper.clickOnSaveBtnOfShares();
	}

	@Test(priority = 31)
	public void test32_cancelCertifiedBonds() {
		collateral360Helper.clickOnEDitBtnOfShares();
		collateral360Helper.enterIssuer();
		collateral360Helper.enterBondSerialNo();
		collateral360Helper.clickCancelOnShares();
	}

	// Verify Uncertified Securities or Mutual funds section

	@Test(priority = 32)
	public void test33_VerifyUncertifiedSecuritiesOrMutualFundsSection() {
		collateral360Helper.clickOnEDitBtnOfShares();
		collateral360Helper.selectShareTypeAsUncertificatedSecurities(option);
		collateral360Helper.verifyUncertificatedSecurities();
	}

	@Test(priority = 33)
	public void test34_saveOnUncertifiedSecurities() {
		collateral360Helper.selectShareTypeAsUncertificatedSecurities(option);
		collateral360Helper.enterAccountPledged(option);
		collateral360Helper.enterMarginRate();
		collateral360Helper.clickOnSaveBtnOfShares();
	}

	@Test(priority = 34)
	public void test35_updateOnUncertifiedSecurities() {
		collateral360Helper.clickOnEDitBtnOfShares();
		collateral360Helper.enterAccountType();
		collateral360Helper.enterAccountNumber();
		collateral360Helper.clickOnSaveBtnOfShares();
	}

	@Test(priority = 35)
	public void test36_cancelOnUncertifiedSecurities() {
		collateral360Helper.clickOnEDitBtnOfShares();
		collateral360Helper.enterAccountType();
		collateral360Helper.enterAccountNumber();
		collateral360Helper.enterAllowedTradeDesc();
		collateral360Helper.clickCancelOnShares();
	}

	// Real Estate

	@Test(priority = 36)
	public void test37_goToCollateralPool() {
		log.info("Go to collateral pool");
		reader.readValue(_hashFacility, "resources/Facility.json");
		searchHelper.searchFacility(_hashFacility);
		collateral360Helper.clickOnCollateralPool();
		collateral360Helper.clickDetailsOnCollateralPool();
		collateral360Helper.clickCollateralAccounts();
		collateral360Helper.clickDetailsOnCollateralAccounts();
	}

	@Test(priority = 37)
	public void test38_saveCollateralDetailsAsRealState() {
		collateral360Helper.editOnBasicCollateralInformation();
		collateral360Helper.enterCollateralName();
		collateral360Helper.selectCollateralTypeAsRealEstate(option);
		collateral360Helper.selectCollateralSubTypeAsRetailOffice(option);
		collateral360Helper.enterCountry(option);
		collateral360Helper.enterCity();
		collateral360Helper.enterStreet();
		collateral360Helper.enterNumber();
		collateral360Helper.enterZipCode();
		
		collateral360Helper.newlybuilt(option);
//		collateral360Helper.checkForProceedBtn();
		
		 collateral360Helper.clickSaveCollateral();
	}

	// APN/Tax Information

	@Test(priority = 38)
	public void test39_ClickTaxInformation() {
		collateral360Helper.clickOnTaxInformation();
		collateral360Helper.clickEditOnTaxInformation();
		collateral360Helper.EntervaluesInTaxInformation();
	}

	@Test(priority = 39)
	public void test40_AddTaxInformation() {
		collateral360Helper.ClickonAddTax();
	}

	@Test(priority = 40)
	public void test41_verifyErrorMsgTaxApnDetails() {
		collateral360Helper.SaveTaxApnDetails();
		Assert.assertEquals(collateral360Helper.getCountOfErrorMsgs(), 6);
	}

	@Test(priority = 41)
	public void test42_SaveTaxInformationDetails() {
		collateral360Helper.propertyTaxesCurrent(option);
		collateral360Helper.EnterDetailsTaxApnInformation();
		collateral360Helper.propertyTaxesCurrent(option);
		collateral360Helper.ClickOnAddTaxPayment();
		collateral360Helper.TaxPaymentInformation();
		collateral360Helper.SaveTaxApnDetails();
	}

	// @Test(priority = 42)
	// public void test43_EditTaxInformationDetails() {
	// collateral360Helper.EditLinkButton();
	// collateral360Helper.SaveTaxApnDetails();
	// }
	//
	// @Test(priority = 43)
	// public void test44_UpdateTaxInformationDetails() {
	// collateral360Helper.EditLinkButton();
	// collateral360Helper.UpdateTaxInfo();
	// collateral360Helper.SaveTaxApnDetails();
	// }

	// @Test(priority = 44)
	// public void test45_CancelTaxInformationDetails() {
	// collateral360Helper.EditLinkButton();
	// collateral360Helper.UpdateTaxInfo();
	// collateral360Helper.CancelTaxInfoButton();
	// }

}