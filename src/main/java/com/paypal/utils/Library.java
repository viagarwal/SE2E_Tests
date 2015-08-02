package com.paypal.utils;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Library {
	
	public void selectVisibleText(WebElement elm , String text) {
		
		Select select  = new Select(elm);
		select.selectByVisibleText(text);
	}
}
