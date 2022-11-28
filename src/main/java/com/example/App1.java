package com.example;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class App1 {
    public static void main(String[] args) {


        method1();

    }


    public static void method1(){
        try {
            method2();
        } catch (RuntimeException e){
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }


    public static void method2(){
        try {
            method3();
        } catch (RuntimeException e){
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }

    public static void method3(){
        try {
            throw new RuntimeException("method3");
        } catch (RuntimeException e){
            e.printStackTrace();
            System.out.println(e.getMessage());
        }




    }







}
