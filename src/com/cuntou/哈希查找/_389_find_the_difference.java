package com.cuntou.哈希查找;

/**
 * @ClassName : _389_find_the_difference  //类名
 * @Description :   //描述
 * @Author : 村头 //作者
 * @Date: 2022/6/20  9:46
 */

public class _389_find_the_difference {
    /***
     * 找不同
     * 在给定的两个字符串中 s 和 t ，他们只包含小写字母
     * 字符串 t 由 s随机重排的，然后在随机位置加一个字母
     * 请找出在 t 中被添加的字母
     *
     * 其实 就是找不同
     */
    public char findTheDifference (String s, String t) {
        int[] counts = new int[26];
        for (char c : s.toCharArray()) counts[c - 'a']++;
        for (char c : t.toCharArray()) {
            counts[c - 'a']--;
            if (counts[c - 'a'] < 0) return c;
        }
        return ' ';
    }

    public char findTheDifference1 (String s, String t) {
        int as = 0, at = 0;
        for (char c : s.toCharArray()) as += c;
        for (char c : t.toCharArray()) at += c;
        return (char)(at - as);

    }
}
