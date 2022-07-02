package com.cuntou.哈希查找;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

/**
 * @ClassName : _771_jewels_and_stones  //类名
 * @Description :   //描述
 * @Author : 村头 //作者
 * @Date: 2022/6/18  14:14
 */

public class _771_jewels_and_stones {
     /*  leetcode 771 号算法题：宝石与石头
         给定字符串 J 代表石头中宝石的类型，和字符串 S 代表你拥有的石头。
         S 中每个字符代表了一种你拥有的石头的类型，你想知道你拥有的石头中有多少是宝石。

         J 中的字母不重复，J 和 S中的所有字符都是字母。
         字母区分大小写，因此 "a" 和 "A" 是不同类型的石头。

         输入: J = "aA", S = "aAAbbbb"
         输出: 3

         输入: J = "z", S = "ZZ"
         输出： 0

         - S 和 J 最多含有 50 个字母。
         - J 中的字符不重复。
     */
    //暴力解法
    //时间复杂度设计O(M*N)
    public int numJewelsInStones(String jewels, String stones) {

        int ans = 0;
        for (char c : stones.toCharArray()) {
            //线性查找
            for (char j : jewels.toCharArray()) {
                if (c == j) ans++;
            }
        }
        return ans;
    }
    //哈希查找
    public int numJewelsInStones1(String jewels, String stones) {
        Set<Character> set = new HashSet<>();
        for (char c : jewels.toCharArray()) set.add(c);

        int ans = 0;
        for (char c : stones.toCharArray()) {
            if (set.contains(c)) ans++;
        }
        return ans;
    }

    //26个字母
    //哈希查找
    public int numJewelsInStones2(String jewels, String stones) {
        int[] count = new int[58];
        //大写字母和小写字母之间是断开的,所以要包含所有的大小写字母和六个非字母
        for (char c : jewels.toCharArray()) count[c - 'A'] = 1;

        int ans = 0;
        for (char c : stones.toCharArray()) {
            if (count[c - 'A'] == 1) ans++;
        }
        return ans;
    }
}
