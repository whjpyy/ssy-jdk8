package com.chen.shengsiyuan.jdk8.stream;

import java.util.Arrays;
import java.util.List;

public class StreamTest7 {

    public static void main(String[] args) {
        List<String> list = Arrays.asList("hello", "world", "hello world");
        list.stream().map(i -> i.substring(0, 1).toUpperCase() + i.substring(1)).forEach(System.out::println);

        List<String> list1 = Arrays.asList("hello", "world", "hello world");
        list1.stream().map(i -> {
            String result = i.substring(0, 1).toUpperCase() + i.substring(1);
            System.out.println("test");
            return result;
        });
    }
}
