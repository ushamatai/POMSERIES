package com.qa.hubspot.test;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.hubspot.baselayer.BaseTest;

public class ProductInfoPageTest  extends BaseTest {
	
	
	@BeforeClass
	public void homePageSetup() {
		 
		accountpage=loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
		
		}
	
	@Test(priority=2)
	public void verifyProductTitleTest() 
	{
		Assert.assertEquals(productInfoPage.getProductInforTitle("MacBook"), "MacBook Pro");
	}
	
	@Test(priority=1)
	//create same for iMac as well
	public void verifyProductInfoTest() {
		String productName="MacBook";
		Assert.assertTrue(accountpage.doSearch(productName));
		productInfoPage=accountpage.searchProductFromResult("MacBook Pro"); 
		Assert.assertTrue(productInfoPage.getProductImages()==4);
		Map<String, String> productInforMap= productInfoPage.getProductInformation();
		System.out.println(productInforMap);
		Assert.assertEquals(productInforMap.get("Brand"), "Apple");
		Assert.assertEquals(productInforMap.get("Availability"), "Out Of Stock");
		Assert.assertEquals(productInforMap.get("Price is"), "$2,000.00");
		Assert.assertEquals(productInforMap.get("Ex Tax"), "$2,000.00");
		Assert.assertEquals(productInforMap.get("Product Code"), "Product 18");
		Assert.assertEquals(productInforMap.get("Name of product is:"), "MacBook Pro");
		Assert.assertEquals(productInforMap.get("Reward Points"), "800");
	}
	
	@Test(priority=3)
	public void verifyAddToCart() {
		productInfoPage.selectQuantity("2");
		productInfoPage.addToCart();
		//productInfoPage.getShoppingCart();
		productInfoPage.successMessage();
	
		
		
		
	}
	

}
