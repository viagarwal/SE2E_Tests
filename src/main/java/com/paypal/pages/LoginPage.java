package com.paypal.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.paypal.utils.Driver;
import com.paypal.utils.WebDriverWaitUtils;

public class LoginPage extends Driver {

	@FindBy(css ="a#createAccount") public static WebElement signUpButton;
	public LoginPage() {
		PageFactory.initElements(eventFiringWebDriver, this);
	}
	
	public String getPageTitle() {
		String title = eventFiringWebDriver.getTitle();
		return title;
	}
	
	public boolean verifyPageTitle() {
		String pageTitle = "Log in to your PayPal account";
		return getPageTitle().contains(pageTitle);
	}
	public AccountSetUpPage clickOnSignUpButton() {
		WebDriverWaitUtils.waitElementIsVisible(eventFiringWebDriver, signUpButton);
		signUpButton.click();
		return new AccountSetUpPage();
	}
	
}
