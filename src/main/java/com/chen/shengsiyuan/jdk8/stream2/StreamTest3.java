package com.chen.shengsiyuan.jdk8.stream2;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamTest3 {

    public static void main(String[] args) {
        final List<String> list = Arrays.asList("hello", "world", "hello world", "welcome", "person", "student");

//        list.stream().forEach(System.out::println);

//        list.stream().map(i -> i).forEach(System.out::println);
        Stream<String> stream = list.stream();

        System.out.println("1111");

        Stream<String> stream2 = stream.map(item -> item + "_abc");

        System.out.println("2222");

        stream2.forEach(System.out::println);
    }
}
