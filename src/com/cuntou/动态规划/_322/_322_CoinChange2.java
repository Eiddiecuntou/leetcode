package com.cuntou.动态规划._322;

/**
 * @ClassName : _322_CoinChange2  //类名
 * @Description :   //描述
 * @Author : 村头 //作者
 * @Date: 2022/7/24  19:38
 */

public class _322_CoinChange2 {
    //给你一个整数数组 coins ，表示不同面额的硬币；以及一个整数 amount ，表示总金额。
    //
    //计算并返回可以凑成总金额所需的 最少的硬币个数 。如果没有任何一种硬币组合能组成总金额，返回 -1 。
    //
    //你可以认为每种硬币的数量是无限的。
    //回溯
    public int coinChange (int[] c, int k) {
        return dfs(k,c);
    }

    private int dfs(int target, int[] c) {
        if (target == 0) return 0;

        int minCoins = Integer.MAX_VALUE;
        for (int i = 0; i < c.length ; i++) {
            if (target - c[i] < 0) continue;
            int subMinCoins = dfs(target -c[i], c);
            if (subMinCoins == -1) continue;
            minCoins = Math.min(minCoins, subMinCoins + 1);
        }
        return minCoins == Integer.MAX_VALUE ? -1 : minCoins;
    }
}
