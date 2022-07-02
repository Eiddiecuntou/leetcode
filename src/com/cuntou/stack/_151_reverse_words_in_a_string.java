package com.cuntou.stack;

/**
 * @ClassName : _151_reverse_words_in_a_string  //类名
 * @Description :   //描述
 * @Author : 村头 //作者
 * @Date: 2022/6/22  9:40
 */

public class _151_reverse_words_in_a_string {
    /* leetcode 151 号算法题：翻转字符串里的单词
    给定一个字符串，逐个翻转字符串中的每个单词。

    输入："the sky is blue"
    输出："blue is sky the"

    输入："  hello world!  "
    输出："world! hello"

    输入："a good   example"
    输出："example good a"

    输入：s = "  Bob    Loves  Alice   "
    1. "Bob    Loves  Alice"
    2. ["Bob", "Loves", "Alice"]
    3. ["Alice", "Loves", "Bob"]
    4. "Alice Loves Bob"
    输出："Alice Loves Bob"

    1. 无空格字符构成一个 单词 。
    2. 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
    3. 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。

    请尝试使用 O(1) 额外空间复杂度的原地解法。
     */
    //不使用内置api
    public String reverseWords2 (String s) {
        // 按照字符要反转的话
        //
        s = trimSpaces(s);
        char[] chars = s.toCharArray();
        reverse(chars, 0, chars.length - 1);

        reverseEachWord(chars);
        
        return s;
    }

    private String trimSpaces(String s) {
        return null;
    }

    private void reverseEachWord(char[] chars) {
    }

    private void reverse(char[] chars, int i, int i1) {
    }




}
