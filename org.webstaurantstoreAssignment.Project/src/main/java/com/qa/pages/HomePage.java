package com.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.TestBase;

public class HomePage extends TestBase {
	
		//Initializing the page object using PAGE FACTORY
		public HomePage()
		{	
			PageFactory.initElements(driver, this);
		}
		
		// page factory - Object repository
		
		//Find SearchEngine textbox to enter search key
		@FindBy(name="searchval") 
		WebElement searchEngine;
		
		//Find SearchEngine submit button to initiate search
		@FindBy(xpath ="//button[text()='Search']") 
		WebElement searchBtn;
		
		//Actions
		public SearchResultPages SearchItem(String searchtxt)
		{
			searchEngine.sendKeys(searchtxt);
			searchBtn.click();
			return new SearchResultPages();
		}

}
