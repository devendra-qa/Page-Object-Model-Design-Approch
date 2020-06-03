package com.sf.qa.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.sf.qa.base.TestBase;
import com.sf.qa.pages.AccountsPage;
import com.sf.qa.pages.HomePage;
import com.sf.qa.pages.LoginPage;
import com.sf.qa.pages.OpportunitiesPage;

public class OpportunitiesPageTest extends TestBase {

	LoginPage loginPage;
	HomePage homePage;
	AccountsPage accountsPage;
	OpportunitiesPage opportunitiesPage;

	public OpportunitiesPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage = new LoginPage();
		homePage = new HomePage();
		accountsPage = new AccountsPage();
		opportunitiesPage = new OpportunitiesPage();
		homePage = loginPage.validateLogin(prop.getProperty("username"), prop.getProperty("password"));
		try {
			Thread.sleep(100000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		accountsPage = homePage.clickOnAccountsTab();
	}

	@Test
	public void createNewOpportunityTest() {
		accountsPage.selectAccountName("ABC Corp");
		accountsPage.validateRelatedTabOnAccountIsSelected();
		accountsPage.clickOpportunitiesRelatedListLink();
		
		
	}

	@Test(priority = 1, testName = "validate header on Opportunities page")
	public void pageHeadeOpportunitiesTest() {
		Assert.assertEquals(opportunitiesPage.validateOpportunitiesPageHeader(), "Opportunities",
				"Page header does not match");
	}

	@AfterMethod()
	public void tearDown() {
		driver.quit();
	}

}
