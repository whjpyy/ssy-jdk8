package com.chen.shengsiyuan.jdk8.stream;

import java.util.stream.IntStream;

public class StreamTest3 {

    public static void main(String[] args) {

        System.out.println(IntStream.range(1,7).map(i -> i* 2).reduce(0, Integer::sum));
    }
}
