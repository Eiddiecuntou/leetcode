package com.cuntou.贪心算法;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @ClassName : _1209_remove_all_adjacent_duplicates_in_string_ii  //类名
 * @Description :   //描述
 * @Author : 村头 //作者
 * @Date: 2022/7/23  14:36
 */

public class _1209_remove_all_adjacent_duplicates_in_string_ii {
    /* 1209. 删除字符串中的所有相邻重复项 II
    给你一个字符串 s，「k 倍重复项删除操作」将会从 s 中选择 k 个相邻且相等的字母，
    并删除它们，使被删去的字符串的左侧和右侧连在一起。
    你需要对 s 重复进行无限次这样的删除操作，直到无法继续为止。
    在执行完所有删除操作后，返回最终得到的字符串。

    本题答案保证唯一。

    示例 1：
    输入：s = "abcd", k = 2
    输出："abcd"
    解释：没有要删除的内容。

    示例 2：
    输入：s = "deeedbbcccbdaa", k = 3
    输出："aa"
    解释：
    先删除 "eee" 和 "ccc"，得到 "ddbbbdaa"
    再删除 "bbb"，得到 "dddaa"
    最后删除 "ddd"，得到 "aa"

    示例 3：
    输入：s = "pbbcggttciiippooaais", k = 2
    输出："ps"
     
    提示：
    1 <= s.length <= 10^5
    2 <= k <= 10^4
    s 中只含有小写英文字母。

     */
    //栈
    class pair {
        char ch;
        int cnt;
        public pair (char ch, int cnt) {
            this.ch = ch;
            this.cnt = cnt;
        }
    }
    public String removeDuplicates(String s, int k) {
        Deque<pair> stack = new ArrayDeque<>();
        for (int i = 0; i < s.length() ; i++) {
            if (stack.isEmpty() || s.charAt(i) != stack.peek().ch) {
                stack.push(new pair(s.charAt(i), 1));
            } else {
                stack.peek().cnt++;
                if (stack.peek().cnt == k) {
                    stack.pop();
                }
            }
        }
        StringBuilder res = new StringBuilder();
        while (!stack.isEmpty()) {
            pair p = stack.pollLast();
            for (int i = 0; i < p.cnt ; i++) {
                res.append(p.ch);
            }
        }

        return res.toString();
    }

}
