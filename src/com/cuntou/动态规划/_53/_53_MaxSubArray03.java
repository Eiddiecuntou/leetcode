package com.cuntou.动态规划._53;

/**
 * @ClassName : _53_MaxSubArray03  //类名
 * @Description :   //描述
 * @Author : 村头 //作者
 * @Date: 2022/7/25  11:29
 */

public class _53_MaxSubArray03 {
    //找出最大的值
    //之前想的是用二维数组来表示，但是可以发现其实可以由第一行的数组表示出来
    public int maxSubArray(int[] nums) {
        //之前是用的二维数组来进行存储东西，有点觉得麻烦，所以该使用一维数组，
        // 而一维数组其实使用的就是简单的前缀和来进行换成动态规划
        //状态定义 ： dp[i]表示的是子数组[0,j]的累加和
        int[] dp = new int[nums.length];
        //状态初始化
        dp[0] = nums[0];
        int maxSum = dp[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = dp[i - 1] + nums[i];
            maxSum = Math.max(maxSum, dp[i]);
        }
        // 状态转移

        for (int i = 1; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                // [i, j]
                dp[j] = dp[j] - dp[i - 1];
                maxSum = Math.max(maxSum, dp[j]);
            }
        }
        return maxSum;
    }
}
