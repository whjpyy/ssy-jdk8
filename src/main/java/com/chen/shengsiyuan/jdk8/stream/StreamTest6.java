package com.chen.shengsiyuan.jdk8.stream;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.OptionalInt;
import java.util.UUID;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class StreamTest6 {

    public static void main(String[] args) {
        Stream<String> stream = Stream.generate(UUID.randomUUID()::toString);
//        System.out.println(stream.findFirst().get());
        stream.findFirst().ifPresent(System.out::println);
        System.out.println("-------------------------");

        Stream.iterate(1, item -> item + 2).limit(6).forEach(System.out::println);
        System.out.println("-------------------------");

        int sum = Stream.iterate(1, item -> item + 2).filter(i -> i > 2).mapToInt(i -> i * 2).skip(2).limit(2).sum();
        System.out.println(sum);
        System.out.println("-------------------------");

        OptionalInt min = Stream.iterate(1, item -> item + 2).filter(i -> i > 2).mapToInt(i -> i * 2).skip(2).limit(2).min();
        min.ifPresent(System.out::println);
        System.out.println("-------------------------");

        IntSummaryStatistics statistics = Stream.iterate(1, item -> item + 2).filter(i -> i > 2).mapToInt(i -> i * 2).skip(2).limit(2).summaryStatistics();
        System.out.println(statistics.getMin());
        System.out.println(statistics.getMax());
        System.out.println("-------------------------");

        Stream<Integer> stream1 = Stream.of(1, 2);
        System.out.println(stream1);
        Stream stream2 = stream1.filter(i -> i > 2);
        System.out.println(stream2);
        Stream stream3 = stream2.distinct();
        System.out.println(stream3);
    }
}
