package com.paypal.tests;

import java.io.IOException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;

import com.paypal.pages.AccountInformationPage;
import com.paypal.pages.AccountSetUpPage;
import com.paypal.pages.HomePage;
import com.paypal.pages.LoginPage;
import com.paypal.utils.Driver;
import com.paypal.utils.ReadExcelDataProvider;
import com.paypal.utils.YamlDataReader;

public class LoginTest extends Driver {
	
	private String locale = null;
	private HomePage homePage = null;
	private LoginPage loginPage = null;
	private AccountInformationPage accountInformationPage = null;
	private AccountSetUpPage AccountSetUpPage = null;
	String methodName = null;
	
	
	@BeforeClass
	public void setUp1() {
		homePage = new HomePage();
		AccountSetUpPage = new AccountSetUpPage();
		accountInformationPage = new AccountInformationPage();
		loginPage = new LoginPage();
		
	}
	@Factory(dataProviderClass=ReadExcelDataProvider.class,dataProvider="getExcelData")
	public LoginTest(YamlDataReader eachCountryData) {
		this.locale	= eachCountryData.getLocale();
	}
	
	@Test(description="Login to Paypal account")
	public void getNewAccount() throws IOException  {
	
//		methodName =  new Object(){}.getClass().getEnclosingMethod().getName();
		System.out.println(this.locale);
//		homePage.clickLoginButton();
//		loginPage.clickOnSignUpButton();
//		AccountSetUpPage.clickOnBusinessRadioButton();
//		AccountSetUpPage.clickOnContinueButton();
//		accountInformationPage.fillAccountInfo(locale);
	}

}
