package com.chen.shengsiyuan.jdk8.stream2;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamTest2 {

    public static void main(String[] args) {
        List<String> list = Arrays.asList("hello", "world", "hell world");

        list.stream().onClose(() -> {
            System.out.println("closed1 invoked");
        }).onClose(() -> {
            System.out.println("closed2 invoked");
        }).forEach(System.out::println);

        NullPointerException nullPointerException = new NullPointerException("my exception");
        try(Stream<String> stream = list.stream()){
            stream.onClose(() -> {
                System.out.println("closed1 invoked");
                throw new NullPointerException("first exception");
//                throw nullPointerException;
            }).onClose(() -> {
                System.out.println("closed2 invoked");
//                throw new ArithmeticException("second exception");
//                throw nullPointerException;
                throw new NullPointerException("second exception");
            }).forEach(System.out::println);

        }
    }
}
