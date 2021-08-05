package com.whp.ex_0726;

import java.util.concurrent.ConcurrentSkipListMap;

/**
 * @Author: wanghp
 * @Date: 2021/7/27 10:20 上午
 * @Describe
 * @Version V1.0
 */
public class ConcurrentHashMapTest {

    public static void main(String[] args) {
        ConcurrentSkipListMap<String, Object> skipListMap = new ConcurrentSkipListMap<>();
        skipListMap.put("", "");
    }
}
