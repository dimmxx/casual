package com.example.inherit;

public class App5 {

    public static void main(String[] args) {

        Human human = new Human("John", 25);

        Student student = new Student(human);


        System.out.println(student);

    }




}
