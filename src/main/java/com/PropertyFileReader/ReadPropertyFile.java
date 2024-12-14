package com.PropertyFileReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;

import com.Constant.Constant;
import com.Enum.EnumForConfigFile;

public final class ReadPropertyFile {

	private ReadPropertyFile()
	{
		
	}
	
	private static Properties property;
	private static FileInputStream fis;
	private static Map<String, String> configKeyValuesInMap=new HashMap<String, String>();
	private static String value;
	
	static {
		property=new Properties();
		try {
			fis=new FileInputStream(Constant.getCONFIGFILEPATH());
			System.out.println(Constant.getCONFIGFILEPATH());
		}catch (FileNotFoundException e) {
			throw new RuntimeException("File is not found in the Configuration file path & Unable to read the file");
		}try {
			property.load(fis);
		}catch (IOException e) {
			throw new RuntimeException("Unable to load the configuration file");
		}finally {
			if(fis!=null)
			{
				try {
					fis.close();
				}catch (IOException e) {
					throw new RuntimeException("Unable to close the file");
				}
			}
		}
		//Iterate the config file key-values and store in map
		//1st way-Using normal for loop
		/*
		 * for(Map.Entry<Object, Object> entry:property.entrySet()) {
		 * configKeyValuesInMap.put(entry.getKey().toString(),
		 * entry.getValue().toString()); }
		 */
		
		//2nd way-Using Lamba
		//property.forEach((key,value)->configKeyValuesInMap.put((String)key, (String)value));
		
		//3rd way
		property.entrySet().stream().forEach(entry->configKeyValuesInMap.put(entry.getKey().toString(), entry.getValue().toString()));
	}
	
	public static String getValue(EnumForConfigFile key)
	{
		if(!configKeyValuesInMap.containsKey(key.name().toLowerCase()))
		{
			System.out.println("Key specified by the user is not present in the config file");
		}else if(configKeyValuesInMap.get(key.name().toLowerCase()).isEmpty()) {
			System.out.println("Value is null for the key "+key+" entered by user");
		}else {
			value=configKeyValuesInMap.get(key.name().toLowerCase());
		}
		return value;
	}
	
}
