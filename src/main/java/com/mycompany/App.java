package com.mycompany;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class App {

    public static void main(String[] args) {

        String str = "2020-12-25 09:00";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        LocalDateTime localDateTimeS = LocalDateTime.parse(str, formatter);

//        List<LocalDateTime> list = new ArrayList<>();
//        list.add(localDateTimeS);
//        for(int i = 0; i < 10; i++){
//            localDateTimeS = localDateTimeS.plus(30, ChronoUnit.MINUTES);
//            list.add(localDateTimeS);
//        }
//        System.out.println(list);

        List<Pair<LocalDateTime, LocalDateTime>> result = new ArrayList<>();

        List<String> stringList = List.of(

                "2020-12-25T09:01",

                "2020-12-25T09:04",
                "2020-12-25T09:05",
                "2020-12-25T09:06",


                "2020-12-25T09:10"
                );
        List<LocalDateTime> list = stringList.stream().map(LocalDateTime::parse).collect(Collectors.toList());



        String s = "916 917 918 919 931 949 1011 1012 1013 1014 1015 1016 1017 1018 1019 1020";


        int b = 0;
        int loop = 0;

        for (int i = 0; i < list.size() - 1; i++) {
            if (!Objects.equals(list.get(i).plus(1, ChronoUnit.MINUTES), list.get(i + 1))) {
                if(loop > 1){
                    Pair<LocalDateTime, LocalDateTime> pair = new Pair<>(list.get(b), list.get(i));
                    result.add(pair);
                    loop = 0;
                    b = i + 1;

                }

            }else{
                if(i == list.size() - 1){
                    Pair<LocalDateTime, LocalDateTime> pair = new Pair<>(list.get(b), list.get(i + 1));
                    result.add(pair);
                    break;
                }
                loop++;

            }
        }






//        List<Pair<LocalDateTime, LocalDateTime>> result = new ArrayList<>();
//        LocalDateTime key = list.get(0);
//        LocalDateTime value = list.get(list.size() - 1);
//
//        for(int i = 0; i < list.size() - 1; i++){
//            if(!list.get(i).equals(list.get(i + 1).plus(30, ChronoUnit.MINUTES))){
//                key = list.get(i);
//                value = list.get(i + 1);
//                result.add(new Pair<>(key, value));
//                continue;
//            }
//
//            value = list.get(i);
//            result.add(new Pair<>(key, value));
//            key = list.get(i + 1);
//        }


    }
}
