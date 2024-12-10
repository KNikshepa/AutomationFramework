package com.DataProviderUtility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.Constant.Constant;

public class ExcelUtility {

	private ExcelUtility() {

	}

	private static FileInputStream fis;
	private static XSSFWorkbook workbook;
	
	public static List<Map<String, String>> testDetails(String sheetName)
	{
		try {
			fis=new FileInputStream(Constant.getExcelFilePath());
		}catch (FileNotFoundException e) {
			throw new RuntimeException("Unable to read the data from excel file");
		}
		
		try {
			workbook=new XSSFWorkbook(fis);
		}catch (IOException e) {
			e.printStackTrace();
		}
		
		XSSFSheet sheet=workbook.getSheet(sheetName);
		Map<String, String> map=null;
		List<Map<String, String>> list=new ArrayList<Map<String,String>>();
		int noOfRows=sheet.getLastRowNum();
		int noOfColumns=sheet.getRow(0).getLastCellNum();
		
		for(int i=1;i<=noOfRows;i++)
		{
			map=new HashMap<String, String>();
			for(int j=0;j<noOfColumns;j++)
			{
				String key=sheet.getRow(0).getCell(j).getStringCellValue();
				String value=sheet.getRow(i).getCell(j).getStringCellValue();
			}
			list.add(map);
		}
		return list;
	}
}
