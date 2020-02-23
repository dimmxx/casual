package com.mycompany.service;

import org.apache.commons.compress.utils.IOUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExcelParseService {


    public Map<Integer, List<String>> parseXLSXFileToMap(String path, String sheetName) {
        Sheet sheet = null;
        try {
            Workbook workbook = new XSSFWorkbook(new FileInputStream(new File(path)));
            sheet = workbook.getSheet(sheetName);

        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

        int rowToRead = sheet.getLastRowNum(); //the last row index to read
        //finding out the max number of cells in a row to read
        int cellToRead = 0;
        for (Row row : sheet) {
            if (cellToRead < row.getLastCellNum()) cellToRead = row.getLastCellNum();
        }
        System.out.println("\nParsing started: " + (rowToRead + 1) + " rows, " + (cellToRead + 1) + " cells\n");
        Map<Integer, List<String>> data = new HashMap<>();
        for (int i = 0; i <= rowToRead; i++) {
            Row row = sheet.getRow(i);
            if (row == null) {
                sheet.createRow(i);
                row = sheet.getRow(i);
            }
            data.put(i, new ArrayList<>());
            for (int j = 0; j <= cellToRead; j++) {
                Cell cell = row.getCell(j);
                if (cell == null) {
                    row.createCell(j);
                    data.get(i).add("0.0");
                    continue;
                } else if (cell.getCellType() == CellType.STRING && cell.getStringCellValue().equals(" ")) {
                    data.get(i).add("0.0");
                    continue;
                }
                switch (cell.getCellType()) {
                    case STRING:
                        data.get(i).add(cell.getStringCellValue().trim());
                        break;
                    case NUMERIC:
                        data.get(i).add(String.valueOf(cell.getNumericCellValue()).trim());
                        break;
                    case BOOLEAN:
                        data.get(i).add("#BOOLEAN");
                        break;
                    case FORMULA:
                        data.get(i).add("#FORMULA");
                        break;
                    case BLANK:
                        data.get(i).add("0.0");
                        break;
                    case _NONE:
                        data.get(i).add("#_NONE");
                        break;
                    case ERROR:
                        data.get(i).add("#ERROR");
                        break;
                    default:
                        data.get(i).add("#VALUE");
                }
            }
        }
        //marking merged cells up
        List<CellRangeAddress> mergedRegionsList = sheet.getMergedRegions();
        for (CellRangeAddress cellAddresses : mergedRegionsList) {
            int firstRow = cellAddresses.getFirstRow();
            int firstColumn = cellAddresses.getFirstColumn();
            int lastRow = cellAddresses.getLastRow();
            int lastColumn = cellAddresses.getLastColumn();
            if (firstRow == lastRow) { //a case when cells in one row are merged
                for (int i = firstColumn + 1; i <= lastColumn; i++) {
                    data.get(firstRow).set(i, "MR");
                }
            } else if (firstColumn == lastColumn) { //a case when cells in one column are merged
                for (int i = firstRow + 1; i <= lastRow; i++) {
                    data.get(i).set(firstColumn, "MC");
                }
            } else if (firstRow != lastRow & firstColumn != lastColumn) { //a case when cells` area is merged
                for (int i = firstColumn + 1; i <= lastColumn; i++) {
                    data.get(firstRow).set(i, "MA");
                }
                for (int i = firstRow + 1; i <= lastRow; i++) {
                    for (int j = firstColumn; j <= lastColumn; j++) {
                        data.get(i).set(j, "MA");
                    }
                }
            }
        }

        List<Integer> mapList = new ArrayList<>(data.keySet());
        for (int i = 0; i < data.size(); i++) {
            System.out.printf("%-3s", mapList.get(i) + " : ");
            for (String element : data.get(i)) {
                System.out.printf("%-10s", element);
            }
            System.out.println();
        }
        System.out.println();

        data.forEach((key, value) -> System.out.println(key + " " + value));
        return data;
    }


}
