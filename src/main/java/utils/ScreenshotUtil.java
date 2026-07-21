package utils;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotUtil {

	public static String captureScreenshot(WebDriver driver, String scenarioName) {

		try {

			String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());

			String fileName = scenarioName.replace(" ", "_") + "_" + timestamp + "_" + Thread.currentThread().getId()
					+ ".png";

			File destination = new File("target/screenshots/" + fileName);

			File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

			source.renameTo(destination);

			return destination.getAbsolutePath();

		} catch (Exception e) {

			e.printStackTrace();

			return null;

		}

	}

}