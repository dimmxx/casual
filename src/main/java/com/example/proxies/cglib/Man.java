package com.example.proxies.cglib;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Man {

    public String introduce(String name) {
        String response = "Меня зовут " + name;
        System.out.println(response);
        return response;
    }

    public void sayAge(int age) {
        System.out.println("Мне " + age + " лет");
    }


}
