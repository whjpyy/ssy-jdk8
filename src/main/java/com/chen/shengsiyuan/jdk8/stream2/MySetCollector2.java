package com.chen.shengsiyuan.jdk8.stream2;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

import static java.util.stream.Collector.Characteristics.*;

public class MySetCollector2<T> implements Collector<T, Set<T>, Map<T, T>> {
    @Override
    public Supplier<Set<T>> supplier() {
        System.out.println("supplier invoked");

//        return HashSet::new;
        return () -> {
            // 并行是会生成8个结果容器
            System.out.println("-----------");
            return new HashSet<>();
        };
    }

    @Override
    public BiConsumer<Set<T>, T> accumulator() {
        System.out.println("accumulator invoked");

        return (set, item) -> {
            System.out.println("accumulator: " + set + "," + Thread.currentThread().getName());
            set.add(item);
        };
    }

    @Override
    public BinaryOperator<Set<T>> combiner() {
        System.out.println("combiner invoked");
        return (set1, set2) -> {
            System.out.println("set1：" + set1);
            System.out.println("set2：" + set2);
            set1.addAll(set2);
            return set1;
        };
    }

    @Override
    public Function<Set<T>, Map<T, T>> finisher() {
        System.out.println("finisher invoked");
        return set -> {
            Map<T, T> map = new HashMap<>();
            set.stream().forEach(item -> map.put(item, item));
            return map;
        };
    }

    @Override
    public Set<Characteristics> characteristics() {
        System.out.println("charcteristics invoked");
//        return Collections.unmodifiableSet(EnumSet.of(UNORDERED, IDENTITY_FINISH));
        // IDENTITY_FINISH不需要进行finisher
        // CONCURRENT 结果容器只有一个，多个线程进行操作时，如果在遍历的时候修改set，则会抛出ConcurrentModificationException,
        return Collections.unmodifiableSet(EnumSet.of(UNORDERED));
    }

    public static void main(String[] args) {
        for(int i = 0;i < 1;i ++) {
            List<String> list = Arrays.asList("hello", "world", "welcome", "a", "b", "c", "d", "e", "f", "g");
            Set<String> set = new HashSet<>();
            set.addAll(list);

            System.out.println("set: " + set);

            Map<String, String> map = set.parallelStream().collect(new MySetCollector2<>());
            System.out.println(map);
        }
    }
}
