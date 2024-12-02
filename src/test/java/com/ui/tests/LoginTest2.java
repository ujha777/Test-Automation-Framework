package com.ui.tests;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.ui.page.HomePage;
import com.ui.page.LoginPage;
import com.utilities.BrowserUtility;

public class LoginTest2 {

	public static void main(String[] args) {
		//Launch a browser
		WebDriver wd=new ChromeDriver();
		
		HomePage homePage=new HomePage(wd);
		homePage.maximizeWindow();
		LoginPage loginPage = homePage.goToLoginPage();
		loginPage.doLoginWith("xataso5515@kindomd.com", "password");
		
	}

}
