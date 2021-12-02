package com.qa.TestCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.pages.HomePage;
import com.qa.pages.SearchResultPages;
import com.qa.pages.ViewCartPage;


public class SearchEngineTests extends TestBase{
	
	
	HomePage homepage;
	SearchResultPages searchpages;
	ViewCartPage cartpage;
	
	public SearchEngineTests()
	{
		super();
	}
	
	
	@BeforeMethod
	public void setUp()
	{
		try {
			initWebDriver();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		homepage = new HomePage();
	}
	
	

	//Scenario: 
	//			 @Search : 'stainless work table'
	//			 @verify: 'Table' keyword present in all the searched results item Title
	//			 @Add: Add last Item to the cart
	//			 @empty cart : Remove/Empty cart
	//			 @Validate Message
	
	
	@Test
	public void searchItemTest() throws InterruptedException
	{
		//@ Search
		searchpages = homepage.SearchItem("stainless work table");
		
		//@verify
		boolean flag = searchpages.ValidateSearchResult("Table");		
		Assert.assertEquals(flag, true);
		
		//@Add
		searchpages.AddLastItemToCart();
		Thread.sleep(10);
		//@empty
		cartpage.EmptyCart();
		
		//@Validate Empty cart Message
		boolean result = cartpage.getMsg();
		Assert.assertEquals(result, true);
	}
	
	/*@AfterMethod	
	public void tearDown()
	{
		driver.quit();
	}*/

}
