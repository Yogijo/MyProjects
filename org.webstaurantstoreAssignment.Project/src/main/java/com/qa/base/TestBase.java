package com.qa.base;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.qa.util.TestUtil;

public class TestBase {
	
	public static WebDriver driver;
	public static Properties prop;
	
	public static String browserName = "chrome";
	public static String driverPath = "C://Users//munijo02//workspace//Tools//";
	
	public static void initWebDriver() throws InterruptedException {		
		if(browserName == "chrome")
		{
			System.setProperty("webdriver.chrome.driver", driverPath +"chromedriver.exe");
			driver  = new ChromeDriver();
		}

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_TIMEOUT);
		
		driver.get("https://www.webstaurantstore.com/");

	}

}
