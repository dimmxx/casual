package com.example.proxies.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.FixedValue;

import java.lang.reflect.Proxy;

public class Main {

    public static void main(String[] args) {

        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(Man.class);
        enhancer.setCallback((FixedValue) () -> "Hello Tom!");
        Man proxy = (Man) enhancer.create();

        String res = proxy.introduce(null);

        System.out.println(res);


    }
}

