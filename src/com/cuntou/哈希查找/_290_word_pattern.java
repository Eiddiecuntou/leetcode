package com.cuntou.哈希查找;

import com.sun.xml.internal.ws.policy.EffectiveAlternativeSelector;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName : _290_word_pattern  //类名
 * @Description :   //描述
 * @Author : 村头 //作者
 * @Date: 2022/6/20  11:19
 */

public class _290_word_pattern {
    /* leetcode 290 号算法题：单词规律
    给定一种规律 pattern 和一个字符串 str ，判断 str 是否遵循相同的规律。

    这里的 遵循 指完全匹配，
    例如， pattern 里的每个字母和字符串 str 中的每个非空单词之间存在着双向连接的对应规律。

    输入: pattern = "abba", str = "dog cat cat dog"
    输出: true

    输入:pattern = "abba", str = "dog cat cat fish"
    输出: false

    输入: pattern = "aaaa", str = "dog cat cat dog"
    输出: false
     */
    //使用的就是两个hashmap数组来进行挨个映射互相证明
    public boolean wordPattern(String pattern, String s) {
        String[] words = s.split( " ");
        if (pattern.length() != words.length) return false;

        Map<Character,String> char2Word = new HashMap<>();
        Map<String,Character> word2Char = new HashMap<>();

        for (int i = 0; i < pattern.length() ; i++) {
            Character c = pattern.charAt(i);
            String word = words[i];
            if ((char2Word.containsKey(c) && !char2Word.get(c).equals(word)) ||
                    word2Char.containsKey(word) && !word2Char.get(word).equals(c)) {
                return false;
            }
            char2Word.put(c, word);
            word2Char.put(word, c);
        }
        return true;
    }
}
