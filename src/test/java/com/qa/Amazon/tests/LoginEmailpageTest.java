package com.qa.Amazon.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.Amazon.utils.Constants;

public class LoginEmailpageTest extends BaseTest
{
	@Test
	public void LoginPageTitleTest()
	{
		String actTitle=loginpage.getLoginPageTitle();
		System.out.println("Page Title"+actTitle);
		Assert.assertEquals(actTitle,Constants.LOGIN_PAGE_TITLE);
	}
	@Test(priority=2)
	public void LoginpageurlTest()
	{
		/*
		 * String acturl=loginpage.getLoginPageUrl();
		 * System.out.println("page url"+acturl);
		 */
		Assert.assertTrue(loginpage.getLoginPageUrl());
	}
	//@Test
	/*public void LoginEmailTest()
	{
		loginpwdpage=loginpage.doLoginEmailPage(prop.getProperty("username"));
		Assert.assertEquals(loginpwdpage.get, null);
		
	}*/
	
	
	
}
