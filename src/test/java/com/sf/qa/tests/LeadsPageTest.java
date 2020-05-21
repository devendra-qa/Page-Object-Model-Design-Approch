package com.sf.qa.tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.sf.qa.base.TestBase;
import com.sf.qa.pages.HomePage;
import com.sf.qa.pages.LeadsPage;
import com.sf.qa.pages.LoginPage;
import com.sf.qa.util.TestUtil;

public class LeadsPageTest extends TestBase{
	
	LoginPage loginPage;
	HomePage homePage;
	LeadsPage leadsPage;
	
	String sheetName = "leads";
	
	public LeadsPageTest(){
		super();
	}
	//test cases should be separated-- independent with each other
	//before each test case-- launch the browser and login
	//@test-- execute test case
	//after each test case-- close the browser
	
	@BeforeMethod
	public void setUp(){
		initialization();
		loginPage = new LoginPage();
		homePage = new HomePage();
		leadsPage = new LeadsPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		try {
			Thread.sleep(100000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/*WebDriverWait wait = new WebDriverWait(driver, 100);
		wait.until(ExpectedConditions.titleContains("Home | Salesforce"));*/
		leadsPage = homePage.clickOnLeadsTab();
		
	}
	
	/*@Test(priority=1)
	public void leadsPageTitleTest(){
		String title = leadsPage.validateLeadsPageTitle();
		Assert.assertEquals(title, "Home | Salesforce", "Leads page title not matched");
	}*/
	
	@Test(priority=1)
	public void leadsLabelTest(){
		Assert.assertTrue(leadsPage.validateLeadsLabel(), "Leads label is not displayed");
	}
	
	@Test(priority=2)
	public void requiredFieldsTest(){
		leadsPage.clickOnNewBtn();
		leadsPage.clickOnSaveBtn();
		//leadsPage.validateRequiredFields();
		Assert.assertEquals(leadsPage.validateRequiredFields(), "These required fields must be completed: Company, Last Name", "Validation error message matched");
	}
	
	@DataProvider
	public Object[][] getSFTestData(){
		Object data[][] = TestUtil.getTestData(sheetName);
		return data;
	}
	@Test(priority=3, dataProvider="getSFTestData")
	//public void createNewLeadTest(){
	public void createNewLeadTest(String salutation, String lastName, String company){
		leadsPage.clickOnNewBtn();
		//leadsPage.createNewLead("Prof.", "ujjwal", "abctest");
		leadsPage.createNewLead(salutation, lastName, company);
		leadsPage.clickOnSaveBtn();
	}

	
	@AfterMethod()
	public void tearDown(){
		driver.quit();
	}
	


}
