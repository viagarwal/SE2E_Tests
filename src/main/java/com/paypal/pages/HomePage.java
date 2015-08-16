package com.paypal.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.paypal.utils.Driver;

public class HomePage extends Driver {
	
	@FindBy(id = "signup-button") private WebElement signUpButton; 
	
	public HomePage() {
		PageFactory.initElements(eventFiringWebDriver, this);
	}
	
	public String getPageTitle() {
		String title = eventFiringWebDriver.getTitle();
		return title;
	}
	
	public boolean verifyPageTitle() {
		String pageTitle = "Send Money, Pay Online or Set Up a Merchant Account - PayPal India";
		return getPageTitle().contains(pageTitle);
	}
	
	public AccountSetUpPage clickSignUpButton() {
		signUpButton.click();
		return new AccountSetUpPage();
	}

}
