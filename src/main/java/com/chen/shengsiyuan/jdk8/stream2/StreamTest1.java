package com.chen.shengsiyuan.jdk8.stream2;

import java.util.*;

import static java.util.stream.Collectors.*;

public class StreamTest1 {

    public static void main(String[] args) {
        Student student1 = new Student("zhangsan", 80);
        Student student2 = new Student("lisi", 90);
        Student student3 = new Student("wangwu", 100);
        Student student4 = new Student("zhaoliu", 90);
        Student student5 = new Student("zhaoliu", 90);

        List<Student> list = Arrays.asList(student1, student2, student3, student4, student5);

        list.stream().collect(toList()).forEach(System.out::println);
        System.out.println("----------------------------------");

        System.out.println("count: " + list.stream().collect(counting()));
        System.out.println("count: " + list.stream().count());
        System.out.println("----------------------------------");

        list.stream().collect(minBy(Comparator.comparingInt(Student::getScore))).ifPresent(System.out::println);
        list.stream().collect(maxBy(Comparator.comparingInt(Student::getScore))).ifPresent(System.out::println);
        System.out.println(list.stream().collect(averagingInt(Student::getScore)));
        System.out.println(list.stream().collect(summingInt(Student::getScore)));
        IntSummaryStatistics intSummaryStatistics = list.stream().collect(summarizingInt(Student::getScore));
        System.out.println(intSummaryStatistics);
        System.out.println("----------------------------------");

        System.out.println(list.stream().map(Student::getName).collect(joining()));
        System.out.println(list.stream().map(Student::getName).collect(joining(", ")));
        System.out.println(list.stream().map(Student::getName).collect(joining(", ", "[", "]")));
        System.out.println("----------------------------------");

        // 复合使用
        Map<Integer, Map<String, List<Student>>> map = list.stream().collect(groupingBy(Student::getScore, groupingBy(Student::getName)));
        System.out.println(map);
        Map<Boolean, List<Student>> map2 = list.stream().collect(partitioningBy(s -> s.getScore() > 80));
        System.out.println(map2);
        Map<Boolean, Map<Boolean, List<Student>>> map3 = list.stream().collect(partitioningBy(s -> s.getScore() > 80, partitioningBy(s -> s.getScore() > 90)));
        System.out.println(map3);
        Map<Boolean, Long> map4 = list.stream().collect(partitioningBy(s -> s.getScore() > 80, counting()));
        System.out.println(map4);
        Map<String, Student> map5 = list.stream().collect(groupingBy(Student::getName, collectingAndThen(minBy(Comparator.comparingInt(Student::getScore)), Optional::get)));
        System.out.println(map5);
        System.out.println("----------------------------------");

    }
}
