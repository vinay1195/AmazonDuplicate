package com.qa.Amazon.pages;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.Amazon.utils.ElementUtil;

public class productinfopage 
{
private WebDriver driver;
private ElementUtil eleutil;
ArrayList<String> productinfo;

public productinfopage(WebDriver driver)
{
	this.driver=driver;
	eleutil=new ElementUtil(driver);
	
}
private By productlink=By.xpath("//span[@class='a-size-large product-title-word-break']");
private By price=By.xpath("//table[@class='a-lineitem a-align-top']//tr//td");
private By productMetadatarows=By.xpath("//table[@class='a-normal a-spacing-micro']//tr");
private By productMetadata=By.xpath("//table[@class='a-normal a-spacing-micro']//tr//td");
String Before="/html/body/div[1]/div/div[10]/div[5]/div[4]/div[41]/div/table/tbody/tr[";
String After="]/td[";
String last="]/span";

public String isElementExist()
{

	return eleutil.doGetText(productlink);
	
}
public ArrayList<String> productMetada()
{
	productinfo= new ArrayList<String>();
	
	//driver.findElement(By.xpath("//*[@id=\"search\"]/div[1]/div[1]/div/span[1]/div[1]/div[3]/div/div/div/div/span/div/div/div/div[2]/div/div/div[1]/h2/a/span")).click();
	List<WebElement> rows = driver.findElements(productMetadatarows);
	int rowscount=rows.size();
	
	for(int i=1;i<=rowscount;i++)
	{
		for(int j=1;j<=2;j++)
		{
			String xpath = Before + i + After + j +last ;
			//System.out.println(xpath);
			String text = driver.findElement(By.xpath(xpath)).getText();
			productinfo.add(text);
			
			/*
			 * String metakey=meta[0].trim(); String metavalue=meta[1].trim();
			 * productinfo.put(metakey, metavalue);
			 */
			
		}
		System.out.println();
	}
	return productinfo;

}
}
