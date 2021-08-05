package com.whp.ex_0725;

import com.whp.User;

import java.util.concurrent.TimeUnit;

/**
 * @Author: wanghp
 * @Date: 2021/7/25 5:18 下午
 * @Describe
 * @Version V1.0
 */
public class ThreadLocalTest {

    public static void main(String[] args) {
        ThreadLocal<User> threadLocal = new ThreadLocal<>();
        threadLocal.remove();
        threadLocal.set(new User() {{
            setUserName("wanghaiping");
        }});

        Thread t1 = new Thread(() -> {
            threadLocal.set(null);
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("t1"+threadLocal.get());
        });
        Thread t2 = new Thread(() -> {
            System.out.println("t2"+threadLocal.get());

        });


        t1.start();
        t2.start();
        System.out.println("主线程"+threadLocal.get());

    }
}
