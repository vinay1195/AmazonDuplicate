package com.qa.Amazon.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.Amazon.utils.Constants;

public class LoginPasswordpageTest extends BaseTest {
	@BeforeClass
	public void LoginPasswordpageSetup() {
		loginpwdpage = loginpage.doLoginEmailPage(prop.getProperty("username"));
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void SerachButtonisExist() {

		Assert.assertTrue(loginpwdpage.SerachButtonisExist());
	}

	@Test
	public void LoginPassworTest() {
		loginpwdpage.doLoginpwdSignin(prop.getProperty("pwd"));

	}

	/*
	 * @Test public void loginpasswordpageURL() {
	 * Assert.assertTrue(loginpwdpage.getLoginPageUrl()); }
	 */

	@Test
	public void isAmazonExist() {
		Assert.assertTrue(loginpwdpage.isAmazonnameExist());
	}

	@DataProvider
	public Object[][] productdata() {
		return new Object[][] { { "LG" }, { "SamSung" }, { "MI" }, };
	}

	
	  @Test(dataProvider = "productdata")
	  public void SearchTest(String productname) { 
		  Searchpage =loginpwdpage.doSearch(productname);
	  Assert.assertTrue(Searchpage.productlistcount() > 0); }
	 
	@DataProvider
	public Object[][] productSelectData() {
		return new Object[][] { { "LG", "Replacement LG Remote Control for Smart TV,LG Magic Remote AN-MR22GA with Voice and Pointer Function,Compatible for 2022-2019 LG TVs,OLED,QNED,NANOCell etc." }, {
				"SamSung",
				"SAMSUNG Galaxy A54 5G A Series Cell Phone, Factory Unlocked Android Smartphone, 128GB w/ 6.4” Fluid Display Screen, Hi Res Camera, Long Battery Life, Refined Design, US Version, 2023, Awesome Violet" } };
	}

	@Test(dataProvider = "productSelectData")
	public void selectProductTest(String productname, String mainProductName) {
		Searchpage = loginpwdpage.doSearch(productname);
		System.out.println("my product name is" + productname);
		productinfo = Searchpage.selectProduct(mainProductName);
		Assert.assertEquals(productinfo.isElementExist(), mainProductName);
		// productinfo.isElementExist();
	}

}
