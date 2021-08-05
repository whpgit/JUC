package com.whp.ex_0724_util;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @Author: wanghp
 * @Date: 2021/7/24 10:58 下午
 * @Describe 为什么还不是我们想要的   ，notify不释放锁，等他释放了才到while里
 * @Version V1.0
 */
public class Face_notify_02 {
    //修饰的只是引用，这里真正改变这个对象的值，现实没把握不建议使用
    volatile List<Object> list = new ArrayList<>();

    public void add(Object o) {
        list.add(o);
    }

    public int get() {
        return list.size();
    }

    public static void main(String[] args) {
        Face_notify_02 face01 = new Face_notify_02();
        Object lock = new Object();


        new Thread(() -> {
            synchronized (lock) {
                System.out.println("t2 启动`");
                if (face01.get() != 5) {
                    try {
                        lock.wait();  //这里会释放锁，然后再这里等待，被人唤醒继续往下执行
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("t2notify");
                lock.notify();
            }
            System.out.println("t2，结束");
        }, "t2").start();
        new Thread(() -> {
            synchronized (lock) {
                System.out.println("t1 启动");
                for (int i = 0; i < 10; i++) {
                    face01.add(new Object());
                    System.out.println("add " + i);
                    if (i == 5) {
                        lock.notify();
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                    }
                    try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            }
            System.out.println("t1 结束");
        }).start();


    }
}
