package com.cuntou.动态规划.背包问题;

/**
 * @ClassName : _11_KnapsackCost  //类名
 * @Description :   //描述
 * @Author : 村头 //作者
 * @Date: 2022/7/29  15:23
 */

public class _11_KnapsackCost {
    public int knapsack_1(int[] w, int[] g,int W, int G, int[] v){
        //dp[i][j]:表示选择物品的时候需要付出两种代价为 i 和 j 时可以获得的最大值
        int[][] dp = new int[W + 1][ G + 1];

        for (int i = 0; i < w.length ; i++) {
            for (int j = W; j >= w[i] ; j--) {
                for (int k = G; k >= g[i] ; k--) {
                    dp[j][k] = Math.max(dp[j][k], dp[j - w[i]][k - g[i]] + v[i]);
                }
            }
        }
        return dp[W][G];
    }
}
