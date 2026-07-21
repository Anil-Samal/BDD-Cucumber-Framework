package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

	private final By usernameInput = By.name("username");

	private final By passwordInput = By.name("password");

	private final By loginButton = By.cssSelector("button[type='submit']");

	private final By dashboardText = By.xpath("//h6[text()='Dashboard']");

	public LoginPage(WebDriver driver) {

		super(driver);

	}
	public void enterUsername(String username) {

		waitUtil.waitForVisibility(usernameInput).sendKeys(username);
	}

	public void enterPassword(String password) {

		waitUtil.waitForVisibility(passwordInput).sendKeys(password);
	}

	public void clickLogin() {

		waitUtil.waitForClickable(loginButton).click();

	}

	public void login(String username, String password) {

		enterUsername(username);

		enterPassword(password);

		clickLogin();
	}

	public boolean isDashboardDisplayed() {

		return waitUtil.waitForVisibility(dashboardText).isDisplayed();

	}
}