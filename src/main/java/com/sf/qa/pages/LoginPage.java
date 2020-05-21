package com.sf.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sf.qa.base.TestBase;

public class LoginPage extends TestBase{
	
	//Page Factory -OR:
	
	@FindBy(id="username")
	WebElement username;
	
	@FindBy(name="pw")
	WebElement password;
	
	@FindBy(id="Login")
	WebElement loginBtn;
	
	@FindBy(id="logo")
	WebElement sfLogo;
	
	
	//create constructor of page class
	public LoginPage(){
		//initializing the Page Objects (WebElements) in Page Factory using PageFactory method
		//driver refers to the TestBase driver
		//this refers to the current class (LoginPage class)
		PageFactory.initElements(driver, this);
	}
	
	//Actions:
	
	public String validateLoginPageTitle(){
		return driver.getTitle();
	}
	
	public boolean validateSFLogo(){
		return sfLogo.isDisplayed();
	}

	public HomePage login(String un, String pwd){
		username.sendKeys(un);
		password.sendKeys(pwd);
		loginBtn.click();
		return new HomePage();
	}

}
