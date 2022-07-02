package com.cuntou.哈希查找;

import java.util.*;

/**
 * @ClassName : _49_group_anagrams  //类名
 * @Description :   //描述
 * @Author : 村头 //作者
 * @Date: 2022/6/20  14:53
 */

public class _49_group_anagrams {
    /*  leetcode 49 号算法题：字母异位词分组
        给定一个字符串数组，将字母异位词组合在一起。
        字母异位词指字母相同，但排列不同的字符串。

        输入: ["eat", "tea", "tan", "ate", "nat", "bat"]
        输出:
        [
            ["bat"],              --> abt
            ["eat", "tea", ate"], --> aet
            ["tan", "nat"]        --> ant
        ]

        - 所有输入均为小写字母。
        - 不考虑答案输出的顺序。
     */
    public List<List<String>> groupAnagrams(String[] strs){
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            char[] chars = s.toCharArray();
            int[] count = new int[26];
            for (char c : chars) count[c - 'a']++;
            String key = Arrays.toString(count);
            if (!map.containsKey(key)) map.put(key,new ArrayList<>());
            map.get(key).add(s);
        }
        return new ArrayList<>(map.values());
    }
}
