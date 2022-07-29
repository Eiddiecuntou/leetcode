package com.cuntou.回溯;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName : _131_palindrome_partitioning  //类名
 * @Description :   //描述
 * @Author : 村头 //作者
 * @Date: 2022/7/20  22:01
 */

public class _131_palindrome_partitioning {
     /* 131. 分割回文串
    给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是 回文串 。
    返回 s 所有可能的分割方案。

    回文串 是正着读和反着读都一样的字符串。

    示例 1：
    输入：s = "aab"
    输出：[["a", "a", "b"], ["aa", "b"]]

    示例 2：
    输入：s = "a"
    输出：[["a"]]

    提示：
    1 <= s.length <= 16
    s 仅由小写英文字母组成
     */
    //求子集的问题
    private String s;
    private List<List<String>> res;
    public List<List<String>> partition(String s) {
        this.s = s;
        this.res = new ArrayList<>();
        dfs(0, new ArrayList<>());
        return res;
    }

    private void dfs(int startIndex, List<String> path) {
        if (startIndex == s.length()) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = startIndex; i < s.length() ; i++) {
            int endIndex = i;
            //[StartIndex,endIndex]
            if (!checkPalindrome(s, startIndex, endIndex)) continue;
            path.add(s.substring(startIndex, endIndex + 1));
            dfs(i + 1, path);
            path.remove(path.size() - 1);

        }
    }


    private boolean checkPalindrome(String str, int left, int right) {
        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) return false;
            left++;
            right--;
        }
        return true;

    }
}
