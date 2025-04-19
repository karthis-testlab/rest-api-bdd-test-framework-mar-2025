package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesHandlers {
	
	private static Properties properties = new Properties();
	private static String value = null;
	
	public static String config(String key) {
		try {
			properties.load(new FileInputStream(new File("src/test/resources/config.properties")));
			value = properties.getProperty(key);
		} catch (IOException e) {			
			e.printStackTrace();
		}
		return value;
	}
	
	public static String secret(String key) {
		try {
			properties.load(new FileInputStream(new File("src/test/resources/secret.properties")));
			value = properties.getProperty(key);
		} catch (IOException e) {			
			e.printStackTrace();
		}
		return value;
	}

}