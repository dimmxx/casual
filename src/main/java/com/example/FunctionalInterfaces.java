package com.example;

import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.IntPredicate;
import java.util.function.IntUnaryOperator;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class FunctionalInterfaces {


    public static String obs(String str, Integer i){

        return str;
    }



    public static BiFunction<String, Integer, String> convert (Function<String, String> function){


        return (s, i) -> function.apply(s);




    }





    public static void main(String[] args) {

        BiFunction<IntUnaryOperator, IntPredicate, IntUnaryOperator> intFunctionToConditionalIntFunction
            = functionToConditionalFunction();
        IntUnaryOperator abs = intFunctionToConditionalIntFunction.apply(a -> -a, a -> a < 0);
        int i1 = abs.applyAsInt(-5);
        int i2 = abs.applyAsInt(0);
        int i3 = abs.applyAsInt(5);


        Supplier<String> stringSupplier = () -> "WELL DONE!";
        System.out.println(stringSupplier.get());



        int a1 = -5;
        int b = -a1;
        //System.out.println(b);


        Supplier<Integer> supplier = () -> 5;
        //System.out.println(supplier.get());

        IntUnaryOperator intUnaryOperator = (n) -> n * 2;
        //System.out.println(intUnaryOperator.applyAsInt(3));

        IntUnaryOperator intUnaryOperator1 = a -> {
            return -a;
        };
        System.out.println(intUnaryOperator1.applyAsInt(-2));



        Function<Integer, Integer> function = (k) -> k * 2;
        System.out.println(function.apply(5));

        UnaryOperator<Integer> unaryOperator = (i) -> i * 2;
        System.out.println(unaryOperator.apply(3));



        String str = "hello";
        System.out.println(str.repeat(5));


    }

    public static BiFunction<IntUnaryOperator, IntPredicate, IntUnaryOperator> functionToConditionalFunction() {
        return (operator, predicate) -> {
            return (a) -> {
                if(predicate.test(a)){
                    return operator.applyAsInt(a);
                } else {
                    return a;
                }
            };
        };
    }


}
