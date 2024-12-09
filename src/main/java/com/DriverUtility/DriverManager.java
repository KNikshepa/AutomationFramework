package com.DriverUtility;

import org.openqa.selenium.WebDriver;

public final class DriverManager {

	private DriverManager()
	{
		
	}
	
	//Using singleton pattern- Singleton pattern ensures that no more than one instance of a webdriver 
	//is created being used throughout the application or test suite.
	
	private static ThreadLocal<WebDriver> threadInParallel=new ThreadLocal<WebDriver>();
	private static DriverManager instanceDriver=null;

	public static DriverManager getInstance()
	{
		if(instanceDriver==null)
		{
			instanceDriver=new DriverManager();
		}
		return instanceDriver;
	}
	
	public WebDriver getDriver()
	{
		return threadInParallel.get();
	}
	
	public void setDriver(WebDriver driver)
	{
		threadInParallel.set(driver);
	}
	
	public void unload()
	{
		threadInParallel.remove();
	}
}
