package com.mycompany.service;

import java.util.HashMap;
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

        System.out.println();

        processMerge(map);


        for (int i = 0; i <= startRow; i++) {
            for (int j = 0; j < mapListSize - startCell; j++) {
                array[j][i] = map.get(i).get(startCell + j);
            }
        }

        for (String[] row : array) {
            for (String str : row) {
                System.out.printf("%-12s", str);
            }
            System.out.print("\n");
        }




    }

    public Map<Integer, List<String>> processMerge(Map<Integer, List<String>> map) {
        for (int i = 0; i < map.size(); i++) {
            for (int j = 0; j < map.get(i).size(); j++) {
                if (map.get(i).get(j).equals("MR")) {
                    map.get(i).set(j, map.get(i).get(j - 1));
                }
                if (map.get(i).get(j).equals("MC")) {
                    map.get(i).set(j, map.get(i - 1).get(j));
                }
                if (map.get(i).get(j).equals("MA")) {
                    map.get(i).set(j, map.get(i).get(j - 1));
                    if (i != map.size() - 1 && map.get(i + 1).get(j - 1).equals("MA")) {
                        map.get(i + 1).set(j - 1, map.get(i).get(j - 1));
                    }
                }

            }

        }


        System.out.println("MergeMap:");
        map.forEach((key, value) -> System.out.println(key + " " + value));
        return map;
    }


}
