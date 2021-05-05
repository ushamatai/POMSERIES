package com.qa.hubspot.application.utils;

import java.util.ArrayList;
import java.util.List;

public class Constants {
	
	public static final String ACCOUNT_PAGE_TITLE="My Account" ;
	public static final String LOGIN_PAGE_TITLE="Account Login" ;
	public static final String ACCOUNT_PAGE_HEADER="Your Store";
	public static final String REGISTRATION_SUCCESS_MESSAGE="Your Account Has Been Created!";
	public static final String REGISTER_SHEET_NAME="registration";
	public static final int ACCOUNT_SECTION_COUNT=4;
	public static  List<String> AccountSectionsList() {
		
		List<String> sectionList=new ArrayList<String>();
		sectionList.add("My Account");
		sectionList.add("My Orders");
		sectionList.add("My Affiliate Account");
		sectionList.add("Newsletter");
		return sectionList;
		
		
	}
public static  List<String> AccountSectionsRightList() {
		
		List<String> sectionListRight=new ArrayList<String>();
		sectionListRight.add("My Account");
		sectionListRight.add("Edit Account");
		sectionListRight.add("Password");
		sectionListRight.add("Address Book");
		sectionListRight.add("Wish List");
		sectionListRight.add("Order History");
		sectionListRight.add("Downloads");
		sectionListRight.add("Recurring payments");
		sectionListRight.add("Reward Points");
		sectionListRight.add("Returns");
		sectionListRight.add("Transactions");
		sectionListRight.add("Newsletter");
		sectionListRight.add("Logout");
		return sectionListRight;
		
		
	}
	
	

}
