package com.cuntou.贪心算法;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @ClassName : _1047_remove_all_adjacent_duplicates_in_string  //类名
 * @Description :   //描述
 * @Author : 村头 //作者
 * @Date: 2022/7/23  14:24
 */

public class _1047_remove_all_adjacent_duplicates_in_string {
    /* 1047. 删除字符串中的所有相邻重复项
    给出由小写字母组成的字符串 S，重复项删除操作会选择两个相邻且相同的字母，并删除它们。
    在 S 上反复执行重复项删除操作，直到无法继续删除。
    在完成所有重复项删除操作后返回最终的字符串。答案保证唯一。

    示例：
    输入："abbaca"
    输出："ca"

    输入："abcddcbaca"
    输出： abc

    提示：
    1 <= S.length <= 20000
    S 仅由小写英文字母组成。
     */
    // 栈
    // 时间复杂度：O(n)
    // 空间复杂度：O(n)
    public String removeDuplicate(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            if (!stack.isEmpty() && stack.peek() == c) {
                stack.pop();
            } else {
                stack.push(c);
            }
        }
        StringBuilder res = new StringBuilder();
        while (!stack.isEmpty()) res.append(stack.pollLast());
        return res.toString();
    }

}
