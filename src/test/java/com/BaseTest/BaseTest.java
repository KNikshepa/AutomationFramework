package com.BaseTest;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.DriverUtility.DriverUtility;

public class BaseTest {

	public WebDriver driver;
	private DriverUtility driverUtility=new DriverUtility();
	
	@BeforeMethod
	public void setUp()
	{
		driver=driverUtility.initDriver();
	}
	
	@AfterMethod
	public void tearDown()
	{
		driverUtility.quitBrowser();
	}
}
