package com.paypal.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.paypal.utils.Driver;
import com.paypal.utils.WebDriverWaitUtils;

public class SignUpPage extends Driver {

	@FindBy(id = "country") private WebElement selectCountry;	
	
	
	public SignUpPage() {
		PageFactory.initElements(eventFiringWebDriver, this);
	}

	public String getPageTitle() {
		return eventFiringWebDriver.getTitle();
	}

	public boolean verifyPageTitle() {
		String pageTitle = "Sign Up for a PayPal Account – PayPal";
		return getPageTitle().contains(pageTitle);
	}

	public AccountSetUpPage selectAccount(String country) {
		WebDriverWaitUtils.waitElementIsVisible(eventFiringWebDriver , selectCountry);
		new Select(selectCountry).selectByVisibleText(country);
		return new AccountSetUpPage();
	}
}
