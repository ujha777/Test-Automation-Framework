package com.utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import com.constant.Browser;

public abstract class BrowserUtility {
	//instance variable created in heap memory
	//Non primitive data type
	//initializtion done by constructor
	//abstract class can have the constructor
	//can call the parent constructor i.e BrowserUtility from Child Constructor i.e Home Page by super keyword
	//parent class should be abstract keyword

	private static ThreadLocal<WebDriver> driver=new ThreadLocal<WebDriver>();
	Logger logger = LoggerUtility.getLogger(this.getClass());
	public BrowserUtility(WebDriver driver) {
		super();
		this.driver.set(driver);//initialization the instance variable driver
	}

	public BrowserUtility(String browserName) {
		logger.info("Launching Browser for "+ browserName);
		if (browserName.equalsIgnoreCase("chrome")) {
			driver.set(new ChromeDriver());
		}
		else if(browserName.equalsIgnoreCase("edge")) {
			driver.set(new EdgeDriver());
		}
		else {
			logger.info("Invalid Browser Name...Please select Chrome or Edge only ");
			System.out.println("Invalid Browser Name..Please Select Chrome or Edge Only");
		}
	}
	public BrowserUtility(Browser browserName) {
		logger.info("Launching Browser for "+ browserName);
		if (browserName==Browser.CHROME) {

			driver.set(new ChromeDriver());
		}
		else if(browserName==Browser.EDGE) {
			driver.set(new EdgeDriver());
		}
		else if(browserName==Browser.FIREFOX) {
			driver.set(new FirefoxDriver());
		} 
	}

	public BrowserUtility(Browser browserName,boolean isHeadless) {
		logger.info("Launching Browser for "+ browserName);
		if (browserName==Browser.CHROME) {
			if (isHeadless) {
				ChromeOptions chromeOptions=new ChromeOptions();
				chromeOptions.addArguments("--headless=old");
				chromeOptions.addArguments("--window-size=1920,1080");
				driver.set(new ChromeDriver(chromeOptions));
			}
			else {
				driver.set(new ChromeDriver());
			}


		}
		else if(browserName==Browser.EDGE) {
			if (isHeadless) {
				EdgeOptions edgeOptions=new EdgeOptions();
				edgeOptions.addArguments("--headless=old");
				edgeOptions.addArguments("disable-gpu");
				driver.set(new EdgeDriver(edgeOptions));
			}
			else {
				driver.set(new EdgeDriver());
			}
		}
		else if(browserName==Browser.FIREFOX) {
			if (isHeadless) {
				FirefoxOptions firefoxOptions=new FirefoxOptions();
				firefoxOptions.addArguments("--headless=old");
				firefoxOptions.addArguments("--window-size=1920,1080");
				driver.set(new FirefoxDriver(firefoxOptions));
			}else {
				driver.set(new FirefoxDriver());
			}
		} 
	}

	public WebDriver getDriver() {
		return driver.get();
	}

	public void goToWebSite(String url) {
		logger.info("Visting the website"+ url);
		driver.get().get(url);

	}

	public void maximizeWindow() {
		logger.info("Maximize the browser window");
		driver.get().manage().window().maximize();
	}

	public void clickOn(By locator) {
		logger.info("Finding Element with the locator"+ locator);
		WebElement element = driver.get().findElement(locator);
		logger.info("Element found and now performing Click"+ locator);
		element.click();
	}

	public void enterText(By locator,String textToEnter) {
		logger.info("Finding Element with the locator"+ locator);
		WebElement element = driver.get().findElement(locator);
		logger.info("Element found and now enter Text"+ textToEnter);
		element.sendKeys(textToEnter);
	}

	public String getVisibleText(By locator) {
		logger.info("Finding Element with the locator"+ locator);
		WebElement element = driver.get().findElement(locator);
		logger.info("Element found and now returning the visible "+ element.getText() );
		return element.getText();
	}

	public String takeScreenshot(String name) {
		TakesScreenshot screenshot = (TakesScreenshot)driver.get();
		File screenshotData = screenshot.getScreenshotAs(OutputType.FILE);
		Date  date=new Date();
		SimpleDateFormat format=new SimpleDateFormat("HH-mm-ss");
		String timeStamp = format.format(date);
		String path=System.getProperty("user.dir")+"//screenshots"+"//"+name+" - "+timeStamp+".png";
		File screenShotFile=new File(path);
		try {
			FileUtils.copyFile(screenshotData, screenShotFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return path;
	}
	
	public void quit() {
		driver.get().quit();
	}


}
