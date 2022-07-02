package com.cuntou.kmp;


/**
 * @ClassName : kmp  //类名
 * @Description :   //描述
 * @Author : 村头 //作者
 * @Date: 2022/4/19  11:32
 */

public class kmp {

    public static int[] getNextArr(String m) {
        if (m.length() < 2) { //只有一个字符
            return new int[] {-1};
        }
        if (m.length() < 3) { //只有两个字符
            return new int[] {-1, 0};
        }

        char[] str = m.toCharArray();
        int[] next = new int[m.length()];
        next[0] = -1;
        next[1] = 0; //人为规定的两个位置的next值
        int cn = 0; //表示往前跳的下标。也就是前缀字符串的下一个字符。初始化就是第一个字符
        int i = 2; //从第三个字符开始判断

        while (i < m.length()) {
            if (str[i - 1] == str[cn]) {
                //当前字符的前一个字符，与cn所对应的字符比较
                next[i++] = ++cn; //等价于：next[i++] = next[i - 1] + 1; cn++;
            } else if (cn > 0) {
                //说明当前字符没匹配成功，cn要往前跳，找上一组前缀、后缀字符串
                cn = next[cn];
            } else {
                //cn一直往前跳，都没能与当前字符匹配成功，则当前位置next值就是0
                next[i++] = 0;
            }
        }

        return next; //返回next数组
    }
    public static int getKmp(String s,String m) {
        if (s == null || m == null || s.length() < 1 || m.length() < 1) {
            return -1;
        }
        int[] next = getNextArr(m); //计算出子串的next数组

        char[] str1 = s.toCharArray();
        char[] str2 = m.toCharArray();
        int i = 0;//指向主串的下标
        int j = 0;//指向子串的下标

        while(i < str1.length && j < str2.length) {
            if (str1[i] == str2[j]) {
                //字符相等的情况，i和j同时加1
                i++;
                j++;
            } else if (j == 0) {
                //j不能再往前走了，那么i就往后走一个位置
                i++;
            } else {
                //j还能往前跳，寻找前面的前缀字符串
                j = next[j];
            }
        }
        return j == str2.length ? i - j : -1;//判断子串是否已经遍历完
    }
}






