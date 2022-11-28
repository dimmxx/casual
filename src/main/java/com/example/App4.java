package com.example;

import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import java.util.function.Function;

public class App4 {

    public static void main(String[] args) throws UnsupportedEncodingException {


        int n = 6;
        char[] spaces = new char[n];
        Arrays.fill(spaces, ' ');
        System.out.println(new String(spaces) + "!");


        String epoch = "1662058713242";

        LocalDateTime time = new Timestamp(Long.parseLong(epoch)).toLocalDateTime();

        System.out.println(time);



        LocalDateTime time1 = LocalDateTime.ofInstant(Instant.ofEpochMilli(Long.parseLong(epoch)), ZoneId.systemDefault());

        System.out.println(time1);




        List<Boolean> list = new ArrayList<>();
        list.add(true);
        list.add(true);
        list.add(true);

        System.out.println(list.stream().allMatch(e -> Objects.equals(e, true)));


    }


}
