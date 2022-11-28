package com.example.lambda;

import com.amazonaws.services.dynamodbv2.xspec.L;

import java.util.List;
import java.util.stream.Collectors;

public class Demo {

    public static void main(String[] args) {



        Functional<String, Integer> functional = (str) -> Integer.valueOf(str);

        Integer aaa = functional.process("56");

        System.out.println(aaa + 1);

        List<String> list = List.of("45", "65", "12");

        List<Integer> lll = list.stream()
            .map(functional::process)
            .map(i -> i + 1)
            .collect(Collectors.toList());

        System.out.println(lll);


    }




}
