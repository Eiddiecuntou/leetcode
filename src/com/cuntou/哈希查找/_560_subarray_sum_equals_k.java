package com.cuntou.哈希查找;

/**
 * @ClassName : _560_subarray_sum_equals_k  //类名
 * @Description :   //描述
 * @Author : 村头 //作者
 * @Date: 2022/6/20  10:11
 */

public class _560_subarray_sum_equals_k {
    /* leetcode 560 号算法题：和为K的子数组

       给定一个整数数组和一个整数 k，
       你需要找到该数组中和为 k 的连续的子数组的个数。

       输入:nums = [1,1,1], k = 2
       输出: 2

       输入:nums = [0,1,-1,1,1,2], k = 0
       输出: 4

        - 数组的长度为 [1, 20,000]。
        - 数组中元素的范围是 [-1000, 1000] ，且整数 k 的范围是 [-1e7, 1e7]。
     */
    // 暴力解法
    public int subarraySum1(int[] nums, int k) {
        int res = 0;
        for (int i = 0; i < nums.length ; i++) {
            for (int j = i; j < nums.length ; j++) {
                int sum = 0;
                for (int m = i; m <= j  ; m++) {
                    sum += nums[m];
                }
                if (sum == k) res++;
            }
        }
        return res;
    }
    //使用的就是前缀和来进行优化
    public int subarraySum2(int[] nums, int k) {
        int[] prefixSum = new int[nums.length + 1];
        prefixSum[0] = 0;
        for (int i = 1; i <= nums.length; i++) {
            prefixSum[i] = prefixSum[i - 1] + nums[i -1];
        }

        int res = 0;
        for (int i = 0; i <= nums.length; i++) {
            int diff = prefixSum[i] - k;
            for (int j = 0; j < i; j++) {
                if (prefixSum[j] == diff) res++;
            }
        }
        return res;
    }

}
