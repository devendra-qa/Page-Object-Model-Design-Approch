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
	public void loginPageTitleTest() {
		String title = loginPage.validateLoginPageTitle();
		// Assert.assertEquals(title, "Login | Salesforce");

		// display message only if test case failed
		Assert.assertEquals(title, "Login | Salesforce", "Login page title not matched");
	}

	@Test(priority = 2)
	public void salesforceLogoTest() {
		boolean flag = loginPage.validateSalesforceLogo();
		Assert.assertTrue(flag, "Logo not displayed");
	}

	@Test(priority = 3)
	public void forgotPasswordLinkTest() {
		String title = loginPage.validateForgotPasswordLink();
		Assert.assertEquals(title, "Forgot Your Password | Salesforce", "Page title not matched");
	}

	@Test(priority = 4)
	public void domainLinkTest() {
		String title = loginPage.validateDomainLink();
		Assert.assertEquals(title, "Login | Salesforce", "Page title not matched");
	}

	@Test(priority = 5)
	public void loginTest() {
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}

	@AfterMethod()
	public void tearDown() {
		driver.quit();
	}

}
