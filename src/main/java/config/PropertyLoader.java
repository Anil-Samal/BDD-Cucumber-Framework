package config;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import constants.FrameworkConstants;

public class PropertyLoader {

	private final Properties properties = new Properties();

	public PropertyLoader() {

		String environment = EnvironmentManager.getEnvironment();
		String filePath = FrameworkConstants.CONFIG_PATH + environment + ".properties";

		try (FileInputStream fis = new FileInputStream(filePath)) {

			properties.load(fis);

		} catch (IOException e) {

			throw new RuntimeException(

					"Unable to load property file : " + filePath,

					e);

		}

	}

	public String getProperty(String key) {

		String value = properties.getProperty(key);

		if (value == null) {

			throw new RuntimeException(

					"Missing property : " + key);

		}

		return value;

	}

}