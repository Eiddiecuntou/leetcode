package com.cuntou.贪心算法;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @ClassName : _316_remove_duplicate_letters  //类名
 * @Description :   //描述
 * @Author : 村头 //作者
 * @Date: 2022/7/23  11:16
 */

public class _316_remove_duplicate_letters {
/* 316. 去除重复字母
    给你一个字符串 s ，请你去除字符串中重复的字母，使得每个字母只出现一次。
    需保证 返回结果的字典序最小（要求不能打乱其他字符的相对位置）。

    示例 1：
    输入：s = "bcabc"
    输出：abc

    示例 2：
    输入：s = "cbacdcbc"
    输出：acdb

    提示：
    1 <= s.length <= 10^4
    s 由小写英文字母组成

     */
    //贪心的时候将字典区的前面的位置是放小字母
    //先进后出
    //使用贪心和单调栈
    public String removeDuplicateLetters(String s) {
        //1.计算字符在字符串S中的最后索引
        int[] lastIndex = new int[26];
        for (int i = 0; i < s.length() ; i++) {
            //找到最后的索引
            lastIndex[s.charAt(i) - 'a'] = i;
        }

        //2.维护一个单调栈
        Deque<Character> stack = new ArrayDeque<>();
        //用于记录字符是否存在于栈中的
        boolean[] exists = new boolean[26];

        for (int i = 0; i < s.length() ; i++) {
            char c = s.charAt(i);
            if (exists[c - 'a']) continue;

            //条件
            //1.当前的字符小于栈顶元素
            //2.栈顶元素是否会在后面还有会出现
            while (!stack.isEmpty() && stack.peek() > c
                    && lastIndex[stack.peek() - 'a'] > i) {
                char top = stack.pop();
                exists[top - 'a'] = false;
            }
            stack.push(c);
            exists[c - 'a'] = true;
        }

        //将栈中的字符串拼接成结果
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pollLast());
        }
        return sb.toString();
    }
}
