package com.chen.shengsiyuan.jdk8.stream2;

public class AutoCloseableTest implements AutoCloseable {

    public void doSomething(){
        System.out.println("doSomething invoked!");
    }

    @Override
    public void close() throws Exception {
        System.out.println("closed invoked!");
    }

    public static void main(String[] args) throws Exception {
        try(AutoCloseableTest autoCloseableTest = new AutoCloseableTest()){
            autoCloseableTest.doSomething();
        }
    }
}
