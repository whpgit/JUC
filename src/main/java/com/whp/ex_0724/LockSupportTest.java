package com.whp.ex_0724;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

/**
 * @Author: wanghp
 * @Date: 2021/7/24 10:45 下午
 * @Describe
 * @Version V1.0
 */
public class LockSupportTest {

    public static void main(String[] args) {

        Thread thread = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                System.out.println(i);
                if (i == 6) {
                    LockSupport.park();//这里停了
                }
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        //加了这个就好玩了，他可以先调，即便后面park了，还是可以继续执行...
//        LockSupport.unpark(thread);
        thread.start();


        try {
            TimeUnit.SECONDS.sleep(3);

            LockSupport.unpark(thread);//叫醒  这里可以叫醒指定的线程 贼吊
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
