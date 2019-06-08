package com.chen.shengsiyuan.jdk8;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class PredicateTest2 {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        PredicateTest2 predicateTest2 = new PredicateTest2();
        predicateTest2.conditionFilter(list, integer -> integer % 2 == 0);
        System.out.println("--------------------------");
        predicateTest2.conditionFilter(list, integer -> integer % 2 == 1);
        System.out.println("--------------------------");
        predicateTest2.conditionFilter(list, integer -> integer > 5);
        System.out.println("--------------------------");
        predicateTest2.conditionFilter(list, integer -> integer < 3);
        System.out.println("--------------------------");
        predicateTest2.conditionFilter(list, integer -> true);
        System.out.println("--------------------------");

        predicateTest2.conditionFilter2(list, i -> i > 5, i -> i % 2 == 0);
        System.out.println("--------------------------");
        predicateTest2.conditionFilter3(list, i -> i > 5, i -> i % 2 == 0);
        System.out.println("--------------------------");
        predicateTest2.conditionFilter4(list, i -> i > 5);
        System.out.println("--------------------------");

        System.out.println(predicateTest2.isEqual("test").test("test"));
        System.out.println("--------------------------");
    }

    public void conditionFilter(List<Integer> list, Predicate<Integer> predicate){
        for (Integer integer : list){
            if(predicate.test(integer)){
                System.out.println(integer);
            }
        }
    }

    public void conditionFilter2(List<Integer> list, Predicate<Integer> predicate1, Predicate<Integer> predicate2){
        for (Integer integer : list){
            if(predicate1.and(predicate2).test(integer)){
                System.out.println(integer);
            }
        }
    }

    public void conditionFilter3(List<Integer> list, Predicate<Integer> predicate1, Predicate<Integer> predicate2){
        for (Integer integer : list){
            if(predicate1.or(predicate2).test(integer)){
                System.out.println(integer);
            }
        }
    }

    public void conditionFilter4(List<Integer> list, Predicate<Integer> predicate1){
        for (Integer integer : list){
            if(predicate1.negate().test(integer)){
                System.out.println(integer);
            }
        }
    }

    public Predicate<String> isEqual(Object object){
        return Predicate.isEqual(object);
    }
}
