package com.whp.ex_0729;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * @Author: wanghp
 * @Date: 2021/7/29 下午11:07
 * @Describe
 * @Version V1.0
 */
public class LinkBlockQueueTest {
    public static void main(String[] args) {
        LinkedBlockingQueue<String> linkedBlockingQueue = new LinkedBlockingQueue<>(1);

        new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(5);
                String take = linkedBlockingQueue.take();
                System.out.println(take);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        try {
            linkedBlockingQueue.put("");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        linkedBlockingQueue.add("aa");//添加不进报错
        boolean isAdd = linkedBlockingQueue.offer("bb");//添加不进报错
        System.out.println(isAdd);
        System.out.println("放的线程走了"); // transferqueue最大区别

    }
}
