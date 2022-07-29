package com.cuntou.动态规划._509;

/**
 * @ClassName : Fibonacci5  //类名
 * @Description :   //描述
 * @Author : 村头 //作者
 * @Date: 2022/7/24  13:32
 */

public class Fibonacci5 {
    //动态规划的四个步骤
    //1.定义状态数组，dp[i] 代表的是数字 i 的斐波那契数
    public int fib(int n) {
        if (n <= 1) return n;

        int[] dp = new int[n + 1];

        //2.状态初始化
        dp[0] = 0;
        dp[1] = 1;

        //3.状态转移
        for (int i = 2; i < n ; i++) {
            dp[i] = dp[i -1] + dp[i -2];
        }

        //4.返回最终需要的状态值
        return dp[n];
    }

}
