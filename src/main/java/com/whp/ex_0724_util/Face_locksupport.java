package com.whp.ex_0724_util;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

/**
 * @Author: wanghp
 * @Date: 2021/7/24 10:58 下午
 * @Describe 为什么还不是我们想要的   ，notify不释放锁，等他释放了才到while里
 * @Version V1.0  这块有个问题  unpark回来 t2为空
 */
public class Face_locksupport {
    List<Object> list = new ArrayList<>();

    public void add(Object o) {
        list.add(o);
    }

    public int get() {
        return list.size();
    }

    static Thread t1 = null, t2 = null;

    public static void main(String[] args) {
        Face_locksupport face01 = new Face_locksupport();

        t1 = new Thread(() -> {
            LockSupport.park();
            System.out.println("t2，结束");
            System.out.println(t2);
            LockSupport.unpark(t2);
        }, "t2");
        t2 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                face01.add(new Object());
                System.out.println("add " + i);
                if (i == 5) {
                    LockSupport.unpark(t1);
                    LockSupport.park();
                }
                try {
                    //要这个睡眠，不然没用
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        });
        t2.start();
        t1.start();
    }
}
