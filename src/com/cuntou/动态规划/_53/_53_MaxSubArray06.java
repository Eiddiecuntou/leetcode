package com.cuntou.动态规划._53;

/**
 * @ClassName : _53_MaxSubArray06  //类名
 * @Description :   //描述
 * @Author : 村头 //作者
 * @Date: 2022/7/25  15:01
 */

public class _53_MaxSubArray06 {
    //更改状态的定义，之前一直使用的都是我们将前缀和而不是使用的是考虑直接的和
    public int maxSubArray(int[] nums) {
        //状态的定义：dp[i]表示以索引为I的元素结尾的之前最大的子数组的和
        //找到前面的最大和，后面的直接去加就直接知道了
        int[] dp =new int[nums.length];

        //状态初始化
        dp[0] = nums[0];
        int maxSum = dp[0];
        //状态转移
        for (int i = 1; i < nums.length ; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i] ,nums[i]);
            maxSum = Math.max(maxSum, dp[i]);
        }
        return maxSum;
    }
}
