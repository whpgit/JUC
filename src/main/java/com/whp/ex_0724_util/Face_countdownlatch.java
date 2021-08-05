package com.whp.ex_0724_util;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * @Author: wanghp
 * @Date: 2021/7/24 10:58 下午
 * @Describe 为什么还不是我们想要的   ，notify不释放锁，等他释放了才到while里
 * @Version V1.0
 */
public class Face_countdownlatch {
    List<Object> list = new ArrayList<>();

    public void add(Object o) {
        list.add(o);
    }

    public int get() {
        return list.size();
    }

    public static void main(String[] args) {
        Face_countdownlatch face01 = new Face_countdownlatch();
        CountDownLatch countDownLatch = new CountDownLatch(1);

        new Thread(() -> {
            if (face01.get() != 5) {
                try {
                    countDownLatch.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("t2，结束");
        }, "t2").start();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                face01.add(new Object());
                System.out.println("add " + i);
                if (i == 5) {
                    countDownLatch.countDown();
                }
                try {
                    //要这个睡眠，不然没用
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }).start();


    }
}
