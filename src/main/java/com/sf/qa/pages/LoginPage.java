package com.sf.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sf.qa.base.TestBase;

public class LoginPage extends TestBase {
	/*
	 * tb- textbox, ta- textarea, pl- picklist, tab- tab, lnk- link, btn- button, img-
	 * image, msg- message, pghdr- page header, hdr- header
	 */

	// Page Factory -OR:
	// Login Page OR
	@FindBy(id = "username")
	WebElement tb_Username;

	@FindBy(name = "pw")
	WebElement tb_Password;

	@FindBy(css = "#Login")
	WebElement btn_Login;

	@FindBy(css = "#logo")
	WebElement img_Salesforce;

	@FindBy(xpath = "//a[@id='forgot_password_link']")
	WebElement lnk_ForgotYourPassword;

	@FindBy(xpath = "//a[@id='mydomainLink']")
	WebElement lnk_UseCustomDomain;

	// create constructor of this page class
	public LoginPage() {
		// initializing the Page Objects (WebElements) in Page Factory using
		// PageFactory class
		// driver- refers to the TestBase driver
		// this- refers to the current class i.e. LoginPage class)
		PageFactory.initElements(driver, this);
	}

	// Login Page Actions:

	public String validateLoginPageTitle() {
		return driver.getTitle();
	}

	public boolean validateSalesforceImage() {
		return img_Salesforce.isDisplayed();
	}

	public String validateForgotPasswordLink() {
		lnk_ForgotYourPassword.click();
		return driver.getTitle();
	}

	public String validateUseCustomDomainLink() {
		lnk_UseCustomDomain.click();
		return driver.getTitle();
	}

	public HomePage validateLogin(String un, String pwd) {
		tb_Username.sendKeys(un);
		tb_Password.sendKeys(pwd);
		btn_Login.click();
		return new HomePage();
	}

}
