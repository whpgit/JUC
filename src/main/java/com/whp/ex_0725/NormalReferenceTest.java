package com.whp.ex_0725;

import com.whp.User;

import java.io.IOException;

/**
 * @Author: wanghp
 * @Date: 2021/7/25 5:36 下午
 * @Describe
 * @Version V1.0
 */
public class NormalReferenceTest {

    public static void main(String[] args) throws IOException {
        User user = new User();
        user = null;
        System.gc();
        System.in.read();//阻塞当前线程，让垃圾去回收

    }
}
