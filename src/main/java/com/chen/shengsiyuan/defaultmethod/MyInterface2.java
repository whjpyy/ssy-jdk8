package com.chen.shengsiyuan.defaultmethod;

public interface MyInterface2 {

    default void myMethod(){
        System.out.println("MyInterface2");
    }
}
