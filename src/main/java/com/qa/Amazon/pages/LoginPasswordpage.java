package com.qa.Amazon.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.Amazon.utils.Constants;
import com.qa.Amazon.utils.ElementUtil;

public class LoginPasswordpage 
{
	private WebDriver driver;
	private ElementUtil eleutil;
	

	public  LoginPasswordpage(WebDriver driver) {
		this.driver = driver;
		eleutil=new ElementUtil(driver);
	}
	public boolean SerachButtonisExist()
	{
		return eleutil.isElementExist(Searchfield);
	}
	public boolean getLoginPageUrl()
	{
		return eleutil.waitForURLToContain(Constants.LoginPasswordpage_URL_FRACTION,Constants.DEFAULT_TIME_OUT);
	}
	public boolean isAmazonnameExist()
	{
		return eleutil.isElementExist(Amazonlogo);
	}
	public Serachresultpage doSearch(String productname)
	{
		driver.findElement(Searchfield).clear();
		eleutil.doSendKeys(Searchfield, productname);
		eleutil.doClick(searchbtn);
		
		return new Serachresultpage(driver);
	}
	private By searchbtn=By.id("nav-search-submit-button");
	private By password= By.id("ap_password");
	private By Signin=By.id("signInSubmit");
	private By Searchfield=By.id("twotabsearchtextbox");
	private By Amazonlogo= By.id("nav-logo-sprites");
	public Serachresultpage doLoginpwdSignin(String pwd)
	{
		eleutil.doSendKeys(password,pwd);
		eleutil.doClick(Signin);
		return new Serachresultpage(driver);
	}
	
	
	
	
}
