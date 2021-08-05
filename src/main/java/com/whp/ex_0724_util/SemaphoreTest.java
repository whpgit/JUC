package com.whp.ex_0724_util;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * @Author: wanghp
 * @Date: 2021/7/24 10:02 下午
 * @Describe    TimeUnit.SECONDS  和
 * @Version V1.0
 */
public class SemaphoreTest {

    public static void main(String[] args) {
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(() -> {
            try {

                System.out.println("T0 running...");
                Thread.sleep(1000);
                System.out.println("T0 running end...");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
            }

        }).start();
        //同时执行的线程数量
        Semaphore semaphore = new Semaphore(2);

        new Thread(() -> {
            try {
                semaphore.acquire(); //1 到 0
                System.out.println("T1 running...");
//                TimeUnit.SECONDS.sleep(1);
                Thread.sleep(1000);
                System.out.println("T1 running end...");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                semaphore.release(); //又重0到1
            }

        }).start();

        Thread t2 = new Thread(() -> {
            try {
                semaphore.acquire(); //1 到 0
                System.out.println("T2 running...");
                Thread.sleep(10000);
//                TimeUnit.SECONDS.sleep(1);

                System.out.println("T2 running end...");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                semaphore.release(); //又重0到1
            }
        });

        t2.start();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("end ...");

        t2.isInterrupted();
    }
}
