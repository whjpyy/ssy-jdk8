package com.chen.shengsiyuan.jdk8.stream;

import java.util.Arrays;
import java.util.List;

public class StreamTest12 {

    public static void main(String[] args) {
        List<String> list1 = Arrays.asList("Hi", "Hello", "你好");
        List<String> list2 = Arrays.asList("zhangsan", "lisi", "wangwu", "zhaoliu");

        list1.stream().flatMap(s -> list2.stream().map(s2 -> s + " " + s2)).forEach(System.out::println);
    }
}
