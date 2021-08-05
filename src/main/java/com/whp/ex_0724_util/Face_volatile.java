package com.whp.ex_0724_util;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: wanghp
 * @Date: 2021/7/24 10:58 下午
 * @Describe
 * @Version V1.0
 */
public class Face_volatile {
    //修饰的只是引用，这里真正改变这个对象的值，现实没把握不建议使用
    volatile List<Object> list = new ArrayList<>();

    public void add(Object o) {
        list.add(o);
    }

    public int get() {
        return list.size();
    }

    public static void main(String[] args) {
        Face_volatile face01 = new Face_volatile();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                face01.add(new Object());
                System.out.println("add " + i);
//                try {
//                    TimeUnit.SECONDS.sleep(1);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
            }
        }).start();


        new Thread(() -> {
            while (true) {
                if (face01.get() == 5) {
                    break;
                }
            }
            System.out.println("t2，结束");
        }, "t2").start();

    }
}
