package com.chen.shengsiyuan.jdk8.stream;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamTest4 {

    public static void main(String[] args) {
//        Stream<String> stream = Stream.of("hello", "world", "helloworld");

//        String[] arr = stream.toArray(length -> {
//            System.out.println(length);
//            return new String[length];
//        });
//        String[] arr = stream.toArray(String[]::new); // 方法引用
//        Arrays.asList(arr).forEach(System.out::println);

        Stream<String> stream = Stream.of("hello", "world", "helloworld");
//        List<String> list = stream.collect(Collectors.toList());
//        List<String> list = stream.collect(
//                () -> new ArrayList<>(),
//                (theList, item) -> theList.add(item),
//                (theList1, theList2) -> theList1.addAll(theList2));
//        LinkedList<Object> list = stream.collect(LinkedList::new, LinkedList::add, LinkedList::addAll);


        // 第三个参数只有并行的时候才有作用
        List<String> list = stream.collect(
                () -> {
                    System.out.println("返回空的list");
                    return new ArrayList<>();
                },
                (theList, item) -> {
                    System.out.println("add：" + theList.size());
                    System.out.println("add: " + item);
                    theList.add(item);
                },
//                (theList1, theList2) -> {
//                    System.out.println("addAll: " + theList1.size());
//                    System.out.println("addAll: " + theList2.size());
//                    theList1.addAll(theList2);
//                }
                (a, b) -> {}
                );

        list.forEach(System.out::println);
        System.out.println("-------------------------");

        Stream<String> stream2 = Stream.of("hello", "world", "helloworld");
        ArrayList<String> arrayList = stream2.collect(Collectors.toCollection(ArrayList::new));
        arrayList.forEach(System.out::println);
        System.out.println("-------------------------");
        Stream<String> stream3 = Stream.of("hello", "world", "helloworld");
        TreeSet<String> treeSet = stream3.collect(Collectors.toCollection(TreeSet::new));
        treeSet.forEach(System.out::println);
        System.out.println("-------------------------");
        Stream<String> stream4 = Stream.of("hello", "world", "helloworld");
        String str = stream4.collect(Collectors.joining(",")).toString();
        System.out.println(str);

    }
}
