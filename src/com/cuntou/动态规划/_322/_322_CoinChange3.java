package com.cuntou.动态规划._322;

import java.util.Arrays;

/**
 * @ClassName : _322_CoinChange3  //类名
 * @Description :   //描述
 * @Author : 村头 //作者
 * @Date: 2022/7/24  19:58
 */

public class _322_CoinChange3 {
    public int coinChange(int[] c,int k) {
        int[] memo = new int[ k + 1];
        Arrays.fill(memo, Integer.MAX_VALUE);
        return dfs(k, c, memo);
    }

    //计算返回凑成总金额target需要的最少的硬币数
    private int dfs(int target, int[] c, int[] memo) {
        if (target == 0) {
            return 0;
        }
        if (memo[target] != Integer.MAX_VALUE) {
            return memo[target];
        }
        int minCoins = Integer.MAX_VALUE;
        for (int i = 0; i < c.length ; i++) {
            if (target - c[i] < 0) continue;
            int subMinCoins = dfs(target - c[i], c ,memo);
            if (subMinCoins == -1) continue;
            minCoins = Math.min(minCoins, subMinCoins + 1);
        }
        memo[target] = minCoins == Integer.MAX_VALUE ? -1 : minCoins;
        return memo[target];
    }
}
