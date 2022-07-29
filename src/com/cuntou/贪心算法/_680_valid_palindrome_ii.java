package com.cuntou.贪心算法;

/**
 * @ClassName : _680_valid_palindrome_ii  //类名
 * @Description :   //描述
 * @Author : 村头 //作者
 * @Date: 2022/7/22  21:35
 */

public class _680_valid_palindrome_ii {
     /* 680. 验证回文字符串 Ⅱ
    给定一个非空字符串 s，最多删除一个字符。判断是否能成为回文字符串。

    示例 1:
    输入: "aba"
    输出: true

    示例 2:
    输入: "abca"
    输出: true

    注意:
    字符串只包含从 a-z 的小写字母。字符串的最大长度是 50000。

     */

    public boolean validPalindrome1 (String s) {
        //删除挨个字符然后判断,i = -1 表示不删除任何字符
        for (int i = -1; i < s.length() ; i++) {
            boolean isPalindrome = true;
            int left = 0, right = s.length() - 1;
            while (left < right) {
                //删除索引I对应的字符
                if (left == i) left++;
                if (right == i) right--;

                if (s.charAt(left) == s.charAt(right)) {
                    left++;
                    right--;
                } else {
                    isPalindrome = false;
                    break;
                }
            }
            if (isPalindrome) return true;
        }
        return false;
    }

    //只要开头结尾两个不一样的时候,就可以删除开头结尾的任何一个字符
    public boolean validPalindrome2 (String s) {
        int left = 0, right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) == s.charAt(right)) {
                left++;
                right--;
            } else {
                //要么删除left指向的字符,要么删除right指向的字符
                //判断剩余的字符是不是回文把你的
                return validPalindrome(s, left + 1, right) ||
                        validPalindrome(s, left, right - 1);
            }
        }
        return true;
    }

    private boolean validPalindrome(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
