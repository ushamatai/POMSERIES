package com.qa.hubspot.baselayer;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import com.qa.hubspot.pages.AccountsPage;
import com.qa.hubspot.pages.LoginPage;
import com.qa.hubspot.pages.ProductInfoPage;
import com.qa.hubspot.pages.RegistrationPage;

public class BaseTest {
	
	public BasePage basepage;
	public Properties prop;
	public WebDriver driver;
	public LoginPage loginPage;
	public AccountsPage accountpage;
	public ProductInfoPage productInfoPage;
	public RegistrationPage registerPage;
	
	
	//Before Method Approach
	
	@BeforeTest
	public void setUp() {
		basepage= new BasePage();
		prop= basepage.init_properties();
		String browser=prop.getProperty("browser");
		driver=basepage.init_driver(browser);
		loginPage= new LoginPage(driver);
		driver.get(prop.getProperty("url"));
				
	}
	
	@AfterTest
	
	public void tearDown()
	{
		
		driver.quit();
		
	}

}
