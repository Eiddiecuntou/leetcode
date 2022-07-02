package com.cuntou.排序算法;

/**
 * @ClassName : _327_count_of_range_sum  //类名
 * @Description :   //描述
 * @Author : 村头 //作者
 * @Date: 2022/5/31  21:53
 */

public class _327_count_of_range_sum {
    //最简单的去使用暴力解法
    public int countRangeSum(int[] nums, int lower, int upper) {
        int count = 0;
        for (int i = 0; i < nums.length ; i++) {
            for (int j = i; j < nums.length ; j++) {
                //long
                long sum = 0;
                for (int k = i; k <= j ; k++) {
                    sum += nums[k];
                }
                if (sum <= upper && sum >= lower) {
                    count++;
                }
            }

        }
        return count;
    }

}
