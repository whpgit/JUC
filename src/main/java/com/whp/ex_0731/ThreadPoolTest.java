package com.whp.ex_0731;

import java.io.IOException;
import java.util.concurrent.*;

/**
 * @Author: wanghp
 * @Date: 2021/7/31 下午2:12
 * @Describe
 * @Version V1.0
 */
public class ThreadPoolTest {

    public static void main(String[] args) {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(2, 4,
                60, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>(4),
                Executors.defaultThreadFactory(), new MyRejectedExecutionHandler());

        // 使用自定义的拒绝策略  4+1main+
        for (int i = 0; i < 10; i++) {
            int finalI = i;
            executor.submit(() -> {
                System.out.println("任务" + finalI + "start");
                try {
                    System.in.read();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        }
        //TODO 如果main 线程被安排去执行了，这里就不会走了` 很奇怪，研究下
        System.out.println(executor.isShutdown());
        System.out.println(executor.getQueue().size());
    }

}
