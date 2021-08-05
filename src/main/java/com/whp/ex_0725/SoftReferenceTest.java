package com.whp.ex_0725;

import java.lang.ref.SoftReference;
import java.util.concurrent.TimeUnit;

/**
 * @Author: wanghp
 * @Date: 2021/7/25 5:42 下午
 * @Describe 软引用
 * @Version V1.0
 */
public class SoftReferenceTest {
    public static void main(String[] args) {
        SoftReference<byte[]> softReference = new SoftReference<>(new byte[1024*1024*10]);
        System.out.println(softReference.get());



        System.gc();
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(softReference.get());

        byte[] b = new byte[1024*1024*10];

        System.out.println(softReference.get());
    }
}
