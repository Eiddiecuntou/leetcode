package com.cuntou.滑动窗口;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @ClassName : _3_longest_substring_without_repeating_characters  //类名
 * @Description :   //描述
 * @Author : 村头 //作者
 * @Date: 2022/6/30  22:14
 */

public class _3_longest_substring_without_repeating_characters {
    /* leetcode 3. 无重复字符的最长子串
    给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。

    示例 1:
    输入: s = "abcabcbb"
    输出: 3
    解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。

    示例 2:
    输入: s = "bbbbb"
    输出: 1
    解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。

    示例 3:
    输入: s = "pwwkew"
    输出: 3
    解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
         请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。

    示例 4:
    输入: s = ""
    输出: 0
     
    提示：
    0 <= s.length <= 5 * 10^4
    s 由英文字母、数字、符号和空格组成

     */
    //使用暴力解法
    public int lengthOfLongestSubstring (String s) {
        int n = s.length();
        if (n <= 1) return n;
        int maxLen = 1;

        for (int i = 0; i < n ; i++) {
            for (int j = i + 1; j < n ; j++) {
                if (allUnique (s,i,j)) {
                    maxLen = Math.max(maxLen, j - i + 1);
                }
            }

        }
        return maxLen;
    }
    private boolean allUnique (String s, int start, int end) {
        Set<Character> set = new HashSet<>();
        for (int i = start; i <= end ; i++) {
            if (set.contains(s.charAt(i))) {
                return false;
            }
            set.add(s.charAt(i));
        }
        return true;
    }

    //2.滑动窗口
    //时间复杂度O(2n)= O(n) 最坏的情况是left和right都遍历了一遍字符串
    //空间复杂度O(n)
    public int lengthOfLongestSubString2(String s) {
        int n = s.length();
        if (n <= 1) return n;
        int maxLen = 1;

        int left = 0, right = 0;
        Set<Character> window = new HashSet<>();
        while (right < n) {
            char rightChar = s.charAt(right);
            if (window.contains(rightChar)) {
                window.remove(s.charAt(left));
                left++;
            }
            maxLen = Math.max(maxLen, right - left + 1);
            window.add(rightChar);
            right++;
        }
        return maxLen;

    }



    


}
