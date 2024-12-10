package com.ExtentReport;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReport {

	private ExtentReport()
	{
		
	}
	
	private static ExtentReports extent;
	private static String timestampOfExtentReport;
	
	
	public void setUp()
	{
		if(Objects.isNull(extent))
		{
			timestampOfExtentReport=new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss").format(new Date());
			ExtentSparkReporter sparkReporter=new ExtentSparkReporter("ExtentReport "+timestampOfExtentReport+".html");
			sparkReporter.config().setDocumentTitle("Test Execution Report");
			sparkReporter.config().setReportName("Automated Test Report");
			extent=new ExtentReports();
			extent.attachReporter(sparkReporter);
		}
	}
	
	public void tearDown()
	{
		if(Objects.nonNull(extent))
		{
			extent.flush();
		}
	}
	
	public static void createTest(String testcasename)
	{
		ExtentReportManager.getInstance().setExtentTest(extent.createTest(testcasename));
	}
	
}
