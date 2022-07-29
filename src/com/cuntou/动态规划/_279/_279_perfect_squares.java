package com.cuntou.动态规划._279;

import java.util.Arrays;

/**
 * @ClassName : _279_perfect_squares  //类名
 * @Description : '  //描述
 * @Author : 村头 //作者
 * @Date: 2022/7/29  14:59
 */

public class _279_perfect_squares {
    /* 279. 完全平方数
    给定正整数 n，找到若干个完全平方数（比如 1, 4, 9, 16, ...）使得它们的和等于 n。
    你需要让组成和的完全平方数的个数最少。

    给你一个整数 n ，返回和为 n 的完全平方数的 最少数量 。

    完全平方数 是一个整数，其值等于另一个整数的平方；
    换句话说，其值等于一个整数自乘的积。
    例如，1、4、9 和 16 都是完全平方数，而 3 和 11 不是。

    示例 1：
    输入：n = 12
    输出：3
    解释：12 = 4 + 4 + 4

    示例 2：
    输入：n = 13
    输出：2
    解释：13 = 4 + 9
     
    提示：
    1 <= n <= 10^4

     */
    //完全平方数最小为1，最大的话是为sqrt(n)
    // 也就是我们要从 nums = [1, 2, ..., sqrt(n)] 数组里选出几个数，
    // 令其平方和为 n(背包容量)。求最少的完全平方数
    public int numSquares(int n) {
        int[] dp = new int[n + 1];

        Arrays.fill(dp,Integer.MAX_VALUE);
        //组成这些的完全平方数
        dp[0] = 0;

        for (int i = 1; i <= Math.sqrt(n) ; i++) {
            for (int c = i * i; c <= n ; c++) {
                dp[c] = Math.min(dp[c], dp[n - i * i] + 1 );
            }
        }
        return dp[n];

    }
}
