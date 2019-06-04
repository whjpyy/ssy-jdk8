package com.chen.shengsiyuan.jdk8;

import org.omg.CORBA.INTERNAL;

import java.util.function.Function;

public class FunctionTest {

    public static void main(String[] args) {
        FunctionTest test = new FunctionTest();

        System.out.println(test.compute(1, v -> v * 2));
        System.out.println(test.compute(1, v -> v + 5));
        System.out.println(test.compute(1, v -> v * v));

        System.out.println(test.convert(5, v -> String.valueOf(v) + "helloword"));

    }

    public int compute(int a, Function<Integer, Integer> function){
        return function.apply(a);
    }

    public String convert(int a, Function<Integer, String> function){
        return function.apply(a);
    }
}
