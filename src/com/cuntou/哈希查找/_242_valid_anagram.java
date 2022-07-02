package com.cuntou.哈希查找;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName : _242_valid_anagram  //类名
 * @Description :   //描述
 * @Author : 村头 //作者
 * @Date: 2022/6/20  13:45
 */

public class _242_valid_anagram {
    /*  leetcode 242 号算法题：有效的字母异位词
    给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。

    输入: s = "anagram", t = "nagaram"
    输出: true

    输入: s = "rat", t = "car"
    输出: false

    - 你可以假设字符串只包含小写字母。
    - 如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？
     */
    //去判断一下什么是什么，
    public boolean isAnagram1(String s, String t) {
        if (s.length() != t.length()) return false;
        //使用字符 来作为下标索引
        int[] map = new int[26];
        for (char c : s.toCharArray()) map[c - 'a']++;
        for (char c : t.toCharArray()) {
            map[c - 'a']--;
            if (map[c - 'a'] < 0) return false;
        }
        return true;
    }

    //包含这个Unicode字符 字符不是连续的，不可以使用数组
    // 使用map 来记录、
    public boolean isAnagram2(String s, String t) {
        if(s.length() != t.length()) return false;
        //1.统计字符串 s 中每个字符出现的次数
        Map<Character,Integer> map = new HashMap<>();
        for (char c : s.toCharArray())  {
            if (map.containsKey(c)) {
                map.put(c,map.get(c) + 1);
            } else {
                map.put(c,1);
            }
        }

        //2.减去字符串t中字符出现的次数，如果出现嗯对次数小于0 的话，返回FALSE
        for (char c : t.toCharArray()) {
            // api的意思getOrDefault(Object key, V defaultValue)
            //意思就是当Map集合中有这个key时，就使用这个key对应的value值，如果没有就使用默认值defaultValue
            map.put(c,map.getOrDefault(c,0) - 1);
            if (map.get(c) < 0) return false;
        }
        return true;

    }

    //排序解法
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();

        Arrays.sort(sChars);
        Arrays.sort(tChars);

        return Arrays.equals(sChars,tChars);
     }


    }

