package com.whp.ex_0801;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.locks.LockSupport;

/**
 * @Author: wanghp
 * @Date: 2021/8/1 上午8:45
 * @Describe
 * @Version V1.0
 */
public class ParallelStreamAPI {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4);
        try {
            LockSupport.park();//把自己阻塞住
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("end...");
        list.parallelStream();
    }
}
