package com.cuntou.动态规划._72;

/**
 * @ClassName : _72_MinEditDistance  //类名
 * @Description :   //描述
 * @Author : 村头 //作者
 * @Date: 2022/7/26  13:58
 */

public class _72_MinEditDistance {
    //给你两个单词 word1 和 word2， 请返回将 word1 转换成 word2 所使用的最少操作数  。
    //
    //你可以对一个单词进行如下三种操作：
    //
    //插入一个字符
    //删除一个字符
    //替换一个字符
    //输入：word1 = "horse", word2 = "ros"
    //输出：3
    //解释：
    //horse -> rorse (将 'h' 替换为 'r')
    //rorse -> rose (删除 'r')
    //rose -> ros (删除 'e')
    //示例 2：
    //输入：word1 = "intention", word2 = "execution"
    //输出：5
    //解释：
    //intention -> inention (删除 't')
    //inention -> enention (将 'i' 替换为 'e')
    //enention -> exention (将 'n' 替换为 'x')
    //exention -> exection (将 'n' 替换为 'c')
    //exection -> execution (插入 'u')
    //提示：
    //0 <= word1.length, word2.length <= 500
    //word1 和 word2 由小写英文字母组成
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();

        //如果有一个字符为空字符串了，就可以提前返回另一个字符串的长度
        if (m * n == 0) return m + n;

        //定义数组 dp[i][j] 表示 word1前 i 个字符转换成word2 中前j个字符所花的最小操作数
        int[][] dp = new int[m + 1][n + 1];

        //填充数组了
        for (int i = 0; i <= m ; i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j <= n ; j++) {
            dp[0][j] = j;
        }

        for (int i = 1; i <= m ; i++) {
            for (int j = 1; j <= n ; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i -1][j -1];
                } else {
                    int insertNum = 1 + dp[i][j - 1];
                    int deleteNum = 1 + dp[i - 1][j];
                    int replaceNum = 1 + dp[i - 1][j - 1];
                    dp[i][j] = Math.min(insertNum, Math.min(deleteNum, replaceNum));
                }
            }
        }
        return dp[m][n];
    }
}
