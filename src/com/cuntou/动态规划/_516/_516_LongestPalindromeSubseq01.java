package com.cuntou.动态规划._516;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName : _516_LongestPalindromeSubseq01  //类名
 * @Description :   //描述
 * @Author : 村头 //作者
 * @Date: 2022/7/25  19:52
 */

public class _516_LongestPalindromeSubseq01 {
    //给你一个字符串 s ，找出其中最长的回文子序列，并返回该序列的长度。
    //子序列定义为：不改变剩余字符顺序的情况下，删除某些字符或者不删除任何字符形成的一个序列。
    //找最长的子序列，最长子序列的意思就是各个数字都可组成起来
    //返回所有的子序列之和
    private List<String> res = new ArrayList<>();

    public List<String> subSeqs(String s) {
        findSubSeq(s, 0, "");
        return res;
    }

    //使用穷举遍历
    public void findSubSeq(String s, int start, String subSeq) {
        if (start != 0) res.add(subSeq);

        for (int i = start; i < s.length() ; i++) {
            findSubSeq(s, i + 1, subSeq + s.charAt(i));
        }
    }
    public static void main(String[] args) {
        System.out.println(new _516_LongestPalindromeSubseq01().subSeqs("ab"));
    }
}
