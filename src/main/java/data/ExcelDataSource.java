package data;

import java.util.Map;

import testdata.TestDataManager;

public class ExcelDataSource {

	private final TestDataManager manager;

	public ExcelDataSource(TestDataManager manager) {

		this.manager = manager;

	}

	public LoginData getLoginData(String testCaseId) {

		Map<String, String> row = manager.getTestData("Login", testCaseId);

		LoginData data = new LoginData();

		data.setTestCase(row.get("TestCase"));

		data.setUsername(row.get("Username"));

		data.setPassword(row.get("Password"));

		data.setExecute(row.get("Execute"));

		return data;

	}

}