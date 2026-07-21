package utils;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebDriver;

public class WaitUtil {

	private final WebDriverWait wait;

	public WaitUtil(WebDriver driver) {

		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	}

	public WebElement waitForVisibility(By locator) {

		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

	}

	public WebElement waitForClickable(By locator) {

		return wait.until(ExpectedConditions.elementToBeClickable(locator));

	}

	public boolean waitForTitleContains(String title) {

		return wait.until(ExpectedConditions.titleContains(title));

	}

	public boolean waitForUrlContains(String text) {

		return wait.until(ExpectedConditions.urlContains(text));

	}

	public void waitForInvisibility(By locator) {

		wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));

	}

}