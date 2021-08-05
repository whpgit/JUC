package com.whp.ex_0724;

import org.openjdk.jol.info.ClassLayout;

/**
 * @Author: wanghp
 * @Date: 2021/7/24 9:53 上午
 * @Describe
 * @Version V1.0
 */
public class T0724 {

    void print() {
        System.out.println("this is print");
    }

    public static void main(String[] args) throws InterruptedException {
        T0724 t0724 = new T0724();
        new Thread(t0724::print).start();

        // TimeUnit.SECONDS.sleep(5);   //如果不加vm或者不加睡眠，则对象头为001，
        //TODO 在倒数第3个 bit 位上，结合之前的结构信息图可以发现倒数第三个 bit 位上是用来区分是否是偏向锁标志位的，1 代表可偏向状态，0 代表不可偏向状态。
        Integer a = null;
        Object o = new Object();
        System.out.println(ClassLayout.parseInstance(o).toPrintable());
        System.out.println("打印对象o 的hashCode:" + Integer.toBinaryString(o.hashCode()));
        synchronized (o) {
            System.out.println(ClassLayout.parseInstance(o).toPrintable());
        }
    }
}

