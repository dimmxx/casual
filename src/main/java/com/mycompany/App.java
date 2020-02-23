package com.mycompany;

import com.mycompany.service.ExcelParseObjectMapper;
import com.mycompany.service.ExcelParseService;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * Hello world!
 *
 */
public class App {

    public static void main( String[] args ) {
        ExcelParseService excelParseService = new ExcelParseService();
        ExcelParseObjectMapper excelParseObjectMapper = new ExcelParseObjectMapper();

        String path = "/Users/mint/Downloads/parse.xlsx";

        Map<Integer, List<String>> xlsxMap = excelParseService.parseXLSXFileToMap(path, "Sheet10");

//        List<AdditionalPositionLibrary> additionalPositionLibraryList =
//            excelParseObjectMapper.additionalPositionMapper(xlsxMap, "marker:additional_position");
//        additionalPositionLibraryList.forEach(element -> additionalPositionLibraryRepository.save(element));


        excelParseObjectMapper.mainPositionMapper(xlsxMap, "m:s");

    }
}
