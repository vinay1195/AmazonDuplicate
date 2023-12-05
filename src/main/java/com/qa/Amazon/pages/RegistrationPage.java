package com.qa.Amazon.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.Amazon.utils.Constants;
import com.qa.Amazon.utils.ElementUtil;

public class RegistrationPage {
	private WebDriver driver;
	private ElementUtil util;

	private By customername = By.id("ap_customer_name");
	private By email = By.id("ap_email");
	private By password = By.id("ap_password");
	private By ReneterPassword = By.id("ap_password_check");
	private By continueBtn = By.id("continue");
	private By captcha = By.xpath("//span[@id='aacb-captcha-header']");
	public RegistrationPage(WebDriver driver)
	{
		this.driver=driver;
		util= new ElementUtil(driver);
	}
	public boolean doRegistration(String customernmae,String email,String password)
	{
		
		util.doSendKeys(this.customername, "Vinaychadana");
		util.doSendKeys(this.email, email);
		util.doSendKeys(this.password, password);
		util.doSendKeys(this.ReneterPassword,password);
		util.doClick(continueBtn);
		
		String message=util.waitForElementToBeVisible(captcha, 10, 2000).getText();
		System.out.println("String message is"+message);
		if(message.contains(Constants.REGISTER_SUCCESS_MSG))
		{
			driver.get("https://www.amazon.com/ap/register?showRememberMe=true&openid.pape.max_auth_age=900&openid.return_to=https%3A%2F%2Fwww.amazon.com%2Fgp%2Fyourstore%2Fhome%3Fpath%3D%252Fgp%252Fyourstore%252Fhome%26signIn%3D1%26useRedirectOnSuccess%3D1%26action%3Dsign-out%26ref_%3Dnav_AccountFlyout_signout&prevRID=S6C8MA6STWNFJZZH35GT&openid.assoc_handle=usflex&openid.mode=checkid_setup&prepopulatedLoginId=&failedSignInCount=0&pageId=usflex&openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0");
			return true;
		}
		return false;
		
		
	}
	

}
