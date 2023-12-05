package com.qa.Amazon.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.Amazon.utils.Constants;
import com.qa.Amazon.utils.ExcelUtil;

public class RegistrationPageTest extends BaseTest
{
	@BeforeClass
	public void SetupRegistrationpage()
	{
		Register=loginpage.doRegistrationpage();
	}
	
	public void doRegistrationTest() 
	{
		Assert.assertTrue(Register.doRegistration("vinaychanadan1", "chandanavina1@gmail.com", "Mvinay@2243"),"YES");
		
	}

}
