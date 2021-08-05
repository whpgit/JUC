package com.whp.ex_0724;

import com.whp.User;

import java.util.Random;

/**
 * @Author: wanghp
 * @Date: 2021/7/24 1:04 下午
 * @Describe
 * @Version V1.0
 */
public class DoubleSync {
    private static User user;

    private DoubleSync() {
    }

    public static User getInstance() {

        if (user == null) {
//            synchronized (DoubleSync.class) {
//                if(user==null){

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            user = new User();
            user.setAge(new Random().nextInt(10));
//                }
            }
//        }
        System.out.println(user.hashCode());
        return user;

    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                System.out.println(DoubleSync.getInstance().getAge());
            }).start();

        }
//        User user = new User();
//        User user1 = new User();
//        System.out.println(user.hashCode());
//        System.out.println(user1.hashCode());
    }

}
