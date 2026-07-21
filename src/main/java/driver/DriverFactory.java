package driver;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import config.ConfigReader;

public class DriverFactory {

	public static void initializeDriver() {

		ConfigReader config = new ConfigReader();

		String browser = System.getProperty("browser", config.getBrowser());

		System.out.println("--------------------------------");
		System.out.println("Thread ID : " + Thread.currentThread().getId());

		System.out.println("Browser   : " + browser);

		System.out.println("--------------------------------");

		switch (browser.toLowerCase()) {

		case "chrome":

			DriverManager.setDriver(new ChromeDriver());

			break;

		case "edge":

			DriverManager.setDriver(new EdgeDriver());

			break;

		case "firefox":

			DriverManager.setDriver(new FirefoxDriver());

			break;

		default:

			throw new RuntimeException("Unsupported browser : " + browser);

		}

		getDriver().manage().window().maximize();

		getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		System.out.println("Driver Created : " + getDriver());

	}

	public static WebDriver getDriver() {

		WebDriver currentDriver = DriverManager.getDriver();

		System.out.println("Thread : " + Thread.currentThread().getId() + " -> Driver : " + currentDriver);

		return currentDriver;

	}

	public static void quitDriver() {

		WebDriver driver = DriverManager.getDriver();

		if (driver != null) {

			driver.quit();

			DriverManager.unload();

		}

	}

}