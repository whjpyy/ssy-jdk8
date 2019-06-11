package com.chen.shengsiyuan.jdk8.defaultmethod;

/**
 * 实现类要比接口优先级更高
 */
public class MyClass extends MyInterface1Impl implements MyInterface2{

//    @Override
//    public void myMethod() {
////        System.out.println("MyClass");
//        MyInterface2.super.myMethod();
//    }

    public static void main(String[] args) {
        MyClass myClass = new MyClass();
        myClass.myMethod();
    }
}
