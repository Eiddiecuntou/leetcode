package com.cuntou.动态规划.零钱问题;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @ClassName : _322_coin_change  //类名
 * @Description :   //描述
 * @Author : 村头 //作者
 * @Date: 2022/7/29  11:34
 */

public class _322_coin_change {
    /* 322. 零钱兑换
    给你一个整数数组 coins ，表示不同面额的硬币；以及一个整数 amount ，表示总金额。

    计算并返回可以凑成总金额所需的 最少的硬币个数 。
    如果没有任何一种硬币组合能组成总金额，返回 -1 。

    你可以认为每种硬币的数量是无限的。

    示例 1：
    输入：coins = [1, 2, 5], amount = 11
    输出：3
    解释：11 = 5 + 5 + 1

    示例 2：
    输入：coins = [2], amount = 3
    输出：-1

     */
    //转换成完全背包问题
    //从coins列表中可重复选择最少数量的硬币
    public int coinChange(int[] coins, int amount) {
        // 1. 状态定义：dp[c] : 表示凑齐总金额为 c 的时候需要的最小硬币数
        int[] dp = new int[amount + 1];

        // 2. 状态初始化
        // bug 修复：这里不能使用 Integer.MAX_VALUE，
        // 因为计算下面的 1 + dp[c - coins[i]] 时候，如果 dp[c - coins[i]] = Integer.MAX_VALUE 的话
        // 那么 1 + dp[c - coins[i]] 会溢出
        Arrays.fill(dp,amount + 1);
        // 凑齐总金额为 0 的时候需要的最小硬币数就是不取硬币
        dp[0] = 0;

        //3.状态转移
        for (int i = 0; i < coins.length ; i++) {
            for (int c = coins[i]; c <= amount ; c++) {
                dp[c] = Math.max(dp[i], dp[c - coins[i]]);
            }
        }

        return dp[amount] == amount + 1 ? -1 : dp[amount];
    }
}
