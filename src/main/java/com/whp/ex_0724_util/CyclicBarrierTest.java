package com.whp.ex_0724_util;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;

/**
 * @Author: wanghp
 * @Date: 2021/7/24 7:15 下午
 * @Describe 如果缓冲数量不够5个线程则阻塞住，直到放满
 *
 * 3.CyclicBarrier 使用场景
 *
 * 可以用于多线程计算数据，最后合并计算结果的场景。
 *
 * 4. CyclicBarrier 与 CountDownLatch 区别
 *
 * CountDownLatch 是一次性的，CyclicBarrier 是可循环利用的
 * CountDownLatch 参与的线程的职责是不一样的，有的在倒计时，有的在等待倒计时结束。CyclicBarrier 参与的线程职责是一样的。
 *
 * 作者：一团捞面
 * 链接：https://www.jianshu.com/p/333fd8faa56e
 * 来源：简书
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 * @Version V1.0
 */
public class CyclicBarrierTest {

    static void insert(CyclicBarrier cyclicBarrier) {
        for (int i = 0; i < 4; i++) {
            new Thread(() -> {
                try {
                    System.out.println("这是另外一个线程往里面塞数据");
                    //如果不够，就一直等着
                    cyclicBarrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }

    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(5, () -> System.out.println("满了"));

        for (int i = 0; i < 21; i++) {
            new Thread(() -> {
                try {
                    //如果不够，就一直等着
                    cyclicBarrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }).start();
        }

        try {
            //本地休眠6秒
            TimeUnit.SECONDS.sleep(6);
            new Thread(() -> insert(cyclicBarrier)).start();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
