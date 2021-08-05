package com.whp.functioninterface;

/**
 * @Author: wanghp
 * @Date: 2021/7/25 8:14 下午
 * @Describe
 * @Version V1.0
 */
@FunctionalInterface
public interface Fun<T, R> {

    R get(T t);
}
