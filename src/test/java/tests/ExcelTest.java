package tests;

import org.testng.annotations.Test;
import utils.ExcelUtil;

import java.util.Map;

public class ExcelTest {

	@Test

	public void readExcelData() {

		ExcelUtil excel = new ExcelUtil("LoginData.xlsx");

		Map<String, String> data = excel.getRowData("Login", 1);

		System.out.println(data.get("Username"));

		System.out.println(data.get("Password"));
	}

}