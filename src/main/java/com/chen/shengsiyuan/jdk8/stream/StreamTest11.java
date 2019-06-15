package com.chen.shengsiyuan.jdk8.stream;

import java.util.Arrays;
import java.util.List;

public class StreamTest11 {

    public static void main(String[] args) {
        List<String> list = Arrays.asList("hello welcome", "world hello", "hello world hello", "hello welcome");
        list.stream().flatMap(s -> Arrays.asList(s.split(" ")).stream()).distinct().forEach(System.out::println);
        System.out.println("---------------------");

        list.stream().map(s -> s.split(" ")).flatMap(Arrays::stream).distinct().forEach(System.out::println);
    }
}
