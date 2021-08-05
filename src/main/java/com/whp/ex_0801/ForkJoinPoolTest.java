package com.whp.ex_0801;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

/**
 * @Author: wanghp
 * @Date: 2021/8/1 上午8:26
 * @Describe
 * @Version V1.0
 */
public class ForkJoinPoolTest {

    public static void main(String[] args) {
        System.out.println("核心数：" + Runtime.getRuntime().availableProcessors());
        AddTaskReturn addTaskReturn = new AddTaskReturn();
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        forkJoinPool.submit(new AddTaskReturn());
    }

    static class AddTaskReturn extends RecursiveTask<Long> {
        int start;
        int end;
        int MAX_NUM = 10;

        @Override
        protected Long compute() {
            int sum = 0;
            if (end - start <= MAX_NUM) {

                for (int i = start; i <= end; i++) {
                    sum +=i;
                }
            }else {
                //进行切割
                int middle = (start+end) / 2;


            }
            AddTaskReturn task1 = new AddTaskReturn();
            AddTaskReturn task2 = new AddTaskReturn();

            return task1.join() + task2.join();
        }
    }
}
