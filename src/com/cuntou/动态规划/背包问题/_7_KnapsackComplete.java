package com.cuntou.动态规划.背包问题;

/**
 * @ClassName : _7_KnapsackComplete  //类名
 * @Description :   //描述
 * @Author : 村头 //作者
 * @Date: 2022/7/28  17:49
 */

public class _7_KnapsackComplete {
    //1.状态定义：dp[i][c] 表示从[0...i]的选取物品的放入容量为c的背包中的最大价值】
    public int knapsack01(int[] w, int[] v, int C) {
        int[][] dp = new int[w.length][ C + 1];

        //2.状态初始化 首先要考虑将0好的物品放进去
        for (int c = 0; c <= C ; c++) {
            dp[0][c] = (c / w[0]) * v[0];
        }
        
        //3.状态转移
        //4.在这种情况下的时候，不需要考虑他是否需要从左往右或者从右往左
        for (int i = 1; i < w.length ; i++) {
            for (int c = 0; c <= C ; c++) {
                int count = c / w[i];
                for (int k = 0; k <= count ; k++) {
                    dp[i][c] = Math.max(dp[i][c], k * v[i] + dp[i - 1][c - k * w[i]]);
                }
            }
        }
        return dp[w.length - 1][C];
        

    }
}
