package com.sf.qa.tests;

import java.lang.reflect.Method;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
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

public class DataProviderTest extends TestBase {

	LoginPage loginPage;
	HomePage homePage;
	AccountsPage accountsPage;

	String sheetName = "opportunities";

	public DataProviderTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage = new LoginPage();
		homePage = new HomePage();
		accountsPage = new AccountsPage();
		homePage = loginPage.validateLogin(prop.getProperty("username"), prop.getProperty("password"));
		/*try {
			Thread.sleep(100000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}*/
		accountsPage = homePage.clickOnAccountsTab();
	}

	/*@DataProvider (name = "getSFTestData")
	public Object[][] getSFTestData() {
		Object data[][] = TestUtil.getTestData(sheetName);
		return data;
	}*/

	@Test(priority = 7, dataProvider = "getAccoTestData",  dataProviderClass = DataProviderClass.class)
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

	
	@Test(priority = 9, dataProvider = "getOppTestData", dataProviderClass = DataProviderClass.class)
	public void createNewOpportunityOnAccountTest(String opportunityName, String type, String leadSource, String amount,
			String closeDate, String stage, String description) {
		accountsPage.selectAccountName("ABC Corp");
		accountsPage.validateRelatedTabOnAccountIsSelected();
		accountsPage.clickOpportunitiesRelatedListLink();
		accountsPage.clickNewButtonOnOpportunityRelatedList();
		/*
		 * try { Thread.sleep(50000); } catch (InterruptedException e) {
		 * e.printStackTrace(); }
		 */
		accountsPage.createNewOpportunityOnAccount("ABC Corp " + opportunityName, type, leadSource, amount, closeDate,
				stage, description);
		accountsPage.clickSaveOpportunityButtton();
		try {
			Thread.sleep(30000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	

	@AfterMethod()
	public void tearDown() {
		driver.quit();
	}

}
