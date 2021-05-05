package com.qa.hubspot.test;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.hubspot.application.utils.Constants;
import com.qa.hubspot.application.utils.ExcelUtil;
import com.qa.hubspot.baselayer.BaseTest;

public class RegisterPageTest  extends BaseTest{
	
	@BeforeClass
	public void registrationPageSetup() {
		registerPage= loginPage.registerPage();
		
	}
	
	//DP method to fetch data from excel
	@DataProvider
	public Object[][] getRegisterData() {
		System.out.println("Hello");
		Object data[][] = ExcelUtil.getTestData(Constants.REGISTER_SHEET_NAME);
		return data;
		
	}
	
	//Letting test know that data needs to be fetched from DP method
	@Test(dataProvider="getRegisterData")
	public void doRegistrationTest(String firstname, String lastname ,String email , String telephone, String password
			,String subsrcibe) {
		System.out.println("bye");
		
		registerPage.registrationFlow( firstname,  lastname , email ,  telephone,  password
				, subsrcibe);
	}
	
	
	




}
