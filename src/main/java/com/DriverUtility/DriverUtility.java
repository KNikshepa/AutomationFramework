package com.DriverUtility;

import java.util.Objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import com.Enum.EnumForConfigFile;
import com.PropertyFileReader.ReadPropertyFile;

public class DriverUtility {

	public DriverUtility()
	{
		
	}
	
	public WebDriver initDriver()
	{
		if(Objects.isNull(DriverManager.getInstance().getDriver()))
		{
			switch(ReadPropertyFile.getValue(EnumForConfigFile.browsername))
			{
			case "edge":
				EdgeOptions edgeOptions=new EdgeOptions();
				edgeOptions.addArguments("start-maximized");
				edgeOptions.addArguments("--disable-extensions");
				edgeOptions.addArguments("--disable-infobars");
				DriverManager.getInstance().setDriver(new EdgeDriver(edgeOptions));
				break;
			case "chrome":
				ChromeOptions chromeOptions=new ChromeOptions();
				chromeOptions.addArguments("start-maximized");
				chromeOptions.addArguments("--disable-extensions");
				chromeOptions.addArguments("--disable-infobars");
				DriverManager.getInstance().setDriver(new ChromeDriver(chromeOptions));
				break;
			default:
				System.out.println("Invalid Browser Name");
			}
		}
		return DriverManager.getInstance().getDriver();
	}
	
	public void quitBrowser()
	{
		if(Objects.nonNull(DriverManager.getInstance().getDriver()))
		{
			DriverManager.getInstance().getDriver().quit();
			DriverManager.getInstance().unload();
		}
	}
}
