package utils;

import org.apache.poi.ss.usermodel.*;
import java.io.IOException;
import java.io.InputStream;

public class ExcelReader {

    public String getCellData(String fileName,
                              String sheetName,
                              int rowNumber,
                              int columnNumber) {

        try (InputStream inputStream =
                     getClass().getClassLoader()
                             .getResourceAsStream("testdata/" + fileName)) {

            if (inputStream == null) {
                throw new RuntimeException("Excel file not found: " + fileName);
            }

            Workbook workbook = WorkbookFactory.create(inputStream);
            Sheet sheet = workbook.getSheet(sheetName);

            DataFormatter formatter = new DataFormatter();

            String value = formatter.formatCellValue(
                    sheet.getRow(rowNumber).getCell(columnNumber));

            workbook.close();

            return value;

        } catch (IOException e) {
            throw new RuntimeException("Unable to read Excel file.", e);
        }
    }
}