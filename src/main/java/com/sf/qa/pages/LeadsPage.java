package com.sf.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.sf.qa.base.TestBase;

public class LeadsPage extends TestBase{
	
	@FindBy(css="span[class*=forceBreadCrumbItem]")
	WebElement leadsLabel;
	
	@FindBy(xpath="//div[contains(text(),'New')]")
	WebElement newBtn;
	
	@FindBy(xpath="//li[contains(text(),'These required fields must be completed: Company,')]")
	WebElement requiredFieldMsg;
	
	@FindBy(xpath="//button[@title='Save']")
	WebElement saveBtn;
	
	public LeadsPage(){
		PageFactory.initElements(driver, this);
	}
	
	//Actions:
	
		public String validateLeadsPageTitle(){
			return driver.getTitle();
		}
		
		public boolean validateLeadsLabel(){
			return leadsLabel.isDisplayed();
		}
		
		public void clickOnNewBtn(){
			newBtn.click();
		}
		
		public void clickOnSaveBtn(){
			saveBtn.click();
		}
		
		public String validateRequiredFields(){
			//driver.findElement(By.cssSelector("button[title='Save']")).click();
			WebDriverWait wait = new WebDriverWait(driver,20);
			wait.until(ExpectedConditions.visibilityOf(requiredFieldMsg));
			String msg = requiredFieldMsg.getText();
			return msg;

		}
		
		public void createNewLead(String sal, String lname, String comp){
			driver.findElement(By.xpath("(//a[@class='select'])[1]")).click();
			driver.findElement(By.xpath("//a[contains(text(),'" + sal + "')]")).click();;
			driver.findElement(By.cssSelector("input[class*='lastName']")).sendKeys(lname);
			driver.findElement(By.xpath("(//input[@class=' input' and @maxlength='255'])[1]")).sendKeys(comp);
		}
}
