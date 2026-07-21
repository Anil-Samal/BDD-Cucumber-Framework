package context;

import managers.PageObjectManager;
import testdata.TestDataManager;
import utils.ExcelUtil;

public class TestContext {

	private final ScenarioContext scenarioContext;

	private final ThreadLocal<PageObjectManager> pageObjectManager = ThreadLocal.withInitial(PageObjectManager::new);

	private final TestDataManager testDataManager;

	public TestContext() {

		scenarioContext = new ScenarioContext();

		testDataManager = new TestDataManager(new ExcelUtil("LoginData.xlsx"));

	}

	public ScenarioContext getScenarioContext() {

		return scenarioContext;

	}

	public PageObjectManager getPageObjectManager() {

		return pageObjectManager.get();

	}

	public TestDataManager getTestDataManager() {

		return testDataManager;

	}

}