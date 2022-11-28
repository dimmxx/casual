package com.example.lambda;

@FunctionalInterface
public interface Functional <T, R>{

    R process(T t);

}
