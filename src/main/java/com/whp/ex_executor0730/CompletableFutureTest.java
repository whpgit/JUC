package com.whp.ex_executor0730;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

/**
 * @Author: wanghp
 * @Date: 2021/7/30 下午11:30
 * @Describe
 * @Version V1.0
 */
public class CompletableFutureTest {
    static Integer priceTM() {
        return 1;
    }

    static Integer priceJD() {
        return 2;
    }

    static Integer pricePDD() {
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return 3;
    }

    public static void main(String[] args) {
        CompletableFuture<Integer> tmFuture = CompletableFuture.supplyAsync(CompletableFutureTest::priceTM);
        CompletableFuture<Integer> jdFuture = CompletableFuture.supplyAsync(CompletableFutureTest::priceJD);
        CompletableFuture<Integer> pddFuture = CompletableFuture.supplyAsync(CompletableFutureTest::pricePDD);
        CompletableFuture.allOf(tmFuture, jdFuture, pddFuture).join();
        System.out.println("allOf over");

        CompletableFutureTest c1 = new CompletableFutureTest();
        CompletableFutureTest c2 = new CompletableFutureTest();

    }
}
