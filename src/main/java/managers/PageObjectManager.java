package managers;


import driver.DriverManager;
import pages.LoginPage;

public class PageObjectManager {

	private LoginPage loginPage;

	public LoginPage getLoginPage() {

		if (loginPage == null) {

			loginPage = new LoginPage(DriverManager.getDriver());

		}

		return loginPage;
	}
}