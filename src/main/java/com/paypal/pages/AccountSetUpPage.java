package com.paypal.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AccountSetUpPage {
	
	private WebDriver driver;
	WebDriverWait  wait  = null;
	
	public AccountSetUpPage(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, 20);
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

	@FindBy(xpath ="//input[@value='Personal']") private WebElement personalRadioButton;
	@FindBy(xpath ="//input[@value='Business']") private WebElement busnessRadioButton;
	@FindBy(id ="personalSignUpForm") private WebElement ContinueButton;
	
	public void clickOnBusinessRadioButton(){
		wait.until(ExpectedConditions.visibilityOf(busnessRadioButton));
		busnessRadioButton.click();
	}
	
	public AccountInformationPage clickOnContinueButton() {
		wait.until(ExpectedConditions.visibilityOf(ContinueButton));
		ContinueButton.click();
		return new AccountInformationPage(driver);
	}
}
