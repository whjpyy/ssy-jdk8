package com.chen.shengsiyuan.jdk8.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamTest13 {

    public static void main(String[] args) {

        Student student1 = new Student("zhangsan", 99, 20);
        Student student2 = new Student("lisi", 90, 20);
        Student student3 = new Student("wangwu", 90, 30);
        Student student4 = new Student("zhangsan", 71, 40);

        List<Student> list = Arrays.asList(student1, student2, student3, student4);

        Map<String, List<Student>> map = list.stream().collect(Collectors.groupingBy(Student::getName));
        System.out.println(map);

        Map<Integer, List<Student>> mapScore = list.stream().collect(Collectors.groupingBy(Student::getScore));
        System.out.println(mapScore);

        Map<String, Long> mapCount = list.stream().collect(Collectors.groupingBy(Student::getName, Collectors.counting()));
        System.out.println(mapCount);

        Map<String, Double> mapDouble = list.stream().collect(Collectors.groupingBy(Student::getName, Collectors.averagingDouble(Student::getScore)));
        System.out.println(mapDouble);

        // 分区
        Map<Boolean, List<Student>> mapPartition = list.stream().collect(Collectors.partitioningBy(s -> s.getScore() >= 90));
        System.out.println(mapPartition);

    }
}
