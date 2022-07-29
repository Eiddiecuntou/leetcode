package com.cuntou.动态规划.背包问题;

/**
 * @ClassName : _3_Knapsack01_bak  //类名
 * @Description :   //描述
 * @Author : 村头 //作者
 * @Date: 2022/7/28  16:19
 */

public class _3_Knapsack01_bak {

    public int knapscak01(int[] w, int[] v, int C) {
        //1.状态定义：dp[i][c] 表示从[0....i]中选出物品放入到容量c中的最大的价值
        int[][] dp = new int[w.length][ C + 1];

        //2.初始化
        for (int c = 0; c <= C ; c++) {
            dp[0][c] = (c >= w[0] ? v[0] : 0);
        }

        //3.状态转移
        for (int i = 1; i < w.length ; i++) {
            for (int c = 0; c <= C ; c++) {
                int count = c >= w[i] ? 1 : 0;
                for (int k = 0; k <= count ; k++) {
                    dp[i][c] = Math.max(dp[i - 1][c], k * v[i] + dp[i -1][c - k*w[i]]);
                }
            }
        }

        return dp[w.length - 1][C];
    }
}
