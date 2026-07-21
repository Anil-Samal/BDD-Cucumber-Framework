package utils;

import org.apache.poi.ss.usermodel.*;

import java.io.InputStream;
import java.util.*;

public class ExcelUtil {

	private Workbook workbook;

	public ExcelUtil(String fileName) {

		try {
			InputStream inputStream = getClass().getClassLoader().getResourceAsStream("testdata/" + fileName);

			if (inputStream == null) {

				throw new RuntimeException("Excel file not found : " + fileName);
			}
			workbook = WorkbookFactory.create(inputStream);
			
		} catch (Exception e) {

			throw new RuntimeException("Unable to load Excel file", e);
		}
	}
	public Sheet getSheet(String sheetName) {

		Sheet sheet = workbook.getSheet(sheetName);

		if (sheet == null) {

			throw new RuntimeException("Sheet not found : " + sheetName);

		}

		return sheet;

	}

	public int getRowCount(String sheetName) {

		return getSheet(sheetName).getLastRowNum();

	}

	public int getColumnCount(String sheetName) {

		Row headerRow = getSheet(sheetName).getRow(0);

		return headerRow.getLastCellNum();

	}
	public String getCellData(String sheetName, int row, int column) {

		DataFormatter formatter = new DataFormatter();

		return formatter.formatCellValue(getSheet(sheetName).getRow(row).getCell(column));
	}
	public Map<String, String> getRowData(String sheetName, int rowNumber) {

		Sheet sheet = getSheet(sheetName);

		Row header = sheet.getRow(0);

		Row row = sheet.getRow(rowNumber);

		Map<String, String> data = new HashMap<>();

		DataFormatter formatter = new DataFormatter();

		for (int i = 0; i < header.getLastCellNum(); i++) {

			String key = formatter.formatCellValue(header.getCell(i));

			String value = formatter.formatCellValue(row.getCell(i));

			data.put(key, value);

		}

		return data;
	}

}