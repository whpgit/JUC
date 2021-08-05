package com.whp.ex_0725;

import com.whp.User;

import java.lang.ref.WeakReference;

/**
 * @Author: wanghp
 * @Date: 2021/7/25 5:33 下午
 * @Describe java引用有4种
 * 强、软、弱、虚
 * <p>
 * 弱引用只要gc就能被回收，那有什么用呢，一般用到容易，比如threadlocal  weakhashmap
 * @Version V1.0
 */
public class WeakReferenceTest {

    public static void main(String[] args) {
        WeakReference<User> weakReference = new WeakReference<>(new User());

        System.out.println(weakReference.get());
        System.gc();

        System.out.println(weakReference.get());


        //eg : 典型的使用threadLocal
        ThreadLocal<User> threadLocal = new ThreadLocal<>();
        threadLocal.set(new User());
        threadLocal.remove();


        //todo  threadLocalMap  就有可能内存泄漏 如果不是弱引用
        /**
         * 为什么Entry 要使用弱引用？
         * 如果是强引用，即使threadLocal 为null ，但key 的引用依赖会指向threadlocal对象
         * 而使用的弱引用则不会。
         *
         * 如果Key 为null  但是key 还是在，会导致内存泄漏
         * 但还是有内存泄漏，所以不使用的时候要remove掉
         */
        //
//        static class Entry extends WeakReference<ThreadLocal<?>> {
//            /** The value associated with this ThreadLocal. */
//            Object value;
//
//            Entry(ThreadLocal<?> k, Object v) {
//                super(k);
//                value = v;
//            }
//        }
    }
}
