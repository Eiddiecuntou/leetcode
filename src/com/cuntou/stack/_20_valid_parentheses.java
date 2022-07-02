package com.cuntou.stack;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName : _20_valid_parentheses  //类名
 * @Description :   //描述
 * @Author : 村头 //作者
 * @Date: 2022/6/21  18:12
 */

public class _20_valid_parentheses {
    /*  leetcode 20 号算法题：有效的括号
        给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。

        有效字符串需满足：
        1. 左括号必须用相同类型的右括号闭合。
        2. 左括号必须以正确的顺序闭合。

        输入：s = "()"
        输出：true

        输入：s = "([)]"
        输出：false

        输入：s = "()[]{}"
        输出：true

        1 <= s.length <= 10^4
        s 仅由括号 '()[]{}' 组成
     */

    // 时间复杂度：O(n)
    // 空间复杂度：O(n)

    //假设一种括号
    //先进后出 碰到对应的右括号再来处理这些东西
    //时间O(n)
    //空间O(n)
    public boolean isValid(String s) {
        //思路:
        //1.是一个先进后出的队列,使用的就是这个栈
        //2.如果有一个左括号,就把他放进去,之后遇到一个右括号就可以把他们弹射出去
        //3.考虑边界条件,如果这个数组是奇数,肯定是不能的
        //4.如果再弹射的时候,发现这个数组也是空的那么也不需要进行检查,直接返回
        if (s.length() % 2== 1) return false;
        ArrayDeque<Character> stack = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) return false;
                stack.pop();
            }

        }
        return stack.isEmpty();

    }
    public boolean isValid1 (String s) {
        ArrayDeque<Character> stack = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[' ) {
                stack.push(c);
            } else {
                if (stack.isEmpty()) return false;
                char top = stack.pop();
                if (c == ')' && top != '(') return false;
                if (c == '}' && top != '{') return false;
                if (c == ']' && top != '[') return false;

            }
        }
        return stack.isEmpty();
    }

    public boolean isValid2 (String s) {
        if (s.length() % 2 == 1) return false;

        Map<Character, Character> map = new HashMap<>();
        map.put('(', ')');
        map.put('{', '}');
        map.put('[', ']');

        ArrayDeque<Character> stack = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            if (map.containsKey(c)) {
                stack.push(c);
            } else {
                if (stack.isEmpty()) return false;
                char top = stack.pop();
                if (c != map.get(top)) return false;
            }
        }
        return stack.isEmpty();
    }
}
