package com.example.proxies.intefacebased;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class PersonInvocationHandler implements InvocationHandler {

    private Person person;

    public PersonInvocationHandler(Person person) {
        this.person = person;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("Привет! - " + method.getName());
        return method.invoke(person, args);
    }
}

