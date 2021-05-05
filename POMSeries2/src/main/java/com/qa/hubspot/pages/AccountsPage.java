package com.qa.hubspot.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.qa.hubspot.application.utils.Constants;
import com.qa.hubspot.application.utils.ElementUtil;
import com.qa.hubspot.baselayer.BasePage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class    AccountsPage extends BasePage{

	
		
		private By headerText=By.cssSelector("div#logo a");
		private By accountSectionHeaders=By.cssSelector("div#content h2");
		private By searchText=By.cssSelector("div#search input[name='search']"); 
		private By searchBtn=By.cssSelector("div#search button[type='button']");
		private By righList=By.cssSelector("#column-right a");
		private By searchItemResult=By.cssSelector(".product-layout .product-thumb");
		private By resultItems=By.cssSelector(".product-thumb h4 a");
		private ElementUtil eleUtil;
		
		public AccountsPage(WebDriver driver)
		{
			this.driver=driver;
			eleUtil= new ElementUtil(driver);
		}
		
		public String getAccountsPageTitle() {
			
			return eleUtil.waitForTitlePresent(Constants.ACCOUNT_PAGE_TITLE, 10);
		}
	
		public String getHeaderValue() {
			if(eleUtil.doisdisplayed(headerText))
			{
				return eleUtil.dogettext(headerText);
			}
			return null;
			
		}

	
	public int getAccountSectionsCount() {
		//return driver.findElements(accountSectionHeaders).size();
		return eleUtil.getElements(accountSectionHeaders).size();
			
	}
	
	public List<String> getAccountSectionsList() {
		
		List<WebElement> accSectionList= eleUtil.getElements(accountSectionHeaders);
		List<String> accountlist=new ArrayList<>();
		for(WebElement e :accSectionList )
		{
			accountlist.add(e.getText());
		}
		return accountlist;
	}
	
    public List<String> getRightList() {
		
		List<WebElement> rightList= eleUtil.getElements(righList);
		System.out.println(rightList.size());
		List<String> rightSectionList=new ArrayList<>();
		for(WebElement e :rightList )
		{
			rightSectionList.add(e.getText());
			System.out.println(e.getText());
		}
		return rightSectionList;
	}

    
    public boolean doSearch(String productName) {
    	eleUtil.doSendKeys(searchText, productName);
    	eleUtil.doclick(searchBtn);
    	if(eleUtil.getElements(searchItemResult).size()>0)
    	{
    		return true;
    		
    	}
    	return false;
    	
    }
    
    public ProductInfoPage searchProductFromResult(String productName) {
    	
    	List<WebElement> resultItemList= eleUtil.getElements(resultItems);
    	System.out.println("Total no of Items displayed " +resultItemList.size());
    	
    	for(WebElement e: resultItemList)
    	{
    		System.out.println(e.getText());
    		if(e.getText().equals(productName))
    		{
    			e.click();
    		    break;
    	}
    	
    	
    	
    }
    	return new ProductInfoPage(driver);
	
    }
}
