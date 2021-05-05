 package com.qa.hubspot.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import com.qa.hubspot.application.utils.Constants;
import com.qa.hubspot.application.utils.ElementUtil;
import com.qa.hubspot.baselayer.BasePage;

import io.qameta.allure.Step;

public class LoginPage extends BasePage {
	private WebDriver driver;
	private ElementUtil eleutil;

	//By Locator: Object Repository
	
	By email= By.id("input-email");
	By forgotPwdLink=By.linkText("Forgotten Password123");
	By password=By.id("input-password");
	By loginButton= By.xpath("//input[@type='submit'  and  @value='Login']");
	By registerLink= By.linkText("Register");
	
	//2. Constructor of the page class- to access driver
	
	public LoginPage(WebDriver driver) {
		
		this.driver=driver;	
		eleutil= new ElementUtil(driver);
	}
	//3.Page actions (Behavior of the page ..the form methods):
	public String  getLoginPageTitle() {
		return eleutil.waitForTitlePresent(Constants.LOGIN_PAGE_TITLE, 10);
	}
	
	public boolean  isForgotPwdLinkExist () {
		return eleutil.doisdisplayed(forgotPwdLink);
	}
	
	@Step("Logging with username :  {0}   and  password :  {1}")
	public AccountsPage doLogin(String un, String pwd) {
		System.out.println("Enter username and password" + un +" "+ pwd);

		eleutil.doSendKeys(email, un);
		eleutil.doSendKeys(password, pwd);
		eleutil.doActionClick(loginButton);
		
		return new AccountsPage(driver);
	}
	
	public RegistrationPage  registerPage() {
		eleutil.doclick(registerLink);
		return new RegistrationPage(driver);
		
	}
	
}
