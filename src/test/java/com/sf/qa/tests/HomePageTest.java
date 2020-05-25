package com.sf.qa.tests;

import static org.testng.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.sf.qa.base.TestBase;
import com.sf.qa.pages.HomePage;
import com.sf.qa.pages.LoginPage;
import com.sf.qa.util.TestUtil;

public class HomePageTest extends TestBase {

	LoginPage loginPage;
	HomePage homePage;

	public HomePageTest() {
		super();
	}
	/*
	 * test cases should be separated-- independent with each other before each
	 * test case-- launch the browser and login
	 * 
	 * @test-- execute test case after each test case-- close the browser
	 */

	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage = new LoginPage();
		homePage = new HomePage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		try {
			Thread.sleep(100000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		/*
		 * WebDriverWait wait = new WebDriverWait(driver, 100);
		 * wait.until(ExpectedConditions.titleContains("Home | Salesforce"));
		 */
	}

	@Test(priority = 1)
	public void homePageTitleTest() {
		String title = homePage.validateHomePageTitle();
		Assert.assertEquals(title, "Home | Salesforce", "Home page title not matched");
	}

	@Test(priority = 2)
	public void assistantLabelTest() {
		Assert.assertTrue(homePage.validateQuarterlyPerformanceLabel(), "Quarterly Performance label not displayed");
	}

	@Test(priority = 3)
	public void leadsTabTest() {
		homePage.clickOnLeadsTab();
	}

	@Test(priority = 4)
	public void contactsTabTest() {
		homePage.clickOnContactsTab();
	}

	@Test(priority = 5)
	public void accountsTabTest() {
		homePage.clickOnAccountsTab();
	}

	@Test(priority = 6)
	public void opportunitiesTabTest() {
		homePage.clickOnOpportunitiesTab();
	}

	@AfterMethod()
	public void tearDown() {
		driver.quit();
	}

}
