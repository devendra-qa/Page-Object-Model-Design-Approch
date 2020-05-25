package com.sf.qa.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.sf.qa.base.TestBase;

public class HomePage extends TestBase {

	@FindBy(xpath = "//div/h2/span[@title='Quarterly Performance']")
	WebElement quarterlyPerformanceLabel;

	@FindBy(xpath = "//a[@title='Leads']")
	WebElement leadsTab;

	@FindBy(xpath = "//a[@title='Contacts']")
	WebElement contactsTab;

	@FindBy(xpath = "//a[@title='Accounts']")
	WebElement accountsTab;

	@FindBy(xpath = "//a[@title='Opportunities']")
	WebElement opportunitiesTab;

	public HomePage() {
		PageFactory.initElements(driver, this);
	}

	// Actions:

	public String validateHomePageTitle() {
		return driver.getTitle();

	}

	public boolean validateQuarterlyPerformanceLabel() {
		return quarterlyPerformanceLabel.isDisplayed();
	}

	public LeadsPage clickOnLeadsTab() {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", leadsTab);
		// leadsTab.click();
		return new LeadsPage();
	}

	public AccountsPage clickOnAccountsTab() {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", accountsTab);
		return new AccountsPage();
	}

	public ContactsPage clickOnContactsTab() {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", contactsTab);
		return new ContactsPage();
	}

	public OpportunitiesPage clickOnOpportunitiesTab() {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", opportunitiesTab);
		return new OpportunitiesPage();
	}
}
