package com.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.TestBase;

public class ViewCartPage extends TestBase{
	
	SearchResultPages searchpages;
	//Initializing the page object using PAGE FACTORY
	public ViewCartPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	// page factory - Object repository
	@FindBy(xpath = "//a[contains(text(), 'Empty Cart')]")		   
    WebElement EmptyCart;
    
    @FindBy(xpath = "//button[contains(text(), 'Empty Cart')]")		   
    WebElement EmptyCartBtn;
    
    public void EmptyCart()
	{
    	
     searchpages.ClickCartBtn();
	 EmptyCart.click();
	 EmptyCartBtn.click();
	}
	
	public Boolean getMsg()
	{
		return driver.getPageSource().contains("Your cart is empty.");
	}

}
