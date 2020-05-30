package com.sf.qa.pages;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.sf.qa.base.TestBase;

public class LeadsPage extends TestBase {

	List<WebElement> colName = null;

	// Leads landing page OR
	@FindBy(css = "span[class*=forceBreadCrumbItem]")
	WebElement pghdr_Leads;

	@FindBy(xpath = "//div[contains(text(),'New')]")
	WebElement btn_New;

	@FindBy(xpath = "//div[contains(text(),'Change Status')]")
	WebElement btn_ChangeStatus;

	@FindBy(xpath = "//div[contains(text(),'Change Owner')]")
	WebElement btn_ChangeOwner;

	@FindBy(xpath = "//span[@class='triggerLinkText selectedListView uiOutputText']")
	WebElement listView;

	// New Lead window OR
	@FindBy(xpath = "//h2[contains(text(),'New Lead')]")
	WebElement hdr_NewLead;

	@FindBy(xpath = "(//a[contains(@class,'select')])[1]")
	WebElement pl_Salutation;

	@FindBy(css = "input[class*='firstName']")
	WebElement tb_FirstName;

	@FindBy(css = "input[class*='lastName']")
	WebElement tb_LastName;

	@FindBy(xpath = "(//input[@class=' input' and @maxlength='255'])[1]")
	WebElement tb_Company;

	@FindBy(xpath = "(//input[@type='email']")
	WebElement tb_Email;

	@FindBy(xpath = "(//input[@type='tel'])[2]")
	WebElement tb_Mobile;

	@FindBy(xpath = "(//a[contains(@class,'select')])[2]")
	WebElement pl_LeadSource;

	@FindBy(xpath = "(//a[contains(@class,'select')])[3]")
	WebElement pl_Industry;

	@FindBy(xpath = "(//a[contains(@class,'select')])[4]")
	WebElement pl_LeadStatus;

	@FindBy(xpath = "((//a[contains(@class,'select')])[5]")
	WebElement pl_Rating;

	@FindBy(xpath = "//textarea[contains(@class,'street compoundTLRadius')]")
	WebElement ta_Street;

	@FindBy(xpath = "//input[contains(@class,'city compoundBorderBottom')]")
	WebElement tb_City;

	@FindBy(xpath = "//input[contains(@class,'state compoundBorderBottom input')]")
	WebElement tb_State;

	@FindBy(xpath = "//input[contains(@class,'postalCode compoundBLRadius')]")
	WebElement tb_postalCode;

	@FindBy(xpath = "//input[contains(@class,'country compoundBRRadius input')]")
	WebElement tb_Country;

	@FindBy(xpath = "//button[@title='Cancel']")
	WebElement btn_Cancel;

	@FindBy(xpath = "//button[@title='Save & New']")
	WebElement btn_SaveAndNew;

	@FindBy(xpath = "//button[@title='Save']")
	WebElement btn_Save;

	@FindBy(xpath = "//ul[@class='errorsList']/li")
	WebElement msgError;

	// Lead page OR
	@FindBy(xpath = "//a[@id='detailTab__item']")
	WebElement tab_Details;

	@FindBy(xpath = "//span[contains(text(),'Mark as Current Status')]")
	WebElement btn_MarkStatusAsComplete;

	@FindBy(xpath = "//span[contains(text(),'Select Converted Status')]")
	WebElement btn_SelectConvertedStatus;

	@FindBy(xpath = "//span[contains(@class,'label bBody')][contains(text(),'Convert')]")
	WebElement btn_Convert;

	@FindBy(xpath = "//span[contains(text(),'Your lead has been converted')]")
	WebElement msgLeadConversion;

	@FindBy(xpath = "//button[@class='slds-button slds-button_brand']")
	WebElement btn_GotoLeads;

	// Initialize page factory elements
	public LeadsPage() {
		PageFactory.initElements(driver, this);
	}

	// Actions:

	public String validatePageTitleLeads() {
		return driver.getTitle();
	}

	public boolean validatePageHeaderLead() {
		return pghdr_Leads.isDisplayed();
	}

	public String validatePageHeaderText() {
		return pghdr_Leads.getText();
	}

	public void clickNewButton() {
		btn_New.click();
	}

	public boolean validateHeaderNewLead() {
		return hdr_NewLead.isDisplayed();
	}

	public boolean validateSalutationPicklist() {
		return pl_Salutation.isDisplayed();
	}

	public void clickSalutationPicklist() {
		pl_Salutation.click();
	}

	public boolean validateFirstNameTextbox() {
		return tb_FirstName.isDisplayed();
	}

	public boolean validateLasttNameTextbox() {
		return tb_LastName.isDisplayed();
	}

	public boolean validateCompanyTextbox() {
		return tb_Company.isDisplayed();
	}

	public boolean validateLeadStatusPicklist() {
		return pl_LeadStatus.isDisplayed();
	}

	public String validateDefaultLeadStatusPicklistValue() {
		return pl_LeadStatus.getText();
	}

	public void clickSaveButton() {
		btn_Save.click();
	}

	public void clickCancelButton() {
		btn_Cancel.click();
	}

	public void selectLeadStatusPathLink(String leadStatus) {
		// WebElement leadStatusPathLink =
		// driver.findElement(By.xpath("//*[@title='" + leadStatus + "']"));
		WebElement leadStatusPathLink = driver
				.findElement(By.xpath("//span[@class='title slds-path__title'][(text()='" + leadStatus + "')]"));

		/*
		 * WebDriverWait wait = new WebDriverWait(driver, 30);
		 * wait.until(ExpectedConditions.elementToBeClickable(leadStatusPathLink
		 * )); leadStatusPathLink.click();
		 */

		/*
		 * JavascriptExecutor executor = (JavascriptExecutor) driver;
		 * executor.executeScript("arguments[0].click();", leadStatusPathLink);
		 */
		Actions actions = new Actions(driver);
		actions.moveToElement(leadStatusPathLink).click().perform();
	}

	public void clickLeadDetailsTab() {
		tab_Details.click();
	}

	public void clickMarkStatusAsCompleteButton() {
		Actions actions = new Actions(driver);
		actions.moveToElement(btn_MarkStatusAsComplete).click().perform();
	}

	public void clickSelectConvertedStatusButton() {
		Actions actions = new Actions(driver);
		actions.moveToElement(btn_SelectConvertedStatus).click().perform();
	}

	public void clickConvertButton() {
		btn_Convert.click();
	}

	public void clickGotoLeadsButton() {
		btn_GotoLeads.click();
	}

	public String validateLeadConvertedMessage() {
		return msgLeadConversion.getText();
	}

	public ArrayList<String> validateSalutationPicklistValues() {
		List<WebElement> list = driver.findElements(By.xpath("//div[@class='select-options']/ul/li"));
		ArrayList<String> aPicklist = new ArrayList<String>();

		for (int i = 0; i < list.size(); i++) {
			aPicklist.add(list.get(i).getText());
		}
		return aPicklist;
	}

	public String validateErrorMessage() {
		msgError.isDisplayed();
		String msg = msgError.getText();
		return msg;
	}

	public void createNewLead(String sal, String fname, String lname, String comp) {
		clickSalutationPicklist();
		// select salutation
		driver.findElement(By.xpath("//a[contains(text(),'" + sal + "')]")).click();
		tb_FirstName.sendKeys(fname);
		tb_LastName.sendKeys(lname);
		tb_Company.sendKeys(comp);
	}

	public void selectLeadRecord(String leadStatus) {
		WebElement leadTable = driver.findElement(By.xpath("//table/tbody"));
		List<WebElement> allRows = leadTable.findElements(By.xpath("tr"));
		for (int i = 1; i < allRows.size(); i++) {
			WebElement colLeadStatus = driver.findElement(By.xpath("//tr[" + i + "]/td[8]"));
			if (colLeadStatus.getText().toLowerCase().equalsIgnoreCase(leadStatus)) {
				colName = driver.findElements(By.xpath("//tr[" + i + "]/th/span/a"));
			}
		}
		String leadName = colName.get(0).getText();
		System.out.println(leadName);
		// click 1st Open - Not Contacted lead record
		colName.get(0).click();
	}

}
