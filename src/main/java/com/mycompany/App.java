package com.mycompany;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;
import java.util.stream.Collectors;

public class App {

    public static void main(String[] args) throws IOException {


        LocalTime time = LocalTime.now();

        System.out.println(time);


        LocalTime t1 = LocalTime.of(9, 0);

        LocalTime t2 = LocalTime.of(9, 0);

        System.out.println(t2.isAfter(t1));

    }




}
