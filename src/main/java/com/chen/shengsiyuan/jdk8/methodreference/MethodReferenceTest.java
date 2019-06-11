package com.chen.shengsiyuan.jdk8.methodreference;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;

public class MethodReferenceTest {

    public String getString(Supplier<String> supplier){
        return supplier.get() + "test";
    }

    public String getString2(String str, Function<String, String> function){
        return function.apply(str);
    }

    public static void main(String[] args) {
        Student stu1 = new Student("zhangsan", 10);
        Student stu2 = new Student("lisi", 90);
        Student stu3 = new Student("wangwu", 50);
        Student stu4 = new Student("zhaoliu", 40);

        List<Student> students = Arrays.asList(stu1, stu2, stu3, stu4);

        // 1.类名::静态方法
        students.sort((s1, s2) -> Student.compareStudentByScore(s1, s2));
        students.forEach(s -> System.out.println(s.getScore()));
        System.out.println("-------------");

        students.sort(Student::compareStudentByName);
        students.forEach(s -> System.out.println(s.getName()));
        System.out.println("-------------");


        // 2.对象名::实例方法
        StudentComparator studentComparator = new StudentComparator();
        students.sort((s1, s2) -> studentComparator.compareStudentByScore(s1, s2));
        students.forEach(s -> System.out.println(s.getScore()));
        System.out.println("-------------");

        students.sort(studentComparator::compareStudentByName);
        students.forEach(s -> System.out.println(s.getName()));
        System.out.println("-------------");


        // 3.类名::实例方法
        students.sort((s1, s2) -> s1.compareByScore(stu2));
        students.forEach(s -> System.out.println(s.getScore()));
        System.out.println("-------------");

        students.sort(Student::compareByName);
        students.forEach(s -> System.out.println(s.getName()));
        System.out.println("-------------");

        List<String> cities = Arrays.asList("qingdao", "chongqing", "tianjin", "beijing");
        cities.sort(String::compareToIgnoreCase);
        cities.forEach(System.out::println);
        System.out.println("-------------");


        // 构造函数引用: 类名::new
        MethodReferenceTest methodReferenceTest = new MethodReferenceTest();
        System.out.println(methodReferenceTest.getString(String::new));
        System.out.println(methodReferenceTest.getString2("hello", String::new));

    }
}
