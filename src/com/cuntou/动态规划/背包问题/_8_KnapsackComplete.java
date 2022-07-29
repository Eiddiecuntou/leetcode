package com.cuntou.动态规划.背包问题;

/**
 * @ClassName : _8_KnapsackComplete  //类名
 * @Description :   //描述
 * @Author : 村头 //作者
 * @Date: 2022/7/29  8:41
 */

public class _8_KnapsackComplete {

    public int knapsack01(int[] w, int[] v, int C) {
        //1.状态定义 ： dp[c]将物品放入到容器为c的背包中产生的最大价值
        int[] dp = new int[C + 1];

        //2.状态初始化，考虑将第0号元素放到背包中
        for (int c = 0; c <= C ; c++) {
            dp[c] = (c / w[0]) * v[0];
        }

        //3.状态转移
        for (int i = 1; i < w.length ; i++) {
            for (int c = 0; c <= C ; c++) {
                int count = c / w[i];
                //这样做的时候，会导致如果是中间的值是最大的话，会被覆盖掉
                //因为他完全依赖之前的值，而之前的值没有存储起来只会一直被覆盖
                for (int k = 0; k <= count ; k++) {
                    dp[c] = Math.max(dp[c], k * v[i] + dp[c - k * w[i]] );
                }
            }
        }
        return dp[C];
    }
}
