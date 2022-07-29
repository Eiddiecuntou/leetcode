package com.cuntou.动态规划.背包问题;

/**
 * @ClassName : _4_Knapsack01  //类名
 * @Description :   //描述
 * @Author : 村头 //作者
 * @Date: 2022/7/28  16:48
 */

public class _4_Knapsack01 {

    public int knapsack01(int[] w, int[] v, int C) {
        //1.状态定义：dp[c]：将物品放入到容量C的背包中的产生的最大值
        int[] dp = new int[C + 1];

        //2.状态初始化
        //考虑将第0号物品放入到背包中
        for (int c = 0; c <= C ; c++) {
            dp[c] = (c >= w[0] ? v[0] : 0);
        }

        //3.状态转移
        for (int i = 0; i < w.length ; i++) {
            for (int c = C; c >= w[i] ; c--) {
                dp[c] = Math.max(dp[c], v[i] + dp[c - w[i]]);
            }
        }
        return dp[C];

    }
}
