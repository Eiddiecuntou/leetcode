package com.cuntou.回溯;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName : _17_LetterCombinationsOfAPhoneNumber1  //类名
 * @Description :   //描述
 * @Author : 村头 //作者
 * @Date: 2022/7/18  14:40
 */

public class _17_LetterCombinationsOfAPhoneNumber1 {
    //挨个选一下，先选什么对应的数字
    //字符串，字符串本质还是一个数组
    private Map<Character, String> phone = new HashMap<Character, String>() {{
        put('2', "abc");
        put('3', "def");
        put('4', "ghi");
        put('5', "jkl");
        put('6', "mno");
        put('7', "pqrs");
        put('8', "tuv");
        put('9', "wxyz");
    }};
    private List<String> res;
    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.isEmpty()) {
            return res;
        }
        res = new ArrayList<>();
        findCombination(digits, 0, new StringBuilder());
        return res;

    }

    private void findCombination (String digits, int index, StringBuilder sb) {
        if (index == digits.length()) {
            res.add(sb.toString());
            return;
        }

        char numChar = digits.charAt(index);
        char[] letters = phone.get(numChar).toCharArray();
        for (char c : letters) {
            sb.append(c);
            findCombination(digits, index + 1, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
    public static void main(String[] args) {
        System.out.println(new _17_LetterCombinationsOfAPhoneNumber1()
                .letterCombinations("234"));
    }
}
