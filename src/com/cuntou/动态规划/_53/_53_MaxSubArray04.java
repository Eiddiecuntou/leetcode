package com.cuntou.动态规划._53;

/**
 * @ClassName : _53_MaxSubArray04  //类名
 * @Description :   //描述
 * @Author : 村头 //作者
 * @Date: 2022/7/25  14:43
 */

public class _53_MaxSubArray04 {
    // 动态规划
    public int maxSubArray(int[] nums) {
        //1.状态定义 ： dp[i][j] 表示累加和
        int[][] dp = new int[nums.length][nums.length];
        //2.状态初始化
        dp[0][0] = nums[0];
        int maxSum = dp[0][0];
        for (int i = 1; i < nums.length ; i++) {
            dp[0][i] = dp[0][i - 1] + nums[i];
            maxSum = Math.max(maxSum, dp[0][i]);
        }
        //状态转移
        for (int i = 1; i < nums.length ; i++) {
            for (int j = i; j < nums.length ; j++) {
                //[i,j]
                dp[i][j] = dp[0][j] - dp[0][i -1];
                maxSum = Math.max(maxSum, dp[i][j]);

            }
        }
        return maxSum;
    }
}
