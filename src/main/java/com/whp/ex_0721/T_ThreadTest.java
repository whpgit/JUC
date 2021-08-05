package com.whp.ex_0721;

import lombok.Data;

/**
 * @Author: wanghp
 * @Date: 2021/7/21 11:13 下午
 * @Describe TODO 线程的状态
 * @Version V1.0
 */
@Data
public class T_ThreadTest extends Thread {
    @Override
    public void run() {
        for (int i = 1; i < 100; i++) {
            System.out.println(i);
        }
    }

    static class  T_T  implements Runnable{

        @Override
        public void run() {
            for (int i = 100; i <= 200; i++) {
                System.out.println(i);
            }
        }
    }

    public static void main(String[] args) {


        T_ThreadTest test = new T_ThreadTest();
        Thread t2 = new Thread(new T_T());
        System.out.println(test.getState());

        test.start();
        t2.start();
        System.out.println(test.getState());

        try {
            t2.join();
            test.join();
        } catch (Exception e) {
            e.printStackTrace();
        }


        System.out.println(test.getState());

    }
}
