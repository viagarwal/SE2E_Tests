package com.paypal.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.paypal.utils.Driver;
import com.paypal.utils.WebDriverWaitUtils;

public class AccountSetUpPage extends Driver {
	
	@FindBy(xpath ="//input[@value='Personal']") private WebElement personalRadioButton;
	@FindBy(xpath ="//input[@value='Business']") private WebElement busnessRadioButton;
	@FindBy(id ="personalSignUpForm") private WebElement ContinueButton;
	
	public AccountSetUpPage() {
		PageFactory.initElements(eventFiringWebDriver, this);
		
	}
	public String getPageTitle() {
		String title = eventFiringWebDriver.getTitle();
		return title;
	}
	
	public boolean verifyPageTitle() {
		String pageTitle = "See for yourself why millions of people love PayPal";
		return getPageTitle().contains(pageTitle);
	}
	
	public void clickOnBusinessRadioButton(){
		WebDriverWaitUtils.waitElementIsVisible(eventFiringWebDriver, busnessRadioButton);
		busnessRadioButton.click();
	}
	
	public AccountInformationPage clickOnContinueButton() {
		WebDriverWaitUtils.waitElementIsVisible(eventFiringWebDriver, ContinueButton);	
		ContinueButton.click();
		return new AccountInformationPage();
	}
}
