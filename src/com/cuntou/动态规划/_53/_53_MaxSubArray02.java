package com.cuntou.动态规划._53;

/**
 * @ClassName : _53_MaxSubArray02  //类名
 * @Description :   //描述
 * @Author : 村头 //作者
 * @Date: 2022/7/25  10:01
 */
//时间复杂度 O（n ^ 2）
//空间复杂度 O（n ^ 2)
public class _53_MaxSubArray02 {
    //使用动态规划
    //状态的定义：dp[i][j] 表示的是到这个的累加值
    public int maxSubArray(int[] nums) {
        int[][] dp = new int[nums.length][nums.length];
        //状态初始化你……2
        dp[0][0] = nums[0];
        //状态转移方程
        //首先考虑第一行的
        //找到最大得了连续和
        int maxSum = dp[0][0];
        for (int i = 1; i < nums.length; i++) {
            //动态规划的首要转变的想法就是所有的值都是可以推导出来的
            //必须是由前面这个推导出来
            dp[0][i] = dp[0][i -1] + dp[0][i];
            maxSum = Math.max(maxSum, dp[0][i]);
        }

        //状态转移
        for (int i = 1; i < nums.length ; i++) {
            for (int j = i; j < nums.length ; j++) {
                //[i,j]
                dp[i][j] = dp[i-1][j] - dp[i -1][i -1];
                maxSum = Math.max(maxSum, dp[i][j]);
            }
        }
        return maxSum;
    }

}
