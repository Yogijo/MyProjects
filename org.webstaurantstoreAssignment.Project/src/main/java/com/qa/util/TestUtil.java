package com.qa.util;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.qa.base.TestBase;

public class TestUtil extends TestBase {

	public static Duration PAGE_LOAD_TIMEOUT = Duration.ofSeconds(20);
	public static Duration IMPLICIT_TIMEOUT =Duration.ofSeconds(10);
	
	public List<WebElement> FindElements(String Element)
	{
		return driver.findElements(By.xpath(Element));
	}
}