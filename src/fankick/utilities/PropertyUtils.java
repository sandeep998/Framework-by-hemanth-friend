package fankick.utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class PropertyUtils implements FileConstants {
	private static Properties readPropertyFile(String fileName) {
		Properties properties = new Properties();
		try {
			properties.load(new FileInputStream(fileName));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return properties;
	}

	public static String getServerValue(String key) {
		Properties properties = readPropertyFile(SERVER_PROPERTIES);
		return properties.getProperty(key);
	}

	public static String getObjectValue(String key) {
		Properties properties = readPropertyFile(OBJECT_PROPERTIES);
		return properties.getProperty(key);
	}

}
