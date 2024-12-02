package com.ui.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.utilities.BrowserUtility;
//child classes always to use final keyword
public final class MyAccountPage extends BrowserUtility {
	private static final By USER_NAME_LOCATOR=By.xpath("//a[@title='View my customer account']/span");
	public MyAccountPage(WebDriver driver) {
		super(driver);
		
	}
	
	public String getUserName() {
		return getVisibleText(USER_NAME_LOCATOR);
	}

}
