package utilities;

import org.apache.poi.ss.usermodel.*;
import java.io.FileInputStream;
import java.util.*;

public class ExcelFileReader {

    private Map<String, Map<String, String>> excelData = new HashMap<>();

    public ExcelFileReader() {
        loadExcelData();
    }

    private void loadExcelData() {
        try (FileInputStream fis = new FileInputStream("src/test/resources/my-test-data-file.xlsx");
             Workbook workbook = WorkbookFactory.create(fis)) {

            Sheet sheet = workbook.getSheet("my-test-data-sheet");
            Row headerRow = sheet.getRow(0);

            for (int i = 1; i <= sheet.getLastRowNum(); i++) {
                Row row = sheet.getRow(i);
                if (row == null) continue;

                String tcId = row.getCell(0).toString();
                Map<String, String> rowData = new HashMap<>();

                for (int j = 0; j < headerRow.getLastCellNum(); j++) {
                    String columnName = headerRow.getCell(j).toString();
                    Cell dataCell = row.getCell(j);
                    String cellValue = (dataCell == null) ? "" : dataCell.toString();
                    rowData.put(columnName, cellValue);
                }
                excelData.put(tcId, rowData);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getData(String tcId, String columnName) {
        return excelData.get(tcId).get(columnName);
    }
}
