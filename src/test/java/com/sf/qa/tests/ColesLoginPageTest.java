package com.sf.qa.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.sf.qa.base.TestBase;
import com.sf.qa.pages.ColesHomePage;
import com.sf.qa.pages.ColesLoginPage;
import com.sf.qa.pages.HomePage;
import com.sf.qa.pages.LoginPage;

//import org.apache.log4j.Logger;

public class ColesLoginPageTest extends TestBase {

	ColesLoginPage colesLoginPage;
	ColesHomePage colesHomePage;

	// Logger log = Logger.getLogger(LoginPageTest.class);

	// create constructor of this class
	public ColesLoginPageTest() {
		super();
		/*
		 * using super keyword calling the super constructor of TestBase class
		 * as the properties are initialized in the constructor of this class
		 */

	}

	@BeforeMethod
	public void setUp() {
		initialization();
		colesLoginPage = new ColesLoginPage();
	}

	@Test(priority = 1)
	public void verifyLoginPageTitleTest() {
		String aTitle = colesLoginPage.validateLoginPageTitle();
		String eTitle = "Login | Salesforce";
		// display message only if test case failed
		Assert.assertEquals(aTitle, eTitle, "Login page title not matched");
	}

	@Test(priority = 2)
	public void verifySalesforceLogoTest() {
		boolean flag = colesLoginPage.validateSalesforceImage();
		Assert.assertTrue(flag, "Logo not displayed");
	}

	@Test(priority = 3)
	public void verifyForgotPasswordLinkTest() {
		String aTitle = colesLoginPage.validateForgotPasswordLink();
		String eTitle = "Forgot Your Password | Salesforce";
		Assert.assertEquals(aTitle, eTitle, "Page title not matched");
	}

	@Test(priority = 4)
	public void verifyRemembermeCheckboxTest() {
		boolean flag = colesLoginPage.validateRemembermeCheckbox();
		Assert.assertFalse(flag, "Rememberme Checkbox is selected");
	}

	@Test(priority = 5)
	public void verifyUserLoginTest() {
		colesHomePage = colesLoginPage.validateLogin(prop.getProperty("username"), prop.getProperty("password"));
	}

	@AfterMethod()
	public void tearDown() {
		driver.quit();
	}

}
