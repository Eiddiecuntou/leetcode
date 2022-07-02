package com.cuntou.stack;

import java.util.ArrayDeque;

/**
 * @ClassName : _224_basic_calculator  //类名
 * @Description :   //描述
 * @Author : 村头 //作者
 * @Date: 2022/6/21  21:45
 */

public class _224_basic_calculator {
    /* leetcode 224 号算法题：基本计算器
        给你一个字符串表达式 s ，请你实现一个基本计算器来计算并返回它的值。

        输入：s = "1 + 1"
        输出：2

        输入：s = " 2-1 + 2 "
        输出：3

        输入：s = "(1+(4+5+2)-3)+(6+8)"
        输出：23

        1 <= s.length <= 3 * 10^5
        s 由数字、'+'、'-'、'('、')'、和 ' ' 组成
        s 表示一个有效的表达式
     */
    //首先是没有括号的情况
    public int calculate1(String s) {
        //没有符号的话就可以进行直接模拟
        //主要就是在想字符串中的数字是怎么表示的，字符串中的数字的正负是怎么表示的，之后存储的字符串是怎么表示的
        //主要就是利用这些来开始记数
        int preSign = 1;
        //1 代表正数，-1 代表的是负数
        int num = 0;
        int res = 0;
        for (char c : s.toCharArray()) {
            if (c >= '0' && c <= '9') {
                num = num * 10 + ( c - '0');
            } else if (c == '+') {
                res += (preSign * num);
                preSign = 1;
                num = 0;
            } else if (c == '-') {
                res += (preSign * num);
                preSign = -1;
                num = 0;
            }
        }
        return res + preSign * num;

    }

    //有括号之后，我们需要考虑的就是运算的先后问题了
    public int calculate(String s) {
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        int preSign = 1;
        //1 代表正数，-1 代表的是负数
        int num = 0;
        int res = 0;
        for (char c : s.toCharArray()) {
            if (c <= '9' && c >= '0') {
                num = num * 10 + (c - '0');
            } else if (c == '+') {
                res += (preSign * num);
                preSign = 1;
                num = 0;
            } else if (c == '-') {
                res += (preSign * num);
                preSign = -1;
                num = 0;
            } else if (c == '(') {
                stack.push(res);
                stack.push(preSign);
                preSign = 1;
                res = 0;
            } else if (c == ')') {
                res += preSign * num;
                res *= stack.pop();
                res += stack.pop();
                num = 0;
            }
        }
        return res + preSign * num;
    }
}
