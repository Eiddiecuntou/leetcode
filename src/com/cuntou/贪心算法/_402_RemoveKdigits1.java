package com.cuntou.贪心算法;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @ClassName : _402_RemoveKdigits1  //类名
 * @Description :   //描述
 * @Author : 村头 //作者
 * @Date: 2022/7/22  19:41
 */
//用空间 换 时间
public class _402_RemoveKdigits1 {
    //
    public String removeKdigits1(String num, int k) {
        Deque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < num.length(); i++) {
            char c = num.charAt(i);
            while (!stack.isEmpty() && k > 0 && stack.peek() > c) {
                stack.pop();
                k--;
            }
            stack.push(c);
        }
        for (int i = 0; i < k ; i++) {
            stack.pop();
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            char c = stack.pop();
            sb.append(c);
        }
        sb = sb.reverse();
        // 删除前面是 0 的字符
        int len = sb.length();
        while (len != 0) {
            if (sb.charAt(0) > '0') break;
            sb.deleteCharAt(0);
            len = sb.length();
        }

        return sb.length() == 0 ? "0" : sb.toString();
    }
}
