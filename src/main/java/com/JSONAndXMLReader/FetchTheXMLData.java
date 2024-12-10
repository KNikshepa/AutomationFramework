package com.JSONAndXMLReader;

import java.io.File;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;

public class FetchTheXMLData {

	public static void main(String[] args) {

		try {
			XmlMapper xmlMapper = new XmlMapper();
			File xmlFile = new File("src/main/resources/UserDataInXML.xml");
			// Check if the file exists
			if (!xmlFile.exists()) {
				System.out.println("File not found at: " + xmlFile.getAbsolutePath());
				return;
			}
			
			 // Read the XML file and map it to the UserDetails object
            UserDetails userdata = xmlMapper.readValue(xmlFile, UserDetails.class);
            
            // Print the details
            System.out.println("UserName: " + userdata.getUserName());
            System.out.println("Email Address: " + userdata.getEmailAddress());

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
