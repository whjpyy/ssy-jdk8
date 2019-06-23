package com.chen.shengsiyuan.jdk8.stream2;

import java.util.function.Consumer;
import java.util.function.IntConsumer;

public class ConsumerTest {

    public void test(Consumer<Integer> consumer){
        consumer.accept(100);
    }

    public static void main(String[] args) {
        ConsumerTest test = new ConsumerTest();

        Consumer<Integer> consumer = i -> System.out.println(i);
        IntConsumer intConsumer = i -> System.out.println(i);

        System.out.println(consumer instanceof Consumer);
        System.out.println(intConsumer instanceof IntConsumer);

        test.test(consumer);    // 面向对象方式
//        test.test(intConsumer);
//        test.test((Consumer)intConsumer);   // java.lang.ClassCastException: com.chen.shengsiyuan.jdk8.stream2.ConsumerTest$$Lambda$2/1078694789 cannot be cast to java.util.function.Consumer
        test.test(consumer::accept);        // 函数式方式
        test.test(intConsumer::accept);     // 函数式方式
    }
}
