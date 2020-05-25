package com.sf.qa.pages;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.sf.qa.base.TestBase;

public class LeadsPage extends TestBase {

	@FindBy(css = "span[class*=forceBreadCrumbItem]")
	WebElement leadsLbl;

	@FindBy(xpath = "//div[contains(text(),'New')]")
	WebElement newBtn;

	@FindBy(xpath = "//h2[contains(text(),'New Lead')]")
	WebElement newLeadLbl;

	@FindBy(xpath = "(//a[contains(@class,'select')])[1]")
	WebElement salutationPl;

	@FindBy(css = "input[class*='firstName']")
	WebElement firstNameTb;

	@FindBy(css = "input[class*='lastName']")
	WebElement lastNameTb;

	@FindBy(xpath = "(//input[@class=' input' and @maxlength='255'])[1]")
	WebElement companyTb;

	@FindBy(xpath = "(//a[contains(@class,'select')])[4]")
	WebElement leadStatusPl;

	@FindBy(xpath = "//button[@class='slds-button slds-button--neutral uiButton--brand uiButton forceActionButton']")
	WebElement saveBtn;

	@FindBy(xpath = "//button[@title='Cancel']")
	WebElement cancelBtn;

	@FindBy(xpath = "//ul[@class='errorsList']")
	WebElement requiredFieldMsg;

	public LeadsPage() {
		PageFactory.initElements(driver, this);
	}

	// Actions:

	public String validateLeadsPageTitle() {
		return driver.getTitle();
	}

	public boolean validateLeadsLabel() {
		return leadsLbl.isDisplayed();
	}

	public void clickOnNewButton() {
		newBtn.click();
	}

	public boolean validateNewLeadLabel() {
		return newLeadLbl.isDisplayed();
	}

	public boolean validateSalutationPicklist() {
		return salutationPl.isDisplayed();
	}

	public void clickOnSalutationPicklist() {
		salutationPl.click();
	}

	public boolean validateFirstNameTextbox() {
		return firstNameTb.isDisplayed();
	}

	public boolean validateLastNameTextbox() {
		return lastNameTb.isDisplayed();
	}

	public boolean validateCompanyTextbox() {
		return companyTb.isDisplayed();
	}

	public boolean validateLeadStatusPicklist() {
		return leadStatusPl.isDisplayed();
	}

	public String validateDefaultLeadStatusValue() {
		leadStatusPl.isDisplayed();
		return leadStatusPl.getText();
	}

	public void clickOnSaveButton() {
		saveBtn.click();
	}

	public void clickOnCancelButton() {
		cancelBtn.click();
	}

	public ArrayList<String> validateSalutationPicklistValues() {
		// salutationPl.click();
		List<WebElement> list = driver.findElements(By.xpath("//div[@class='select-options']/ul/li"));
		ArrayList<String> aPicklist = new ArrayList<String>();

		for (int i = 0; i < list.size(); i++) {
			aPicklist.add(list.get(i).getText());
		}
		return aPicklist;

	}

	public String validateRequiredFieldsMsg() {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(requiredFieldMsg));
		// requiredFieldMsg.isDisplayed();
		String msg = requiredFieldMsg.getText();
		return msg;

	}

	public void createNewLead(String sal, String fname, String lname, String comp) {
		salutationPl.click();
		driver.findElement(By.xpath("//a[contains(text(),'" + sal + "')]")).click();
		firstNameTb.sendKeys(fname);
		lastNameTb.sendKeys(lname);
		companyTb.sendKeys(comp);
	}
}
