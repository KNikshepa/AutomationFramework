package com.PropertyFileReader;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import com.Constant.Constant;
import com.Enum.EnumForConfigFile;

public final class ReadPropertyFile {

    private ReadPropertyFile() {
    }

    private static Properties property;
    private static Map<String, String> configKeyValuesInMap = new HashMap<>();
    private static String value;
    static InputStream inputStream;

    static {
        property = new Properties();
        try {
            // Load the Configuration.properties file from resources
            inputStream = ReadPropertyFile.class.getClassLoader().getResourceAsStream("Configuration.properties");

            if (inputStream == null) {
                throw new RuntimeException("Configuration.properties file not found in the classpath");
            }

            // Load properties from the input stream
            property.load(inputStream);

        } catch (IOException e) {
            throw new RuntimeException("Unable to load the configuration file", e);
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    throw new RuntimeException("Unable to close the input stream", e);
                }
            }
        }

        // Iterate over the properties and store them in a map
        property.entrySet().stream()
            .forEach(entry -> configKeyValuesInMap.put(entry.getKey().toString(), entry.getValue().toString()));
    }

    public static String getValue(EnumForConfigFile key) {
        if (!configKeyValuesInMap.containsKey(key.name().toLowerCase())) {
            System.out.println("Key specified by the user is not present in the config file");
            return null;
        } else if (configKeyValuesInMap.get(key.name().toLowerCase()).isEmpty()) {
            System.out.println("Value is null for the key " + key + " entered by user");
            return null;
        } else {
            value = configKeyValuesInMap.get(key.name().toLowerCase());
        }
        return value;
    }
}
