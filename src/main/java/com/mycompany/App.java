package com.mycompany;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public class App {

    public static void main(String[] args) {

        String str = "2020-12-25 09:00";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        LocalDateTime localDateTimeS = LocalDateTime.parse(str, formatter);

        List<LocalDateTime> list = new ArrayList<>();
        list.add(localDateTimeS);

        for(int i = 0; i < 600; i++){
            localDateTimeS = localDateTimeS.plus(1, ChronoUnit.MINUTES);
            list.add(localDateTimeS);
        }

        System.out.println(list);


        List<Pair<LocalDateTime, LocalDateTime>> result = new ArrayList<>();
        LocalDateTime key = list.get(0);
        LocalDateTime value = list.get(list.size() - 1);

        for(int i = 0; i < list.size() - 1; i++){

            if(list.get(i).equals(list.get(i + 1).plus(1, ChronoUnit.MINUTES))){
                temp = list.get(i + 1);
            } else{



            }


        }





    }





}
