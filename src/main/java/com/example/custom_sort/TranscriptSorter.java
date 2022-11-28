package com.example.custom_sort;

import java.util.Comparator;
import java.util.List;

public class TranscriptSorter implements Comparator<Transcript> {

    private List<String> ORDERED_ENTRIES = List.of("1040", "W2", "1099", "1098", "5498");

    @Override
    public int compare(Transcript o1, Transcript o2) {


        if (ORDERED_ENTRIES.contains(o1.getName()) && ORDERED_ENTRIES.contains(o2.getName())) {
            // Both objects are in our ordered list. Compare them by
            // their position in the list
            return ORDERED_ENTRIES.indexOf(o1.getName()) - ORDERED_ENTRIES.indexOf(o2.getName());
        }




        return 0;
    }
}
