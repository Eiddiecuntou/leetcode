package com.cuntou.回溯;

import java.util.*;

/**
 * @ClassName : _301_remove_invalid_parentheses  //类名
 * @Description :   //描述
 * @Author : 村头 //作者
 * @Date: 2022/7/21  9:05
 */

public class _301_remove_invalid_parentheses {
    /* 301. 删除无效的括号
    给你一个由若干括号和字母组成的字符串 s ，删除最小数量的无效括号，使得输入的字符串有效。
    返回所有可能的结果。答案可以按 任意顺序 返回。

    示例 1：
    输入：s = "()())()"
    输出：["()()()", "(())()"]

    示例 2：
    输入：s = "(a)())()"
    输出：["(a)()()", "(a())()"]

    示例 3：
    输入：s = ")("
    输出：[""]
     
    提示：
    1 <= s.length <= 25
    s 由小写英文字母以及括号 '(' 和 ')' 组成
    s 中至多含 20 个括号

     */
    //使用一个一个的尝试
    //BFS
    public List<String> removeInvalidParentheses(String s) {
        List<String> res = new ArrayList<>();
        Queue<String> queue = new LinkedList<>();
        queue.add(s);
        Set<String> visited = new HashSet<>();
        visited.add(s);


        boolean found = false;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size ; i++) {
                String currStr = queue.remove();
                if (isValid(currStr)) {
                    res.add(currStr);
                    found = true;
                    continue;
                }
                int currStrLen = currStr.length();
                for (int j = 0; j < currStrLen ; j++) {
                    if (currStr.charAt(j) != '(' && currStr.charAt(j) != ')') continue;

                    String leftStr = currStr.substring(0, j);
                    String rightStr = (j == currStrLen - 1) ? "" : currStr.substring(j + 1,currStrLen);
                    String next = leftStr + rightStr;
                    if (!visited.contains(next)) {
                        queue.add(next);
                        visited.add(next);
                    }
                }
            }
            if (found) break;
        }
        return res;
    }

    private boolean isValid(String s) {
        int count = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') count++;
            else if (c == ')')count--;

            if (count < 0) return false;
        }
        return count == 0;
    }

}
