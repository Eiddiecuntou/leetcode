package com.cuntou.动态规划.背包问题;

/**
 * @ClassName : _3_Knapsack01  //类名
 * @Description :   //描述
 * @Author : 村头 //作者
 * @Date: 2022/7/28  15:55
 */

public class _3_Knapsack01 {

    public int knapsack01(int[] w, int[] v, int C) {
        //1. 状态定义： dp[i][c] 表示从[0...i]中选取物品放入到容量为c的背包中的最大的价值
        int[][] dp = new int[w.length][C + 1];

        //2. 状态初始化：考虑将0号索引的东西放入背包中
        for (int c = 0; c <= C ; c++) {
            dp[0][c] = (c >= w[0] ? v[0] : 0);
        }

        //3.状态转移
        for (int i = 1; i < w.length; i++) {
            for (int c = 0; c <= C ; c++) {
                if (c < w[i]) {
                    dp[i][c] = dp[i - 1][c];
                } else {
                    dp[i][c] = Math.max(dp[i - 1][c] , v[i] + dp[i - 1][c - w[i]]);
                }
            }
        }
        //表示问题就是为了0 -n 号物品的最大值是什么？
        return dp[w.length - 1][C];
    }
}
