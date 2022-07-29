package com.cuntou.动态规划._322;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName : _322_CoinChange1  //类名
 * @Description :   //描述
 * @Author : 村头 //作者
 * @Date: 2022/7/24  9:54
 */

public class _322_CoinChange1 {

    //回溯
    private int minCoins = Integer.MAX_VALUE;
    //时间复杂度是指数级别的
    public int coinChange(int[] c,int k) {
        //1.回溯穷举所有的硬币组合
        dfs(k, c, new ArrayList<>());
        return minCoins == Integer.MAX_VALUE ? -1 : minCoins;
    }

    private void dfs(int target, int[] c,
                     List<Integer> coins) {
        if (target == 0) {
            minCoins = Math.min(minCoins, coins.size());

        }
        for (int i = 0; i < c.length ; i++) {
            if (target - c[i] < 0) continue;
            coins.add(c[i]);
            dfs(target - c[i], c, coins);
            coins.remove(coins.size() - 1);
        }
    }

}
