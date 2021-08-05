package com.whp.ex_0802;


import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * @Author: wanghp
 * @Date: 2021/8/2 下午7:09
 * @Describe
 * @Version V1.0
 */
public class CompletableFuture01 {


    static Integer add(int i) {
        Integer integer =i+1 ;
        System.out.println(integer);
        return integer;
    }

    public static void main(String[] args) {
        System.out.println(5/2);
        System.out.println(211/10);
        CompletableFuture<Integer> completableFuture = CompletableFuture.supplyAsync(() -> {
            return add(1);
        }).thenApplyAsync(i -> {
            System.out.println(i);
            return i + 1;
        });
        Integer integer = null;
        try {
            integer = completableFuture.get(1, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
        System.out.println(integer);
    }
}
