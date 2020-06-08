package com.sf.qa.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.sf.qa.base.TestBase;
import com.sf.qa.pages.HomePage;
import com.sf.qa.pages.LoginPage;

//import org.apache.log4j.Logger;

public class LoginPageTest extends TestBase {

	LoginPage loginPage;
	HomePage homePage;

	// Logger log = Logger.getLogger(LoginPageTest.class);

	// create constructor of this class
	public LoginPageTest() {
		super();
		/*
		 * using super keyword calling the super constructor of TestBase class
		 * as the properties are initialized in the constructor of this class
		 */

	}

	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage = new LoginPage();
	}

	@Test(priority = 1)
	public void verifyLoginPageTitleTest() {
		String aTitle = loginPage.validateLoginPageTitle();
		String eTitle = "Login | Salesforce";
		// display message only if test case failed
		Assert.assertEquals(aTitle, eTitle, "Login page title not matched");
	}

	@Test(priority = 2)
	public void verifySalesforceLogoTest() {
		boolean flag = loginPage.validateSalesforceImage();
		Assert.assertTrue(flag, "Logo not displayed");
	}

	@Test(priority = 3)
	public void verifyForgotPasswordLinkTest() {
		String aTitle = loginPage.validateForgotPasswordLink();
		String eTitle = "Forgot Your Password | Salesforce";
		Assert.assertEquals(aTitle, eTitle, "Page title not matched");
	}

	@Test(priority = 4)
	public void verifyUseCustomDomainLinkTest() {
		String aTitle = loginPage.validateUseCustomDomainLink();
		String eTitle = "Login | Salesforce";
		Assert.assertEquals(aTitle, eTitle, "Page title not matched");
	}

	@Test(priority = 5)
	public void verifyUserLoginTest() {
		homePage = loginPage.validateLogin(prop.getProperty("username"), prop.getProperty("password"));
	}

	@AfterMethod()
	public void tearDown() {
		driver.quit();
	}

}
