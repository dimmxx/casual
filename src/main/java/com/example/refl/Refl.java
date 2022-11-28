package com.example.refl;

import lombok.SneakyThrows;

import java.lang.reflect.Field;
import java.util.Collection;
import java.util.List;
import java.util.function.Function;

public class Refl {


    public static void main(String[] args) {

        User user = User.builder()
            .name("Peter")
           // .age(10)
            .article(Article.builder()
                .author(null)
                .build())
            .lines(List.of("hello", "buy"))
            .comments(List.of(
                Comment.builder()
                    .pages(10)
                    .topic("books")
                    .build(),

                Comment.builder()
                    .pages(10)
                    .topic("fishing")
                    .build()
            ))
            .build();

        Function<String, String> function = input -> "{chipher}" + input.toUpperCase();

        reflect(user, function);

        System.out.println(user);








    }

    @SneakyThrows
    private static void reflect(Object object, Function<String, String> function) {
        Class<?> clazz = object.getClass();
        boolean clazzEncrypted = clazz.isAnnotationPresent(Encrypted.class);

        for (Field field : clazz.getDeclaredFields()) {
            field.setAccessible(true);
            boolean innerClazzEncrypted = field.getType().isAnnotationPresent(Encrypted.class);
            Object fieldValue = field.get(object);
            if(field.getType().equals(String.class)){
                func(object, field, function, clazzEncrypted);
            } else if(innerClazzEncrypted){
                reflect(fieldValue, function);
            } else if (Collection.class.isAssignableFrom(field.getType())) {
                Collection<Object> collection = (Collection<Object>) fieldValue;
                if(collection != null){


                    for (Object item : collection) {

                        if(item.getClass().isAnnotationPresent(Encrypted.class)){
                            reflect(item, function);

                        }
                    }
                }
            }
        }
        System.out.println();
    }


    @SneakyThrows
    private static void func(Object object, Field field, Function<String, String> function, boolean clazzEncrypted) {
        if (clazzEncrypted && field.isAnnotationPresent(Encrypted.class) && field.getType().equals(String.class)) {
            field.set(object, function.apply((String) field.get(object)));
        }

    }

}