package com.cuntou.面试.阿里巴巴;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @ClassName : 进制转换  //类名
 * @Description :   //描述
 * @Author : 村头 //作者
 * @Date: 2022/7/26  15:33
 */

public class 进制转换 {
    //得到了一个数，不能确定这个数的进制，只是知道可能是2 -16进制当中的其中之一
    //可以算出所有可能得结果吗，并且转换为十进制之后 10^9 + 7进行取模，将答案从大到小排列
    static int MOD = 1000000007;

    //有可能出现的数字中有英文字母
    //这个时候就需要考虑了一下子，如果是因为字母代表的是多少进制
    public static void main(String[] args) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('A', 10);
        map.put('B', 11);
        map.put('C', 12);
        map.put('D', 13);
        map.put('E', 14);
        map.put('F', 15);

        Scanner sc = new Scanner(System.in);
        String numStr = sc.next();

        int[] res = new int[15];

        int n = numStr.length();
        //时间复杂度 ： O(n)
        for (int i = 0; i < n ; i++) {

        }

    }
}
