package com.cuntou.动态规划._516;

/**
 * @ClassName : _516_LongestPalindromeSubseq02  //类名
 * @Description :   //描述
 * @Author : 村头 //作者
 * @Date: 2022/7/26  9:13
 */

public class _516_LongestPalindromeSubseq02 {
    //判断是否是回文子序列
    private int len = Integer.MIN_VALUE;
    public int longestPalindromeSubseq(String s) {
       findSubSeq(s, 0, " ");
       return len;
    }

    private void findSubSeq(String s, int start, String subSeq) {
        if (start != 0) {
            if (isPalindrome(subSeq)) {
                len = Math.max(len,subSeq.length());
            }
        }

        //start 用于剪枝
        for (int i = start; i < s.length() ; i++) {
            findSubSeq(s, i + 1, subSeq + s.charAt(i));
        }
    }

    //判断子串是否是回文
    private boolean isPalindrome(String s) {
        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }
}
