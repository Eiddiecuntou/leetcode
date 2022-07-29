package com.cuntou.动态规划._1143;

/**
 * @ClassName : _1143_LongestCommonSubsequence01  //类名
 * @Description :   //描述
 * @Author : 村头 //作者
 * @Date: 2022/7/26  11:28
 */

public class _1143_LongestCommonSubsequence01 {
    //给定两个字符串 text1 和 text2，返回这两个字符串的最长 公共子序列 的长度。如果不存在 公共子序列 ，返回 0 。
    //
    //一个字符串的 子序列 是指这样一个新的字符串：它是由原字符串在不改变字符的相对顺序的情况下删除某些字符（也可以不删除任何字符）后组成的新字符串。
    //
    //例如，"ace" 是 "abcde" 的子序列，但 "aec" 不是 "abcde" 的子序列。
    //两个字符串的 公共子序列 是这两个字符串所共同拥有的子序列。
    //找公共的子序列
    //最长的序列的话，又是一个最优值
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        // dp[i][j] = 表示text1 前 i 个字符 和 text2 的前 j 个字符 [最长公共子序列的长度]
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    //如果是前面的数字相等之后，就去考虑这些
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    //如果是不相等的话，只需要考虑考虑这个中的一个，要么是s少一个，要么是p少一个去比较
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }

        return dp[m][n];
    }
}
