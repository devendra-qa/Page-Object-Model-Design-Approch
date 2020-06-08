package com.sf.qa.tests;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.sf.qa.base.TestBase;
import com.sf.qa.pages.AccountsPage;
import com.sf.qa.pages.HomePage;
import com.sf.qa.pages.LeadsPage;
import com.sf.qa.pages.LoginPage;
import com.sf.qa.util.TestUtil;

public class AccountsPageTest extends TestBase {

	LoginPage loginPage;
	HomePage homePage;
	AccountsPage accountsPage;

	/* String sheetName = "opportunities"; */

	public AccountsPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage = new LoginPage();
		homePage = new HomePage();
		accountsPage = new AccountsPage();
		homePage = loginPage.validateLogin(prop.getProperty("username"), prop.getProperty("password"));
		/*
		 * try { Thread.sleep(100000); } catch (InterruptedException e) {
		 * e.printStackTrace(); }
		 */
		accountsPage = homePage.clickOnAccountsTab();
	}

	@Test(priority = 1) // validate Accounts page title
	public void pageTitleAccountsTest() {
		String aPageTitle = accountsPage.validatePageTitleAccounts();
		String ePageTitle = "Lightning Experience | Salesforce";
		Assert.assertEquals(aPageTitle, ePageTitle, "Page title not matches");
	}

	@Test(priority = 2) // validate header Accounts on Accounts page
	public void pageHeadeAccountsTest() {
		Assert.assertEquals(accountsPage.validatePageHeaderAccounts(), "Accounts", "Page header does not match");
	}

	@Test(priority = 3)
	public void columnsOnAccountsPageTest() {
		Assert.assertEquals(accountsPage.validateAccountNameColumn(), "Account Name", "Account Name column not exists");
		;
		Assert.assertEquals(accountsPage.validateAccountSiteColumn(), "Account Site", "Account Site column not exists");
		;

	}

	@Test(priority = 4) // validate all the fields on New Account page
	public void fieldsOnNewAccountWindowTest() {
		accountsPage.clickNewButton();
		Assert.assertTrue(accountsPage.validateAccountNameTextbox(), "Account Name textbox not exists");
		Assert.assertEquals(accountsPage.validateRatingPicklist(), "--None--", "Rating default value does not match");
		Assert.assertTrue(accountsPage.validatePhoneTextbox(), "Phone textbox not exists");
		Assert.assertTrue(accountsPage.validateWebsiteTextbox(), "Website textbox not exists");
		Assert.assertEquals(accountsPage.validateTypePicklist(), "--None--", "Type default value does not match");
		Assert.assertEquals(accountsPage.validateOwnershipPicklist(), "--None--",
				"Ownership default value does not match");
		Assert.assertEquals(accountsPage.validateIndustryPicklist(), "--None--",
				"Industry default value does not match");
		Assert.assertTrue(accountsPage.validateBillingStreetTextbox(), "Billing Street textbox not exists");
		Assert.assertTrue(accountsPage.validateBillingCityTextbox(), "Billing City textbox not exists");
		Assert.assertTrue(accountsPage.validateBillingStateTextbox(), "Billing State textbox not exists");
		Assert.assertTrue(accountsPage.validateBillingPostalCodeTextbox(), "Billing Postal Code textbox not exists");
		Assert.assertTrue(accountsPage.validateBillingCountryTextbox(), "Billing Country textbox not exists");
		Assert.assertTrue(accountsPage.validateShippingStreetTextbox(), "Shipping Street textbox not exists");
		Assert.assertTrue(accountsPage.validateShippingCityTextbox(), "Shipping City textbox not exists");
		Assert.assertTrue(accountsPage.validateShippingStateTextbox(), "Shipping State textbox not exists");
		Assert.assertTrue(accountsPage.validateShippingPostalCodeTextbox(), "Shipping Postal Code textbox not exists");
		Assert.assertTrue(accountsPage.validateShippingCountryTextbox(), "Shipping Country textbox not exists");
		Assert.assertEquals(accountsPage.validateActivePicklist(), "--None--", "Active default value does not match");
	}

	@Test(priority = 5) // required fields validation
	public void requiredFieldsErrorMessageTest() {
		accountsPage.clickNewButton();
		try {
			Thread.sleep(30000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		accountsPage.clickSaveButton();
		String aErrorMsg = accountsPage.validateRequiredFieldsErrorMessage();
		String eErrorMsg = "These required fields must be completed: Account Name";
		Assert.assertEquals(aErrorMsg, eErrorMsg, "Error message doen not match");
	}

	/*
	 * @DataProvider public Object[][] getSFTestData() { Object data[][] =
	 * TestUtil.getTestData(sheetName); return data; }
	 */

	@Test(priority = 7, dataProvider = "getAccoTestData", dataProviderClass = DataProviderClass.class)
	public void createNewAccountTest(String accountName, String rating, String phone, String website, String type,
			String ownership, String industry, String billingStreet, String billingCity, String billingState,
			String billingZip, String billingCountry, String shippingStreet, String shippingCity, String shippingState,
			String shippingZip, String shippingCountry, String active) {
		accountsPage.clickNewButton();
		accountsPage.createNewAccount(accountName, rating, phone, website, type, ownership, industry, billingStreet,
				billingCity, billingState, billingZip, billingCountry, shippingStreet, shippingCity, shippingState,
				shippingZip, shippingCountry, active);
		accountsPage.clickSaveButton();
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void selectAccountNameTest() {
		accountsPage.selectAccountName("ABC Corp");
	}

	@Test(priority = 9, dataProvider = "getOppTestData", dataProviderClass = DataProviderClass.class)
	public void createNewOpportunityOnAccountTest(String opportunityName, String type, String leadSource, String amount,
			String closeDate, String stage, String description) {
		accountsPage.selectAccountName("ABC Corp");
		accountsPage.validateRelatedTabOnAccountIsSelected();
		accountsPage.clickOpportunitiesRelatedListLink();
		accountsPage.clickNewButtonOnOpportunityRelatedList();
		accountsPage.createNewOpportunityOnAccount("ABC Corp " + opportunityName, type, leadSource, amount, closeDate,
				stage, description);
		accountsPage.clickSaveOpportunityButtton();
		try {
			Thread.sleep(30000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void uploadFileTest() {
		accountsPage.selectAccountName("ABC Corp");
		accountsPage.clickNotesAndAttachmentsRelatedListLink();
		accountsPage.validateUploadFiles();
		/*try {
			Thread.sleep(30000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		TestUtil.uploadFile("D:\\sample test files\\testsPNGFile.png");
		accountsPage.clickDoneButton();

	}
	
	@Test
	public void vaidateRelatedTabIsSelected(){
		accountsPage.selectAccountName("ABC Corp");
		accountsPage.validateRelatedTabOnAccountIsSelected();

	}

	@AfterMethod()
	public void tearDown() {
		driver.quit();
	}

}
