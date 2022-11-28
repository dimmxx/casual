package com.example.custom_sort;

import java.util.ArrayList;
import java.util.List;

public class DemoTranscript {




    public static void main(String[] args) {




        List<Transcript> list = new ArrayList<>();
        list.add(new Transcript("1098"));
        list.add(new Transcript("W2"));

        TranscriptSorter transcriptSorter = new TranscriptSorter();

        list.sort(transcriptSorter);

        System.out.println(list);







    }





}
