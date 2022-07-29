package com.cuntou.动态规划._300;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @ClassName : _300_LengthOfLongestIncrementSubSeq  //类名
 * @Description :   //描述
 * @Author : 村头 //作者
 * @Date: 2022/7/26  10:56
 */

public class _300_LengthOfLongestIncrementSubSeq {
    //给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。
    //子序列 是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子序列。
    public int lengthOfLTS(int[] nums) {
         if (nums == null || nums.length == 0) return 0;
         int maxLen = 1;

         //状态数组：dp[i]表示nums[i]结尾时最长递增子序列的长度
        int[] dp = new int[nums.length];
        //状态初始化：每个单个元素最少有一个递增的子序列
        Arrays.fill(dp, 1);

        //状态转移方程
        for (int i = 1; i < nums.length ; i++) {
            for (int j = 0; j < i ; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                    maxLen = Math.max(maxLen, dp[i]);
                }
            }
        }
        return maxLen;
    }
 }
