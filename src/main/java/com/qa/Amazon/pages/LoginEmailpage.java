package com.qa.Amazon.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.Amazon.utils.ElementUtil;
import com.qa.Amazon.utils.Constants;



public class LoginEmailpage
{
	private WebDriver driver;
	private ElementUtil eleutil;

	public  LoginEmailpage(WebDriver driver) {
		this.driver = driver;
		eleutil=new ElementUtil(driver);
	}
	private By email=By.id("ap_email");
	private By Continue=By.id("continue");
	private By Errormsg= By.xpath("//div[@class='a-box-inner a-alert-container']//h4");
	private By createAccount=By.id("createAccountSubmit");
	public String getLoginPageTitle()
	{
		return eleutil.doGetTitle(Constants.LOGIN_PAGE_TITLE,Constants.DEFAULT_TIME_OUT);
	}
	public boolean getLoginPageUrl()
	{
		return eleutil.waitForURLToContain(Constants.LOGIN_PAGE_URL_FRACTION,Constants.DEFAULT_TIME_OUT);
	}
	public LoginPasswordpage doLoginEmailPage(String Usernme)
	{
		eleutil.doSendKeys(email,Usernme);
		eleutil.doClick(Continue);
		return new LoginPasswordpage(driver);
	}
//	nothing is added.
	public boolean doLoginWithWrongCredentials(String Usernme)
	{
		eleutil.doSendKeys(email,Usernme);
		eleutil.doClick(Continue);
		String ErrorText=driver.findElement(Errormsg).getText();
		if(ErrorText.contentEquals(Constants.LOGIN_ERROR_MESSAGE))
		{
			return false;
		}
		return true;
	}
	public RegistrationPage doRegistrationpage()
	{
	  eleutil.doClick(createAccount);
	  return new RegistrationPage(driver);
	}
	
	

}
