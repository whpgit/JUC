package com.whp.ex_0801;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author: wanghp
 * @Date: 2021/8/1 上午8:26
 * @Describe
 * @Version V1.0
 */
public class WorkStealingTest {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newWorkStealingPool();
    }
}
