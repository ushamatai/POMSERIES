package com.qa.hubspot.application.utils;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementUtil {

	private WebDriver driver;

	public ElementUtil(WebDriver driver) {
		this.driver = driver;

	}
	// driver.findelement(by.id),sendkeys

	public By ByLocator(String value) {
		return By.id(value);
	}

	public WebElement getElement(By locator) {
		return driver.findElement(locator);
	}

	public List<WebElement> getElements(By locator) {
		return driver.findElements(locator);
	}
	
	
	
	public void doSendKeys(By Locator, String value) {

		getElement(Locator).sendKeys(value);

	}

	public void doclick(By locator)

	{
		getElement(locator).click();

	}

	// Action class methods
	public void doActionSendkeys(By locator, String value) {
		Actions action = new Actions(driver);
		action.sendKeys(getElement(locator), value).perform();
	}

	public void doActionClick(By locator) {
		Actions action = new Actions(driver);
		action.click(getElement(locator)).perform();
	}

	// move to element -Action class

	public void domovetoelementActionsendkeys(By locator, String value) {
		Actions action = new Actions(driver);
		action.moveToElement(getElement(locator)).sendKeys(value).build().perform();
	}

	public void domovetoelementActionClick(By locator) {
		Actions action = new Actions(driver);
		action.moveToElement(getElement(locator)).click().build().perform();
	}

	// to check if particular element is displayed or not
	public boolean doisdisplayed(By locator) {
		return getElement(locator).isDisplayed();
	}

	// get text for any element
	public String dogettext(By locator) {
		return getElement(locator).getText();
	}

	// To count number of Weblements corresponding to tagname
	public int getElementsCount(String tagName) {
		return driver.findElements(By.tagName(tagName)).size();
	}

	// To get attribute of the tagname
	public List<String> getAttributeList(String tagName, String attribute) {
		List<String> attrlist = new ArrayList<String>();
		List<WebElement> elementlist = driver.findElements(By.tagName(tagName));

		for (WebElement p : elementlist) {
			String text = p.getAttribute(attribute);
			attrlist.add(text);

		}
		return attrlist;

	}

	// ****************************DROPDOWN UTILS------------------------------//

	public void doSelectbyvalue(By locator, String value) {
		Select select = new Select(getElement(locator));
		select.selectByValue(value);
	}

	public void doSelectbyindex(By locator, int index) {
		Select select = new Select(getElement(locator));
		select.selectByIndex(index);
	}

	public void doSelectbyvisibletext(By locator, String text) {
		Select select = new Select(getElement(locator));
		select.selectByVisibleText(text);
	}

	// ************************Wait Utils*************************************

	public WebElement waitforElementtobelocated(By locator, int timeout) {
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		return wait.until(ExpectedConditions.presenceOfElementLocated(locator));

	}

	public Alert waitForALertToBePresent(int timeout) {
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		return wait.until(ExpectedConditions.alertIsPresent());

	}

	public WebElement waitforElementtobelocated(By locator, int timeout, int intervalTime) {
		WebDriverWait wait = new WebDriverWait(driver, timeout, intervalTime);
		return wait.until(ExpectedConditions.presenceOfElementLocated(locator));

	}

	public String waitForTitlePresent(String value, int time) {
		WebDriverWait wait = new WebDriverWait(driver, time);
		wait.until(ExpectedConditions.titleContains(value));
		return driver.getTitle();
	}

	public Boolean waitforurl(int timeout, String value) {

		WebDriverWait wait = new WebDriverWait(driver, timeout);
		return wait.until(ExpectedConditions.urlContains(value));

	}

	public WebElement waitforElementToBeVisible(By locator, int timeout) {
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		return wait.until(ExpectedConditions.visibilityOf(getElement(locator)));

	}
	
	
	    public void waitforElementToBeclickable(By locator, int timeout) {
		WebDriverWait wait=new WebDriverWait(driver, timeout);
		 wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
		
	}
	     public List<WebElement> visibilityOfAllElements(By locator, int timeout) {
			WebDriverWait wait=new WebDriverWait(driver, timeout);
			//internally this will create driver.findelements
			
		    return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
			

	}
	    
//	     public void getpagelinktext(By locator, int timeout) {
//			visibilityOfAllElements(locator, timeout).stream().forEach(ele -> System.out.println(ele.getText()));
//			
//			
//		}
//		public void getpagelinkcount(By locator, int timeout) {
//			visibilityOfAllElements(locator, timeout).stream().forEach(ele -> System.out.println(ele.getSize()));
//			
//			
//		}
}
