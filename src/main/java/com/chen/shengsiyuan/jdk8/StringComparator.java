package com.chen.shengsiyuan.jdk8;

import java.util.*;

public class StringComparator {

    public static void main(String[] args) {
        List<String> names = Arrays.asList("zhangsan", "lisi", "wangwu", "zhaoliu");

        Collections.sort(names, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.compareTo(o1);
            }
        });


        System.out.println(names);

        Collections.sort(names, ((o1, o2) -> {
            return o1.compareTo(o2);
        }));
        System.out.println(names);

        List<String> list1 = Arrays.asList("hello", "world", "hello world");
        List<String> list2 = new ArrayList<>();
        list1.forEach(item -> list2.add(item.toUpperCase()));
        list2.forEach(item -> System.out.println(item));

        list1.stream().map(item -> item.toLowerCase()).forEach(item -> System.out.println(item));
        list1.stream().map(String::toLowerCase).forEach(item -> System.out.println(item));
    }
}
