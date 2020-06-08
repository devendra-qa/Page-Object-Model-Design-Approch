package com.sf.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.sf.qa.base.TestBase;
import com.sf.qa.util.TestUtil;

public class AccountsPage extends TestBase {
	TestUtil testUtil;
	WebDriverWait wait;

	JavascriptExecutor js = (JavascriptExecutor) driver;

	// Accounts Tab OR
	@FindBy(xpath = "//span[contains(@class,'forceBreadCrumbItem')]")
	WebElement pghdr_Accounts;

	@FindBy(xpath = "//span[contains(@class,'selectedListView')]")
	WebElement listViewAccount;

	@FindBy(xpath = "//div[contains(text(),'New')]")
	WebElement btn_NewAccount;

	@FindBy(xpath = "//input[@name='Account-search-input']")
	WebElement tb_AccountSearch;

	@FindBy(xpath = "//table/thead/tr/th[3]/div/a/span[text()='Account Name']")
	WebElement colAccountName;

	@FindBy(xpath = "//table/thead/tr/th[4]/div/a/span[text()='Account Site']")
	WebElement colAccountSite;

	@FindBy(xpath = "//table/thead/tr/th[5]/div/a/span[text()='Phone']")
	WebElement colPhone;

	@FindBy(xpath = "//table/thead/tr/th[6]/div/a/span[text()='Account Owner Alias']")
	WebElement colAccountOwnerAlias;

	// New Account Window OR

	@FindBy(xpath = "(//input[@maxlength='255'])[2]")
	WebElement tb_AccountName;

	@FindBy(xpath = "(//a[contains(@class,'select')])[1]")
	WebElement pl_Rating;

	@FindBy(xpath = "(//input[@type='tel'])[1]")
	WebElement tb_Phone;

	@FindBy(xpath = "//input[@type='url']")
	WebElement tb_Website;

	@FindBy(xpath = "(//a[contains(@class,'select')])[2]")
	WebElement pl_Type;

	@FindBy(xpath = "(//a[contains(@class,'select')])[3]")
	WebElement pl_Ownership;

	@FindBy(xpath = "(//a[contains(@class,'select')])[4]")
	WebElement pl_Industry;

	@FindBy(css = "textarea[placeholder='Billing Street']")
	WebElement tb_BillingStreet;

	@FindBy(css = "input[placeholder='Billing City']")
	WebElement tb_BillingCity;

	@FindBy(css = "input[placeholder='Billing State/Province']")
	WebElement tb_BillingState;

	@FindBy(css = "input[placeholder='Billing Zip/Postal Code']")
	WebElement tb_BillingPostalCode;

	@FindBy(css = "input[placeholder='Billing Country']")
	WebElement tb_BillingCountry;

	@FindBy(css = "textarea[placeholder='Shipping Street']")
	WebElement tb_ShippingStreet;

	@FindBy(css = "input[placeholder='Shipping City']")
	WebElement tb_ShippingCity;

	@FindBy(css = "input[placeholder='Shipping State/Province']")
	WebElement tb_ShippingState;

	@FindBy(css = "input[placeholder='Shipping Zip/Postal Code']")
	WebElement tb_ShippingPostalCode;

	@FindBy(css = "input[placeholder='Shipping Country']")
	WebElement tb_ShippingCountry;

	@FindBy(xpath = "(//a[contains(@class,'select')])[8]")
	WebElement pl_Active;

	@FindBy(xpath = "//li[contains(text(),'These required fields must be completed:')]")
	WebElement msgError;

	@FindBy(xpath = "//button[@title='Cancel']")
	WebElement btn_Cancel;

	@FindBy(xpath = "//button[@title='Save & New']")
	WebElement btn_SaveAndNew;

	@FindBy(xpath = "//button[@title='Save']")
	WebElement btn_SaveAccount;

	// Related Tab OR

	@FindBy(xpath = "//a[@id='relatedListsTab__item']")
	WebElement tab_RelatedTabOnAccount;

	// Contacts Related List OR

	@FindBy(xpath = "//h2/a/span[@title='Contacts']")
	WebElement lnk_ContactsRelatedList;

	@FindBy(xpath = "//div[@class='slds-col slds-no-flex slds-grid slds-align-top slds-p-bottom--xx-small test-lvmForceActionsContainer']//ul[@class='branding-actions slds-button-group slds-m-left--xx-small small oneActionsRibbon forceActionsContainer']//div[@class='slds-truncate'][contains(text(),'New')]")
	WebElement btn_NewContact;

	// Opportunities Related List OR

	@FindBy(xpath = "//h2/a/span[@title='Opportunities']")
	WebElement lnk_OpportunitiesRelatedList;

	@FindBy(xpath = "//h1[@class='slds-page-header__title listViewTitle slds-truncate']")
	WebElement pghdr_Opportunities;

	@FindBy(xpath = "//tr/th[2]/div/a/span[(text()='Opportunity Name')]")
	WebElement colOpportunityName;

	@FindBy(xpath = "//div[@class='slds-col slds-no-flex slds-grid slds-align-top slds-p-bottom--xx-small test-lvmForceActionsContainer']//ul[@class='branding-actions slds-button-group slds-m-left--xx-small small oneActionsRibbon forceActionsContainer']//div[@class='slds-truncate'][contains(text(),'New')]")
	WebElement btn_NewOpportunity;

	// New Opportunity Window OR

	@FindBy(xpath = "//input[@maxlength='120']")
	WebElement tb_OpportunityName;

	@FindBy(xpath = "//span[@class='pillText']")
	WebElement tb_OppAccountName;

	@FindBy(xpath = "(//a[@class='select'])[2]")
	WebElement pl_OppType;

	@FindBy(xpath = "(//a[@class='select'])[3]")
	WebElement pl_OppLeadSource;

	@FindBy(xpath = "//input[contains(@class,'input uiInputSmartNumber')]")
	WebElement tb_OppAmount;

	@FindBy(xpath = "//div[contains(@class,'form-element')]/input[contains(@class,' input')]")
	WebElement tb_OppCloseDate;

	@FindBy(xpath = "(//a[@class='select'])[1]")
	WebElement pl_OppStage;

	@FindBy(xpath = "//textarea[@maxlength='32000']")
	WebElement ta_OppDescription;

	@FindBy(xpath = "//button[contains(@class,'uiButton forceActionButton')]/span[contains(@class,'label bBody')][(text()='Save')]")
	WebElement btn_SaveOpportunity;

	@FindBy(xpath = "//ul[@class='errorsList']/li")
	WebElement msg_OppError;

	// Cases Related List OR
	@FindBy(xpath = "//h2/a/span[@title='Cases']")
	WebElement lnk_CasesRelatedList;

	// Notes & Attachments OR

	@FindBy(xpath = "//span[contains(text(),'Notes & Attachments')]")
	WebElement lnk_NotesAndAttachmentsRelatedList;

	@FindBy(xpath = "//h1[contains(text(),'Notes & Attachments')]")
	WebElement pghdr_NotesAndAttachments;

	@FindBy(xpath = "//div[contains(@class,'lvmForceActionsContainer')]//div[contains(text(),'Upload Files')]")
	WebElement btn_UploadFiles;

	@FindBy(xpath = "//span[contains(text(),'Done')]")
	WebElement btn_Done;

	// Initialize page factory elements
	public AccountsPage() {
		PageFactory.initElements(driver, this);
	}

	// Accounts Tab Actions
	public String validatePageTitleAccounts() {
		return driver.getTitle();
	}

	public String validatePageHeaderAccounts() {
		pghdr_Accounts.isDisplayed();
		return pghdr_Accounts.getText();
	}

	public boolean validateAccountSearchTextbox() {
		return tb_AccountSearch.isDisplayed();
	}

	public String validateAccountNameColumn() {
		colAccountName.isDisplayed();
		return colAccountName.getText();
	}

	public String validateAccountSiteColumn() {
		colAccountSite.isDisplayed();
		return colAccountSite.getText();
	}

	public void clickNewButton() {
		btn_NewAccount.click();
	}

	public boolean validateAccountNameTextbox() {
		return tb_AccountName.isDisplayed();
	}

	public String validateRatingPicklist() {
		pl_Rating.isDisplayed();
		return pl_Rating.getText();
	}

	public boolean validatePhoneTextbox() {
		return tb_Phone.isDisplayed();
	}

	public boolean validateWebsiteTextbox() {
		return tb_Website.isDisplayed();
	}

	public String validateTypePicklist() {
		pl_Type.isDisplayed();
		return pl_Type.getText();
	}

	public String validateOwnershipPicklist() {
		pl_Ownership.isDisplayed();
		return pl_Ownership.getText();
	}

	public String validateIndustryPicklist() {
		pl_Industry.isDisplayed();
		return pl_Industry.getText();
	}

	public boolean validateBillingStreetTextbox() {
		return tb_BillingStreet.isDisplayed();
	}

	public boolean validateBillingCityTextbox() {
		return tb_BillingCity.isDisplayed();
	}

	public boolean validateBillingStateTextbox() {
		return tb_BillingState.isDisplayed();
	}

	public boolean validateBillingPostalCodeTextbox() {
		return tb_BillingPostalCode.isDisplayed();
	}

	public boolean validateBillingCountryTextbox() {
		return tb_BillingCountry.isDisplayed();
	}

	public boolean validateShippingStreetTextbox() {
		return tb_ShippingStreet.isDisplayed();
	}

	public boolean validateShippingCityTextbox() {
		return tb_ShippingCity.isDisplayed();
	}

	public boolean validateShippingStateTextbox() {
		return tb_BillingState.isDisplayed();
	}

	public boolean validateShippingPostalCodeTextbox() {
		return tb_ShippingPostalCode.isDisplayed();
	}

	public boolean validateShippingCountryTextbox() {
		return tb_ShippingCountry.isDisplayed();
	}

	public boolean validateActivePicklist() {
		return pl_Active.isDisplayed();
	}

	public void clickSaveButton() {
		btn_SaveAccount.click();
	}

	public String validateRequiredFieldsErrorMessage() {
		msgError.isDisplayed();
		String msg = msgError.getText();
		return msg;
	}

	public void createNewAccount(String aName, String rat, String phn, String ws, String typ, String os, String ind,
			String bStr, String bCty, String bSt, String bZip, String bCntry, String sStr, String sCty, String sSt,
			String sZip, String sCntry, String act) {
		tb_AccountName.sendKeys(aName);
		pl_Rating.click();
		WebElement e1 = driver.findElement(By.xpath("//a[contains(text(),'" + rat + "')]"));
		e1.click();
		tb_Phone.sendKeys(phn);
		tb_Website.sendKeys(ws);
		pl_Type.click();
		WebElement e2 = driver.findElement(By.xpath("//a[contains(text(),'" + typ + "')]"));
		e2.click();
		pl_Ownership.click();
		WebElement e3 = driver.findElement(By.xpath("//a[contains(text(),'" + os + "')]"));
		e3.click();
		pl_Industry.click();
		WebElement e4 = driver.findElement(By.xpath("//a[contains(text(),'" + ind + "')]"));
		e4.click();
		tb_BillingStreet.sendKeys(bStr);
		tb_BillingCity.sendKeys(bCty);
		tb_BillingState.sendKeys(bSt);
		tb_BillingPostalCode.sendKeys(bZip);
		tb_BillingCountry.sendKeys(bCntry);
		tb_ShippingStreet.sendKeys(sStr);
		tb_ShippingCity.sendKeys(sCty);
		tb_ShippingState.sendKeys(sSt);
		tb_ShippingPostalCode.sendKeys(sZip);
		tb_ShippingCountry.sendKeys(sCntry);
		pl_Active.click();
		WebElement e5 = driver.findElement(By.xpath("//a[contains(text(),'" + ind + "')]"));
		e5.click();

	}

	public void selectAccountName(String aName) {
		new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOf(tb_AccountSearch));
		tb_AccountSearch.sendKeys(aName);
		tb_AccountSearch.sendKeys(Keys.ENTER);
		WebElement e1e = driver.findElement(By.xpath("//table/tbody/tr/th/span/a"));
		js.executeScript("arguments[0].click();", e1e);

	}

	// Account Related Tab Actions
	public void validateRelatedTabOnAccountIsSelected() {
		new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOf(tab_RelatedTabOnAccount));
		if (tab_RelatedTabOnAccount.isEnabled()) {
			System.out.println("Related tab is aleready selected");
		} else {
			tab_RelatedTabOnAccount.click();
		}

	}

	// Opportunities Related List Actions
	public void clickOpportunitiesRelatedListLink() {
		lnk_OpportunitiesRelatedList.isDisplayed();
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", lnk_OpportunitiesRelatedList);
	}

	public void clickNewButtonOnOpportunityRelatedList() {
		btn_NewOpportunity.click();
	}

	public void clickSaveOpportunityButtton() {
		btn_SaveOpportunity.click();
	}

	public void createNewOpportunityOnAccount(String on, String tp, String ls, String am, String cd, String stg,
			String des) {

		testUtil = new TestUtil();

		tb_OpportunityName.sendKeys(on);
		pl_OppType.click();
		WebElement e1 = driver.findElement(By.xpath("//a[contains(text(),'" + tp + "')]"));
		e1.click();
		pl_OppLeadSource.click();
		WebElement e2 = driver.findElement(By.xpath("//a[contains(text(),'" + ls + "')]"));
		e2.click();
		tb_OppAmount.sendKeys(am);
		tb_OppCloseDate.sendKeys(testUtil.getFutureDate());
		pl_OppStage.click();
		WebElement e3 = driver.findElement(By.xpath("//a[contains(text(),'" + stg + "')]"));
		e3.click();
		ta_OppDescription.sendKeys(des);
	}

	// Notes & Attachments Related List Actions

	public void clickNotesAndAttachmentsRelatedListLink() {
		lnk_NotesAndAttachmentsRelatedList.isDisplayed();
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", lnk_NotesAndAttachmentsRelatedList);
	}

	public void validateNotesAndAttachmentsPageHeader() {
		pghdr_NotesAndAttachments.isDisplayed();
	}

	public void validateUploadFiles() {
		new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(btn_UploadFiles));
		btn_UploadFiles.click();
	}

	public void clickDoneButton() {
		btn_Done.click();
	}

}
