package com.qa.hubspot.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.hubspot.application.utils.Constants;
import com.qa.hubspot.application.utils.ElementUtil;
import com.qa.hubspot.baselayer.BasePage;

public class RegistrationPage  extends BasePage{
	
	private WebDriver driver;
	private ElementUtil eleutil;

        private By firstname=By.id("input-firstname");
		private By lastname=By.id("input-lastname");
		private By email=By.id("input-email");
		private By telephone=By.id("input-telephone");
		private By password=By.id("input-password");
		private By confirmPassword=By.id("input-confirm");
		private By subsrcibeYes=By.xpath("//label[@class='radio-inline' ]//input[@value='1']");
		private By subsrcibeNo=By.xpath("//label[@class='radio-inline' ]//input[@value='0']");
		private By privacyCheckBox=By.name("agree");
		private By continueBtn= By.cssSelector(".btn-primary");
		private By successMessage=By.cssSelector("#content h1");
		private By logoutLink=By.linkText("Logout");
		private By registerLink= By.linkText("Register");
		
		public RegistrationPage(WebDriver driver) {
			this.driver=driver;
			eleutil= new ElementUtil(this.driver);
			}
		
		
		public boolean registrationFlow(String firstname, String lastname ,String email , String telephone, String password
				,String subsrcibe) {
			eleutil.doSendKeys(this.firstname, firstname);
			eleutil.doSendKeys(this.lastname, lastname);
			eleutil.doSendKeys(this.email, email);
			eleutil.doSendKeys(this.telephone, telephone);
			eleutil.doSendKeys(this.password, password);
			eleutil.doSendKeys(this.confirmPassword, password);
			if(subsrcibe=="yes")
			{
				eleutil.doclick(subsrcibeYes);
			}
			else {
				eleutil.doclick(subsrcibeNo);
			}
			eleutil.doclick(privacyCheckBox);
			eleutil.doclick(continueBtn);
			String text=eleutil.dogettext(successMessage);
			
			if (text.contains(Constants.REGISTRATION_SUCCESS_MESSAGE)) {
				eleutil.doclick(logoutLink);
				eleutil.doclick(registerLink);
				return true;
			}
				
			else {
				return false;
			}
			
		}




}
