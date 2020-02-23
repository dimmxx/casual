package com.mycompany.service;

import java.util.List;
import java.util.Map;


public class ExcelParseObjectMapper {

    public void mainPositionMapper(Map<Integer, List<String>> map, String marker) {

        System.out.println("!!!!!!!!!!!! Main position parsing started");


        NumCellAddress surfaceMarkerAddress = CommonUtils.findMarker(map, marker);

        int startRow = surfaceMarkerAddress.getRow();
        int startCell = surfaceMarkerAddress.getCell() + 1;
        int mapSize = map.size();
        int mapListSize = map.get(0).size();


        System.out.println("sr" + startRow);
        System.out.println("sc" + startCell);

        System.out.println(surfaceMarkerAddress.getRow() + ":" + surfaceMarkerAddress.getCell());


        String[][] array = new String[mapListSize - startCell][startRow + 1];

        for (String[] row : array) {
            for (String str : row) {
                str = null;
            }
        }
        for (String[] row : array) {
            for (String str : row) {
                System.out.printf("%-12s", str);
            }
            System.out.print("\n");
        }

        System.out.println();






        for (int i = 0; i <= startRow; i++) {
            for (int j = 0; j < mapListSize - startCell; j++) {
                if (map.get(i).get(startCell + j).equals("MR")) {
                    array[j][i] = array[j - 1][i];
                } else if (map.get(i).get(startCell + j).equals("MC")) {
                    array[j][i] = array[j][i - 1];
                } else if (map.get(i).get(startCell + j).equals("MA") && j != 0) {
                    if(array[j][i] == null) array[j][i] = array[j - 1][i];
                    if(map.get(i + 1).get(startCell + j - 1).equals("MA")) {
                        if (array[j][i] == null) array[j - 1][i + 1] = array[j - 1][i];
                    }
                } else {
                    array[j][i] = map.get(i).get(startCell + j);
                }
            }
        }

        for (String[] row : array) {
            for (String str : row) {
                System.out.printf("%-12s", str);
            }
            System.out.print("\n");
        }


    }


}
