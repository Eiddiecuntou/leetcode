package com.cuntou.动态规划.背包问题;

/**
 * @ClassName : _5_Knapsack01  //类名
 * @Description :   //描述
 * @Author : 村头 //作者
 * @Date: 2022/7/28  17:15
 */

public class _5_Knapsack01 {

    public int knapsack01(int[] w, int[] v, int C) {
        //1.状态定义：dp[c]：将物品放入容量为c的背包中的产生的最大价值
        int[] dp = new int[C + 1];

        //2.状态初始化

        //3.状态转移
        for (int i = 0; i < w.length ; i++) {
            for (int c = C; c >= w[i] ; c--) {
                dp[c] = Math.max(dp[c], v[i] + dp[c - w[i]]);
            }
        }
        return dp[C];


    }
}
