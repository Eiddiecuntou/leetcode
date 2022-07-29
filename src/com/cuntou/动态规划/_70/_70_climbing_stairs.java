package com.cuntou.动态规划._70;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @ClassName : _70_climbing_stairs  //类名
 * @Description :   //描述
 * @Author : 村头 //作者
 * @Date: 2022/7/27  9:41
 */

public class _70_climbing_stairs {
      /* 70. 爬楼梯
    假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
    每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
    注意：给定 n 是一个正整数。

    示例 1：
    输入： 2
    输出： 2
    解释： 有两种方法可以爬到楼顶。
    1.  1 阶 + 1 阶
    2.  2 阶

    示例 2：
    输入： 3
    输出： 3
    解释： 有三种方法可以爬到楼顶。
    1.  1 阶 + 1 阶 + 1 阶
    2.  1 阶 + 2 阶
    3.  2 阶 + 1 阶
     */
    public int climbStairs1(int n) {
        return dfs(n);
    }
    private int dfs(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;

        int left = dfs(n - 1);
        int right = dfs(n - 2);

        return left + right;
    }

    //记忆化搜索 + DFS
    public int climbStairs2(int n) {
        int[] memo = new int[n + 1];
        Arrays.fill(memo, -1);
        return dfs1(n, memo);
    }

    private int dfs1(int n, int[] memo) {
        if (n == 1) return 1;
        if (n == 2) return 2;

        if (memo[n] != -1) return memo[n];

        int left = dfs1(n - 1, memo);
        int right = dfs1(n -2, memo);

        memo[n] = left + right;
        return memo[n];
    }

    //动态规划
    public int climbStairs3(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;

        //1.dp[i] : 定义状态数组，来表示走到第一个台阶的方法数
        int[] dp = new int[n + 1];

        //2.状态初始化
        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i <= n ; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        //找到n个数字的返回结果

        return dp[n];
    }
}
