package com.qa.hubspot.baselayer;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * 
 * @author umatai
 *
 */

public class BasePage {
	
	public WebDriver driver;
	public Properties prop;
	
	public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<WebDriver>();
	
	
	/**
	 * This method is used to initialize browser based on given browser
	 * @param browser   
	 * @return This will return the webDriver driver
	 */
	public WebDriver init_driver(String browser) {
		
		System.out.println("Browser value is " + browser);
		
		if(browser.equalsIgnoreCase("chrome"))
		{   WebDriverManager.chromedriver().setup();
			//driver= new ChromeDriver();
		
			tlDriver.set(new ChromeDriver());
			
		}
		
		else if(browser.equalsIgnoreCase("firefox"))
		{   WebDriverManager.firefoxdriver().setup();
			//driver= new FirefoxDriver();
		tlDriver.set(new FirefoxDriver());
			
		}
		else
		{
			System.out.println("Please enter correct browser value");
		}
		
		getDriver().manage().deleteAllCookies();
		getDriver().manage().window().maximize();
		//driver.manage().timeouts().implicitlyWait(100, TimeUnit.MILLISECONDS);
		
		return getDriver();
		
	}
	
	/**
	 * getDriver using local
	 * @return 
	 */
	
	//Synchronized- At a time only one test will be picked
	public  static synchronized WebDriver getDriver() {
	return tlDriver.get();
		
	}
	
	/**
	 * 	This method is used to load the properties from config.properties file
	 * @return it returns properties prop reference 
	 */
	public Properties init_properties() {
		
		 prop= new Properties();
		 try {
			FileInputStream file= new FileInputStream("./src/main/java/com/qa/hubspot/config/config.properties");
			prop.load(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		 
		 return prop;
		 
	}
	
	
	public  String getScreenshot() {
		//Driver is typecasted to Screenshot
		//below will tak the screenshot in memory and then store in file.
	File src=	((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
	//Below will create path
	String path=System.getProperty("user.dir") + "/screenshots" + System.currentTimeMillis() +".png";
	File destination= new File(path);
	try {
		FileUtils.copyFile(src, destination);
	} catch (IOException e) {
		e.printStackTrace();
	}
	return path;
	
		
	}
	
	

	
}
