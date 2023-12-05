package com.qa.Amazon.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.Amazon.utils.ElementUtil;

public class Serachresultpage
{
private WebDriver driver;
private ElementUtil eleutil;

	public Serachresultpage(WebDriver driver)
	{
		this.driver=driver;
		eleutil=new ElementUtil(driver);
		
	}
	private By productlist = By.xpath("//a[@class='a-link-normal s-underline-text s-underline-link-text s-link-style a-text-normal']//span");
	
	public int productlistcount()
	{
		int resultcount=eleutil.waitForElementsToBeVisible(productlist, 10,2000).size();
		//System.out.println("productlist count is"+resultcount);
		return resultcount;
	}
	 public productinfopage selectProduct(String MainProductName)
	 {
		 System.out.println("mainproduct name is"+MainProductName);
		 List<WebElement>Searchlistnames=eleutil.waitForElementsToBeVisible(productlist, 10, 2000);
		 for(WebElement e:Searchlistnames)
		 {
			 String Text=e.getText();
			 if(Text.contains(MainProductName))
			 {
				 System.out.println(Text);
				e.click();
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				break;
				
			 }
		 }
		 return new productinfopage(driver);
	 }
}
