package com.mycompany;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class App {

    public static void main(String[] args) throws IOException {


        LocalDate date = LocalDate.now();

        //LocalDate date = LocalDate.of(2020, 10, 1);

        System.out.println(date);
        System.out.println(date.lengthOfMonth());


        Map<String, LocalTime> map = new LinkedHashMap<>();

        for(int i = 0; i < date.lengthOfMonth(); i++){
            String month = date.getMonth().getValue() < 10?"0" + date.getMonth().getValue():"" + date.getMonth().getValue();
            String day = (i + 1) < 10?"0" + (i + 1):"" + (i + 1);





            map.put(date.getYear() + "-" + month + "-" + day, null);
        }

        map.forEach((k, v) -> System.out.println(k + ": " + v));



    }




}
