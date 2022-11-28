package com.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.stream.Collectors;

public class App2 {


    public static void main(String[] args) throws IOException {


        System.out.println(getPageContents("https://checkip.amazonaws.com"));

    }


    private static String getPageContents(String address) throws IOException {
        URL url = new URL(address);
        try(BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()))) {
            return br.lines().collect(Collectors.joining(System.lineSeparator()));
        }
    }








}
