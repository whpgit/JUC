package com.whp.ex_0801;

import java.util.concurrent.ForkJoinPool;

/**
 * @Author: wanghp
 * @Date: 2021/8/4 下午5:29
 * @Describe
 * @Version V1.0
 */
public class ForkJoinTest02 {

    public static void main(String[] args) {
        ForkJoinPool forkJoinPool = new ForkJoinPool(Runtime.getRuntime().availableProcessors());
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler = forkJoinPool.getUncaughtExceptionHandler();
        System.out.println(uncaughtExceptionHandler.toString());
    }
}
