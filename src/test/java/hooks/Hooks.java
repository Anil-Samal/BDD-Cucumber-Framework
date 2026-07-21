package hooks;

import java.io.ByteArrayInputStream;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import config.ConfigReader;
import driver.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.qameta.allure.Allure;
import utils.LoggerUtil;

public class Hooks {

	private static final Logger log = LoggerUtil.getLogger(Hooks.class);

	private ConfigReader config;

	@Before(order = 0)
	public void setup(Scenario scenario) {

		log.info("======================================");

		log.info("Test Execution Started");

		log.info("Scenario : " + scenario.getName());

		log.info("Thread ID : " + Thread.currentThread().getId());

		config = new ConfigReader();

		log.info("Browser : " + config.getBrowser());

		log.info("Application URL : " + config.getUrl());

		// Initialize Browser

		DriverFactory.initializeDriver();

		WebDriver driver = DriverFactory.getDriver();

		if (driver == null) {

			throw new RuntimeException("WebDriver initialization failed");

		}

		// Launch Application

		driver.get(config.getUrl());

		log.info("Browser launched successfully");

		log.info("======================================");

	}

	@After(order = 1)
	public void captureScreenshot(Scenario scenario) {

		if (scenario.isFailed()) {

			log.error("Scenario Failed : " + scenario.getName());

			WebDriver driver = DriverFactory.getDriver();

			if (driver != null && driver instanceof TakesScreenshot) {

				byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);

				// Attach to Cucumber Report

				scenario.attach(screenshot, "image/png", "Failure Screenshot");

				// Attach to Allure Report

				Allure.addAttachment("Failure Screenshot", new ByteArrayInputStream(screenshot));

				log.info("Screenshot attached successfully");

			}

		}

	}

	@After(order = 0)
	public void tearDown(Scenario scenario) {

		log.info("--------------------------------------");

		if (scenario.isFailed()) {

			log.error("Scenario Status : FAILED");

		} else {

			log.info("Scenario Status : PASSED");

		}

		DriverFactory.quitDriver();

		log.info("Browser closed successfully");

		log.info("Test Execution Completed");

		log.info("--------------------------------------");

	}

}