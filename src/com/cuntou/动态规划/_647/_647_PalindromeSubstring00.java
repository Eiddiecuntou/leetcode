package com.cuntou.动态规划._647;

/**
 * @ClassName : _647_PalindromeSubstring00  //类名
 * @Description :   //描述
 * @Author : 村头 //作者
 * @Date: 2022/7/25  15:53
 */

public class _647_PalindromeSubstring00 {
    //暴力
    //时间复杂度 o (n ^3)
    //找到回文子串的长度给你一个字符串 s ，请你统计并返回这个字符串中 回文子串 的数目。
    //
    //回文字符串 是正着读和倒过来读一样的字符串。
    //
    //子字符串 是字符串中的由连续字符组成的一个序列。
    //具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被视作不同的子串。

    //示例 1：
    //
    //输入：s = "abc"
    //输出：3
    //解释：三个回文子串: "a", "b", "c"
    //示例 2：
    //
    //输入：s = "aaa"
    //输出：6
    //解释：6个回文子串: "a", "a", "a", "aa", "aa", "aaa"
    public int countSubstrings(String s) {
        if (s == null || s.length() == 0) return 0;
        int res = 0;
        //穷举所有的子串
        for (int i = 0; i < s.length() ; i++) {
            for (int j = i; j < s.length() ; j++) {
                //[i,j]
                String str = s.substring(i, j + 1);
                if (isPalindrome(str)) res++;
            }
        }
        return res;
    }

    private boolean isPalindrome(String s) {
        int i = 0;
        int j = s.length();
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }
}
