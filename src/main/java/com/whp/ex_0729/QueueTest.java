package com.whp.ex_0729;

import java.util.Random;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * @Author: wanghp
 * @Date: 2021/8/2 下午6:39
 * @Describe
 * @Version V1.0
 */
public class QueueTest {
    static LinkedBlockingQueue<Integer> queue = new LinkedBlockingQueue<>(10);
    static Random random = new Random();

    static void put() {
        for (int i = 0; i < 10; i++) {
            try {
                queue.put(i);
                TimeUnit.SECONDS.sleep(random.nextInt(3));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    static void take() {
        try {
            while (true) {
                Integer take = queue.take();
                System.out.println(take);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Thread(QueueTest::put).start();
        new Thread(QueueTest::take).start();
    }
}
