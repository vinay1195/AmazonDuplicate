package com.qa.Amazon.tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.Amazon.utils.Constants;
import com.qa.Amazon.utils.ExcelUtil;

import org.testng.annotations.Test;
import org.testng.annotations.Test;

public class LoginEmailPageNegativeTest extends BaseTest {
	
	  @DataProvider public Object[][] LoginWrongTestData() { return new Object[][]
	  { { "123456789" }, { "74185236911" }, { " 5  " }, { "000000000000" } }; }
	  
	  @Test(dataProvider = "LoginWrongTestData")
	 
	/*
	 * @DataProvider public void getRegistratiodata() {
	 * ExcelUtil.getTestData(Constants.REGISTER_SHEET_NAME);
	 * 
	 * }
	 * 
	 * @Test(dataProvider="getRegistratiodata")
	 */	
	public void loginNegativeTest(String name) {
		Assert.assertFalse(loginpage.doLoginWithWrongCredentials(name));
	}
}
