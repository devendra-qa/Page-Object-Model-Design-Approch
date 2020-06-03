package com.sf.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sf.qa.base.TestBase;

public class OpportunitiesPage extends TestBase {

	@FindBy(xpath = "//a[@id='relatedListsTab__item']")
	WebElement tab_RelatedTabOnAccount;

	@FindBy(xpath = "//span[contains(@class,'slds-card__header-title')][contains(text(),'Opportunities')]")
	WebElement lnk_OpportunitiesRelatedList;

	@FindBy(xpath = "//h1[@class='slds-page-header__title listViewTitle slds-truncate']")
	WebElement pghdr_Opportunities;

	@FindBy(xpath = "//tr/th[2]/div/a/span[(text()='Opportunity Name')]")
	WebElement colOpportunityName;

	@FindBy(xpath = "(//div[contains(@class,'slds-truncate')][@title='New'])[3]")
	WebElement btn_New;

	// New Opportunity window OR

	@FindBy(xpath = "//input[@maxlength='120']")
	WebElement tb_OpportunityName;

	@FindBy(xpath = "//span[@class='pillText']")
	WebElement tb_AccountName;

	@FindBy(xpath = "(//a[@class='select'][contains(text(),'--None--')])[2]")
	WebElement pl_Type;

	@FindBy(xpath = "(//a[@class='select'][contains(text(),'--None--')])[3]")
	WebElement pl_LeadSource;

	@FindBy(xpath = "//input[contains(@class,'input uiInputSmartNumber')]")
	WebElement tb_Amount;

	@FindBy(xpath = "//div[contains(@class,'form-element')]/input[contains(@class,' input')]")
	WebElement tb_CloseDate;

	@FindBy(xpath = "(//a[@class='select'][contains(text(),'--None--')])[1]")
	WebElement pl_Stage;

	@FindBy(xpath = "//textarea[@maxlength='32000']")
	WebElement ta_Description;

	@FindBy(xpath = "//button[contains(@class,'uiButton forceActionButton')]/span[contains(@class,'label bBody')][(text()='Save')]")
	WebElement btn_Save;

	@FindBy(xpath = "//ul[@class='errorsList']/li")
	WebElement msgError;
	
	// Initialize page factory elements
		public OpportunitiesPage() {
			PageFactory.initElements(driver, this);
		}

	// Actions

	
	public String validateOpportunitiesPageHeader() {
		pghdr_Opportunities.isDisplayed();
		return pghdr_Opportunities.getText();
	}

	public String validateOpportunityNameColumn() {
		colOpportunityName.isDisplayed();
		return colOpportunityName.getText();
	}

	public void clickNewButton() {
		btn_New.isDisplayed();
		btn_New.click();
	}

	public void validateOpportunityNameTextbox() {
		tb_OpportunityName.isDisplayed();
	}

	public String validateAccountNameTextbox() {
		tb_AccountName.isDisplayed();
		return tb_AccountName.getText();
	}

	public String validateTypePicklist() {
		pl_Type.isDisplayed();
		return pl_Type.getText();
	}

	public String validateLeadSourcePicklist() {
		pl_LeadSource.isDisplayed();
		return pl_LeadSource.getText();
	}

	public void validateAmountTextbox() {
		tb_Amount.isDisplayed();
	}

	public void validateCloseDateTextbox() {
		tb_CloseDate.isDisplayed();
	}

	public String validateStagePicklist() {
		pl_Stage.isDisplayed();
		return pl_Stage.getText();
	}

	public void validateDescriptionTextarea() {
		ta_Description.isDisplayed();
	}

	public void validateSaveButton() {
		btn_Save.isDisplayed();
	}

	public String validateRequiredFieldsErrorMessage() {
		msgError.isDisplayed();
		return msgError.getText();
	}

	public void createNewOpportunityOnAccount(String on, String tp, String ls, String am, String cd, String stg,
			String des) {

		tb_OpportunityName.sendKeys(on);
		pl_Type.click();
		WebElement e1 = driver.findElement(By.xpath("//a[contains(text(),'" + tp + "')]"));
		e1.click();
		pl_LeadSource.click();
		WebElement e2 = driver.findElement(By.xpath("//a[contains(text(),'" + ls + "')]"));
		e2.click();
		tb_Amount.sendKeys(am);
		tb_CloseDate.sendKeys(cd);
		pl_Stage.click();
		WebElement e3 = driver.findElement(By.xpath("//a[contains(text(),'" + stg + "')]"));
		e3.click();
		ta_Description.sendKeys(des);
	}
}
