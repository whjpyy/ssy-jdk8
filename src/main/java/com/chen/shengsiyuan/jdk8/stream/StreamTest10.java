package com.chen.shengsiyuan.jdk8.stream;

import java.util.Arrays;
import java.util.List;

public class StreamTest10 {

    public static void main(String[] args) {
        List<String> list = Arrays.asList("hello", "world", "hello world");
        list.stream().mapToInt(s -> s.length()).filter(length -> length == 5).findFirst().ifPresent(System.out::println);
        System.out.println("-----------------------");

        list.stream().mapToInt(s -> {
            System.out.println(s);
            return s.length();
        }).filter(length -> length == 5).findFirst().ifPresent(System.out::println);

    }
}
