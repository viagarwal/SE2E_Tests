package com.paypal.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AccountInformationPage {

	private WebDriver driver;
	WebDriverWait  wait  = null;
	public AccountInformationPage(WebDriver driver) {
		this.driver=driver;
		wait = new WebDriverWait(driver, 20);
		PageFactory.initElements(driver, this);
	}
	public String getPageTitle() {
		String title = driver.getTitle();
		return title;
	}
	
	public boolean verifyPageTitle() {
		String pageTitle = " Business Account Sign Up – PayPal";
		return getPageTitle().contains(pageTitle);
	}
}
