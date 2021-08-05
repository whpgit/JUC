package com.whp.ex_0731;

import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @Author: wanghp
 * @Date: 2021/7/31 下午2:22
 * @Describe
 * @Version V1.0
 */
public class MyRejectedExecutionHandler implements RejectedExecutionHandler {
    @Override
    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
        System.out.println(Thread.currentThread().getName() + "这是我自定义的拒绝策略，可以放到redis人工进行干预");
        if (!executor.isShutdown()) {
            // 和callerrunPolicy 用当前线程来执行 main 线程
            r.run();
        }
    }
}
