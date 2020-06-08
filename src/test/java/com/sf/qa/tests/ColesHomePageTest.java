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

public class ColesHomePageTest extends TestBase {

	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;

	public ColesHomePageTest() {
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
		homePage = loginPage.validateLogin(prop.getProperty("username"), prop.getProperty("password"));
		homePage.validateHomePageTabIsSelected();
		/*
		 * try { Thread.sleep(50000); } catch (InterruptedException e) {
		 * e.printStackTrace(); }
		 */

	}

	@Test(priority = 1)
	public void homePageTitleTest() {
		String atitle = homePage.validateHomePageTitle();
		String eTitle = "Home | Salesforce";
		Assert.assertEquals(atitle, eTitle, "Home page title not matched");
	}

	@Test(priority = 2)
	public void verifyQuarterlyPerformanceHeaderTest() {
		Assert.assertTrue(homePage.validateQuarterlyPerformanceHeader(), "Quarterly Performance label not displayed");
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

	@Test
	public void verifyHomePageLoadTime() {
		long start = System.currentTimeMillis();
		System.out.println("Start time: " + start);
		driver.get("https://ap4.lightning.force.com/lightning/page/home");
		long finish = System.currentTimeMillis();
		System.out.println("Finish time: " + finish);
		long totalTime = finish - start;
		System.out.println("Total time for page load: " + totalTime);

		/*
		 * testUtil = new TestUtil(); testUtil.pageLoadTime(
		 * "https://ap4.lightning.force.com/lightning/page/home");
		 */
	}

	@AfterMethod()
	public void tearDown() {
		driver.quit();
	}

}
