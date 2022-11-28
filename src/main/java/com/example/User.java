package com.example;

import java.util.ArrayList;
import java.util.List;

public final class User {

    private final String name;
    private final int age;
    private final List<String> roles;


    public User(String name, int age, List<String> roles) {
        this.name = name;
        this.age = age;
        this.roles = new ArrayList<>(roles);
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public List<String> getRoles() {
        return new ArrayList<>(roles);
    }
}
