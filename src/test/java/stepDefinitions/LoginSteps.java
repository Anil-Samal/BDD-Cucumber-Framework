package stepDefinitions;

import org.testng.Assert;

import context.TestContext;
import data.ExcelDataSource;
import data.LoginData;
import enums.ContextKey;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LoginPage;
import testdata.TestDataManager;

public class LoginSteps {

	private final TestContext testContext;

	private final LoginPage loginPage;

	private final TestDataManager testDataManager;

	public LoginSteps(TestContext testContext) {

		this.testContext = testContext;

		this.loginPage = testContext.getPageObjectManager().getLoginPage();

		this.testDataManager = testContext.getTestDataManager();

	}

	@Given("User launches the OrangeHRM application")
	public void launchApplication() {

		// Browser is already launched from Hooks

	}

	@When("User logs in with test data {string}")
	public void loginUsingTestData(String testCaseId) {

		ExcelDataSource dataSource = new ExcelDataSource(testDataManager);

		LoginData data = dataSource.getLoginData(testCaseId);

		// Store data for later steps
		testContext.getScenarioContext().set(ContextKey.USERNAME, data.getUsername());

		loginPage.login(data.getUsername(), data.getPassword());

	}

	@Then("User should navigate to Dashboard")
	public void verifyDashboard() {

		String username = testContext.getScenarioContext().get(ContextKey.USERNAME);

		System.out.println("Logged in user: " + username);

		Assert.assertTrue(loginPage.isDashboardDisplayed(), "Dashboard is not displayed after login");

	}

}