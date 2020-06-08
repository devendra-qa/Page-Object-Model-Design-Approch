package com.sf.qa.tests;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
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

public class LeadsPageTest extends TestBase {

	LoginPage loginPage;
	HomePage homePage;
	LeadsPage leadsPage;

	String sheetName = "leads";

	public LeadsPageTest() {
		super();
	}
	// test cases should be separated-- independent with each other
	// before each test case-- launch the browser and login
	// @test-- execute test case
	// after each test case-- close the browser

	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage = new LoginPage();
		homePage = new HomePage();
		leadsPage = new LeadsPage();
		homePage = loginPage.validateLogin(prop.getProperty("username"), prop.getProperty("password"));
		try {
			Thread.sleep(100000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/*
		 * WebDriverWait wait = new WebDriverWait(driver, 100);
		 * wait.until(ExpectedConditions.titleContains("Home | Salesforce"));
		 */
		leadsPage = homePage.clickOnLeadsTab();
	}

	@Test(priority = 1) // validate Leads page title
	public void pageTitleLeadsTest() {
		String aTitle = leadsPage.validatePageTitleLeads();
		String eTitle = "Lightning Experience | Salesforce";
		Assert.assertEquals(aTitle, eTitle, "Page title does not match");
	}

	@Test(priority = 2) // validate header leads on Leads page
	public void pageHeaderLeadTest() {
		Assert.assertTrue(leadsPage.validatePageHeaderLead(), "Page header not displayed");
		Assert.assertEquals(leadsPage.validatePageHeaderText(), "Leads", "Page header text does not match");
	}

	@Test(priority = 3) // validate all the fields on New Lead window page
	public void fieldsOnNewLeadWindowTest() {
		leadsPage.clickNewButton();
		Assert.assertEquals(leadsPage.validateHeaderNewLead(), "New Lead", "Window header does not match");
		Assert.assertTrue(leadsPage.validateSalutationPicklist(), "Salutation picklist not exists");
		Assert.assertTrue(leadsPage.validateFirstNameTextbox(), "First Name textbox not exists");
		Assert.assertTrue(leadsPage.validateLasttNameTextbox(), "Last Name textbox not exists");
		Assert.assertTrue(leadsPage.validateCompanyTextbox(), "Company textbox not exists");
		Assert.assertTrue(leadsPage.validateLeadStatusPicklist(), "Lead Status picklist not exists");
	}

	@Test(priority = 4) // validate default picklist value
	public void defaultLeadStatusPicklistValueTest() {
		leadsPage.clickNewButton();
		String aDefaultValue = leadsPage.validateDefaultLeadStatusPicklistValue();
		String eDefaultValue = "Open - Not Contacted";
		Assert.assertEquals(aDefaultValue, eDefaultValue, "Lead Status default value does not match");
	}

	@Test(priority = 5)
	public void salutationPicklistValuesTest() {

		TestUtil ePicklist = new TestUtil();
		ArrayList<String> eSalPicklist = ePicklist.getPicklistTestData("leads", "salutation");

		leadsPage.clickNewButton();
		leadsPage.clickSalutationPicklist();
		ArrayList<String> aSalPicklist = leadsPage.validateSalutationPicklistValues();
		/*
		 * System.out.println("actual picklist: " + aSalPicklist);
		 * System.out.println("expected picklist: " + eSalPicklist);
		 */
		Assert.assertEquals(aSalPicklist, eSalPicklist, "Picklist values does not match");
	}

	@Test(priority = 6) // required fields validation
	public void requiredFieldsErrorMessageTest() {
		leadsPage.clickNewButton();
		try {
			Thread.sleep(30000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		leadsPage.clickSaveButton();
		String aErrorMsg = leadsPage.validateErrorMessage();
		String eErrorMsg = "These required fields must be completed: Company, Last Name";
		Assert.assertEquals(aErrorMsg, eErrorMsg, "Error message does not match");
	}

	@DataProvider
	public Object[][] getSFTestData() {
		Object data[][] = TestUtil.getTestData(sheetName);
		return data;
	}

	@Test(priority = 7, dataProvider = "getSFTestData")
	// public void createNewLeadTest(){
	public void createNewLeadTest(String salutation, String firstName, String lastName, String company) {
		leadsPage.clickNewButton();
		// leadsPage.createNewLead("Mr.", "Devid", "P", "ABP Ltd.");
		leadsPage.createNewLead(salutation, firstName, lastName, company);
		leadsPage.clickSaveButton();
	}

	@Test(priority = 8)
	public void changeLeadStatusToWorkingContactedUsingPathLinkTest() {
		leadsPage.selectLeadRecord("Open - Not Contacted");
		leadsPage.clickLeadDetailsTab();
		leadsPage.selectLeadStatusPathLink("Working - Contacted");
		leadsPage.clickMarkStatusAsCompleteButton();
		try {
			Thread.sleep(30000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Test(priority = 9)
	public void changeLeadStatusToClosedNotConvertedUsingPathLinkTest() {
		leadsPage.selectLeadRecord("Working - Contacted");
		leadsPage.clickLeadDetailsTab();
		leadsPage.selectLeadStatusPathLink("Closed - Not Converted");
		leadsPage.clickMarkStatusAsCompleteButton();
		try {
			Thread.sleep(30000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Test(priority = 10)
	public void changeLeadStatusToConvertedUsingPathLinkTest() {
		leadsPage.selectLeadRecord("Working - Contacted");
		leadsPage.clickLeadDetailsTab();
		leadsPage.selectLeadStatusPathLink("Converted");
		leadsPage.clickSelectConvertedStatusButton();
		try {
			Thread.sleep(30000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		leadsPage.clickConvertButton();
		try {
			Thread.sleep(30000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		leadsPage.validateLeadConvertedMessage();
		leadsPage.clickGotoLeadsButton();
	}

	@AfterMethod()
	public void tearDown() {
		driver.quit();
	}

}
