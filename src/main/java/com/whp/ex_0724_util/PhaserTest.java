package com.whp.ex_0724_util;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Phaser;
import java.util.concurrent.TimeUnit;

/**
 * @Author: wanghp
 * @Date: 2021/7/24 9:29 下午
 * @Describe
 * @Version V1.0
 */
public class PhaserTest extends Phaser {
    static Random random = new Random();

    public int[] twoSum(int[] nums, int target) {
        // [1,3,5]  8
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int other = target - nums[i];
            if (map.containsKey(other)) {
                return new int[]{i, map.get(other)};
            }
            map.put(nums[i], i); // 1->0
        }
        return new int[]{};

    }

    public static void main(String[] args) {



        ExecutorService executorService = Executors.newSingleThreadExecutor();


        Executors.newScheduledThreadPool(1);
        try {
            TimeUnit.SECONDS.sleep(2);
//            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("end");
    }
}
