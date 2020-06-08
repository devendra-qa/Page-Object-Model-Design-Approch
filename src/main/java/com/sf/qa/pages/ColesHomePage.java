package com.sf.qa.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.sf.qa.base.TestBase;

public class ColesHomePage extends TestBase {
	
	JavascriptExecutor js = (JavascriptExecutor) driver;
	
	@FindBy(xpath = "//a[@title='Home']")
	WebElement tab_Home;
	
	@FindBy(xpath = "//div/h2/span[@title='Quarterly Performance']")
	WebElement hdr_quarterlyPerformance;

	@FindBy(xpath = "//a[@title='Leads']")
	WebElement tab_Leads;

	@FindBy(xpath = "//a[@title='Contacts']")
	WebElement tab_Contacts;

	@FindBy(xpath = "//a[@title='Accounts']")
	WebElement tab_Accounts;

	@FindBy(xpath = "//a[@title='Opportunities']")
	WebElement tab_Opportunities;

	public ColesHomePage() {
		PageFactory.initElements(driver, this);
	}

	// Actions:

	public String validateHomePageTitle() {
		return driver.getTitle();

	}
	
	public boolean validateHomePageTabIsSelected(){
		new WebDriverWait(driver, 100).until(ExpectedConditions.visibilityOf(tab_Home));
		return tab_Home.isEnabled();
	}

	public boolean validateQuarterlyPerformanceHeader() {
		return hdr_quarterlyPerformance.isDisplayed();
	}

	public LeadsPage clickOnLeadsTab() {
		new WebDriverWait(driver, 100).until(ExpectedConditions.visibilityOf(tab_Leads));
		js.executeScript("arguments[0].click();", tab_Leads);
		return new LeadsPage();
	}

	public AccountsPage clickOnAccountsTab() {
		//js = (JavascriptExecutor) driver;
		new WebDriverWait(driver, 100).until(ExpectedConditions.visibilityOf(tab_Accounts));
		js.executeScript("arguments[0].click();", tab_Accounts);
		return new AccountsPage();
	}

	public ContactsPage clickOnContactsTab() {
		new WebDriverWait(driver, 100).until(ExpectedConditions.visibilityOf(tab_Contacts));
		js.executeScript("arguments[0].click();", tab_Contacts);
		return new ContactsPage();
	}

	public OpportunitiesPage clickOnOpportunitiesTab() {
		new WebDriverWait(driver, 100).until(ExpectedConditions.visibilityOf(tab_Opportunities));
		js.executeScript("arguments[0].click();", tab_Opportunities);
		return new OpportunitiesPage();
	}
}
