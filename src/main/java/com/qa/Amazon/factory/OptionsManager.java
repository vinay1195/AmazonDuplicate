package com.qa.Amazon.factory;

import java.util.Properties;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;

public class OptionsManager
{
	private static Properties prop;
	private static ChromeOptions co;
	private FirefoxOptions fo;
	
	public OptionsManager(Properties prop)
	{
		this.prop=prop;
	}
	public static ChromeOptions getchromeOptions()
	{
		if(Boolean.parseBoolean(prop.getProperty("headless")))
			try {
				co.addArguments("--headless");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		if(Boolean.parseBoolean(prop.getProperty("incognito")))
			try {
				co.addArguments("--incognito");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return co;
	}
	public FirefoxOptions getFirefoxOptions()
	{
		if(Boolean.parseBoolean(prop.getProperty("--headless")))fo.addArguments("--headless");
		if(Boolean.parseBoolean(prop.getProperty("--incognito")))fo.addArguments("--incognito");
		return fo;
	}
	
	
	
	

}
