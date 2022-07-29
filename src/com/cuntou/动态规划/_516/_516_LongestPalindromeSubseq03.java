package com.cuntou.动态规划._516;

/**
 * @ClassName : _516_LongestPalindromeSubseq03  //类名
 * @Description :   //描述
 * @Author : 村头 //作者
 * @Date: 2022/7/26  10:14
 */

public class _516_LongestPalindromeSubseq03 {
    //动态规划
    public int longestPalindromeSubseq(String s) {
        if (s == null || s.length() == 0) return 0;
        int m = s.length();

        //状态数组： dp[i][j] 表示在区间[i ...j]的最长回文子序列的长度
        int[][] dp = new int[m][m];
        for (int i = 0; i < m; i++) {
            dp[i][i] = 1;
        }

        for (int i = m - 2; i >= 0; i--) {
            for (int j = i + 1; j < m; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = 2 + dp[i + 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[0][m - 1];

    }
}
