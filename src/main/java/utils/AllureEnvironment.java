package utils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class AllureEnvironment {

	public static void writeEnvironment() {

		try {

			File directory = new File("target/allure-results");

			if (!directory.exists()) {

				directory.mkdirs();

			}

			File file = new File(directory, "environment.properties");

			FileWriter writer = new FileWriter(file);

			writer.write("Framework=Selenium BDD Cucumber\n");

			writer.write("Language=Java 21\n");

			writer.write("Automation Tool=Selenium WebDriver\n");

			writer.write("Browser=Chrome\n");

			writer.write("OS=" + System.getProperty("os.name") + "\n");

			writer.write("Java Version=" + System.getProperty("java.version") + "\n");

			writer.close();

		} catch (IOException e) {

			e.printStackTrace();

		}

	}

}