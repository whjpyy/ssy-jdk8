package com.chen.shengsiyuan.jdk8.stream2;

public class LambdaTest {

    Runnable r1 = () -> System.out.println("r1:" + this);
    Runnable r2 = new Runnable() {
        @Override
        public void run() {
            System.out.println("r2:" + this);
        }
    };
    Runnable r3 = new Runnable() {
        @Override
        public void run() {
            System.out.println("r3:" + this);
        }
    };

    public static void main(String[] args) {
        LambdaTest lambdaTest = new LambdaTest();

        Thread t1 = new Thread(lambdaTest.r1);
        t1.start();

        Thread t2 = new Thread(lambdaTest.r2);
        t2.start();

        new Thread(lambdaTest.r3).start();
    }
}
