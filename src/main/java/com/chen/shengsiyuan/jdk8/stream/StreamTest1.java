package com.chen.shengsiyuan.jdk8.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamTest1 {

    public static void main(String[] args) {
        Stream stream1 = Stream.of("hello", "world", "hello world");

        String[] myArray = {"hello", "world", "hello world"};
        Stream<String> stream2 = Stream.of(myArray);
        Stream<String> stream3 = Arrays.stream(myArray);

        List<String> list = Arrays.asList(myArray);
        Stream<String> stream4 = list.stream();
    }
}
