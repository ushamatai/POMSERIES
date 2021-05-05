package com.qa.hubspot.test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.hubspot.application.utils.Constants;
import com.qa.hubspot.baselayer.BaseTest;
import com.qa.hubspot.pages.AccountsPage;

public class AccountPageTest extends BaseTest {
	
	@BeforeClass
	public void homePageSetup() {
		 
		accountpage=loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
		

	}
	
	@Test(priority=1)
	public void verifyHomePageTitleTest() {
	String title=accountpage.getAccountsPageTitle();
	System.out.println("Title :" + "homepage");
	Assert.assertEquals(title, Constants.ACCOUNT_PAGE_TITLE);
	
	}
	
	
	@Test(priority= 2)
	public void verifyAccountPageHeaderText() {
		String headerValue=accountpage.getHeaderValue();
		System.out.println("Account page header is  : "+headerValue);
		Assert.assertEquals(headerValue, Constants.ACCOUNT_PAGE_HEADER);
	}
	
	@Test(priority= 3)
	public void verifyAccountSectionsCountTest() {
		Assert.assertTrue(accountpage.getAccountSectionsCount() == Constants.ACCOUNT_SECTION_COUNT);
	}
	
	@Test(priority= 4)
	public void verifyAccountSectionsHeaderNameTest() {
		Assert.assertEquals(accountpage.getAccountSectionsList(), Constants.AccountSectionsList());
	}
	
	@Test(priority= 6)
	public void verifySearchFunctionalityTest() {
	Assert.assertTrue(accountpage.doSearch("iMac"));
	}
	
	@Test(priority= 5)
	public void verifyRightSideList() {
		Assert.assertEquals(accountpage.getRightList(), Constants.AccountSectionsRightList());
	}

}
