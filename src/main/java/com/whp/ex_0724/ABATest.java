package com.whp.ex_0724;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * @Author: wanghp
 * @Date: 2021/7/24 3:54 下午
 * @Describe
 * @Version V1.0
 *    // 带版本号解决ABA问题
 *         AtomicStampedReference aba = new AtomicStampedReference(1,1);
 */
public class ABATest {

    public static void main(String[] args) {
        AtomicStampedReference aba = new AtomicStampedReference(1,1);
     //如果是基础数据类型无所谓，引用数据类型，
        aba.compareAndSet(1,2,1,2);
        System.out.println(aba.getReference());

        AtomicInteger atomicInteger = new AtomicInteger(1);
        atomicInteger.getAndIncrement();
        System.out.println(atomicInteger.get());

    }
}
