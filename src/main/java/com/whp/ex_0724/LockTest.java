package com.whp.ex_0724;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author: wanghp
 * @Date: 2021/7/24 6:36 下午
 * @Describe
 * @Version V1.0
 */
public class LockTest {
    static Lock lock = new ReentrantLock();

    public static void main(String[] args) {

        Thread t1 = new Thread(() -> {
            try {
                lock.lock();
                System.out.println("lock start");

                TimeUnit.SECONDS.sleep(5);
                System.out.println("lock end");
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        });
        t1.start();

        try {
            TimeUnit.SECONDS.sleep(2);
//            t1.interrupt();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
