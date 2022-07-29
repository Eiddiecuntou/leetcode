package com.cuntou.动态规划.背包问题;

/**
 * @ClassName : _9_KnapsackComplete  //类名
 * @Description :   //描述
 * @Author : 村头 //作者
 * @Date: 2022/7/29  8:48
 */

public class _9_KnapsackComplete {
    public int knapsack01(int[] w, int[] v, int C) {
        //1.状态定义： dp[c] 将物品放入容器为c的背包中产生的最大值
        int[] dp = new int[C + 1];

        //2.状态初始化

        //3.状态转移
        for (int i = 0; i < w.length ; i++) {
            for (int c = w[i]; c <= C ; c++) {
                //在运算的时候，得出第一个物品产生的价值要远大于等于第2,3.。。。个
                // 如果放第一个物品产生的价值比不放这个物品产生的价值要小的话
                // 那么不放物品，产生的价值最大
                dp[c] = Math.max(dp[c], v[i] + dp[c - w[i]]);

            }
        }
        return dp[C];
    }
}
