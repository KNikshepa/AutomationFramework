package com.DataProviderUtility;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.testng.annotations.DataProvider;

public class DataProviderUtils {

	@DataProvider
	public static Object[] getData(Method m) {

		String testname=m.getName();
		System.out.println(testname);
		
		List<Map<String, String>> list=ExcelUtility.testDetails("Automation Test Data");
		List<Map<String, String>> iteratioList=new ArrayList<Map<String,String>>();
		
		for(int i=0;i<list.size();i++)
		{
			if(list.get(i).get("Test Case Name").equals(testname))
			{
				if(list.get(i).get("Execute").equalsIgnoreCase("yes"))
				{
					iteratioList.add(list.get(i));
				}
			}
		}
		return iteratioList.toArray();
	}
}
