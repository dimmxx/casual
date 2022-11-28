package com.example;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


@Slf4j
public class Main {

    public static void main(String[] args) {

        // TASK2
        List<Integer> myList = Arrays.asList(10, 15, 8, 49, 25, 98, 32);
        //print only those who are even
        // even means this number divides by 2
        myList.stream()
                .filter(e -> e % 2 == 0)
                .forEach(System.out::println);


        // TASK3
        List<Integer> list = Arrays.asList(10, 15, 8, 49, 25, 98, 32);
        //print only those numbers, starting with ‘1’
        list.stream()
                .map(e -> Integer.toString(e))
                .filter(e -> e.startsWith("1"))
                .forEach(System.out::println);



        // TASK1
        List<User> users = List.of(
                new User(10,1000),
                new User(10,500),
                new User(11,1000),
                new User(11,3000));

//        output
//        key 10-> value 750
//        key 11-> value 2000

        Map<Integer, Double> map = calculate(users);
        map.forEach((key, value) -> System.out.printf("key %d-> value %.0f%n", key, value));
    }

    public static Map<Integer, Double> calculate(List<User> users){
        return users.stream()
                .collect(Collectors.groupingBy(User::getExperience, Collectors.averagingDouble(User::getSalary)));
    }

    static class User {

        int experience;
        double salary;

        public User(int experience, double salary) {
            this.experience = experience;
            this.salary = salary;
        }

        public int getExperience() {
            return experience;
        }

        public double getSalary() {
            return salary;
        }
    }
}
