package com.cuntou.stack;

import java.util.ArrayDeque;

/**
 * @ClassName : _227_basic_calculator_ii  //类名
 * @Description :   //描述
 * @Author : 村头 //作者
 * @Date: 2022/6/21  22:12
 */

public class _227_basic_calculator_ii {
    /*  leetcode 227 号算法题：基本计算器二
        给你一个字符串表达式 s ，请你实现一个基本计算器来计算并返回它的值。
        整数除法仅保留整数部分。
        输入：s = "3+2*2"
        输出： 7

        输入：s = " 3+5 / 2 "
        输出： 5

        1 <= s.length <= 3 * 10^5
        s 由整数和算符 ('+', '-', '*', '/') 组成，中间由一些空格隔开
        s 表示一个有效的表达式
        表达式中的所有整数都是非负整数，且在范围 [0, 2^31 - 1] 内
        题目数据保证答案是一个 32-bit 整数

     */
    //乘法和除法的优先级
    //使用的就是数字
    public int calcutate (String s) {
        char preSign = '+';
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        int i = 0;
        while (i < s.length()) {
            if (s.charAt(i) == ' ') {
                i++;
            } else {
                int num = 0;
                while (i < s.length() && Character.isDigit(s.charAt(i))) {
                    num = num * 10 + (s.charAt(i) - '0');
                    i++;
                }

                if (preSign == '+') {
                    stack.push(num);
                } else if (preSign == '-') {
                    stack.push(-num);
                } else if (preSign == '*') {
                    int tmp = stack.pop();
                    stack.push (tmp * num);
                } else if (preSign == '/') {
                    int tmp = stack.pop();
                    stack.push (tmp / num);
                }
                //去掉空格，是为了拿到下一个符号字符
                while (i < s.length() && s.charAt(i) == ' ') i++;
                if (i < s.length()) preSign = s.charAt(i);
                i++;
            }
        }
        int res = 0;
        while (!stack.isEmpty()) res += stack.pop();
        return res;
    }
}
