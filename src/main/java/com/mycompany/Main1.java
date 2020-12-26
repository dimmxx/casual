package com.mycompany;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Main1 {

    public static void main(String[] args) {

        LocalDateTime open = LocalDateTime.parse("2020-12-23T09:00:00");
        LocalDateTime close = LocalDateTime.parse("2020-12-23T20:00:00");


        List<LocalDateTime> list = new ArrayList<>();

        list.add(open);
        list.add(close);

        LocalDateTime ll = list.get(0).r
        ll = null;




    }




}
