package com.cuntou.动态规划._131;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName : _131_PalindromeSubstring01  //类名
 * @Description :   //描述
 * @Author : 村头 //作者
 * @Date: 2022/7/25  16:05
 */

public class _131_PalindromeSubstring01 {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        if (s == null || s.length() == 0) return res;

        //定义状态数组，表示的是dp[i][j]对应的子串是否是回文
        boolean[][] dp = new boolean[s.length()][s.length()];
        //状态初始化
        for (int i = 0; i < s.length() ; i++) {
            dp[i][i] = true;
        }

        //状态开始转移了
        for (int j = 1; j < s.length() ; j++) {
            for (int i = 0; i < j ; i++) {
                //[i,j]
                boolean isCharEqual = s.charAt(i) == s.charAt(j);
                if (j - i == 1) {
                    dp[i][j] = isCharEqual;
                } else {
                    dp[i][j] = isCharEqual && dp[i + 1][j -1];
                }
            }
        }
        dfs(s, 0, new ArrayList<>(), res, dp);
        return res;
    }
    private void dfs(String s, int start,
                     List<String> path,
                     List<List<String>> res,
                     boolean[][] dp) {
        if (start == s.length()) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = start; i < s.length(); i++) {
            // [start, i]
            // 不是回文的话就剪枝
            if (!dp[start][i]) continue;

            path.add(s.substring(start, i + 1));
            dfs(s, i + 1, path, res, dp);
            path.remove(path.size() - 1);
        }
    }
}
