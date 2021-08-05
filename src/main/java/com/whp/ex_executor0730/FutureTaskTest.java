package com.whp.ex_executor0730;

import java.util.concurrent.FutureTask;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * @Author: wanghp
 * @Date: 2021/7/30 下午11:10
 * @Describe 本身是个runable 又是个Future
 * @Version V1.0
 */
public class FutureTaskTest {
    public static void main(String[] args) {
        FutureTask<Integer> futureTask = new FutureTask<>(() -> {
            return 100;
        });
        Supplier<Integer> callable = () -> {
            return 100;
        };
        Consumer<String> consumer = key -> {
            System.out.println(key);
            return;
        };
        consumer.accept("consumer");
        Function<Integer, String> function = key -> {
            System.out.println(key);
            return "OK";
        };
        System.out.println(function.apply(1));
        new Thread(futureTask).start();

    }
}
