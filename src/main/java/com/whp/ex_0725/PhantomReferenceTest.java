package com.whp.ex_0725;

import com.whp.User;

import java.lang.ref.PhantomReference;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @Author: wanghp
 * @Date: 2021/7/25 6:03 下午
 * @Describe 堆外内存   -Xms20M -Xmx20M   虚引用，给写jvm 的人用  DirectByteBuffer
 * 你直接get不到的， 他会把垃圾回收的放到队列里    一旦虚引用被回收，会到这里，让你接收通知
 * @Version V1.0
 */
public class PhantomReferenceTest {
    static ReferenceQueue queue = new ReferenceQueue();

    static List<byte[]> List = new ArrayList<>();

    public static void main(String[] args) {
        /**
         * 疯狂填充到List 如果发生了溢出，会把
         */
        PhantomReference<User> phantomReference = new PhantomReference<>(new User(), queue);
        new Thread(() -> {
            while (true) {
                List.add(new byte[1024 * 1024]);
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(phantomReference.get());
            }
        }).start();


        new Thread(() -> {
            while (true) {
                //一旦虚引用被回收，会到这里，让你接收通知
                Reference poll = queue.poll();
                if (poll != null) {
                    System.out.println("虚引用被jvm 找到啦 : " + poll);
                }
            }
        }).start();

    }
}
