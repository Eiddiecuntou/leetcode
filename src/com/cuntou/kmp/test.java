package com.cuntou.kmp;

/**
 * @ClassName : test  //类名
 * @Description :   //描述
 * @Author : 村头 //作者
 * @Date: 2022/4/19  11:46
 */

public class test {
    public static void main(String[] args) {
        String str1 = "abababa";
        String str2 = "abac";
            int s = kmp.getKmp(str1,str2);
        System.out.println(s);


    }
}
