package com.qa.Amazon.factory;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory
{
	public WebDriver driver;
	public  Properties prop;
	public static String higlight; 
	
	public static ThreadLocal<WebDriver>tldriver=new ThreadLocal<WebDriver>();
	

	public WebDriver init_driver(Properties prop) throws InterruptedException 
	{
		String browsername=prop.getProperty("browser").trim();
		
		System.out.println("browser name is " + browsername);
		higlight=prop.getProperty("highlight");
		
		if (browsername.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\vinay\\Downloads\\down\\chromedriver-win64\\chromedriver.exe");
			ChromeOptions co = new ChromeOptions();
			co.setBinary("C:\\Users\\vinay\\Downloads\\down\\chrome-win64\\chrome.exe");
			ChromeDriver dr = new ChromeDriver(co);
			driver = new ChromeDriver(co);
			//tldriver.set(new ChromeDriver(OptionsManager.getchromeOptions()));
			
		}
		else if (browsername.equalsIgnoreCase("Firefox"))
		{
			System.setProperty("webDriver.gecko.driver", "C:\\Users\\vinay\\Downloads\\down\\geckodriver.exe");
			driver = new FirefoxDriver();
			//tldriver.set(new ChromeDriver(OptionsManager.getchromeOptions()));
		}

		else 
		{
			System.out.println("Please paa the crct browser name");
		}
		
		driver.manage().deleteAllCookies();
		//Thread.sleep(5000);
		driver.get(prop.getProperty("url"));
		Thread.sleep(5000);
		 driver.manage().window().maximize();
		return driver;
	}
	public static synchronized WebDriver getDriver() {
		return tldriver.get();
	}

	public Properties init_prop() {
		prop=new Properties();
		try {
			FileInputStream fip=new FileInputStream(".\\src\\test\\resources\\config\\config.properties");
			try {
				prop.load(fip);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return prop;
	}
	public String getScreenshot() {
		File src = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
		String path = System.getProperty("user.dir") + "/screenshots/" + System.currentTimeMillis() + ".png";
		File destination = new File(path);
		try {
			FileUtils.copyFile(src, destination);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return path;
	}

}
