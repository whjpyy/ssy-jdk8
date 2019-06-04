package com.chen.shengsiyuan.jdk8;

import java.util.function.BiFunction;
import java.util.function.Function;

public class FunctionTest2 {

    public static void main(String[] args) {
        FunctionTest2 test = new FunctionTest2();

        System.out.println(test.compute(2, value -> value * 3, value -> value * value)); // 12
        System.out.println(test.compute2(2, value -> value * 3, value -> value * value)); // 36

        System.out.println(test.compute3(1,2, (v1, v2) -> v1 + v2));
        System.out.println(test.compute3(1,2, (v1, v2) -> v1 - v2));
        System.out.println(test.compute3(1,2, (v1, v2) -> v1 * v2));
        System.out.println(test.compute3(1,2, (v1, v2) -> v1 / v2));

        System.out.println(test.compute4(2, 3, (v1, v2) -> v1 + v2, v -> v * v));
    }

    public int compute(int a, Function<Integer, Integer> function1, Function<Integer, Integer> function2){
        return function1.compose(function2).apply(a);
    }

    public int compute2(int a, Function<Integer, Integer> function1, Function<Integer, Integer> function2){
        return function1.andThen(function2).apply(a);
    }

    public int compute3(int a, int b, BiFunction<Integer, Integer, Integer> biFunction){
        return biFunction.apply(a, b);
    }

    public int compute4(int a, int b, BiFunction<Integer, Integer, Integer> biFunction,
                        Function<Integer, Integer> function){
        return biFunction.andThen(function).apply(a, b);
    }
}
