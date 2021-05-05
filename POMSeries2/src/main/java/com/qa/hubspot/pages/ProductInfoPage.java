package com.qa.hubspot.pages;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.hubspot.application.utils.ElementUtil;
import com.qa.hubspot.baselayer.BasePage;

public class ProductInfoPage extends BasePage {
	
	private WebDriver driver;
	private ElementUtil eleUtil;

	
	private By productNameHeader= By.cssSelector("#content h1");
	private By productMetaData=By.cssSelector("#content .list-unstyled:nth-of-type(1) li");
	private By productPrice=By.cssSelector("#content .list-unstyled:nth-of-type(2) li");
	private By productQuantity=By.id("input-quantity");
	private By addToCartBtn= By.id("button-cart");
	private By productImages=By.cssSelector("#content .thumbnails img");
	private By cartBox=By.xpath("//*[@id='cart-total']");
	private By alertSuccessMessage=By.xpath("//*[@id='product-product']//div[contains(@class,'alert-success')]");
	
	
	
	public ProductInfoPage(WebDriver driver) {
		this.driver=driver;
		eleUtil= new ElementUtil(driver);
		
	}
	
	/**
	 * Gives the information of the product
	 * @return Hashmap value of products
	 */
	
	public Map<String, String> getProductInformation() {
		
		Map<String,String> productInfoMap = new HashMap<>();
		//This is to get the product name
		productInfoMap.put("Name of product is:", eleUtil.dogettext(productNameHeader).trim());
		List<WebElement> productList=eleUtil.getElements(productMetaData);
		for(WebElement e:productList )
		{
			productInfoMap.put(e.getText().split(":")[0].trim(), e.getText().split(":")[1].trim());
		}
		
		List<WebElement> productPricedetails=eleUtil.getElements(productPrice);
		//Here the key structure is not same for WebElements hence we are not using for loop
		//As for the 0th element there is no key present, hardcoded key is used
		//But for the second key we here we have :
		//Hence, separator is used for 2nd weblement and not the 3rd one
				productInfoMap.put("Price is", productPricedetails.get(0).getText().trim());
				productInfoMap.put(productPricedetails.get(1).getText().split(":")[0].trim(),productPricedetails.get(1).getText().split(":")[1].trim());

		
				return productInfoMap;
		
		
	}
	
	
	//sendkeys will take only string as specified in element utils
	public void selectQuantity(String quantity) {
		driver.findElement(productQuantity).clear();
	 	eleUtil.doSendKeys(productQuantity, quantity);
		
	}

	
	public void addToCart() {
	 	eleUtil.doclick(addToCartBtn);
		
	}
	
	public int getProductImages() {
		int imagesCount= eleUtil.getElements(productImages).size();
		System.out.println("Total no of images is : " + imagesCount );
		return imagesCount;
	}

	public String getProductInforTitle(String productName) {
		return eleUtil.waitForTitlePresent(productName, 5);
		
	}
	
	public String getShoppingCart() {
		eleUtil.waitforElementToBeVisible(alertSuccessMessage, 10);
		String cartText= eleUtil.dogettext(cartBox);
		System.out.println("Text is :" +cartText);
		return cartText;
		
	}
	
	
	public String  successMessage() { 
		WebElement successBox=eleUtil.waitforElementToBeVisible(alertSuccessMessage, 20);
	    String msg=successBox.getText();
		return msg;
		
		
//		String cartText= eleUtil.dogettext(alertSuccessMessage);
//		System.out.println(alertSuccessMessage);
//		return cartText ;
		
		
	}
	
	
	
	
	
	
	
	
	
}


