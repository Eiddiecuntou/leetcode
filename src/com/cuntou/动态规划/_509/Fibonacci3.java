package com.cuntou.动态规划._509;

import java.util.Arrays;

/**
 * @ClassName : Fibonacci3  //类名
 * @Description :   //描述
 * @Author : 村头 //作者
 * @Date: 2022/7/24  11:55
 */

public class Fibonacci3 {
    public int fib(int n) {
        int[] memo = new int[n + 1];
        Arrays.fill(memo, -1);
        return dfs(n ,memo);
    }

    //时间复杂度
    private int dfs(int n ,int[] memo) {
        if (n == 0) return 0;
        if (n == 1) return 1;

        if (memo[n] != -1) {
            return memo[n];
        }
        int leftFib = dfs(n -1, memo);
        int rightFib = dfs(n -2, memo);

        memo[n] = leftFib + rightFib;

        return leftFib + rightFib;
    }

}
