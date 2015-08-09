package com.paypal.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.paypal.utils.WebDriverWaitUtils;

public class AccountSetUpPage {
	
	@FindBy(xpath ="//input[@value='Personal']") private WebElement personalRadioButton;
	@FindBy(xpath ="//input[@value='Business']") private WebElement busnessRadioButton;
	@FindBy(id ="personalSignUpForm") private WebElement ContinueButton;
	
	private WebDriver driver;
	
	public AccountSetUpPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	public String getPageTitle() {
		String title = driver.getTitle();
		return title;
	}
	
	public boolean verifyPageTitle() {
		String pageTitle = "See for yourself why millions of people love PayPal";
		return getPageTitle().contains(pageTitle);
	}
	
	public void clickOnBusinessRadioButton(){
		WebDriverWaitUtils.waitElementIsVisible(driver, busnessRadioButton);
		busnessRadioButton.click();
	}
	
	public AccountInformationPage clickOnContinueButton() {
		WebDriverWaitUtils.waitElementIsVisible(driver, ContinueButton);	
		ContinueButton.click();
		return new AccountInformationPage(driver);
	}
}
