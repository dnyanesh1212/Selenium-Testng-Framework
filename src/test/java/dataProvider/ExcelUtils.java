package dataProvider;

import org.apache.poi.ss.usermodel.*;
import org.testng.SkipException;
import utils.ConfigReader;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExcelUtils {

    private ExcelUtils() {}

    public static List<Map<String, String>> getTestData(String sheetName) {

        List<Map<String, String>> dataList = new ArrayList<>();
        String excelPath = ConfigReader.get("inputExcel");

        try (
                FileInputStream fis =
                        new FileInputStream("src/test/resources/testdata/" + excelPath);
                Workbook workbook = WorkbookFactory.create(fis)
        ) {

            Sheet sheet = workbook.getSheet(sheetName);
            if (sheet == null) {
                throw new SkipException("Sheet not found: " + sheetName);
            }

            Row headerRow = sheet.getRow(0);
            if (headerRow == null) {
                throw new SkipException("Header row missing in sheet: " + sheetName);
            }

            int lastRow = sheet.getLastRowNum();
            int lastCol = headerRow.getLastCellNum();

            for (int i = 1; i <= lastRow; i++) {

                Row row = sheet.getRow(i);
                if (row == null) {
                    continue;
                }

                Map<String, String> rowData = new HashMap<>();

                for (int j = 0; j < lastCol; j++) {

                    String key = headerRow.getCell(j).getStringCellValue();

                    Cell cell = row.getCell(j);
                    String value = (cell == null) ? "" : cell.toString().trim();

                    rowData.put(key, value);
                }

                dataList.add(rowData);
            }

        } catch (SkipException se) {
            throw se;
        } catch (Exception e) {
            throw new SkipException(
                    "Test skipped due to invalid or unreadable Excel data: " + e.getMessage()
            );
        }

        return dataList;
    }
}
