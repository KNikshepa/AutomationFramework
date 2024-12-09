package com.Constant;

import com.Enum.EnumForConfigFile;
import com.PropertyFileReader.ReadPropertyFile;

public final class Constant {

	private  Constant()
	{
		
	}
	
	private static String CONFIGFILEPATH;
	
	public static String getCONFIGFILEPATH()
	{
		return CONFIGFILEPATH=System.getProperty("user.dir")+"\\Configuration\\Configuration.properties";	
	}
	
	private static String EXCELFILEPATH;
	
	public static String getExcelFilePath()
	{
		return EXCELFILEPATH=System.getProperty("user.dir")+ReadPropertyFile.getValue(EnumForConfigFile.excelfilepath);
	}
}
