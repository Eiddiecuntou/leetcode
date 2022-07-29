package com.cuntou.动态规划._644;

import java.util.Arrays;

/**
 * @ClassName : _64_MinPathSum2  //类名
 * @Description :   //描述
 * @Author : 村头 //作者
 * @Date: 2022/7/24  21:24
 */

public class _64_MinPathSum4 {
    public int minPathSum(int[][] grid) {
       int m = grid.length;
       int n = grid[0].length;
       //状态定义：dp[i][j],表示从坐标（i，j)到右下角的最小路径和
        int[][] dp = new int[m][n];
        //状态初始化：
        //找到状态的最后一个值
        dp[m - 1][n -1] = grid[m - 1][n - 1];

        //状态转移
        for (int i = m -1 ; i >= 0 ; i--) {
            for (int j = n - 1; j >= 0 ; j--) {
                //找出最后一行先
                 if (i == m - 1 && j != n - 1) {
                     dp[i][j] = grid[i][j] + dp[i][j + 1];
                 } else if (i != m - 1 && j == n - 1) {
                     dp[i][j] = grid[i][j] + dp[i + 1][j];
                  } else if (i != m - 1 && j != n - 1) {
                     dp[i][j] = grid[i][j] + Math.min(dp[i + 1][j],dp[i][j + 1]);
                 }
            }

        }
        //返回结果
        return dp[0][0];

    }
    public static void main(String[] args) {
        int[][] grid = {
                {1, 3, 1},
                {1, 5, 1},
                {4, 2, 1}
        };
        System.out.println(new _64_MinPathSum4().minPathSum(grid));
    }
}
