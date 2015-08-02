package com.paypal.utils;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;

public class WebDriverWaitUtils {

	public static ExpectedCondition<Boolean> invisibilityOfElementLocated(
			final WebElement locator) {
		return new ExpectedCondition<Boolean>() {
			@Override
			public Boolean apply(WebDriver driver) {
				try {
					return !locator.isDisplayed();
				} catch (NoSuchElementException e) {
					// Returns true because the element is not present in DOM.
					// The
					// try block checks if the element is present but is
					// invisible.
					return true;
				} catch (StaleElementReferenceException e) {
					// Returns true because stale element reference implies that
					// element
					// is no longer visible.
					return true;
				}
			}

			@Override
			public String toString() {
				return "element to no longer be visible: " + locator;
			}
		};
	}

}
