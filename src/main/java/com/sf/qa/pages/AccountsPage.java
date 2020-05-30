package com.sf.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sf.qa.base.TestBase;

public class AccountsPage extends TestBase {

	// Accounts landing page OR
	@FindBy(xpath = "//span[contains(@class,'forceBreadCrumbItem')]")
	WebElement pghdr_Accounts;

	@FindBy(xpath = "//div[contains(text(),'New')]")
	WebElement btn_New;

	@FindBy(xpath = "//span[contains(@class,'selectedListView')]")
	WebElement listViewAccount;

	@FindBy(xpath = "//table/thead/tr/th[3]/div/a/span[text()='Account Name']")
	WebElement colAccountName;

	@FindBy(xpath = "//table/thead/tr/th[4]/div/a/span[text()='Account Site']")
	WebElement colAccountSite;

	@FindBy(xpath = "//table/thead/tr/th[5]/div/a/span[text()='Phone']")
	WebElement colPhone;

	@FindBy(xpath = "//table/thead/tr/th[6]/div/a/span[text()='Account Owner Alias']")
	WebElement colAccountOwnerAlias;

	// New Account window OR

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

	@FindBy(xpath = "//button[contains(@class,'brand uiButton forceActionButton')]//span[contains(text(),'Save')]")
	WebElement btn_Save;
	// button[@title='Save']

	// Initialize page factory elements
	public AccountsPage() {
		PageFactory.initElements(driver, this);
	}

	// Actions
	public String validatePageTitleAccounts() {
		return driver.getTitle();
	}

	public String validatePageHeaderAccounts() {
		pghdr_Accounts.isDisplayed();
		return pghdr_Accounts.getText();
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
		btn_New.click();
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
		btn_Save.click();
	}

	public String validateRequiredFieldsErrorMessage() {
		msgError.isDisplayed();
		String msg = msgError.getText();
		return msg;
	}
	
	public void createNewAccount(String aName, String rat, String phn, String ws, String typ, String os, String ind, String bStr, String bCty, String bSt, String bZip, String bCntry, String sStr, String sCty, String sSt, String sZip, String sCntry, String act) {
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

}
