package com.qa.hubspot.test;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.qa.hubspot.application.utils.Constants;
import com.qa.hubspot.baselayer.BaseTest;
import com.qa.hubspot.testlisteners.ExtentReportListener;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

//not preferable -better to do on xml
//@Listeners(ExtentReportListener.class)
public class LoginPageTest extends BaseTest {
	
	@Test(priority=1)
	public void verifyLoginPageTitleTest() {
		String title=loginPage.getLoginPageTitle();
		System.out.println(title);
		Assert.assertEquals(title, Constants.LOGIN_PAGE_TITLE);
	}
	
	@Description("Verify Test")
	@Severity(SeverityLevel.CRITICAL)
	@Test(priority=2)
	public void verifyifForgotPwdLinkExist () {
		Assert.assertTrue(loginPage.isForgotPwdLinkExist());
		
		
	}
	
	@Description("Logging")
	@Severity(SeverityLevel.BLOCKER)
	@Test(priority=3)
	public void doLogin() {
		loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	}

}
