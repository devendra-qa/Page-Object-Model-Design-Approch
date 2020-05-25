package com.sf.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sf.qa.base.TestBase;

public class LoginPage extends TestBase {

	// Page Factory -OR:

	@FindBy(id = "username")
	WebElement username;

	@FindBy(name = "pw")
	WebElement password;

	@FindBy(css = "#Login")
	WebElement loginBtn;

	@FindBy(css = "#logo")
	WebElement sfLogo;

	@FindBy(xpath = "//a[@id='forgot_password_link']")
	WebElement forgotPasswordLink;

	@FindBy(xpath = "//a[@id='mydomainLink']")
	WebElement customDomainLink;

	// create constructor of this page class
	public LoginPage() {
		// initializing the Page Objects (WebElements) in Page Factory using
		// PageFactory class
		// driver- refers to the TestBase driver
		// this- refers to the current class i.e. LoginPage class)
		PageFactory.initElements(driver, this);
	}

	// Actions:

	public String validateLoginPageTitle() {
		return driver.getTitle();
	}

	public boolean validateSalesforceLogo() {
		return sfLogo.isDisplayed();
	}

	public HomePage login(String un, String pwd) {
		username.sendKeys(un);
		password.sendKeys(pwd);
		loginBtn.click();
		return new HomePage();
	}

	public String validateForgotPasswordLink() {
		forgotPasswordLink.click();
		return driver.getTitle();
	}

	public String validateDomainLink() {
		customDomainLink.click();
		return driver.getTitle();
	}

}
