package com.mycompany.service;

import java.util.List;
import java.util.Map;

public class CommonUtils {
    public static NumCellAddress findMarker(Map<Integer, List<String>> map, String marker){
        for(int i = 0; i < map.size(); i++){
            for (int j = 0; j < map.get(i).size(); j++) {
                if (map.get(i).get(j).equals(marker)) {
                    return new NumCellAddress(i, j);
                }
            }
        }
        return new NumCellAddress(null, null);
    }

}
