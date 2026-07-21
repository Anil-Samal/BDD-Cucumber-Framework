package testdata;

import java.util.Map;

import utils.ExcelUtil;

public class TestDataManager {

	private final ExcelUtil excelUtil;

	public TestDataManager(ExcelUtil excelUtil) {

		this.excelUtil = excelUtil;

	}

	public Map<String, String> getTestData(String sheetName, String testCaseId) {

		int rows = excelUtil.getRowCount(sheetName);

		for (int i = 1; i <= rows; i++) {

			Map<String, String> row = excelUtil.getRowData(sheetName, i);

			if (row.get("TestCase").equals(testCaseId)) {

				return row;
			}
		}

		throw new RuntimeException("Test Data not found : " + testCaseId);

	}

}