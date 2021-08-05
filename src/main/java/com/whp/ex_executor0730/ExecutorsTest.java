package com.whp.ex_executor0730;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author: wanghp
 * @Date: 2021/7/30 下午11:09
 * @Describe
 * @Version V1.0
 */
public class ExecutorsTest {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
    }
}
