package com.cuntou.hashtable;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName : shujinxin  //类名
 * @Description :   //描述
 * @Author : 村头 //作者
 * @Date: 2022/4/15  19:27
 */

public class shujinxin {
    public boolean canConstruct(String ransomNote, String magazine) {
        //记录杂志字符串出现的次数
        HashMap hashMap= new HashMap();
        hashMap.put(1,12);
        int[] arr = new int[26];
        int temp;
        for (int i = 0; i < magazine.length(); i++) {
            temp = magazine.charAt(i) - 'a';
            arr[temp]++;
        }
        for (int i = 0; i < ransomNote.length(); i++) {
            temp = ransomNote.charAt(i) - 'a';
            //对于金信中的每一个字符都在数组中查找
            //找到相应位减一，否则找不到返回false
            if (arr[temp] > 0) {
                arr[temp]--;
            } else {
                return false;
            }
        }
        return true;
    }
}
