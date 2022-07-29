package com.cuntou.贪心算法;

/**
 * @ClassName : _409_longest_palindrome  //类名
 * @Description :   //描述
 * @Author : 村头 //作者
 * @Date: 2022/7/22  20:59
 */

public class _409_longest_palindrome {
     /* 409. 最长回文串
    给定一个包含大写字母和小写字母的字符串，找到通过这些字母构造成的最长的回文串。

    在构造过程中，请注意区分大小写。比如 "Aa" 不能当做一个回文字符串。

    注意:
    假设字符串的长度不会超过 1010。

    示例 1:
    输入:
    "abccccdd"
    输出: 7
    dccaccd

    输入:
    "ababbca"
    aaa
     */

    //回文串
    //看出现的字符数
    //贪心策略:每次将这个字母的v / 2 数放在回文串的左右两侧
    public int longestPalindrome(String s) {
        //字符总是个数是128,包含了大写字母和小写字母
        int[] counter = new int[128];
        for (char c : s.toCharArray()) {
            counter[c]++;
        }

        int ans = 0;
        for (int v : counter) {
            //中间只能有一个出现
            ans += v / 2 * 2;
            if (v % 2 == 1 && ans % 2 == 0) {
                ans++;
            }
        }

        return ans;

    }
}
