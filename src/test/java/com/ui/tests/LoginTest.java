//package com.ui.tests;
//
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//
//import com.utilities.BrowserUtility;
//
//public class LoginTest {
//
//	public static void main(String[] args) {
//		//Launch a browser
//		WebDriver wd=new ChromeDriver();
//		//maximize the browser window
//
//		//navigat to url
//		BrowserUtility browserUtility=new BrowserUtility(wd);
//		browserUtility.maximizeWindow();
//		browserUtility.goToWebSite("https://automationpractice.pl/");
//
//		By SignInLinkLocator=By.xpath("//a[@class='login']");
//		browserUtility.clickOn(SignInLinkLocator);
//
//		By emailTextBoxLocator=By.xpath("//input[@id='email']");
//		browserUtility.enterText(emailTextBoxLocator, "xataso5515@kindomd.com");
//
//		By passwordTextBoxLocator=By.xpath("//input[@type='password']");
//		browserUtility.enterText(passwordTextBoxLocator, "password");
//
//		By submitLoginButtonLocator=By.xpath("//button[@id='SubmitLogin']");
//		browserUtility.clickOn(submitLoginButtonLocator);
//	}
//
//}
