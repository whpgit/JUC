package com.whp.ex_0729;

import java.util.concurrent.LinkedTransferQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TransferQueue;

/**
 * @Author: wanghp
 * @Date: 2021/7/29 下午11:04
 * @Describe
 * @Version V1.0
 */
public class TransferQueueTest {

    public static void main(String[] args) {
        TransferQueue<String> transferQueue = new LinkedTransferQueue<>();

        new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(5);
                String take = transferQueue.take();
                System.out.println(take);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        try {
            transferQueue.transfer("aa"); //有人取走了这个线程才会走，跟其他Queue最大区别
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("有人取走了");

    }
}
