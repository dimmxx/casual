package com.mycompany;

import java.lang.reflect.Array;
import java.util.Arrays;

public class App1 {

    public static void main(String[] args) {

        String line = "[[[30.540757,50.410726],[30.540752,50.410216]]]";

        Object[] arr1 = new Object[1];
        Object[] arr2 = new Object[2];

        String[] g1 = {"30.540757", "50.410726"};
        String[] g2 = {"30.540752", "50.410216"};
        arr2[0] = g1;
        arr2[1] = g2;
        arr1[0] = arr2;

        Object[] test = arr1;

        int i = 0;
        int j = 0;

        while (test.getClass().isArray()){
            try {
                test = (Object[]) test[0];
            } catch (ClassCastException e){
                break;
            }
            i++;
        }
        System.out.println(i);


        while (true){
            if(test.getClass().isArray()){
                i++;
                test = (Object[]) test[0];
            } else {
                break;
            }
        }
        System.out.println(j);




    }





}
