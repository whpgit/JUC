package com.whp.ex_0725;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author: wanghp
 * @Date: 2021/7/25 1:21 下午
 * 1、 为什么添加Node 要用CAS ?
 * A:要保证线程安全，如果用sync锁住整个链表就太大了，CAS只需要关心oldTail节点就行。
 * 2、为什么是双向链表
 * A:需要看前面节点的状态
 *
 * @Version V1.0
 */
public class LockTest {

    public static void main(String[] args) {
        Lock lock = new ReentrantLock();
        lock.lock();
    }
}
