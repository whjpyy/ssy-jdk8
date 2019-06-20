package com.chen.shengsiyuan.jdk8.stream2;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class MyComparatorTest {

    public static void main(String[] args) {
        List<String> list = Arrays.asList("nihao", "helo", "world", "welcome");

//        list.stream().sorted(new Comparator<String>() {
//            @Override
//            public int compare(String o1, String o2) {
//                return o1.compareTo(o2);
//            }
//        }).forEach(System.out::println);
        Collections.sort(list);
        System.out.println(list);
        Collections.sort(list, (o1, o2) -> o1.length() - o2.length());
        System.out.println(list);
        Collections.sort(list, (o1, o2) -> o2.length() - o1.length());
        System.out.println(list);
        Collections.sort(list, Comparator.comparingInt(String::length).reversed());
        System.out.println(list);
        // item为Object类型 里面的上下文太远，中间隔了一个reversed
        Collections.sort(list, Comparator.comparingInt((String item) -> item.length()).reversed());

        Collections.sort(list, Comparator.comparingInt(String::length).thenComparing(String.CASE_INSENSITIVE_ORDER));

        Collections.sort(list, Comparator.comparingInt(String::length).thenComparing((item1, item2) -> item1.compareToIgnoreCase(item2)));

        Collections.sort(list, Comparator.comparingInt(String::length).thenComparing(Comparator.comparing(String::toUpperCase)));

        Collections.sort(list, Comparator.comparingInt(String::length).thenComparing(Comparator.comparing(String::toUpperCase, Comparator.reverseOrder())));

        Collections.sort(list, Comparator.comparingInt(String::length).reversed().thenComparing(Comparator.comparing(String::toUpperCase)));

        Collections.sort(list, Comparator.comparingInt(String::length).reversed().thenComparing(Comparator.comparing(String::toLowerCase, Comparator.reverseOrder())).thenComparing(Comparator.reverseOrder()));


    }
}
