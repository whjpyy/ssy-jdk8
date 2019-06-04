package com.chen.shengsiyuan.jdk8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test3 {

    public static void main(String[] args) {
        TheInterface i1 = () -> {};
        System.out.println(i1.getClass().getInterfaces()[0]);
        TheInterface2 i2 = () -> {};
        System.out.println(i2.getClass().getInterfaces()[0]);

        new Thread( ()-> {
            System.out.println("hello world");
        }).start();

        List<String> list = Arrays.asList("chen", "you", "zeng");
        list.forEach(s -> {
            System.out.println(s.toUpperCase());
        });

        List<String> list2 = new ArrayList<>();
        list.forEach(s -> list2.add(s.toUpperCase()));
        list2.forEach(s -> System.out.println(s));

        // 使用流的方式来实现
        list.stream().map(s -> s.toUpperCase()).forEach(s -> System.out.println(s));
        list.stream().map(String::toUpperCase).forEach(s -> System.out.println(s));
    }
}

@FunctionalInterface
interface TheInterface{
    void myMethod();
}

@FunctionalInterface
interface TheInterface2{
    void myMethod2();
}