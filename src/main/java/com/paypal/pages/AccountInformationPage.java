package com.paypal.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.paypal.utils.Driver;
import com.paypal.utils.WebDriverWaitUtils;
import com.paypal.utils.YamlReader;

public class AccountInformationPage extends Driver {

	private String locale = null;
	@FindBy(id= "business_type") public WebElement  businessType;
	@FindBy(id ="business_name") public WebElement bussinessName;
	@FindBy(id ="business_address1") public WebElement businessAddress;
	@FindBy(id="business_city") public WebElement businessCity;
	@FindBy(id ="business_state") public WebElement businessState;
	@FindBy(id ="business_zip") public WebElement businessZip;
	@FindBy(id ="ccode") public WebElement currencyCode;
	@FindBy(id ="industry") public WebElement category;
	@FindBy(id ="date_of_registration_dd") public WebElement dayOfRegistration;
	@FindBy(id="date_of_registration_mm") public WebElement monthOfRegistration;
	@FindBy(id ="date_of_registration_yyyy") public WebElement yearOfRegistration;
	@FindBy(id ="first_name") public WebElement firstName;
	@FindBy(id="last_name") public WebElement lastName;
	
	
	public AccountInformationPage() {
		PageFactory.initElements(eventFiringWebDriver, this);
	}
	
	public AccountInformationPage(String locale){
		this.locale  = locale;
	}
	
	public String getPageTitle() {
		String title = eventFiringWebDriver.getTitle();
		return title;
	}
	
	public boolean verifyPageTitle() {
		String pageTitle = " Business Account Sign Up – PayPal";
		return getPageTitle().contains(pageTitle);
	}
	
	public void fillAccountInfo(String locale) throws IOException{
		WebDriverWaitUtils.waitElementIsVisible(eventFiringWebDriver , businessType);
		new Select(businessType).selectByVisibleText(YamlReader.getKeyValue(locale).get("Business Type").toString());
	}
}
