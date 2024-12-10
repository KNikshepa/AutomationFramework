package com.ExtentReport;

import com.aventstack.extentreports.ExtentTest;

public class ExtentReportManager {

	private ExtentReportManager()
	{
		
	}
	
	private static ThreadLocal<ExtentTest> threadInParallel=new ThreadLocal<ExtentTest>();
	private static ExtentReportManager instanceExtentTest=null;
	
	public static ExtentReportManager getInstance()
	{
		if(instanceExtentTest==null)
		{
			instanceExtentTest=new ExtentReportManager();
		}
		return instanceExtentTest;
	}

	public ExtentTest getExtentTest()
	{
		return threadInParallel.get();
	}
	
	public void setExtentTest(ExtentTest test)
	{
		threadInParallel.set(test);
	}
	
	public void unload()
	{
		threadInParallel.remove();
	}
}
