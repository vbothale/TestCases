package com.provenir.automation.framework.helper;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.provenir.automation.framework.utility.Util;

public class Customer360Details {

	WebDriver driver;
	Actions actions = null;
	SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");

	public Customer360Details(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		actions = new Actions(driver);
	}

	@FindBy(how = How.ID, using = "editBtn")
	private WebElement custDetailsEditBtn;

	@FindBy(how = How.XPATH, using = ".//*[@id='cDtl']")
	private WebElement custDetailsTxt;

	@FindBy(how = How.XPATH, using = ".//*[@id='savecustdetails']")
	private WebElement custDetailsSaveBtn;

	@FindBy(how = How.XPATH, using = "//form[@id='SAVECUSTDETAILSFORM']/div[contains(@class,'button')]/a[1]")
	private WebElement custDetailsCancelBtn;

	@FindBy(how = How.CSS, using = "label.width145.normal")
	private WebElement custNameOnSummary;

	@FindBy(how = How.XPATH, using = ".//*[@id='compShortName']")
	private WebElement companyShortName;

	@FindBy(how = How.XPATH, using = ".//*[@id='noOfFullTimeEmp']")
	private WebElement noOfFullTimeEmp;

	@FindBy(how = How.XPATH, using = "//*[text()='*']")
	private List<WebElement> asterisk;

	@FindBy(how = How.XPATH, using = ".//*[@id='fiscalYrEnd']")
	private WebElement fiscalYrEnd;

	@FindBy(how = How.XPATH, using = ".//div[@for='fiscalYrEnd']")
	private WebElement errorMsgFiscalYrEnd;

	@FindBy(how = How.XPATH, using = ".//*[@class='error']")
	private WebElement errorMsgText;

	@FindBy(how = How.XPATH, using = ".//*[@id='custTypI']")
	private WebElement custAsIndividual;

	@FindBy(how = How.XPATH, using = ".//*[@id='firstName']")
	private WebElement custFirstName;

	@FindBy(how = How.XPATH, using = ".//*[@id='lastName']")
	private WebElement custLastName;

	@FindBy(how = How.XPATH, using = ".//*[@class='error']")
	private List<WebElement> errorMsg;

	@FindBy(how = How.XPATH, using = ".//*[@id='cReq']")
	private WebElement creditRequest;

	@FindBy(how = How.XPATH, using = ".//div[@id='clientCreditReq']/div[@class='sub_content_div']/a[@id='addAddrRow2']")
	private WebElement addCrdReq;

	@FindBy(how = How.XPATH, using = ".//*[@id='clientCreditReq']/div[1]/div[1]/div[1]/table/tbody/tr[1]/td[7]/a")
	private WebElement actionMenuCrdReq;

	@FindBy(how = How.XPATH, using = "//*[@id='detailsCredReq']")
	private WebElement detailsLnkCrdReq;

	@FindBy(how = How.XPATH, using = "//*[@id='editCredReq']")
	private WebElement editLnkCrdReq;

	@FindBy(how = How.XPATH, using = "//*[@id='deleteCredReq']")
	private WebElement deleteLnkCrdReq;

	@FindBy(how = How.XPATH, using = ".//*[@id='addr']")
	private WebElement addresses;

	@FindBy(how = How.XPATH, using = "//div[@id='addrr']/div[1]/a")
	private WebElement addressText;

	@FindBy(how = How.XPATH, using = ".//div[@id='clientAddress']/div[@class='sub_content_div']/a[@id='addAddrRow2']")
	private WebElement addAddress;

	@FindBy(how = How.XPATH, using = ".//*[@id='city']")
	private WebElement city;

	@FindBy(how = How.ID, using = "saveaddrdetails")
	private WebElement saveAddressDtls;

	@FindBy(how = How.XPATH, using = ".//*[@id='addrLn1']")
	private WebElement addrLine1;

	@FindBy(how = How.XPATH, using = ".//*[@id='apptSuite']")
	private WebElement apptSuite;

	@FindBy(how = How.XPATH, using = ".//form[@id='UPSERTCUSTADDRESSFORM']/div[@class='green_section']/div[2]/div[2]/a[1]")
	private WebElement cancelAddressDtls;

	@FindBy(how = How.XPATH, using = ".//*[@id='clientAddress']/div[1]/div[1]/div[1]/table/tbody/tr[1]/td[10]/a")
	private WebElement actionMenuAddress;

	@FindBy(how = How.XPATH, using = ".//*[@id='detailsAddr']")
	private WebElement detailsLnkAddr;

	@FindBy(how = How.XPATH, using = ".//*[@id='editAddr']")
	private WebElement editLnkAddr;

	@FindBy(how = How.XPATH, using = ".//*[@id='deleteAddr']")
	private WebElement deleteLnkAddr;

	@FindBy(how = How.XPATH, using = ".//*[@id='setPriAddr']")
	private WebElement setPrimLnkAddr;

	@FindBy(how = How.XPATH, using = ".//*[@id='backBC']")
	private WebElement backBreadCrumBtn;

	@FindBy(how = How.XPATH, using = ".//a[@id='annualRevwr']")
	private WebElement annualReview;

	@FindBy(how = How.XPATH, using = ".//*[@id='divTab']/div[1]/h2")
	private WebElement annualReviewTitle;

	@FindBy(how = How.XPATH, using = ".//div[@id='clientCollateral']/div[@class='sub_content_div']/a[@id='addAddrRow2']")
	private WebElement addCollateral;

	@FindBy(how = How.XPATH, using = ".//*[@id='ctrl']")
	private WebElement collateralSection;

	@FindBy(how = How.XPATH, using = ".//*[@id='ctrlr']/div/a")
	private WebElement collateralTxt;

	@FindBy(how = How.XPATH, using = ".//*[@id='clientCollateral']/div[1]/div[1]/div[1]/table/tbody/tr[1]/td[5]/a")
	private WebElement actionMenuColl;

	@FindBy(how = How.XPATH, using = ".//*[@id='detailsCollateral']")
	private WebElement detailsLnkColl;

	@FindBy(how = How.XPATH, using = ".//*[@id='editCollateral']")
	private WebElement editLnkColl;

	@FindBy(how = How.XPATH, using = ".//a[@id='deleteCollateral']")
	private WebElement deleteLnkColl;

	@FindBy(how = How.LINK_TEXT, using = "Details")
	private WebElement detailsLnk;

	@FindBy(how = How.LINK_TEXT, using = "Edit")
	private WebElement editLnk;

	@FindBy(how = How.LINK_TEXT, using = "Delete")
	private WebElement deleteLnk;

	@FindBy(how = How.LINK_TEXT, using = "Set Primary Address")
	private WebElement primaryLink;

	@FindBy(how = How.XPATH, using = ".//*[@id='cLst']")
	private WebElement checklistSection;

	@FindBy(how = How.XPATH, using = ".//*[@id='cLstr']/div/a")
	private WebElement checklistTxt;

	@FindBy(how = How.XPATH, using = ".//*[@class='breadcrumbText']")
	private WebElement breadCrumText;

	@FindBy(how = How.XPATH, using = ".//*[@id='clientChecklist']/div[1]/div[1]/div[1]/table/tbody/tr[1]/td[5]/a")
	private WebElement actionMenuChkList;

	@FindBy(how = How.XPATH, using = ".//form[@id='UPSERTCHECKLISTDETAILSFORM']/div[1]/div[1]/div[6]/a[1]/span[2]/span")
	private WebElement btnOnChkListDetails;

	@FindBy(how = How.XPATH, using = ".//*[@id='addAddrRow2' and @class='see_more']")
	private WebElement seeMoreLnk;

	@FindBy(how = How.XPATH, using = ".//*[@id='leftContent']/div/div[2]/ul/li/a/span/div[contains(@class,'sub_link')]")
	private WebElement cust360ChklistText;

	@FindBy(how = How.XPATH, using = ".//*[@id='cntas']")
	private WebElement contactSection;

	@FindBy(how = How.ID, using = "addContactRow")
	private WebElement addContact;

	@FindBy(how = How.XPATH, using = ".//*[@id='parentFirstName']")
	private WebElement parentFirstName;

	@FindBy(how = How.XPATH, using = ".//*[@id='parentLastName']")
	private WebElement parentLastName;

	@FindBy(how = How.XPATH, using = ".//*[@id='saveContact']")
	private WebElement saveContact;

	@FindBy(how = How.XPATH, using = "//form[@id='UPSERTCUSTCONTACTFORM']/div/div[2]/div[3]/a[1]")
	private WebElement cancelContact;


	@FindBy(how = How.CLASS_NAME, using = "Actionmenu_icon")
	private WebElement actionMenuContacts;

	@FindBy(how = How.ID, using = "cvnt")
	private WebElement covenantSection;
	
	@FindBy(how = How.XPATH, using = "//*[@id='coventMainHeader']//div[@class='data_content']")
	private WebElement reportingCov;


	@FindBy(how = How.XPATH, using = "//*[@id='covnt']/a[@name='addAddrRow']")
	private WebElement addReportingCov;

	@FindBy(how = How.XPATH, using = ".//*[@id='coveTyp']/option[@value='ReportingConv']")
	private WebElement reportingCovType;

	@FindBy(how = How.XPATH, using = ".//*[@id='covName']")
	private WebElement covenantName;

	@FindBy(how = How.XPATH, using = ".//*[@id='expectedResVal']")
	private WebElement expectedVal;

	@FindBy(how = How.XPATH, using = ".//*[@id='actualResVal']")
	private WebElement actualVal;

	@FindBy(how = How.XPATH, using = ".//form[@id='UPSERTCONVENANTFORM']/div[@class='green_section']/div[2]/div[2]/div[3]/a[1]")
	private WebElement cancelCovenant;

	@FindBy(how = How.XPATH, using = ".//form[@id='UPSERTCONVENANTFORM']/div[@class='green_section']/div[2]/div[2]/div[3]/a[1]")
	private WebElement editCovenant;


	@FindBy(how = How.XPATH, using = "//*[@id='covnt']/div[@class='data_content']/div[1]/table/tbody/tr[1]/td[9]/a")
	private WebElement actionMenuReportCov;

	@FindBy(how = How.XPATH, using = "//*[@id='covnt']/div[@class='data_content']/div[1]/table/tbody/tr[2]/td[9]/a")
	private WebElement actionMenuReportCovforDelete;

	@FindBy(how = How.XPATH, using = ".//*[@id='covntTestd']/a[@id='addAddrRow2']")
	private WebElement addTestedCov;

	@FindBy(how = How.XPATH, using = ".//*[@id='coveTyp']/option[@value='TestedConv']")
	private WebElement testedCovType;

	@FindBy(how = How.XPATH, using = ".//form[@id='UPSERTCONVENANTFORM']/div[@class='green_section']/div[2]/div[2]/div[3]/a[2]")
	private WebElement saveCovenant;

	@FindBy(how = How.XPATH, using = ".//*[@id='covntTestd']/div[@class='data_content']/div[1]/table/tbody/tr[1]/td[8]/a")
	private WebElement actionMenuTestedCov;

	@FindBy(how = How.XPATH, using = ".//*[@id='covntRelParty']/a[@id='addAddrRow2']")
	private WebElement addRelatedPartyCov;

	@FindBy(how = How.XPATH, using = ".//*[@id='coveTyp']/option[@value='RelatedConv']")
	private WebElement relPartyCovType;

	@FindBy(how = How.LINK_TEXT, using = "Set Primary Contact")
	private WebElement setPrimContactLnk;

	@FindBy(how = How.XPATH, using = ".//*[@id='covntRelParty']/div[@class='data_content']/div[1]/table/tbody/tr[1]/td[8]/a")
	private WebElement actionMenuRelPartyCov;

	@FindBy(how = How.XPATH, using = ".//*[@id='covntFinStmnt']/a[@id='addAddrRow2']")
	private WebElement addFinancialCov;

	@FindBy(how = How.XPATH, using = ".//*[@id='coveTyp']/option[@value='FinancialCov']")
	private WebElement financialCovType;

	@FindBy(how = How.XPATH, using = ".//*[@id='covntFinStmnt']/div[@class='data_content']/div[1]/table/tbody/tr[1]/td[6]/a")
	private WebElement actionMenuFinancialCov;

	@FindBy(how = How.XPATH, using = ".//*[@id='activeFlg']")
	private WebElement activeFlag;

	@FindBy(how = How.XPATH, using = ".//*[@id='covntFinStmnt']/div[1]/div[1]/label[2]")
	private WebElement totalActiveFinCov;

	@FindBy(how = How.XPATH, using = ".//form[@id='UPSERTCONVENANTFORM']/div/div[@class='main_content_div']/div[@class='sub_content_div']/div[3]/div[1]/label[2]")
	private WebElement financialCovTypeTxt;

	@FindBy(how = How.XPATH, using = ".//*[@id='covntOthr']/a[@id='addAddrRow2']")
	private WebElement addOtherCov;

	@FindBy(how = How.XPATH, using = ".//*[@id='coveTyp']/option[@value='OtherConv']")
	private WebElement otherCovType;

	@FindBy(how = How.XPATH, using = ".//*[@id='covntOthr']/div[@class='data_content']/div[1]/table/tbody/tr[1]/td[7]/a")
	private WebElement actionMenuOtherCov;

	@FindBy(how = How.XPATH, using = ".//*[@id='cbrs']")
	private WebElement crdBureausSection;

	@FindBy(how = How.XPATH, using = ".//div[@id='clientCreditBureaus']/div/a[@id='addAddrRow2']")
	private WebElement addCrdBureau;

	@FindBy(how = How.XPATH, using = ".//*[@id='pullReport']")
	private WebElement pullReport;

	@FindBy(how = How.XPATH, using = ".//*[@id='creditBureauDetail']")
	private WebElement crdBureauReportDetails;

	@FindBy(how = How.XPATH, using = ".//div[@id='clientCreditBureaus']/div[1]/div[@class='data_content']/div[1]/table/tbody/tr[1]/td[6]/a")
	private WebElement actionMenuCrdBureau;

	@FindBy(how = How.XPATH, using = ".//Form[@id='UPSERTCREDITBUREAUFORM']/div[3]/a[1]/span[1]")
	private WebElement editCrdBureauReport;

	@FindBy(how = How.XPATH, using = ".//*[@id='cVfn']")
	private WebElement custVerifSection;

	@FindBy(how = How.XPATH, using = ".//div[@id='clientCustVerification']/div[1]/a[@id='addCustVeriRow']")
	private WebElement addCustVerification;

	@FindBy(how = How.XPATH, using = "//select[@name='documentoryType']")
	private WebElement documentaryType;

	@FindBy(how = How.XPATH, using = ".//*[@id='saveCustVeri']")
	private WebElement saveCustVeri;

	@FindBy(how = How.XPATH, using = ".//*[@id='cancelCustVeri']")
	private WebElement cancelCustVeri;

	@FindBy(how = How.XPATH, using = "//div[@class='error' or @for='idNbr']")
	private WebElement errorMsgCustID;

	@FindBy(how = How.XPATH, using = ".//*[@id='idNbr']")
	private WebElement custIDNumber;

	@FindBy(how = How.XPATH, using = ".//div[@id='clientCustVerification']/div[1]/div[1]/div[1]/table/tbody/tr[1]/td[5]/a")
	private WebElement actionMenuCustVerifi;

	@FindBy(how = How.XPATH, using = ".//*[@id='UPSERTCUSTVERIFICATIONFORM']/div[@class='green_section']/div[2]/div[2]/a[1]")
	private WebElement editCustVerifi;

	@FindBy(how = How.XPATH, using = ".//*[@id='cWtp']")
	private WebElement custWriteUpSection;

	@FindBy(how = How.XPATH, using = ".//*[@id='clientCustWriteUp']/form/div[contains(@class,'button')]/a")
	private WebElement editCustWriteUp;

	@FindBy(how = How.XPATH, using = ".//*[@id='editRichText']/div[2]/div")
	private WebElement contentEditorPopup;

	@FindBy(how = How.XPATH, using = ".//*[@class='cke_editor']/tbody/tr[2]/td[1]/iframe")
	private WebElement editorPopupTxtAreaFrame;

	@FindBy(how = How.XPATH, using = "html/body[@class='cke_show_borders']")
	private WebElement editorPopupTxtArea;

	@FindBy(how = How.XPATH, using = ".//*[@id='editRichText']/div[2]/div/table/thead/tr[2]/td[1]/div/a[@name='popUpSave']")
	private WebElement popUpSaveBtn;

	@FindBy(how = How.XPATH, using = ".//*[@id='editRichText']/div[2]/div/table/thead/tr[2]/td[1]/div/a[1]/span[2]")
	private WebElement popUpCancelBtn;

	@FindBy(how = How.XPATH, using = ".//*[@id='UPSERTCUSTWRITUPFORM']/div[8]/a[2]")
	private WebElement saveCustWriteUp;

	@FindBy(how = How.XPATH, using = ".//*[@id='UPSERTCUSTWRITUPFORM']/div[8]/a[1]")
	private WebElement cancelCustWriteUp;

	@FindBy(how = How.XPATH, using = ".//*[@id='UPSERTCUSTWRITUPFORM']/div[1]/div[2]/div/div")
	private WebElement mngmtStructTxtArea;

	@FindBy(how = How.XPATH, using = ".//*[@id='mngmtStructure']")
	private WebElement mngmtStructLabel;

	@FindBy(how = How.XPATH, using = ".//*[@id='UPSERTCUSTWRITUPFORM']/div[2]/div[2]/div/div")
	private WebElement industryBkgrdTxtArea;

	@FindBy(how = How.XPATH, using = ".//*[@id='instryBckgrnd']")
	private WebElement industryBkgrdLabel;

	@FindBy(how = How.XPATH, using = ".//*[@id='UPSERTCUSTWRITUPFORM']/div[3]/div[2]/div/div")
	private WebElement companyBkgrdTxtArea;

	@FindBy(how = How.XPATH, using = ".//*[@id='compBckgrnd']")
	private WebElement companyBkgrdLabel;

	@FindBy(how = How.XPATH, using = ".//*[@id='UPSERTCUSTWRITUPFORM']/div[4]/div[2]/div/div")
	private WebElement grpStructureTxtArea;

	@FindBy(how = How.XPATH, using = ".//*[@id='groupStruct']")
	private WebElement grpStructureLabel;

	@FindBy(how = How.XPATH, using = ".//*[@id='UPSERTCUSTWRITUPFORM']/div[5]/div[2]/div/div")
	private WebElement businessIdeaTxtArea;

	@FindBy(how = How.XPATH, using = ".//*[@id='busiIdea']")
	private WebElement businessIdeaLabel;

	@FindBy(how = How.XPATH, using = ".//*[@id='UPSERTCUSTWRITUPFORM']/div[6]/div[2]/div/div")
	private WebElement businessStrategyTxtArea;

	@FindBy(how = How.XPATH, using = ".//*[@id='busiStrgy']")
	private WebElement businessStrategyLabel;

	@FindBy(how = How.XPATH, using = ".//*[@id='UPSERTCUSTWRITUPFORM']/div[7]/div[2]/div/div")
	private WebElement businessOpportTxtArea;

	@FindBy(how = How.XPATH, using = ".//*[@id='busiOppor']")
	private WebElement businessOpportLabel;

	@FindBy(how = How.XPATH, using = ".//*[@id='cGrp']")
	private WebElement custGroupSection;

	@FindBy(how = How.XPATH, using = ".//*[@id='addCustGrpRow']")
	private WebElement addCustGroup;

	@FindBy(how = How.XPATH, using = ".//*[@id='grpName']")
	private WebElement groupName;

	@FindBy(how = How.XPATH, using = ".//*[@id='savegrpdetails']")
	private WebElement saveCustGroup;


	@FindBy(how = How.XPATH, using = "//label[@class='error' or @for='grpName']")
	private WebElement errorMsgGroupName;

	@FindBy(how = How.XPATH, using = ".//*[@id='status']")
	private WebElement groupStatus;

	@FindBy(how = How.XPATH, using = "//*[@id='custGroup']/div[1]/div[1]/div[1]/table/tbody/tr/td[3]/a")
	private WebElement actionMenuCustGroup;

	@FindBy(how = How.XPATH, using = ".//*[@id='UPSERTCUSTGRPDETAIL']/div[3]/a[1]")
	private WebElement editCustDetailsBtn;

	@FindBy(how = How.XPATH, using = ".//*[@id='addGrpMember']")
	private WebElement addGroupMember;

	@FindBy(how = How.XPATH, using = ".//*[@class='suggestMenu']/div[@class='actionList']/ul/li[1]")
	private WebElement firstCustNameFrmList;

	@FindBy(how = How.XPATH, using = ".//*[@id='dataContent']/div[2]/div[4]/div[2]/a/b")
	private WebElement dupCustCheck_proceedButton;

	@FindBy(how = How.XPATH, using = ".//*[@id='dob']")
	private WebElement dob_individual;

	@FindBy(how = How.XPATH, using = "//select[@id='covSubTyp']")
	private WebElement covenantSubtype;

	@FindBy(how = How.NAME, using = "firstDueDt")
	private WebElement fDueDate;

	@FindBy(how = How.NAME, using = "effectiveDt")
	private WebElement effDate;

	@FindBy(how = How.NAME, using = "expiryDt")
	private WebElement expiryDate;

	@FindBy(how = How.XPATH, using = "//*[@id='covntDescDiv']/textarea")
	private WebElement covDescription;

	@FindBy(how = How.XPATH, using = "//*[@id='savegrpdetails']")
	private WebElement saveBtnOnGrps;

	@FindBy(how = How.XPATH, using = ".//*[@id='rShp']")
	private WebElement relationshipLink;

	@FindBy(how = How.XPATH, using = "//*[@id='custCorpHierarchy']/a[@id='addAddrRow2']")
	private WebElement addBtnOnCorpHieararchy;

	@FindBy(how = How.XPATH, using = "//*[@id='custPartyHierarchy']/a[@name='addAddrRow']")
	private WebElement addBtnOnRelatedParties;

	@FindBy(how = How.XPATH, using = "//*[@id='relatedTo']")
	private WebElement relatedToField;

	@FindBy(how = How.XPATH, using = ".//*[@id='searchData']/div/div/div[2]/a")
	private WebElement selectBtn;

	@FindBy(how = How.XPATH, using = ".//*[@id='relshpTyp']")
	private WebElement relationshipType;

	@FindBy(how = How.XPATH, using = "//*[@id='UPSERTCUSTRELSHPFORM']/div/div[2]/div/div[4]/a[2]")
	private WebElement saveBtnOnCustHi;

	@FindBy(how = How.XPATH, using = "	.//*[@id='relatedToSearch']")
	private WebElement searchIcon;

	@FindBy(how = How.XPATH, using = ".//*[@id='parentTin']")
	private WebElement taxidContact;

	@FindBy(how = How.XPATH, using = ".//*[@name='parentCustomerSince']")
	private WebElement custSinceContact;

	@FindBy(how = How.XPATH, using = ".//*[@id='exAc']")
	private WebElement externalAccSection;

	@FindBy(how = How.XPATH, using = ".//div[@id='clientExtAccLoan']/a[@id='addAddrRow2']")
	private WebElement addLoanSummary;

	@FindBy(how = How.XPATH, using = ".//*[@id='acctNo']")
	private WebElement accountNo;

	@FindBy(how = How.XPATH, using = ".//*[@id='clientExtAccLoan']/div/div/table/tbody/tr/td[7]/a")
	private WebElement actionMenuExternalAccounts;

	@FindBy(how = How.LINK_TEXT, using = "Edit")
	private WebElement editLoanSummary;

	@FindBy(how = How.XPATH, using = ".//*[@id='acctNo']")
	private WebElement parentaccountNo;

	@FindBy(how = How.XPATH, using = ".//*[@id='inAc']")
	private WebElement internalAccSection;

	@FindBy(how = How.XPATH, using = ".//*[@id='clientInternalAccLoan']/a[@id='addAddrRow2']")
	private WebElement addLoanSummaryInternal;

	@FindBy(how = How.XPATH, using = ".//*[@id='clientInternalAccLoan']/div/div/table/tbody/tr/td[7]/a")
	private WebElement actionMenuInternalAccounts;

	@FindBy(how = How.XPATH, using = ".//*[@id='outBal']")
	private WebElement commitmentBalance;


	@FindBy(how = How.XPATH, using = ".//*[@id='EXTACCTLOANLINEFORM']/div/div[2]/div[2]/a[2]")
	private WebElement saveLoanSummary;

	@FindBy(how = How.XPATH, using = ".//*[@id='INTACCTLOANLINEFORM']/div/div[2]/div[2]/a[2]")
	private WebElement saveLoanSummaryInternal;

	@FindBy(how = How.ID, using = "ownership")
	private WebElement ownership;

	@FindBy(how = How.XPATH, using = "//*[@id='acc_info']/div[2]/div[2]/div/a/div")
	private WebElement commBubble;

	@FindBy(how = How.ID, using = "commentTxt")
	private WebElement commentTxtBox;

	@FindBy(how = How.XPATH, using = "//*[@id='FRMCOMMENTS']/div/div[4]/div/a")
	private WebElement addCmntBtn;

	@FindBy(how = How.XPATH, using = "//*[@id='result_div']/div/div[1]/div[1]")
	private WebElement addedCommentSection;

	@FindBy(how = How.ID, using = "dcts")
	private WebElement documentsLnk;

	@FindBy(how = How.ID, using = "addDocLib")
	private WebElement addDocLink;

	@FindBy(how = How.XPATH, using = "//*[@id='data_content']/div[2]/a[3]")
	private WebElement uploadBtn;

	@FindBy(how = How.XPATH, using = "//*[@id='file']")
	private WebElement browseBtn;

	@FindBy(how = How.ID, using = "uploadBtn")
	private WebElement uploadBtnOnUploader;

	@FindBy(how = How.ID, using = "docType")
	private WebElement selectedRadioBtn;

	@FindBy(how = How.ID, using = "docNameDD")
	private WebElement docName;

	@FindBy(how = How.XPATH, using = "//*[@id='data_content']/div[2]/a[1]")
	private WebElement mergeBtn;

	@FindBy(how = How.ID, using = "docNameVal")
	private WebElement mergeDocNameTxtBox;

	@FindBy(how = How.XPATH, using = "//*[@id='openPopup']/div[2]/div/div/div[2]/div/div[2]/div[2]/a/b")
	private WebElement mergeBtnOnPopup;

	@FindBy(how = How.XPATH, using = "//*[@id='viewer']")
	private WebElement pdfContent;
	@FindBy(how = How.XPATH, using = "//a[@name='CreateCustomer']/span")
	private WebElement createCustLnk;

	@FindBy(how = How.XPATH, using = ".//*[@id='cDtlr']/div/a")
	private WebElement custDetailsHeading;

	@FindBy(how = How.XPATH, using = ".//*[@id='postalCd']")
	private WebElement postalCode;

	@FindBy(how = How.XPATH, using = ".//*[@id='state']")
	private WebElement regionDDL;

	@FindBy(how = How.XPATH, using = ".//*[@id='parentLastName']")
	private WebElement parentLastNameDDL;

	@FindBy(how = How.XPATH, using = ".//*[@id='mainPhNbrCd']")
	private WebElement mainPhoneCode;

	@FindBy(how = How.ID, using = "mainPhNbr")
	private WebElement mainPhnNumbr;

	@FindBy(how = How.ID, using = "mainPhNbrCd")
	private WebElement mainPhNbrCd;

	@FindBy(how = How.ID, using = "mainExtNbr")
	private WebElement mainExtNbr;

	@FindBy(how = How.XPATH, using = ".//*[@id='addrr']/div/a")
	private WebElement addSectionGrid;

	@FindBy(how = How.XPATH, using = ".//*[@id='cntasr']/div/a")
	private WebElement ContactText;

	// commenting section

	@FindBy(how = How.XPATH, using = ".//*[@id='acc_info']/div[2]/div[2]/div/a/div")
	private WebElement commentBubble;

	@FindBy(how = How.XPATH, using = ".//*[@id='totalNoOfCommentsLabel']")
	private WebElement commentNotification;

	@FindBy(how = How.XPATH, using = ".//*[@id='FRMCOMMENTS']/div/label")
	private WebElement categoryLabelOnComment;

	@FindBy(how = How.XPATH, using = ".//*[@id='FRMCOMMENTS']/div/div[1]/label")
	private WebElement sectionLabelOnComment;

	@FindBy(how = How.XPATH, using = ".//*[@id='FRMCOMMENTS']/div/div[2]/div[2]/a/span")
	private WebElement addBtnOnCommentNotification;

	@FindBy(how = How.XPATH, using = ".//*[@id='FRMCOMMENTS']/div/div[2]/div[1]/div")
	private WebElement addSectionOnCommentNotification;

	@FindBy(how = How.XPATH, using = ".//*[@id='editRichText']/div[2]/div")
	private WebElement commentPopup;

	@FindBy(how = How.XPATH, using = ".//*[@id='cke_contents_richTxt']/iframe")
	private WebElement commentPopupEditingSection;

	@FindBy(how = How.XPATH, using = ".//*[@id='editRichText']/div[2]/div/table/thead/tr[2]/td/div/a[2]")
	private WebElement okBtnOommentPopup;

	@FindBy(how = How.XPATH, using = ".//*[@id='editRichText']/div[2]/div/table/thead/tr[2]/td/div/a[1]")
	private WebElement cancelBtnOnommentPopup;

	@FindBy(how = How.XPATH, using = ".//*[@id='dragbar']/h2")
	private WebElement commentPopupText;

	@FindBy(how = How.XPATH, using = ".//*[@id='dragbar']/a")
	private WebElement cancelBtnOnCommentPopup;

	@FindBy(how = How.XPATH, using = ".//*[@id='result_div']")
	private WebElement scrollbarSection;

	@FindBy(how = How.XPATH, using = ".//*[@id='result_div']/div/div[1]/div/div/p")
	private WebElement commentValue1;

	@FindBy(how = How.XPATH, using = ".//*[@id='result_div']/div/div[2]/div/div/p")
	private WebElement commentValue2;

	@FindBy(how = How.XPATH, using = ".//*[@id='result_div']/div/div[3]/div/div/p")
	private WebElement commentValue3;

	@FindBy(how = How.XPATH, using = ".//*[@id='result_div']/div/div[4]/div/div/p")
	private WebElement commentValue4;

	@FindBy(how = How.XPATH, using = ".//*[@id='result_div']/div/div[1]/div/div/div/span[1]")
	private WebElement usernameValue1OnCommentBubble;

	@FindBy(how = How.XPATH, using = ".//*[@id='result_div']/div/div[2]/div/div/div/span[1]")
	private WebElement usernameValue2OnCommentBubble;

	@FindBy(how = How.XPATH, using = ".//*[@id='result_div']/div/div[3]/div/div/div/span[1]")
	private WebElement usernameValue3OnCommentBubble;

	@FindBy(how = How.XPATH, using = ".//*[@id='result_div']/div/div[4]/div/div/div/span[1]")
	private WebElement usernameValue4OnCommentBubble;

	@FindBy(how = How.XPATH, using = ".//*[@id='cSectionId']")
	private WebElement sectionOnCommentBubble;

	@FindBy(how = How.XPATH, using = ".//*[@id='acc_info']/div[2]/div[2]/div/a/div/b/label")
	private WebElement ele1;

	private String customerClassiCode = "custClassificatnCode";
	private String creditReqOnGrid = ".//*[@id='clientCreditReq']/div[@class='sub_content_div']/div[@id='data_content']/div[1]/table/tbody/tr";
	private String addressType = "addrTyp";
	private String country = "country";
	private String eventFreq = "eventFreq";
	private String methodOfComm = "methodOfComm";

	private String contactType = "parentContTyp";
	private String addressGrid = ".//div[@id='clientAddress']/div[@class='sub_content_div']/div[@id='data_content']/div[1]/table/tbody/tr";
	private String collateralOnGrid = ".//div[@id='clientCollateral']/div[1]/div[1]/div[1]/table/tbody/tr";
	private String contactGrid = ".//div[@id='clientContacts']/div[1]/div[1]/div[1]/table/tbody/tr";
	
	private String reportCovGrid = "//*[@id='coventMainHeader']//div[@class='data_content']/div[1]/table/tbody/tr";
	private String testedCovGrid = ".//*[@id='covntTestd']/div[@class='data_content']/div[1]/table/tbody/tr";
	private String recordCovGrid = ".//*[contains(@class,'ProvGrid')]/table/tbody/tr";
	private String relPartyCovGrid = ".//*[@id='covntRelParty']/div[@class='data_content']/div[1]/table/tbody/tr";
	private String financialCovGrid = ".//*[@id='covntFinStmnt']/div[@class='data_content']/div[1]/table/tbody/tr";
	private String otherCovGrid = ".//*[@id='covntOthr']/div[@class='data_content']/div[1]/table/tbody/tr";
	private String crdBureausGrid = ".//div[@id='clientCreditBureaus']/div[1]/div[1]/div[1]/table/tbody/tr";
	private String latestBureauReportsGrid = ".//*[@id='divCreditBureausList']/div[@id='data_content']/div[1]/table/tbody/tr";
	private String custVerificationGrid = ".//div[@id='clientCustVerification']/div[1]/div[1]/div[1]/table/tbody/tr";
	private String custGroupGrid = ".//div[@id='custGroup']/div[1]/div[1]/div[1]/table/tbody/tr";
	private String custGroupMemberGrid = ".//*[@id='custGrpMbr']/div[1]/div[2]/div[1]/table/tbody/tr";
	private String relationshipCorpHieracrchyGrid = "//*[@id='custCorpHierarchy']/div[@id='data_content']/div/table/tbody/tr";
	private String relationshipRelatedPartiesGrid = "//*[@id='custPartyHierarchy']/div[@id='data_content']/div/table/tbody/tr";

	private String searchedCustomerLst = ".//*[@id='UPSERTREQBORRFORM']/div[1]/div/table/tbody/tr";
	private String documentsGrid = "//*[@id='docLibContentData']/div/table/tbody/tr";
	private String documentLibraryGrid = "//*[@id='credLibGridData']/div/table/tbody/tr";

	private String bureau = "bureau";
	private String reportType = "reportType";
	private String covenantType = "coveTyp";
	private String currentDate = null;
	private String backToPage = "//div[contains(@class,'breadcrumbGrid')]/ul/li";

	private String relatedToName = null;

	private String externalAccGrid = ".//div[@id='clientExtAccLoan']/div[1]/div/table/tbody/tr";
	private String loanRelationship = "relType";
	private String loanGrid = ".//*[@id='clientExtAccLoan']/div/div/table/tbody/tr";
	private String internalAccGrid = ".//*[@id='clientInternalAccLoan']/div/div/table/tbody/tr";
	private String loanGridInternal = ".//*[@id='clientInternalAccLoan']/div/div/table/tbody/tr";

	private String documentType = null;
	private int commentCnt = 0;

	private int cnt = 0;

	// private String commentCnt;

	public String getDocumentType() {
		return documentType;
	}

	public void setDocumentType(String documentType) {
		this.documentType = documentType;
	}

	private WebElement element = null;
	List<WebElement> lstWebElements = null;

	public String getRelatedToName() {
		return relatedToName;
	}

	public void setRelatedToName(String relatedToName) {
		this.relatedToName = relatedToName;
	}

	public Customer360Details clickCustDetailsEditBtn() {
		Util.waitForElement(driver, custDetailsEditBtn, 5);
		custDetailsEditBtn.click();
		Util.waitForAJAX(driver);
		return this;
	}

	public String getCustDetailsTxt() {
		Util.waitForAJAX(driver);
		return custDetailsTxt.getText();
	}

	public String getContactText() {
		return ContactText.getText();
	}

	public boolean verifyCustDtlsSaveCancelBtn() {
		if (custDetailsSaveBtn.isDisplayed()
				&& custDetailsCancelBtn.isDisplayed()) {
			return true;
		} else {
			return false;
		}
	}

	public String getCustNameOnSummary() {
		Util.waitForElement(driver, custNameOnSummary, 20);
		return custNameOnSummary.getText();
	}

	public String getCompanyShrtNameOnCustInfo() {
		return companyShortName.getAttribute("value");
	}

	public void enterNoOfFullTimeEmp(String noOfEmp) {
		noOfFullTimeEmp.clear();
		noOfFullTimeEmp.sendKeys(noOfEmp);
	}

	public Customer360Details clickCustDetailsSaveBtn() {
		custDetailsSaveBtn.click();
		Util.waitForAJAX(driver);
		return this;
	}

	public String getNumOfFullTimeEmp() {
		return noOfFullTimeEmp.getText();
	}

	public int getAsteriskCntOnCustDetails() {
		return asterisk.size();
	}

	public void clearFiscalYrEnd() {
		fiscalYrEnd.clear();
	}

	public void enterFiscalYrEnd(String value) {
		fiscalYrEnd.sendKeys(value);
	}

	public boolean isErrorMsgPresent() {
		if (errorMsgText.getText().equalsIgnoreCase("This field is required.")) {
			return true;
		} else {
			return false;
		}
	}

	public Customer360Details clickCustDetailsCancelBtn() {
		custDetailsCancelBtn.click();
		Util.waitForAJAX(driver);
		return this;
	}

	public void clickCustTypeAsIndividual() {
		Util.waitForAJAX(driver);
		custAsIndividual.sendKeys(Keys.SPACE);
		Util.waitForAJAX(driver);
	}

	public void enterCustFirstName(String fname) {
		custFirstName.sendKeys(fname);
	}

	public String getCustFirstName() {
		Util.waitForAJAX(driver);
		return custFirstName.getText();
	}

	public void enterCustLastName(String lname) {
		custLastName.sendKeys(lname);
	}

	public void selectCustomerClassiCode(String custClassiCode) {
		Util.enableAllDropdowns(driver);
		Util.selectItemFromList(driver, customerClassiCode, custClassiCode);
	}

	public int getErrorMsgCount() {
		return errorMsg.size();
	}

	public String getFirstCreditNameFromGrid() {
		Util.waitForAJAX(driver);
		element = driver.findElement(By.xpath(creditReqOnGrid + "[1]/td[2]"));
		return element.getText();
	}

	public boolean isCrdNamePresentOnGrid(String creditName) {
		Util.waitForElementPresent(driver, By.xpath(creditReqOnGrid), 20);
		element = null;
		lstWebElements = driver.findElements(By.xpath(creditReqOnGrid));

		for (int i = 1; i <= lstWebElements.size(); i++) {
			element = driver.findElement(By.xpath(creditReqOnGrid + "[" + i
					+ "]/td[2]"));
			if (element.getText().toLowerCase()
					.contains(creditName.toLowerCase())) {
				return true;
			}
		}
		return false;
	}

	public Customer360Details clickCreditRequests() {
		creditRequest.click();
		Util.waitForAJAX(driver);
		return this;
	}

	public Credit360Helper clickAddCrdRequest() {
		addCrdReq.click();
		Util.waitForAJAX(driver);
		return new Credit360Helper(driver);
	}

	public Credit360Helper clickDetailsLnkCrdReq() {
		actions.moveToElement(actionMenuCrdReq).click().perform();
		Util.waitForElement(driver, detailsLnkCrdReq, 10);
		detailsLnk.click();
		Util.waitForAJAX(driver);
		return new Credit360Helper(driver);
	}

	public Credit360Helper clickEditLnkCrdReq() {
		actions.moveToElement(actionMenuCrdReq).click().perform();
		Util.waitForElement(driver, editLnkCrdReq, 10);
		editLnk.click();
		Util.waitForAJAX(driver);
		return new Credit360Helper(driver);
	}

	public void clickDeleteLnkCrdReq() {
		actions.moveToElement(actionMenuCrdReq).click().perform();
		Util.waitForElement(driver, deleteLnkCrdReq, 10);
		deleteLnk.click();
		Util.waitForAJAX(driver);
	}

	private int getNoOfRecordsInGrid(String xpathGridLocator) {
		int rowCnt = 0;
		lstWebElements = driver.findElements(By.xpath(xpathGridLocator));
		for (WebElement ele : lstWebElements) {
			if (ele.getText().equals("No Data Available")) {
				rowCnt = lstWebElements.size() - 1;
			} else {
				rowCnt = lstWebElements.size();
			}
		}
		return rowCnt;
	}

	public int getNoOfUploadedDocRecords() {
		return getNoOfRecordsInGrid(documentLibraryGrid);
	}

	public int getNoOfCreditReqRecords() {
		return getNoOfRecordsInGrid(creditReqOnGrid);
	}

	public Customer360Details clickAddresses() {
		addresses.click();
		Util.waitForAJAX(driver);
		return this;
	}

	public boolean isAddressGridPresent() {
		Util.waitForElementPresent(driver, By.xpath(addressGrid), 20);
		return driver.findElement(By.xpath(addressGrid)).isDisplayed();
	}

	public void clickAddAddress() {
		addAddress.click();
		Util.waitForAJAX(driver);
	}

	public boolean isCityPresent() {
		Util.waitForAJAX(driver);
		return city.isDisplayed();
	}

	public void clickSaveAddressBtn() {
		Util.waitForAJAX(driver);
		Util.scrollUp(driver);
		saveAddressDtls.click();
		Util.waitForAJAX(driver);
	}

	public void selectAddressType(String value) {
		Util.waitForAJAX(driver);
		Util.enableAllDropdowns(driver);
		Util.scrollUp(driver);
		Util.selectItemFromList(driver, addressType, value);
	}

	public void selectCountry(String value) {
		Util.selectItemFromList(driver, country, value);
		Util.waitForAJAX(driver);
	}

	public void enterAddrLine(String value) {
		Util.waitForElement(driver, addrLine1, 20);
		addrLine1.clear();
		addrLine1.sendKeys(value);
	}

	public void enterApptSuite(String value) {
		apptSuite.clear();
		apptSuite.sendKeys(value);
	}

	public void enterCity(String value) {
		city.clear();
		city.sendKeys(value);
	}

	public void enterPostalCode(String value) {
		postalCode.clear();
		postalCode.sendKeys(value);
	}

	public void selectRegion(String value) {

		Util.selectItemFromList(driver, regionDDL, value);
	}

	public boolean isAddressOnGrid(String value) {
		Util.waitForElementPresent(driver, By.xpath(addressGrid), 30);
		lstWebElements = driver.findElements(By.xpath(addressGrid));

		for (int i = 1; i <= lstWebElements.size(); i++) {
			element = driver.findElement(By.xpath(addressGrid + "[" + i
					+ "]/td[2]"));
			if (element.getText().equalsIgnoreCase(value)) {
				return true;
			}
		}
		return false;
	}

	public void clickCancelAddressBtn() {
		Util.waitForElement(driver, cancelAddressDtls, 20);
		cancelAddressDtls.click();
		Util.waitForAJAX(driver);
	}

	public int getNoOfAddrRecords() {
		Util.waitForElementPresent(driver, By.xpath(addressGrid), 20);
		return getNoOfRecordsInGrid(addressGrid);
	}

	public Customer360Details clickDetailsLnkAddr() {
		actions.moveToElement(actionMenuAddress).click().perform();
		Util.waitForElement(driver, detailsLnk, 15);
		detailsLnk.click();
		Util.waitForAJAX(driver);
		return new Customer360Details(driver);
	}

	public String getCityValue() {
		Util.waitForElement(driver, city, 20);
		Util.waitForAJAX(driver);
		return city.getText();
	}

	public Customer360Details clickBackBreadCrum(String pageName)
			throws InterruptedException {
		Actions action = new Actions(driver);
		action.moveToElement(breadCrumText).build().perform();
		Thread.sleep(2000);
		lstWebElements = driver.findElements(By.xpath(backToPage));
		for (int i = 1; i <= lstWebElements.size(); i++) {
			element = driver.findElement(By.xpath(backToPage + "[" + i
					+ "]/a[@id='breadCrumbLnk']"));
			if (element.getText().equalsIgnoreCase(pageName)) {
				driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
				// Alert alert = driver.switchTo().alert();
				// alert.getText();
				element.click();
			}
		}
		// backBreadCrumBtn.click();
		Util.waitForAJAX(driver);
		return new Customer360Details(driver);
	}

	public Customer360Details clickEditLnkAddr() {
		Util.waitForElement(driver, actionMenuAddress, 8);
		actions.moveToElement(actionMenuAddress).click().perform();
		Util.waitForElement(driver, editLnk, 25);
		editLnk.click();
		Util.waitForAJAX(driver);
		return new Customer360Details(driver);
	}

	public void setAddrAsPrimary(String value) {
		Util.waitForElementPresent(driver, By.xpath(addressGrid), 20);
		lstWebElements = driver.findElements(By.xpath(addressGrid));
		actions = new Actions(driver);
		WebElement eleToSet = null;
		for (int i = 1; i <= lstWebElements.size(); i++) {
			element = driver.findElement(By.xpath(addressGrid + "[" + i
					+ "]/td[2]"));
			if (element.getText().equalsIgnoreCase(value)) {

				eleToSet = driver.findElement(By.xpath(addressGrid + "[" + i
						+ "]/td[10]/a"));
				Util.waitForElementPresent(driver, By.xpath(addressGrid), 20);
				actions.moveToElement(eleToSet).click().perform();
				Util.waitForElementPresent(driver,
						By.linkText("Set Primary Address"), 30);
				// Util.waitForElement(setPrimLnkAddr, 30);
				primaryLink.click();
				// setPrimLnkAddr.click();
				Util.waitForAJAX(driver);
				break;
			}
		}
	}

	public boolean verifyAddrAsPrimary(String value) {
		Util.waitForElementPresent(driver, By.xpath(addressGrid), 20);
		lstWebElements = driver.findElements(By.xpath(addressGrid));
		WebElement eleToSet = null;
		for (int i = 1; i <= lstWebElements.size(); i++) {
			element = driver.findElement(By.xpath(addressGrid + "[" + i
					+ "]/td[2]"));
			if (element.getText().equalsIgnoreCase(value)) {
				eleToSet = driver.findElement(By.xpath(addressGrid + "[" + i
						+ "]/td[1]/span[2]"));
				Util.waitForElement(driver, eleToSet, 20);
				if (eleToSet.isDisplayed()) {
					return true;
				}
			}
		}
		return false;
	}

	public Customer360Details clickDeleteLnkAddr() {
		actions.moveToElement(actionMenuAddress).click().perform();
		Util.waitForElement(driver, deleteLnk, 20);
		deleteLnk.click();
		Util.waitForAJAX(driver);
		return new Customer360Details(driver);
	}

	public void clickAnnualReview() {
		Util.waitForElement(driver, annualReview, 20);
		annualReview.click();
		Util.waitForAJAX(driver);
	}

	public String getAnnualReviewTitle() {
		Util.waitForElement(driver, annualReviewTitle, 20);
		return annualReviewTitle.getText();
	}

	public void clickCollateral() {
		Util.waitForElement(driver, collateralSection, 20);
		collateralSection.click();
		Util.waitForAJAX(driver);
	}

	public boolean isCollateralGridPresent() {
		Util.waitForElementPresent(driver, By.xpath(collateralOnGrid), 20);
		return driver.findElement(By.xpath(collateralOnGrid)).isDisplayed();
	}

	public Collateral360Helper clickAddCollateralBtn() {
		addCollateral.click();
		Util.waitForAJAX(driver);
		return new Collateral360Helper(driver);
	}

	public boolean isCollateralPresentOnGrid(String value) {
		Util.waitForElementPresent(driver, By.xpath(collateralOnGrid), 20);
		element = null;
		List<WebElement> lstCustNamesFromGrid = driver.findElements(By
				.xpath(collateralOnGrid));

		for (int i = 1; i <= lstCustNamesFromGrid.size(); i++) {
			element = driver.findElement(By.xpath(collateralOnGrid + "[" + i
					+ "]/td[1]"));
			Util.waitForElement(driver, element, 20);
			if (element.getText().contains(value)) {
				return true;
			}
		}
		return false;
	}

	public Collateral360Helper clickDetailsLnkColl() {
		Util.waitForAJAX(driver);
		actions.moveToElement(actionMenuColl).click().perform();
		Util.waitForElement(driver, detailsLnk, 20);
		detailsLnk.click();
		Util.waitForAJAX(driver);
		return new Collateral360Helper(driver);
	}

	public Collateral360Helper clickEditLnkColl() {
		actions.moveToElement(actionMenuColl).click().perform();
		Util.waitForElement(driver, editLnk, 20);
		editLnk.click();
		Util.waitForAJAX(driver);
		return new Collateral360Helper(driver);
	}

	public void clickDeleteLnkColl() {
		actions.moveToElement(actionMenuColl).click().perform();
		Util.waitForElement(driver, deleteLnk, 20);
		deleteLnk.click();
		Util.waitForAJAX(driver);
	}

	public int getNoOfCollateralRecords() {
		Util.waitForElementPresent(driver, By.xpath(collateralOnGrid), 20);
		return getNoOfRecordsInGrid(collateralOnGrid);
	}

	public String getTextOnLeftContent() {
		Util.waitForElement(driver, cust360ChklistText, 20);
		return cust360ChklistText.getText();

	}

	public void clickContact() {
		Util.waitForElement(driver, contactSection, 20);
		contactSection.click();
		Util.waitForAJAX(driver);
	}

	public boolean isContactGridPresent() {
		Util.waitForElementPresent(driver, By.xpath(contactGrid), 20);
		return driver.findElement(By.xpath(contactGrid)).isDisplayed();
	}

	public void clickAddContact() {
		Util.waitForElement(driver, addContact, 20);
		addContact.click();
		Util.waitForAJAX(driver);
	}

	public boolean isFirstNamePresent() {
		Util.waitForElement(driver, parentFirstName, 20);
		return parentFirstName.isDisplayed();
	}

	public void clickSaveContact() {
		Util.waitForElement(driver, saveContact, 20);
		saveContact.click();
		Util.waitForAJAX(driver);
	}

	public void selectContactType(String value) {
		Util.waitForAJAX(driver);
		Util.enableAllDropdowns(driver);
		Util.waitForElement(driver, parentFirstName, 20);
		Util.selectItemFromList(driver, contactType, value);
	}

	public void enterParentFirstName(String value) {
		parentFirstName.clear();
		parentFirstName.sendKeys(value);
	}

	public void enterParentLastName(String value) {
		parentLastName.clear();
		parentLastName.sendKeys(value);
	}

	public boolean isContactPresentOnGrid(String value) {
		Util.waitForElementPresent(driver, By.xpath(contactGrid), 20);
		List<WebElement> lstAddr = driver.findElements(By.xpath(contactGrid));

		for (int i = 1; i <= lstAddr.size(); i++) {
			element = driver.findElement(By.xpath(contactGrid + "[" + i
					+ "]/td[2]"));
			if (element.getText().equalsIgnoreCase(value)) {
				Util.waitForAJAX(driver);
				return true;
			}
		}
		Util.waitForAJAX(driver);
		return false;
	}

	public void clickCancelContact() {
		Util.waitForElement(driver, cancelContact, 20);
		cancelContact.click();
		Util.waitForAJAX(driver);
	}

	public void setContactAsPrimary(String value) {
		Util.waitForElementPresent(driver, By.xpath(contactGrid), 20);
		lstWebElements = driver.findElements(By.xpath(contactGrid));
		actions = new Actions(driver);
		WebElement eleToSet = null;
		for (int i = 1; i <= lstWebElements.size(); i++) {
			element = driver.findElement(By.xpath(contactGrid + "[" + i
					+ "]/td[2]"));
			if (element.getText().equalsIgnoreCase(value)) {
				eleToSet = driver.findElement(By.xpath(contactGrid + "[" + i
						+ "]/td[6]/a"));
				actions.moveToElement(eleToSet).click().perform();
				Util.waitForElement(driver, setPrimContactLnk, 20);
				setPrimContactLnk.click();
				Util.waitForAJAX(driver);
				break;
			}
		}
	}

	public boolean verifyContactAsPrimary(String value) {
		Util.waitForElementPresent(driver, By.xpath(contactGrid), 20);
		lstWebElements = driver.findElements(By.xpath(contactGrid));
		WebElement eleToSet = null;
		for (int i = 1; i <= lstWebElements.size(); i++) {
			element = driver.findElement(By.xpath(contactGrid + "[" + i
					+ "]/td[2]"));
			if (element.getText().equalsIgnoreCase(value)) {
				eleToSet = driver.findElement(By.xpath(contactGrid + "[" + i
						+ "]/td[1]/a"));
				Util.waitForElement(driver, eleToSet, 20);
				if (eleToSet.isDisplayed()) {
					return true;
				}
			}
		}
		return false;
	}

	public int getNoOfContactRecords() {
		Util.waitForElementPresent(driver, By.xpath(contactGrid), 20);
		return getNoOfRecordsInGrid(contactGrid);
	}

	public Customer360Details clickDetailsLnkContacts() {
		Util.waitForAJAX(driver);
		actions.moveToElement(actionMenuContacts).click().perform();
		Util.waitForElement(driver, detailsLnk, 20);
		detailsLnk.click();
		Util.waitForAJAX(driver);
		return new Customer360Details(driver);
	}

	public Customer360Details clickEditLnkContacts() {
		actions.moveToElement(actionMenuContacts).click().perform();
		Util.waitForElement(driver, editLnk, 20);
		editLnk.click();
		Util.waitForAJAX(driver);
		return new Customer360Details(driver);
	}

	public void clickDeleteLnkContacts() {

		Util.waitForElementPresent(
				driver,
				By.xpath(".//*[@id='clientContacts']/div[1]/div[1]/div[1]/table/tbody/tr[1]/td[6]/a"),
				30);
		actions.moveToElement(actionMenuContacts).click().perform();
		Util.waitForElement(driver, deleteLnk, 20);
		deleteLnk.click();
		Util.waitForAJAX(driver);
	}

	public String getParentFirstName() {
		Util.waitForElement(driver, parentFirstName, 20);
		return parentFirstName.getText();
	}

	public void clickCovenantSection() {
		Util.waitForElement(driver, covenantSection, 20);
		covenantSection.click();
		Util.waitForAJAX(driver);
	}

	public boolean isReportingCovPresent() {
		Util.waitForElement(driver, reportingCov, 20);
		return reportingCov.isDisplayed();
	}

	public void addReportingCovenant() {
		Util.waitForElement(driver, addReportingCov, 20);
		addReportingCov.click();
		Util.waitForAJAX(driver);
	}

	public String getReportingCovTypeTxt() {
		Util.waitForElement(driver, reportingCovType, 20);
		return reportingCovType.getText();
	}

	public boolean isSaveBtnPresent() {
		Util.waitForElementPresent(driver, By.linkText("Save"), 30);
		return saveCovenant.isDisplayed();

	}

	public boolean isEditBtnPresent() {
		Util.waitForElement(driver, editCovenant, 20);
		return editCovenant.isDisplayed();
	}

	public void enterCovenantName(String value) {
		Util.waitForElement(driver, covenantName, 20);
		covenantName.clear();
		covenantName.sendKeys(value);
	}

	public void enterExpectedValue(String value) {
		expectedVal.clear();
		expectedVal.sendKeys(value);
	}

	public void enterActualValue(String value) {
		Util.waitForElement(driver, actualVal, 30);
		actualVal.clear();
		actualVal.sendKeys(value);
	}

	public void cancelCovenantDetails() {
		Util.waitForElement(driver, cancelCovenant, 20);
		cancelCovenant.click();
		Util.waitForAJAX(driver);
	}

	public boolean isCovenantPresentOnGrid(String gridLocator) {
		Util.waitForElementPresent(driver, By.xpath(gridLocator), 20);
		lstWebElements = driver.findElements(By.xpath(gridLocator));

		boolean isDataPresent = false;
		for (int i = 1; i <= lstWebElements.size(); i++) {
			element = driver.findElement(By.xpath(gridLocator + "[" + i
					+ "]/td[1]"));
			if (!element.getText().equalsIgnoreCase("No Data Available")) {
				isDataPresent = true;
				break;
			}
		}
		return isDataPresent;
	}

	public boolean isReportCovPresentOnGrid() {
		return isCovenantPresentOnGrid(reportCovGrid);
	}

	public boolean isRecordOnCovenantSummary() {
		Util.waitForElementPresent(driver, By.xpath(recordCovGrid), 20);
		lstWebElements = driver.findElements(By.xpath(recordCovGrid));

		boolean isDataPresent = false;
		for (int i = 1; i <= lstWebElements.size(); i++) {
			element = driver.findElement(By.xpath(recordCovGrid + "[" + i
					+ "]/td[1]"));
			if (!element.getText().equalsIgnoreCase("No Data Available")) {
				isDataPresent = true;
				break;
			}
		}
		return isDataPresent;
	}

	public String getReportingCovStatus(String covName) {
		Util.waitForElementPresent(driver, By.xpath(reportCovGrid), 20);
		lstWebElements = driver.findElements(By.xpath(reportCovGrid));

		for (int i = 1; i <= lstWebElements.size(); i++) {
			element = driver.findElement(By.xpath(reportCovGrid + "[" + i
					+ "]/td[1]"));
			if (element.getText().equalsIgnoreCase(covName)) {
				element = driver.findElement(By.xpath(reportCovGrid + "[" + i
						+ "]/td[8]"));
				return element.getText();
			}
		}
		return null;

	}

	public boolean isAddedCovenantNamePresent(String covName) {
		Util.waitForElementPresent(driver, By.xpath(reportCovGrid), 20);
		lstWebElements = driver.findElements(By.xpath(reportCovGrid));

		for (int i = 1; i <= lstWebElements.size(); i++) {
			element = driver.findElement(By.xpath(reportCovGrid + "[" + i
					+ "]/td[1]"));
			if (element.getText().equalsIgnoreCase(covName)) {
				return true;
			}
		}
		return false;
	}

	public Customer360Details clickDetailsLnkReportCov() {
		Util.waitForAJAX(driver);
		actions.moveToElement(actionMenuReportCov).click().perform();
		// Util.waitForElement(detailsLnk, 20);
		Util.waitForElementPresent(driver, By.linkText("Details"), 30);
		detailsLnk.click();
		Util.waitForAJAX(driver);
		return new Customer360Details(driver);
	}

	public void editDetailsOfCov() {
		Util.waitForElement(driver, editCovenant, 20);
		editCovenant.click();
		Util.waitForAJAX(driver);
	}

	public void selectEventFrequency(String value) {
		Util.waitForElement(driver, covenantName, 20);
		Util.enableAllDropdowns(driver);
		Util.selectItemFromList(driver, eventFreq, value);
	}

	public void selectmethodOfComm(String value) {
		Util.waitForElement(driver, covenantName, 20);
		Util.enableAllDropdowns(driver);
		Util.selectItemFromList(driver, methodOfComm, value);
	}

	public void selectFDueDate(String dDate) {
		fDueDate.clear();
		fDueDate.sendKeys(dDate);
		Util.waitForAJAX(driver);

	}

	public void enterEffDate(String efDate) {
		effDate.clear();
		effDate.sendKeys(efDate);
	}

	public void enterExpiryDate(String exDate) {
		expiryDate.clear();
		expiryDate.sendKeys(exDate);
	}

	public void enterCovDesc() {
		covDescription.sendKeys("This is a financial covenant");
	}

	public boolean getActualResOfCov(String value) {

		Util.waitForElementPresent(driver, By.xpath(reportCovGrid), 20);
		lstWebElements = driver.findElements(By.xpath(reportCovGrid));

		for (int i = 1; i <= lstWebElements.size(); i++) {
			element = driver.findElement(By.xpath(reportCovGrid + "[" + i
					+ "]/td[4]"));
			if (element.getText().equalsIgnoreCase(value)) {
				return true;
			}
		}
		return false;
	}

	public Date getFDueDate(String date) throws ParseException {
		Date fDDate = format.parse(date);
		return fDDate;
	}

	public boolean isfDueDateCorrect(String date) throws ParseException {
		Util.waitForElementPresent(driver, By.xpath(recordCovGrid), 20);
		lstWebElements = driver.findElements(By.xpath(recordCovGrid));

		for (int i = 1; i <= lstWebElements.size(); i++) {
			element = driver.findElement(By.xpath(recordCovGrid + "[" + i
					+ "]/td[2]"));
			String dDate = element.getText();
			Date fDueDate = format.parse(dDate);
			if (fDueDate.equals(getFDueDate(date))) {
				return true;
			}
		}
		return false;

	}

	public Date getCurrentDate() throws ParseException {

		Calendar cal = Calendar.getInstance();
		currentDate = cal.get(Calendar.YEAR) + "-"
				+ (cal.get(Calendar.MONTH) + 1) + "-" + cal.get(Calendar.DATE);
		Date crntDate = format.parse(currentDate);
		return crntDate;

	}

	public boolean isRecordedDateCorrect() throws ParseException {
		Util.waitForElementPresent(driver, By.xpath(recordCovGrid), 20);
		lstWebElements = driver.findElements(By.xpath(recordCovGrid));

		for (int i = 1; i <= lstWebElements.size(); i++) {
			element = driver.findElement(By.xpath(recordCovGrid + "[" + i
					+ "]/td[1]"));
			String rcrdDate = element.getText();
			Date recDate = format.parse(rcrdDate);
			if (recDate.equals(getCurrentDate())) {
				return true;
			}
		}
		return false;
	}

	public boolean isDateReceivedCorrect() throws ParseException {
		Util.waitForElementPresent(driver, By.xpath(recordCovGrid), 20);
		lstWebElements = driver.findElements(By.xpath(recordCovGrid));

		for (int i = 1; i <= lstWebElements.size(); i++) {
			element = driver.findElement(By.xpath(recordCovGrid + "[" + i
					+ "]/td[5]"));
			String receivedDate = element.getText();
			Date receivdDate = format.parse(receivedDate);
			if (receivdDate.equals(getCurrentDate())) {
				return true;
			}
		}
		return false;
	}

	public int getCntOfCovHistory() {
		Util.waitForElementPresent(driver, By.xpath(recordCovGrid), 20);
		lstWebElements = driver.findElements(By.xpath(recordCovGrid));
		return lstWebElements.size();
	}

	public Customer360Details clickEditLnkReportCov() {
		Util.waitForAJAX(driver);
		actions.moveToElement(actionMenuReportCov).click().perform();
		// Util.waitForElement(editLnk, 20);
		Util.waitForElementPresent(driver, By.linkText("Edit"), 30);
		editLnk.click();
		Util.waitForAJAX(driver);
		return new Customer360Details(driver);
	}

	public void deleteCovenant(String covName) {
		Util.waitForElementPresent(driver, By.xpath(reportCovGrid), 20);
		lstWebElements = driver.findElements(By.xpath(reportCovGrid));

		for (int i = 1; i <= lstWebElements.size(); i++) {
			element = driver.findElement(By.xpath(reportCovGrid + "[" + i
					+ "]/td[1]"));
			if (element.getText().equalsIgnoreCase(covName)) {
				clickDeleteLnkOfCov(i);
				break;
			}
		}

	}

	public void clickDeleteLnkOfCov(int i) {
		Util.waitForAJAX(driver);

		actions.moveToElement(
				driver.findElement(By
						.xpath("//*[@id='covnt']/div[@class='data_content']/div[1]/table/tbody/tr["
								+ i + "]/td[9]/a"))).click().perform();
		Util.waitForElement(driver, deleteLnk, 20);
		deleteLnk.click();
		Util.waitForAJAX(driver);
	}

	public int getNoOfReportCovRecords() {
		Util.waitForElementPresent(driver, By.xpath(reportCovGrid), 20);
		return getNoOfRecordsInGrid(reportCovGrid);
	}

	public void addTestedCovenant() {
		Util.waitForElement(driver, addTestedCov, 20);
		addTestedCov.click();
		Util.waitForAJAX(driver);
	}

	public String getTestedCovTypeTxt() {
		Util.waitForElement(driver, testedCovType, 20);
		return testedCovType.getText();
	}

	public boolean getTestedCovStatus(String value) {
		Util.waitForElementPresent(driver, By.xpath(testedCovGrid), 20);
		lstWebElements = driver.findElements(By.xpath(testedCovGrid));

		for (int i = 1; i <= lstWebElements.size(); i++) {
			element = driver.findElement(By.xpath(testedCovGrid + "[" + i
					+ "]/td[6]"));
			if (element.getText().equalsIgnoreCase(value)) {
				return true;
			}
		}
		return false;
	}

	public void saveCovenant() {
		Util.waitForElement(driver, saveCovenant, 20);
		saveCovenant.click();
		Util.waitForAJAX(driver);
	}

	public Customer360Details clickDetailsLnkTestedCov() {
		Util.waitForAJAX(driver);
		actions.moveToElement(actionMenuTestedCov).click().perform();
		Util.waitForElement(driver, detailsLnk, 20);
		detailsLnk.click();
		Util.waitForAJAX(driver);
		return new Customer360Details(driver);
	}

	public Customer360Details clickEditLnkTestedCov() {
		Util.waitForAJAX(driver);
		actions.moveToElement(actionMenuTestedCov).click().perform();
		Util.waitForElement(driver, editLnk, 20);
		editLnk.click();
		Util.waitForAJAX(driver);
		return new Customer360Details(driver);
	}

	public void clickDeleteLnkTestedCov() {
		Util.waitForAJAX(driver);
		actions.moveToElement(actionMenuTestedCov).click().perform();
		Util.waitForElement(driver, deleteLnk, 20);
		deleteLnk.click();
		Util.waitForAJAX(driver);
	}

	public boolean getTestedCovEventFreq(String value) {
		Util.waitForElementPresent(driver, By.xpath(testedCovGrid), 20);
		lstWebElements = driver.findElements(By.xpath(testedCovGrid));

		for (int i = 1; i <= lstWebElements.size(); i++) {
			element = driver.findElement(By.xpath(testedCovGrid + "[" + i
					+ "]/td[4]"));
			if (element.getText().equalsIgnoreCase(value)) {
				return true;
			}
		}
		return false;
	}

	public int getNoOfTestedCovRecords() {
		Util.waitForElementPresent(driver, By.xpath(testedCovGrid), 20);
		return getNoOfRecordsInGrid(testedCovGrid);
	}

	public void addRelatedPartyCovenant() {
		Util.waitForElement(driver, addRelatedPartyCov, 20);
		addRelatedPartyCov.click();
		Util.waitForAJAX(driver);
	}

	public String getRelatedPartyCovTypeTxt() {
		Util.waitForElement(driver, relPartyCovType, 20);
		return relPartyCovType.getText();
	}

	public boolean getRelPartyCovStatus(String value) {
		Util.waitForElementPresent(driver, By.xpath(relPartyCovGrid), 20);
		lstWebElements = driver.findElements(By.xpath(relPartyCovGrid));

		for (int i = 1; i <= lstWebElements.size(); i++) {
			element = driver.findElement(By.xpath(relPartyCovGrid + "[" + i
					+ "]/td[6]"));
			if (element.getText().equalsIgnoreCase(value)) {
				return true;
			}
		}
		return false;
	}

	public Customer360Details clickDetailsLnkRelPartyCov() {
		Util.waitForAJAX(driver);
		actions.moveToElement(actionMenuRelPartyCov).click().perform();
		Util.waitForElement(driver, detailsLnk, 20);
		detailsLnk.click();
		Util.waitForAJAX(driver);
		return new Customer360Details(driver);
	}

	public Customer360Details clickEditLnkRelPartyCov() {
		Util.waitForAJAX(driver);
		actions.moveToElement(actionMenuRelPartyCov).click().perform();
		Util.waitForElement(driver, editLnk, 20);
		editLnk.click();
		Util.waitForAJAX(driver);
		return new Customer360Details(driver);
	}

	public void clickDeleteLnkRelPartyCov() {
		Util.waitForAJAX(driver);
		actions.moveToElement(actionMenuRelPartyCov).click().perform();
		Util.waitForElement(driver, deleteLnk, 20);
		deleteLnk.click();
		Util.waitForAJAX(driver);
	}

	public boolean getRelPartyCovEventFreq(String value) {
		Util.waitForElementPresent(driver, By.xpath(relPartyCovGrid), 20);
		lstWebElements = driver.findElements(By.xpath(relPartyCovGrid));

		for (int i = 1; i <= lstWebElements.size(); i++) {
			element = driver.findElement(By.xpath(relPartyCovGrid + "[" + i
					+ "]/td[5]"));
			if (element.getText().equalsIgnoreCase(value)) {
				return true;
			}
		}
		return false;
	}

	public int getNoOfRelPartyCovRecords() {
		Util.waitForElementPresent(driver, By.xpath(relPartyCovGrid), 20);
		return getNoOfRecordsInGrid(relPartyCovGrid);
	}

	public void addFinancialCovenant() {
		Util.waitForElement(driver, addFinancialCov, 20);
		addFinancialCov.click();
		Util.waitForAJAX(driver);
	}

	public String getFinancialCovTypeTxt() {
		Util.waitForElement(driver, financialCovType, 20);
		return financialCovType.getText();
	}

	public boolean getFinancialCovStatus(String value) {
		Util.waitForElementPresent(driver, By.xpath(financialCovGrid), 20);
		lstWebElements = driver.findElements(By.xpath(financialCovGrid));

		for (int i = 1; i <= lstWebElements.size(); i++) {
			element = driver.findElement(By.xpath(financialCovGrid + "[" + i
					+ "]/td[5]"));
			if (element.getText().equalsIgnoreCase(value)) {
				return true;
			}
		}
		return false;
	}

	public String getFinancialCovTypeTxtAftEdit() {
		Util.waitForElement(driver, financialCovTypeTxt, 20);
		return financialCovTypeTxt.getText();
	}

	public Customer360Details clickDetailsLnkFinancialCov() {
		Util.waitForElement(driver, actionMenuFinancialCov, 20);
		actions.moveToElement(actionMenuFinancialCov).click().perform();
		Util.waitForElement(driver, detailsLnk, 20);
		detailsLnk.click();
		Util.waitForAJAX(driver);
		return new Customer360Details(driver);
	}

	public Customer360Details clickEditLnkFinancialCov() {
		Util.waitForElement(driver, actionMenuFinancialCov, 20);
		actions.moveToElement(actionMenuFinancialCov).click().perform();
		Util.waitForElement(driver, editLnk, 20);
		editLnk.click();
		Util.waitForAJAX(driver);
		return new Customer360Details(driver);
	}

	public void clickDeleteLnkFinancialCov() {
		Util.waitForElement(driver, actionMenuFinancialCov, 20);
		actions.moveToElement(actionMenuFinancialCov).click().perform();
		Util.waitForElement(driver, deleteLnk, 20);
		deleteLnk.click();
		Util.waitForAJAX(driver);
	}

	public int getNoOfFinancialCovRecords() {
		Util.waitForElementPresent(driver, By.xpath(financialCovGrid), 20);
		return getNoOfRecordsInGrid(financialCovGrid);
	}

	public void clickCovActiveChkBox() {
		Util.waitForElement(driver, activeFlag, 20);
		activeFlag.click();
	}

	public boolean checkCovActiveChkBox() {
		Util.waitForElement(driver, activeFlag, 20);
		if (activeFlag.isEnabled()) {
			activeFlag.click();
			return false;
		} else {
			activeFlag.click();
			return true;
		}
	}

	public int getTotalActiveFinCov() {
		Util.waitForElement(driver, totalActiveFinCov, 20);
		return Integer.parseInt(totalActiveFinCov.getText());
	}

	public void addOtherCovenant() {
		Util.waitForElement(driver, addOtherCov, 20);
		addOtherCov.click();
		Util.waitForAJAX(driver);
	}

	public int getNoOfOtherCovRecords() {
		Util.waitForElementPresent(driver, By.xpath(otherCovGrid), 20);
		return getNoOfRecordsInGrid(otherCovGrid);
	}

	public String getOtherCovTypeTxt() {
		Util.waitForElement(driver, otherCovType, 20);
		return otherCovType.getText();
	}

	public boolean getOtherCovStatus(String value) {
		Util.waitForElementPresent(driver, By.xpath(otherCovGrid), 20);
		lstWebElements = driver.findElements(By.xpath(otherCovGrid));

		for (int i = 1; i <= lstWebElements.size(); i++) {
			element = driver.findElement(By.xpath(otherCovGrid + "[" + i
					+ "]/td[5]"));
			if (element.getText().equalsIgnoreCase(value)) {
				return true;
			}
		}
		return false;
	}

	public Customer360Details clickDetailsLnkOtherCov() {
		Util.waitForElement(driver, actionMenuOtherCov, 20);
		actions.moveToElement(actionMenuOtherCov).click().perform();
		Util.waitForElement(driver, detailsLnk, 20);
		detailsLnk.click();
		Util.waitForAJAX(driver);
		return new Customer360Details(driver);
	}

	public Customer360Details clickEditLnkOtherCov() {
		Util.waitForElement(driver, actionMenuOtherCov, 20);
		actions.moveToElement(actionMenuOtherCov).click().perform();
		Util.waitForElement(driver, editLnk, 20);
		editLnk.click();
		Util.waitForAJAX(driver);
		return new Customer360Details(driver);
	}

	public void clickDeleteLnkOtherCov() {
		Util.waitForElement(driver, actionMenuOtherCov, 20);
		actions.moveToElement(actionMenuOtherCov).click().perform();
		Util.waitForElement(driver, deleteLnk, 20);
		deleteLnk.click();
		Util.waitForAJAX(driver);
	}

	public boolean getOtherCovEventFreq(String value) {
		Util.waitForElementPresent(driver, By.xpath(otherCovGrid), 20);
		lstWebElements = driver.findElements(By.xpath(otherCovGrid));

		for (int i = 1; i <= lstWebElements.size(); i++) {
			element = driver.findElement(By.xpath(otherCovGrid + "[" + i
					+ "]/td[4]"));
			if (element.getText().equalsIgnoreCase(value)) {
				return true;
			}
		}
		return false;
	}

	public void clickCreditBureausSection() {
		Util.waitForElement(driver, crdBureausSection, 20);
		crdBureausSection.click();
	}

	public boolean isCreditBureausGridPresent() {
		Util.waitForElementPresent(driver, By.xpath(crdBureausGrid), 20);
		return driver.findElement(By.xpath(crdBureausGrid)).isDisplayed();
	}

	public void addCreditBureau() {
		Util.waitForElement(driver, addCrdBureau, 20);
		addCrdBureau.click();
		Util.waitForAJAX(driver);
	}

	public boolean isLatestBureauReportGridPresent() {
		Util.waitForElementPresent(driver, By.xpath(latestBureauReportsGrid),
				20);
		return driver.findElement(By.xpath(latestBureauReportsGrid))
				.isDisplayed();
	}

	public boolean isPullReportEnabled() {
		Util.waitForElement(driver, pullReport, 20);
		if (pullReport.getAttribute("class").equalsIgnoreCase("button_disable")) {
			return false;
		} else {
			return true;
		}
	}

	public void selectBureau(String value) {
		Util.enableAllDropdowns(driver);
		Util.selectItemFromList(driver, bureau, value);
	}

	public void selectReportType(String value) {
		Util.waitForAJAX(driver);
		Util.enableAllDropdowns(driver);
		Util.selectItemFromList(driver, reportType, value);
	}

	public void clickPullReport() {
		Util.waitForElement(driver, pullReport, 20);
		pullReport.click();
		Util.waitForAJAX(driver);
	}

	public boolean isReportOnLstBureauGrid(String value) {
		Util.waitForElementPresent(driver, By.xpath(latestBureauReportsGrid),
				20);
		lstWebElements = driver.findElements(By.xpath(latestBureauReportsGrid));

		for (int i = 1; i <= lstWebElements.size(); i++) {
			element = driver.findElement(By.xpath(latestBureauReportsGrid + "["
					+ i + "]/td[2]"));
			if (element.getText().equalsIgnoreCase(value)) {
				return true;
			}
		}
		return false;
	}

	public void clickLatestBureauReport() {
		Util.waitForElementPresent(driver,
				By.xpath(latestBureauReportsGrid + "[1]/td[2]"), 20);
		driver.findElement(By.xpath(latestBureauReportsGrid + "[1]/td[2]"))
				.click();
	}

	public boolean isCrdBureauReportDisplayed() {
		Util.waitForElement(driver, crdBureauReportDetails, 20);
		if (crdBureauReportDetails.getAttribute("style").isEmpty()) {
			return true;
		} else {
			return false;
		}
	}

	public Customer360Details clickDetailsLnkCrdBureau() {
		Util.waitForElement(driver, actionMenuCrdBureau, 20);
		actions.moveToElement(actionMenuCrdBureau).click().perform();
		Util.waitForElement(driver, detailsLnk, 20);
		detailsLnk.click();
		Util.waitForAJAX(driver);
		return new Customer360Details(driver);
	}

	public Customer360Details clickEditLnkCrdBureau() {
		Util.waitForElement(driver, actionMenuCrdBureau, 20);
		actions.moveToElement(actionMenuCrdBureau).click().perform();
		Util.waitForElement(driver, editLnk, 20);
		editLnk.click();
		Util.waitForAJAX(driver);
		return new Customer360Details(driver);
	}

	public boolean isEditBtnOnCrdBureauDetails() {
		Util.waitForElement(driver, editCrdBureauReport, 20);
		return editCrdBureauReport.isDisplayed();
	}

	public void clickEditCrdBureauBtn() {
		editCrdBureauReport.click();
		Util.waitForAJAX(driver);
	}

	public void clickCustVerificationSection() {
		Util.waitForElement(driver, custVerifSection, 20);
		custVerifSection.click();
	}

	public boolean isCustVerifGridPresent() {
		Util.waitForElementPresent(driver, By.xpath(custVerificationGrid), 20);
		return driver.findElement(By.xpath(custVerificationGrid)).isDisplayed();
	}

	public void addCustVerification() {
		Util.waitForElement(driver, addCustVerification, 20);
		addCustVerification.click();
		Util.waitForAJAX(driver);
	}

	public boolean isDocTypePresent() {
		Util.waitForElement(driver, documentaryType, 20);
		return documentaryType.isDisplayed();
	}

	public void saveCustVerification() {
		Util.waitForElement(driver, saveCustVeri, 20);
		saveCustVeri.click();
		Util.waitForAJAX(driver);
	}

	public void cancelCustVerification() {
		Util.waitForElement(driver, cancelCustVeri, 20);
		cancelCustVeri.click();
		Util.waitForAJAX(driver);
	}

	public boolean isCustIDNumberMandatory() {
		Util.waitForElement(driver, errorMsgCustID, 20);
		return errorMsgCustID.isDisplayed();
	}

	public void enterCustIDNum(String value) {
		Util.waitForElement(driver, custIDNumber, 20);
		custIDNumber.clear();
		custIDNumber.sendKeys(value);
	}

	public boolean isCustIDNumberPresentOnGrid(String value) {
		Util.waitForElementPresent(driver, By.xpath(custVerificationGrid), 20);
		lstWebElements = driver.findElements(By.xpath(custVerificationGrid));

		for (int i = 1; i <= lstWebElements.size(); i++) {
			element = driver.findElement(By.xpath(custVerificationGrid + "["
					+ i + "]/td[2]"));
			Util.waitForElement(driver, element, 20);
			if (element.getText().equalsIgnoreCase(value)) {
				return true;
			}
		}
		return false;
	}

	public int getNumOfRecordsOnCustVeriGrid() {
		Util.waitForElementPresent(driver, By.xpath(custVerificationGrid), 20);
		Util.waitForAJAX(driver);
		return getNoOfRecordsInGrid(custVerificationGrid);
	}

	public Customer360Details clickDetailsLnkCustVerifi() {
		Util.waitForElement(driver, actionMenuCustVerifi, 20);
		actions.moveToElement(actionMenuCustVerifi).click().perform();
		Util.waitForElement(driver, detailsLnk, 20);
		detailsLnk.click();
		Util.waitForAJAX(driver);
		return new Customer360Details(driver);
	}

	public Customer360Details clickEditLnkCustVerifi() {
		Util.waitForElement(driver, actionMenuCustVerifi, 20);
		actions.moveToElement(actionMenuCustVerifi).click().perform();
		Util.waitForElement(driver, editLnk, 20);
		editLnk.click();
		Util.waitForAJAX(driver);
		return new Customer360Details(driver);
	}

	public void clickDeleteLnkCustVerifi() {
		Util.waitForElement(driver, actionMenuCustVerifi, 20);
		actions.moveToElement(actionMenuCustVerifi).click().perform();
		Util.waitForElement(driver, deleteLnk, 20);
		deleteLnk.click();
		Util.waitForAJAX(driver);
	}

	public boolean isEditCustVerifiBtnPresent() {
		Util.waitForElement(driver, editCustVerifi, 20);
		return editCustVerifi.isDisplayed();
	}

	public boolean isSaveCustVerifiBtnPresent() {
		Util.waitForElement(driver, saveCustVeri, 20);
		return saveCustVeri.isDisplayed();
	}

	public void clickEditCustVerification() {
		Util.waitForElement(driver, editCustVerifi, 20);
		editCustVerifi.click();
		Util.waitForAJAX(driver);
	}

	public String getCustIDNum() {
		Util.waitForElement(driver, custIDNumber, 20);
		return custIDNumber.getText();
	}

	public void clickCustWriteUpSection() {
		Util.waitForElement(driver, custWriteUpSection, 20);
		custWriteUpSection.click();
	}

	public boolean isCustWriteUpEditBtnPresent() {
		Util.waitForElement(driver, editCustWriteUp, 20);
		return editCustWriteUp.isDisplayed();
	}

	public void clickEditCustWriteUp() {
		Util.waitForElement(driver, editCustWriteUp, 20);
		editCustWriteUp.click();
	}

	public boolean isEditCustWriteUpBtnPresent() {
		Util.waitForElement(driver, editCustWriteUp, 20);
		return editCustWriteUp.isDisplayed();
	}

	public void clickMngmtStructTxtArea() {
		Util.waitForElement(driver, mngmtStructTxtArea, 20);
		mngmtStructTxtArea.click();
		Util.waitForAJAX(driver);
	}

	public boolean isContentEditorPopupPresent() {
		Util.waitForElement(driver, contentEditorPopup, 20);
		return contentEditorPopup.isDisplayed();
	}

	public void enterDataInEditorPopup(String value) {
		Util.waitForElement(driver, contentEditorPopup, 20);
		driver.switchTo().frame(driver.findElement(By.tagName("iframe")));
		editorPopupTxtArea.sendKeys(value);
	}

	public void clickPopupOKBtn() {
		driver.switchTo().defaultContent();
		Util.waitForElement(driver, contentEditorPopup, 20);
		popUpSaveBtn.click();
	}

	public void clickPopupCancelBtn() {
		driver.switchTo().defaultContent();
		Util.waitForElement(driver, contentEditorPopup, 20);
		popUpCancelBtn.click();
	}

	public String getMngmtStructTxtValue() {
		Util.waitForElement(driver, mngmtStructTxtArea, 20);
		return mngmtStructTxtArea.getText();
	}

	public String getMngmtStructValueAfterSave() {
		Util.waitForElement(driver, mngmtStructLabel, 20);
		return mngmtStructLabel.getText();
	}

	public void clickSaveCustWriteUp() {
		Util.waitForElement(driver, saveCustWriteUp, 20);
		saveCustWriteUp.click();
		Util.waitForAJAX(driver);
	}

	public void clickCancelCustWriteUp() {
		Util.waitForElement(driver, cancelCustWriteUp, 20);
		cancelCustWriteUp.click();
		Util.waitForAJAX(driver);
	}

	public void clickIndustryBkgrdTxtArea() {
		Util.waitForElement(driver, industryBkgrdTxtArea, 20);
		industryBkgrdTxtArea.click();
		Util.waitForAJAX(driver);
	}

	public String getIndustryBkgrdTxtValue() {
		Util.waitForElement(driver, industryBkgrdTxtArea, 20);
		return industryBkgrdTxtArea.getText();
	}

	public String getIndustryBkgrdValueAfterSave() {
		Util.waitForElement(driver, industryBkgrdLabel, 20);
		return industryBkgrdLabel.getText();
	}

	public void clickCompanyBkgrdTxtArea() {
		Util.waitForElement(driver, companyBkgrdTxtArea, 20);
		companyBkgrdTxtArea.click();
		Util.waitForAJAX(driver);
	}

	public String getCompanyBkgrdTxtValue() {
		Util.waitForElement(driver, companyBkgrdTxtArea, 20);
		return companyBkgrdTxtArea.getText();
	}

	public String getCompanyBkgrdValueAfterSave() {
		Util.waitForElement(driver, companyBkgrdLabel, 20);
		return companyBkgrdLabel.getText();
	}

	public void clickGrpStructureTxtArea() {
		Util.waitForElement(driver, grpStructureTxtArea, 20);
		grpStructureTxtArea.click();
		Util.waitForAJAX(driver);
	}

	public String getGrpStructureTxtValue() {
		Util.waitForElement(driver, grpStructureTxtArea, 20);
		return grpStructureTxtArea.getText();
	}

	public String getGrpStructureValueAfterSave() {
		Util.waitForElement(driver, grpStructureLabel, 20);
		return grpStructureLabel.getText();
	}

	public void clickBusinessIdeaTxtArea() {
		Util.waitForElement(driver, businessIdeaTxtArea, 20);
		businessIdeaTxtArea.click();
		Util.waitForAJAX(driver);
	}

	public String getBusinessIdeaTxtValue() {
		Util.waitForElement(driver, businessIdeaTxtArea, 20);
		return businessIdeaTxtArea.getText();
	}

	public String getBusinessIdeaValueAfterSave() {
		Util.waitForElement(driver, businessIdeaLabel, 20);
		return businessIdeaLabel.getText();
	}

	public void clickBusinessStrategyTxtArea() {
		Util.waitForElement(driver, businessStrategyTxtArea, 20);
		businessStrategyTxtArea.click();
		Util.waitForAJAX(driver);
	}

	public String getBusinessStrategyTxtValue() {
		Util.waitForElement(driver, businessStrategyTxtArea, 20);
		return businessStrategyTxtArea.getText();
	}

	public String getBusinessStrategyValueAfterSave() {
		Util.waitForElement(driver, businessStrategyLabel, 20);
		return businessStrategyLabel.getText();
	}

	public void clickBusinessOpportTxtArea() {
		Util.waitForElement(driver, businessOpportTxtArea, 20);
		businessOpportTxtArea.click();
		Util.waitForAJAX(driver);
	}

	public String getBusinessOpportTxtValue() {
		Util.waitForElement(driver, businessOpportTxtArea, 20);
		return businessOpportTxtArea.getText();
	}

	public String getBusinessOpportValueAfterSave() {
		Util.waitForElement(driver, businessOpportLabel, 20);
		return businessOpportLabel.getText();
	}

	public void clickCustGroupSection() {
		Util.waitForElement(driver, custGroupSection, 20);
		custGroupSection.click();
	}

	public boolean isCustGroupGridPresent() {
		Util.waitForElementPresent(driver, By.xpath(custGroupGrid), 20);
		return driver.findElement(By.xpath(custGroupGrid)).isDisplayed();
	}

	public void addCustGroup() {
		Util.waitForElement(driver, addCustGroup, 20);
		addCustGroup.click();
		Util.waitForAJAX(driver);
	}

	public boolean isGroupNamePresent() {
		Util.waitForElement(driver, groupName, 20);
		return groupName.isDisplayed();
	}

	public void saveCustGroup() {
		Util.waitForElement(driver, saveCustGroup, 20);
		saveCustGroup.click();
		Util.waitForAJAX(driver);
	}

	public boolean isCustGrpNameMandatory() {
		Util.waitForElement(driver, errorMsgGroupName, 20);
		return errorMsgGroupName.isDisplayed();
	}

	public void enterGroupName(String value) {
		Util.waitForElement(driver, groupName, 20);
		groupName.sendKeys(value);
	}

	public void selectGroupStatus(String value) {
		Util.waitForElement(driver, groupStatus, 20);
		Util.selectItemFromList(driver, groupStatus, value);
	}

	public boolean isCustGroupPresentOnGrid(String groupName) {
		Util.waitForElementPresent(driver, By.xpath(custGroupGrid), 20);
		lstWebElements = driver.findElements(By.xpath(custGroupGrid));

		for (int i = 1; i <= lstWebElements.size(); i++) {
			element = driver.findElement(By.xpath(custGroupGrid + "[" + i
					+ "]/td[1]"));
			if (element.getText().equalsIgnoreCase("No Data Available")) {
				return false;
			} else if (element.getText().equalsIgnoreCase(groupName)) {
				return true;
			}
		}
		return false;
	}

	public Customer360Details clickDetailsLnkCustGroup() {
		Util.waitForElement(driver, actionMenuCustGroup, 20);
		actions.moveToElement(actionMenuCustGroup).click().perform();
		// Util.waitForElement(detailsLnk, 20);
		Util.waitForElementPresent(driver, By.linkText("Details"), 30);
		detailsLnk.click();
		Util.waitForAJAX(driver);
		return new Customer360Details(driver);
	}

	public Customer360Details clickEditLnkCustGroup() {
		Util.waitForElement(driver, actionMenuCustGroup, 20);
		actions.moveToElement(actionMenuCustGroup).click().perform();
		Util.waitForElement(driver, editLnk, 20);
		editLnk.click();
		Util.waitForAJAX(driver);
		return new Customer360Details(driver);
	}

	public void clickDeleteLnkCustGroup() {
		Util.waitForElement(driver, actionMenuCustGroup, 20);
		actions.moveToElement(actionMenuCustGroup).click().perform();
		Util.waitForElement(driver, deleteLnk, 20);
		deleteLnk.click();
		Util.waitForAJAX(driver);
	}

	public boolean isCustPresentOnGroupMemberGrid(String customerName) {
		Util.waitForElementPresent(driver, By.xpath(custGroupMemberGrid), 20);
		lstWebElements = driver.findElements(By.xpath(custGroupMemberGrid));

		for (int i = 1; i <= lstWebElements.size(); i++) {
			element = driver.findElement(By.xpath(custGroupMemberGrid + "[" + i
					+ "]/td[1]"));
			if (element.getText().equalsIgnoreCase("No Data Available")) {
				return false;
			} else if (element.getText().equalsIgnoreCase(customerName)) {
				return true;
			}
		}
		return false;
	}

	public int getNoOfCustOnGrpMemberGrid() {
		return getNoOfRecordsInGrid(custGroupMemberGrid);
	}

	public void editCustGroup() {
		Util.waitForElement(driver, editCustDetailsBtn, 20);
		editCustDetailsBtn.click();
		Util.waitForAJAX(driver);
	}

	public void addGroupMembers() {
		Util.waitForElement(driver, addGroupMember, 20);
		addGroupMember.click();
	}

	public void addCustOnGroupMemberGrid(String customerName) {
		Util.waitForElementPresent(driver, By.xpath(custGroupMemberGrid), 20);
		int noOfMembers = getNoOfRecordsInGrid(custGroupMemberGrid);
		element = driver.findElement(By.xpath(custGroupMemberGrid + "["
				+ noOfMembers + "]/td[1]/span/input"));

		element.sendKeys(customerName);
		element.sendKeys(Keys.ENTER);
		Util.waitForAJAX(driver);
	}

	public void clickOnFirstCustNameOfList() {
		Util.waitForElement(driver, firstCustNameFrmList, 20);
		firstCustNameFrmList.click();
	}

	public boolean isAddedCustomerPresentOnGrp(String cName) {

		Util.waitForElementPresent(driver, By.xpath(custGroupMemberGrid), 20);
		lstWebElements = driver.findElements(By.xpath(custGroupMemberGrid));

		for (int i = 1; i <= lstWebElements.size(); i++) {
			element = driver.findElement(By.xpath(custGroupMemberGrid + "[" + i
					+ "]/td[1]"));
			if (element.getText().equalsIgnoreCase(cName)) {
				return true;
			}
		}
		return false;
	}

	public void clickSaveBtn() {
		saveBtnOnGrps.click();
		Util.waitForAJAX(driver);
		Util.waitForElementPresent(driver, By.xpath(custGroupGrid), 30);
	}

	public void clickProceedBtn() throws InterruptedException {
		Util.waitForAJAX(driver);
		Util.waitForElementPresent(driver,
				By.xpath("//*[@id='dataContent']/div[2]/div[4]/div[2]/a/b"), 60);
		dupCustCheck_proceedButton.click();
	}

	public void enterDOB(String value) {
		dob_individual.clear();
		// Util.waitForElement(dob_individual, 20);
		dob_individual.sendKeys(value);
	}

	public void selectCovType(String covType) {
		Util.enableAllDropdowns(driver);
		Util.selectItemFromList(driver, covenantType, covType);
		Util.waitForAJAX(driver);
	}

	public void selectCovSubtype(String covSubtype) {
		Util.enableAllDropdowns(driver);
		Util.selectItemFromList(driver, covenantSubtype, covSubtype);
		Util.waitForAJAX(driver);
	}

	public void clickRelationshipSection() {
		Util.waitForElement(driver, relationshipLink, 20);
		relationshipLink.click();
	}

	public boolean isrelationshipCorpHiGridPresent() {
		Util.waitForElementPresent(driver,
				By.xpath(relationshipCorpHieracrchyGrid), 20);
		return driver.findElement(By.xpath(relationshipCorpHieracrchyGrid))
				.isDisplayed();
	}

	public void addRelationshpOfCustHi() {
		Util.waitForElement(driver, addBtnOnCorpHieararchy, 20);
		addBtnOnCorpHieararchy.click();
		Util.waitForAJAX(driver);
	}

	public boolean isRelatedToPresent() {
		Util.waitForElement(driver, relatedToField, 20);
		return relatedToField.isDisplayed();
	}

	public void enterRelatedTo(String cName) {
		relatedToField.sendKeys(cName);

	}

	public void clickSearchIcon() {
		searchIcon.click();
		Util.waitForAJAX(driver);
	}

	public void selectSearchedCust() {

		lstWebElements = driver.findElements(By.xpath(searchedCustomerLst));
		Util.waitForElementPresent(driver,
				By.xpath(searchedCustomerLst + "[1]"), 60);
		String relToName = driver.findElement(
				By.xpath(searchedCustomerLst + "[1]/td[4]")).getText();
		setRelatedToName(relToName);
		element = driver.findElement(By.xpath(searchedCustomerLst
				+ "[1]/td[1]/input"));

		element.click();
		selectBtn.click();
		Util.waitForAJAX(driver);
	}

	public void selectrelationshipType(String option) {
		Util.waitForElement(driver, relationshipType, 30);
		Util.selectItemFromList(driver, relationshipType, option);
	}

	public void clickSaveBtnOnRelationship() {
		saveBtnOnCustHi.click();
		Util.waitForAJAX(driver);
	}

	public boolean isAddedrelatedToPresent() {
		Util.waitForElementPresent(driver,
				By.xpath(relationshipCorpHieracrchyGrid), 30);
		lstWebElements = driver.findElements(By
				.xpath(relationshipCorpHieracrchyGrid));

		for (int i = 1; i <= lstWebElements.size(); i++) {
			element = driver
					.findElement(By.xpath(relationshipCorpHieracrchyGrid + "["
							+ i + "]/td[3]"));
			if (element.getText().equalsIgnoreCase(getRelatedToName())) {
				return true;
			}
		}
		return false;
	}

	public void enterCustomerSince(String value) {
		custSinceContact.clear();
		custSinceContact.sendKeys(value);
	}

	public void clickExternalAccountSection() {
		Util.waitForElement(driver, externalAccSection, 20);
		externalAccSection.click();
		Util.waitForAJAX(driver);
	}

	public void enterTaxIdentification(String value) {
		Util.waitForElement(driver, taxidContact, 20);
		taxidContact.sendKeys(value);
	}

	public boolean isExternalAccountGridPresent() {
		Util.waitForElementPresent(driver, By.xpath(externalAccGrid), 20);
		return driver.findElement(By.xpath(externalAccGrid)).isDisplayed();
	}

	public void addLoanSummary() {
		Util.waitForElement(driver, addLoanSummary, 20);
		addLoanSummary.click();
		Util.waitForAJAX(driver);
	}

	public void enterAccountNumber(String value) {
		accountNo.clear();
		Util.waitForElement(driver, accountNo, 20);
		accountNo.sendKeys(value);

	}

	public void selectRelationship(String value) {
		Util.enableAllDropdowns(driver);
		Util.selectItemFromList(driver, loanRelationship, value);
		Util.waitForAJAX(driver);
	}

	public void clickSaveLoanSummary() {
		Util.waitForAJAX(driver);
		saveLoanSummary.click();
		Util.waitForAJAX(driver);
	}

	public boolean isLoanSummaryDetailsPresentOnGrid(String value) {
		Util.waitForElementPresent(driver, By.xpath(loanGrid), 20);
		List<WebElement> lstAddr = driver.findElements(By.xpath(loanGrid));

		for (int i = 1; i <= lstAddr.size(); i++) {
			element = driver.findElement(By.xpath(loanGrid + "[" + i
					+ "]/td[1]"));
			if (element.getText().equalsIgnoreCase(value)) {
				return true;
			}
		}
		return false;
	}

	public Customer360Details clickEditExternalAccounts() {
		actions.moveToElement(actionMenuExternalAccounts).click().perform();
		Util.waitForElement(driver, editLoanSummary, 20);
		editLoanSummary.click();
		Util.waitForAJAX(driver);
		return new Customer360Details(driver);
	}

	public void enterCommitmentBalance(String value) {
		commitmentBalance.clear();
		Util.waitForElement(driver, commitmentBalance, 20);
		commitmentBalance.sendKeys(value);
		Util.waitForAJAX(driver);
	}

	public boolean isAccountNoPresent() {
		Util.waitForElement(driver, parentaccountNo, 20);
		return parentaccountNo.isDisplayed();
	}

	public void clickInternalAccountSection() {
		Util.waitForElement(driver, internalAccSection, 20);
		internalAccSection.click();
		Util.waitForAJAX(driver);
	}

	public boolean isInternalAccountGridPresent() {
		Util.waitForElementPresent(driver, By.xpath(internalAccGrid), 20);
		return driver.findElement(By.xpath(internalAccGrid)).isDisplayed();
	}

	public void addLoanSummaryInternal() {
		Util.waitForElement(driver, addLoanSummaryInternal, 20);
		addLoanSummaryInternal.click();
		Util.waitForAJAX(driver);
	}

	public void clickSaveLoanSummaryInternal() {
		Util.waitForAJAX(driver);
		saveLoanSummaryInternal.click();
		Util.waitForAJAX(driver);
	}

	public void enterAccountNumberInternal(String value) {
		accountNo.clear();
		Util.waitForElement(driver, accountNo, 20);
		accountNo.sendKeys(value);

	}

	public void selectRelationshipInternal(String value) {
		Util.enableAllDropdowns(driver);
		Util.selectItemFromList(driver, loanRelationship, value);
		Util.waitForAJAX(driver);
	}

	public boolean isLoanSummaryDetailsPresentOnGridforInternal(String value) {
		Util.waitForElementPresent(driver, By.xpath(loanGridInternal), 20);
		List<WebElement> lstAddr = driver.findElements(By
				.xpath(loanGridInternal));

		for (int i = 1; i <= lstAddr.size(); i++) {
			element = driver.findElement(By.xpath(loanGridInternal + "[" + i
					+ "]/td[1]"));
			if (element.getText().equalsIgnoreCase(value)) {
				return true;
			}
		}
		return false;
	}

	public Customer360Details clickEditInternalAccounts() {
		actions.moveToElement(actionMenuInternalAccounts).click().perform();
		Util.waitForElement(driver, editLoanSummary, 20);
		editLoanSummary.click();
		Util.waitForAJAX(driver);
		return new Customer360Details(driver);
	}

	public void addRelationshpOfRelatedParties() {
		Util.waitForElement(driver, addBtnOnRelatedParties, 20);
		addBtnOnRelatedParties.click();
		Util.waitForAJAX(driver);
	}

	public void selectSearchedCustForRelatedParties() {
		Util.waitForElementPresent(driver, By.xpath(searchedCustomerLst), 60);
		lstWebElements = driver.findElements(By.xpath(searchedCustomerLst));
		String relToName = driver.findElement(
				By.xpath(searchedCustomerLst + "[2]/td[4]")).getText();
		setRelatedToName(relToName);
		element = driver.findElement(By.xpath(searchedCustomerLst
				+ "[2]/td[1]/input"));

		element.click();
		selectBtn.click();
		Util.waitForAJAX(driver);
	}

	public void enterOwnership(String ownPer) {
		ownership.sendKeys(ownPer);
	}

	public boolean isAddedrelatedToPresentForRelatedPArties() {
		Util.waitForElementPresent(driver,
				By.xpath(relationshipRelatedPartiesGrid), 30);
		lstWebElements = driver.findElements(By
				.xpath(relationshipRelatedPartiesGrid));

		for (int i = 1; i <= lstWebElements.size(); i++) {
			element = driver
					.findElement(By.xpath(relationshipRelatedPartiesGrid + "["
							+ i + "]/td[1]"));
			if (element.getText().equalsIgnoreCase(getRelatedToName())) {
				return true;
			}
		}
		return false;
	}

	public void clickCommBubble() {
		commBubble.click();
		Util.waitForAJAX(driver);
	}

	public void enterComment(String comment) {

		Util.waitForElementPresent(driver, By.id("commentTxt"), 30);
		commentTxtBox.sendKeys(comment);
	}

	public void clickAddCommentBtn() {
		addCmntBtn.click();
		Util.waitForAJAX(driver);
	}

	public boolean isAddedCommentPresent() {
		Util.waitForElementPresent(driver,
				By.xpath("//*[@id='result_div']/div/div[1]/div[1]"), 30);
		return addedCommentSection.isDisplayed();

	}

	public void clickDcoumentsLnk() {
		documentsLnk.click();
		Util.waitForAJAX(driver);
	}

	public boolean isDocumentsGridPresent() {
		Util.waitForElementPresent(driver, By.xpath(documentsGrid), 30);
		return driver.findElement(By.xpath(documentsGrid)).isDisplayed();

	}

	public void clickAddDocLnk() {
		addDocLink.click();
		Util.waitForAJAX(driver);
	}

	public boolean isUploadBtnPresent() {
		Util.waitForElement(driver, uploadBtn, 30);
		return uploadBtn.isDisplayed();
	}

	public void clickUploadBtn() {
		Util.waitForElementPresent(driver,
				By.xpath("//*[@id='data_content']/div[2]/a[3]"), 30);
		uploadBtn.click();
		Util.waitForAJAX(driver);
	}

	public void uploadPDFFile() {

		Util.waitForElementPresent(driver, By.xpath("//*[@id='file']"), 20);
	}

	public void selectDocumentName(String dName) {
		Util.waitForElement(driver, docName, 30);
		Util.selectItemFromList(driver, docName, dName);
	}

	public void clickuploadBtnOnUploader() {
		uploadBtnOnUploader.click();
		Util.waitForAJAX(driver);
	}

	public boolean isDocumentUploaded() {

		Util.waitForElementPresent(driver, By.xpath(documentLibraryGrid), 30);
		lstWebElements = driver.findElements(By.xpath(documentLibraryGrid));

		for (int i = 1; i <= lstWebElements.size(); i++) {
			element = driver.findElement(By.xpath(documentLibraryGrid + "[" + i
					+ "]/td[1]"));
			if (!element.getText().equalsIgnoreCase("No Data Available")) {
				return true;

			}

		}
		return false;
	}

	public boolean isFileNameCorrect(String fName) {
		lstWebElements = driver.findElements(By.xpath(documentLibraryGrid));
		for (int i = 1; i <= lstWebElements.size(); i++) {
			element = driver.findElement(By.xpath(documentLibraryGrid + "[" + i
					+ "]/td[3]/a"));
			if (element.getText().equalsIgnoreCase(fName)) {
				return true;

			}
		}
		return false;
	}

	public boolean isDocTypeCorrect(String dType) {
		lstWebElements = driver.findElements(By.xpath(documentLibraryGrid));
		for (int i = 1; i <= lstWebElements.size(); i++) {
			element = driver.findElement(By.xpath(documentLibraryGrid + "[" + i
					+ "]/td[4]"));
			if (element.getText().equalsIgnoreCase(dType)) {
				return true;

			}
		}
		return false;
	}

	public boolean isCreatedDateCorrect() throws ParseException {
		lstWebElements = driver.findElements(By.xpath(documentLibraryGrid));
		for (int i = 1; i <= lstWebElements.size(); i++) {
			element = driver.findElement(By.xpath(documentLibraryGrid + "[" + i
					+ "]/td[6]"));
			String cDate = element.getText();
			Date createdDate = format.parse(cDate);

			if (createdDate.equals(getCurrentDate())) {
				return true;
			}
		}
		return false;
	}

	public void selectuploadedFilesForMerging() {
		Util.waitForElementPresent(driver, By.xpath(documentLibraryGrid), 30);
		lstWebElements = driver.findElements(By.xpath(documentLibraryGrid));
		for (int i = 1; i <= lstWebElements.size(); i++) {
			element = driver.findElement(By.xpath(documentLibraryGrid + "[" + i
					+ "]/td[1]/input"));
			element.click();
		}
	}

	public void clickMergeBtn() {
		mergeBtn.click();
		Util.waitForAJAX(driver);
	}

	public void enterMergeDocName(String mName) {

		Util.waitForElementPresent(driver,
				By.xpath("//*[@id='openPopup']/div[2]/div"), 30);
		mergeDocNameTxtBox.sendKeys(mName);

	}

	public void clickMergeBtnOnPopup() {
		mergeBtnOnPopup.click();
		Util.waitForAJAX(driver);
	}

	public boolean isMergedFileNameCorrect(String mergeFName) {
		Util.waitForElementPresent(driver, By.xpath(documentLibraryGrid), 30);
		lstWebElements = driver.findElements(By.xpath(documentLibraryGrid));
		for (int i = 1; i <= lstWebElements.size(); i++) {
			element = driver.findElement(By.xpath(documentLibraryGrid + "[" + i
					+ "]/td[3]/a"));
			if (element.getText().equalsIgnoreCase(mergeFName)) {
				return true;
			}
		}
		return false;
	}

	public boolean isPDFUploaded() {
		Util.waitForElementPresent(driver, By.xpath(documentLibraryGrid), 30);
		lstWebElements = driver.findElements(By.xpath(documentLibraryGrid));
		Boolean result = false;
		for (int i = 1; i <= lstWebElements.size(); i++) {
			element = driver.findElement(By.xpath(documentLibraryGrid + "[" + i
					+ "]/td[3]/a"));
			String mainWindowHandle = driver.getWindowHandle();
			element.click();
			result = verifyOpenedPDF(mainWindowHandle, i);
			driver.close();
			driver.switchTo().window(mainWindowHandle);
			Util.waitForElementPresent(driver,
					By.xpath(".//*[@id='rightContent']/div/div[1]/a[2]"), 30);
		}
		return result;
	}

	public boolean verifyOpenedPDF(String mainWindow, int j) {
		@SuppressWarnings("rawtypes")
		Set s = driver.getWindowHandles();
		@SuppressWarnings("rawtypes")
		Iterator ite = s.iterator();
		while (ite.hasNext()) {
			String popupHandle = ite.next().toString();
			if (!popupHandle.contains(mainWindow)) {
				driver.switchTo().window(popupHandle);
				String url = driver.getCurrentUrl();
				System.out.println("**********url" + j + url);
				Util.waitForElementPresent(driver,
						By.xpath("//*[@id='viewer']"), 60);
				Util.waitForElementPresent(driver,
						By.xpath("//*[@id='numPages']"), 60);
				String pgnum = driver.findElement(
						By.xpath(".//*[@id='numPages']")).getText();
				System.out.println("******pgnum" + j + pgnum);
				return pdfContent.isDisplayed();
			}
		}
		return false;
	}

	public void clickCreateCustLnk() {
		Util.waitForElement(driver, createCustLnk, 5);
		createCustLnk.click();
		Util.waitForAJAX(driver);
	}

	public String getCustHeading() {
		Util.waitForElement(driver, custDetailsHeading, 30);
		return custDetailsHeading.getText();
	}

	public void clickCustHeading() {
		Util.waitForElement(driver, custDetailsHeading, 30);
		custDetailsHeading.click();
	}

	public void enterMainPhnCode(String value) {
		mainPhoneCode.clear();
		mainPhoneCode.sendKeys(value);
	}

	public void enterMainPhnNumber(String value) {
		mainPhnNumbr.clear();
		mainPhnNumbr.sendKeys(value);

	}

	public void enterExtPhnNumber(String value) {
		mainPhnNumbr.clear();
		mainExtNbr.sendKeys(value);
	}

	public void clickAddSec() {
		Util.waitForAJAX(driver);
		addSectionGrid.click();
		Util.waitForAJAX(driver);
	}

	public boolean isCommentBubbleDisplayed() {
		Util.waitForElement(driver, commentBubble, 20);
		if (commentBubble.isDisplayed()) {
			return true;
		} else
			return false;
	}

	public void clickComment() {
		Util.waitForElement(driver, commentBubble, 10);
		commentBubble.click();
		Util.waitForAJAX(driver);
	}

	public void clickOnCommentNotification() {
		Util.waitForElement(driver, commentNotification, 15);
		commentNotification.click();
		Util.waitForAJAX(driver);
	}

	public boolean isCommentPopupOpened() {
		if (categoryLabelOnComment.isDisplayed()
				&& sectionLabelOnComment.isDisplayed()) {
			return true;
		} else
			return false;
	}

	public void clickSectionLablel() {
		Util.waitForElement(driver, sectionLabelOnComment, 10);
		sectionLabelOnComment.click();
	}

	public void clickAddSectionOnCommentNotification() {
		Util.waitForElement(driver, addSectionOnCommentNotification, 15);
		addSectionOnCommentNotification.click();
		Util.waitForAJAX(driver);
	}

	public boolean isCommentEditorDisplayed() {
		if (commentPopup.isDisplayed() && commentPopupText.isDisplayed()) {
			return true;
		} else
			return false;
	}

	public void enterTextOnCommentPopup(String value) {
		Util.waitForElement(driver, commentPopupEditingSection, 20);
		commentPopupEditingSection.sendKeys(value);
		Util.waitForAJAX(driver);
	}

	public void clickOkBtnOnCommentPopup() {
		Util.waitForElement(driver, okBtnOommentPopup, 10);
		okBtnOommentPopup.click();
		Util.waitForAJAX(driver);
	}

	public String getAddedTextOnCommentPopup() {
		return addSectionOnCommentNotification.getText();
	}

	public void clickAddBtnOnCommentBubble() {
		Util.waitForElement(driver, addBtnOnCommentNotification, 15);
		addBtnOnCommentNotification.click();
		Util.waitForAJAX(driver);
	}

	public boolean isAddedCommentDisplayed(String value1, String value2) {
		Util.waitForElementPresent(driver, By.xpath(".//*[@id='commentDiv']"),
				10);
		if (driver
				.findElement(
						By.xpath(".//*[@id='result_div']/div/div/div/div/p"))
				.getText().contains(value1)
				&& driver
						.findElement(
								By.xpath(".//*[@id='result_div']/div/div/div/div/div/span[1]"))
						.getText().contains(value2)) {
			return true;
		} else
			return false;
	}

	public int getCountOfAddedComment(String value) {
		String str = driver
				.findElement(
						By.xpath(".//*[@id='acc_info']/div[2]/div[2]/div/a/div/b/label"))
				.getText();
		str = str.replace('(', ' ').replace(')', ' ').trim();
		if (str.contains(value)) {
			cnt = Integer.parseInt(str);

		}
		return cnt;
	}

	public int getCommentCount() {
		Util.waitForElementPresent(driver,
				By.xpath(".//*[@id='totalNoOfCommentsLabel']"), 15);
		return commentCnt;
	}

	@SuppressWarnings("unchecked")
	public int verifyCommentCount() {
		lstWebElements = driver.findElements(By
				.xpath(".//*[@id='result_div']/div/div"));
		for (int i = 1; i <= lstWebElements.size(); i++) {
			return lstWebElements.size();
		}
		return commentCnt;
	}

	public boolean verifyScrollBar() {
		if (scrollbarSection.isDisplayed()) {
			WebElement scrollbar = driver.findElement(By
					.xpath(".//*[@id='result_div']"));
			scrollbar.sendKeys(Keys.PAGE_DOWN);
			return true;
		} else
			return false;
	}

	public void clickAllOptionOnCommentBubble(String value) {
		Util.selectItemFromList(driver, sectionOnCommentBubble, value);

		Util.waitForAJAX(driver);
	}

}
