package com.JSONAndXMLReader;

import java.io.File;

import javax.management.RuntimeErrorException;

import com.fasterxml.jackson.databind.ObjectMapper;

public class FetchTheJSONData {

	public static void main(String[] args) {

		try {
			ObjectMapper objectMapper = new ObjectMapper();
			// Specify the path to the JSON file
			// Relative path (make sure the file is in src/test/resources)
			File jsonFile = new File("src/main/resources/Userdata.json");

			// Check if the file exists
			if (!jsonFile.exists()) {
				System.out.println("File not found at: " + jsonFile.getAbsolutePath());
			}
			UserDetails userdata = objectMapper.readValue(jsonFile, UserDetails.class);
			userdata.setUserName("Ruhi");
			objectMapper.writerWithDefaultPrettyPrinter().writeValue(jsonFile,userdata);
			System.out.println(userdata.getUserName());
			System.out.println(userdata.getEmailAddress());

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
