package com.qa.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.TestBase;
import com.qa.util.TestUtil;

public class SearchResultPages extends TestBase{
	
	JavascriptExecutor js = (JavascriptExecutor) driver;
	TestUtil util = new TestUtil();
	public String eSearchItemDes ="//*[@data-testid='itemDescription']";
	public String eLastPageNumber = "//div[@id='paging']/nav/ul/li";
	public String eAddLastItem = "//*[@data-testid='itemDescription']";
	List<WebElement> listElement;
	
	//Initializing the page object using PAGE FACTORY
	public SearchResultPages()
	{	
		PageFactory.initElements(driver, this);
	}
	
	// page factory - Object repository
	 @FindBy(xpath = "//span[(@class='hidden xsl:inline')][text()='Cart']")		   
	    WebElement ClickCart;
	    
	    @FindBy(xpath = "//button[@class='close']")		   
	    WebElement notificationAction;    	  
	    
	public boolean ValidateSearchResult(String resContainstxt)
	{
		listElement = util.FindElements(eSearchItemDes);
		for(int i =0;i<listElement.size();i++) 
		{
		 String elementText = listElement.get(i).getText();
		 if(!elementText.contains(resContainstxt))
			 return false;
		}
		return true;
	}
	
	public void GotoSearchResultLastPage()
	{		
		listElement = util.FindElements(eLastPageNumber);
		driver.findElement(By.xpath("//div[@id='paging']/nav/ul/li" + "[" +(listElement.size()-2)+"]" + "/a" )).click();
	}
	
	public void AddLastItemToCart()
	{	
		GotoSearchResultLastPage();
		listElement = util.FindElements(eAddLastItem);
		for(int i =1;i<=listElement.size();i++) 
		{
			if(i==listElement.size())
			 {			
				driver.findElement(By.xpath("//*[@id='product_listing']/div" + "[" + i + "]" + "/div[4]/form/div/div/input[2]")).click();
				driver.findElement(By.xpath("//button[contains(text(), 'Add To Cart')]")).click();
			 }       
	   
		}
	}
	
	public ViewCartPage ClickCartBtn()
	{		
		driver.findElement(By.xpath("//button[@class='close']")).click();
		if(notificationAction.isDisplayed())
			notificationAction.click();
		
		js.executeScript("arguments[0].scrollIntoView();", ClickCart);
		ClickCart.click();	
		return new ViewCartPage();
	}
	
}
