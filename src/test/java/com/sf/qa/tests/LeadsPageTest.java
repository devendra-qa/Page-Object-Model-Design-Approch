package com.sf.qa.tests;

import java.util.ArrayList;

import org.openqa.selenium.By;
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
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
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

	/*
	 * @Test(priority=1) public void leadsPageTitleTest(){ String title =
	 * leadsPage.validateLeadsPageTitle(); Assert.assertEquals(title,
	 * "Home | Salesforce", "Leads page title not matched"); }
	 */

	@Test(priority = 1) // validate label leads on leads page
	public void leadsLabelTest() {
		Assert.assertTrue(leadsPage.validateLeadsLabel(), "Leads label is not displayed");
	}

	@Test(priority = 2) // validate leads page title
	public void leadsPageTitleTest() {
		String pageTitle = leadsPage.validateLeadsPageTitle();
		Assert.assertEquals(pageTitle, "Lightning Experience | Salesforce", "Page title not matched");
	}

	@Test(priority = 3) // validate all the fields on new lead window page
	public void fieldsOnNewLeadWindowTest() {
		leadsPage.clickOnNewButton();
		leadsPage.validateNewLeadLabel();
		leadsPage.validateSalutationPicklist();
		leadsPage.validateFirstNameTextbox();
		leadsPage.validateLastNameTextbox();
		leadsPage.validateCompanyTextbox();
		leadsPage.validateLeadStatusPicklist();
	}

	@Test(priority = 4) // validate default picklist value
	public void defaultLeadStatusValueTest() {
		leadsPage.clickOnNewButton();
		String defaultValue = leadsPage.validateDefaultLeadStatusValue();
		Assert.assertEquals(defaultValue, "Open - Not Contacted", "Lead Status value matched");

	}

	@Test(priority = 5)
	public void salutationPicklistValuesTest() {

		TestUtil ePicklist = new TestUtil();
		ArrayList<String> eSalPicklist = ePicklist.getPicklistTestData("leads", "salutation");

		leadsPage.clickOnNewButton();
		leadsPage.clickOnSalutationPicklist();
		ArrayList<String> aSalPicklist = leadsPage.validateSalutationPicklistValues();
		System.out.println("actual picklist: " + aSalPicklist);
		System.out.println("expected picklist: " + eSalPicklist);
		Assert.assertEquals(aSalPicklist, eSalPicklist, "Picklist values not matched");
	}

	@Test(priority = 6) // required fields validation
	public void requiredFieldsMsgTest() {
		leadsPage.clickOnNewButton();
		leadsPage.clickOnSaveButton();
		String validationMsg = leadsPage.validateRequiredFieldsMsg();
		Assert.assertEquals(validationMsg, "These required fields must be completed: Company, Last Name",
				"Error text matched");
	}

	@DataProvider
	public Object[][] getSFTestData() {
		Object data[][] = TestUtil.getTestData(sheetName);
		return data;
	}

	@Test(priority = 7, dataProvider = "getSFTestData") // validate new lead
														// creation
	// public void createNewLeadTest(){
	public void createNewLeadTest(String salutation, String firstName, String lastName, String company) {
		leadsPage.clickOnNewButton();
		// leadsPage.createNewLead("Mr.", "Devid", "P", "ABP Ltd.");
		leadsPage.createNewLead(salutation, firstName, lastName, company);
		leadsPage.clickOnSaveButton();
	}

	@Test(priority = 8) // change lead status value
	public void changeLeadStatusTest() {
		driver.findElement(By.xpath("//*[text()='Open - Not Contacted']")).click();
		driver.findElement(By.xpath("//td[(@class,'slds-cell-edit cellContainer slds-has-focus')]/span/span/button"))
				.click();
		driver.findElement(By.xpath("//a[contains(@class,'select')]")).click();
		driver.findElement(By.xpath("//a[contains(text(),'Working - Contacted')]")).click();
		driver.findElement(By.xpath("//span[contains(text(),'Save')]")).click();
	}

	@AfterMethod()
	public void tearDown() {
		driver.quit();
	}

}
