package com.qa.Amazon.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.qa.Amazon.factory.DriverFactory;
import com.qa.Amazon.pages.LoginEmailpage;
import com.qa.Amazon.pages.LoginPasswordpage;
import com.qa.Amazon.pages.RegistrationPage;
import com.qa.Amazon.pages.Serachresultpage;
import com.qa.Amazon.pages.productinfopage;
import com.qa.Amazon.utils.JavaScriptUtil;

public class BaseTest 
{
	DriverFactory df;
	WebDriver driver;
	LoginEmailpage loginpage;
	LoginPasswordpage loginpwdpage;
	Properties prop;
	Serachresultpage Searchpage;
	productinfopage productinfo;
	JavaScriptUtil highlight;
	RegistrationPage Register;
	@BeforeTest
	public void setup() throws InterruptedException
	{
		 df= new DriverFactory();
		prop=df.init_prop();
		driver=df.init_driver(prop);
		loginpage=new LoginEmailpage(driver);
		loginpwdpage= new LoginPasswordpage(driver);
		Searchpage=new Serachresultpage(driver);
	}
	/*
	 * @AfterTest public void tearDown() { driver.close(); }
	 * 
	 */

}

