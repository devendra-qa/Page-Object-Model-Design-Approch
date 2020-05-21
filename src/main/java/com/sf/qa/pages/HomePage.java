package com.sf.qa.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.sf.qa.base.TestBase;

public class HomePage extends TestBase{

	@FindBy(xpath="//span[@class='slds-text-heading_small']")
	WebElement assistantLabel;
	
	@FindBy(xpath="//a[@title='Leads']")
	WebElement leadsTab;

	public HomePage(){
		PageFactory.initElements(driver, this);
	}
	
	//Actions:
	
	public String validateHomePageTitle(){
		return driver.getTitle();

	}
	
	public boolean validateAssistantLabel(){
		return assistantLabel.isDisplayed();
	}
	
	public LeadsPage clickOnLeadsTab(){
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", leadsTab);
		//leadsTab.click();
		return new LeadsPage();
	}
}
