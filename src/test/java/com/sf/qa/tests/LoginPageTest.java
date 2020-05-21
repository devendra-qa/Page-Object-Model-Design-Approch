package com.sf.qa.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.sf.qa.base.TestBase;
import com.sf.qa.pages.HomePage;
import com.sf.qa.pages.LoginPage;

public class LoginPageTest extends TestBase{
	
	LoginPage loginPage;
	HomePage homePage;
	
	//create constructor of LoginPageTest class
	public LoginPageTest(){
		//using super keyword calling the constructor of TestBase class
		//as the properties are initialized in the constructor of TestBase class
		super();
	}
	
	@BeforeMethod
	public void setUp(){
		initialization();
		loginPage = new LoginPage();
	}
	
	@Test(priority=1)
	public void loginPageTitleTest(){
		String title = loginPage.validateLoginPageTitle();
		//Assert.assertEquals(title, "Login | Salesforce");
		//display message only if test case failed
		Assert.assertEquals(title, "Login | Salesforce", "Login page title not matched");
	}
	
	@Test(priority=2)
	public void sfLogoTest(){
		boolean flag = loginPage.validateSFLogo();
		Assert.assertTrue(flag);
	}
	
	@Test(priority=3)
	public void loginTest(){
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@AfterMethod()
	public void tearDown(){
		driver.quit();
	}
	

}
