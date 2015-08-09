package com.paypal.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage  {
	
	@FindBy(id = "signup-button") private WebElement signUpButton; 
	
	private WebDriver driver;
	public HomePage(WebDriver driver) {
		this.driver =  driver;
		PageFactory.initElements(driver, this);
	}
	
	public String getPageTitle() {
		String title = driver.getTitle();
		return title;
	}
	
	public boolean verifyPageTitle() {
		String pageTitle = "Send Money, Pay Online or Set Up a Merchant Account - PayPal India";
		return getPageTitle().contains(pageTitle);
	}
	
	public AccountSetUpPage clickSignUpButton() {
		signUpButton.click();
		return new AccountSetUpPage(driver);
	}

}
