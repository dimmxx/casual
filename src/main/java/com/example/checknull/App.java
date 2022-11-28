package com.example.checknull;

public class App {

    public static void main(String[] args) {

        Line line = new Line();
        Department department = new Department();
        User user = new User();

        line.setName("name");
        //department.setLine(line);
        //user.setDepartment(department);

        if(user.getDepartment().getLine() != null){
            System.out.println("not null");
        }

    }









}
