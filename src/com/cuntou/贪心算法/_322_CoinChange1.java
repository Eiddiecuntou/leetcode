package com.cuntou.贪心算法;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @ClassName : _322_CoinChange1  //类名
 * @Description :   //描述
 * @Author : 村头 //作者
 * @Date: 2022/7/21  11:37
 */


public class _322_CoinChange1 {
    //贪心
    //贪心做不了的话
    public int coinChange(int[] c, int k) {
        Arrays.sort(c);

        int rest = k;
        int res = 0;

        for (int i = c.length - 1; i >= 0 ; i--) {
            int currCount = rest / c[i];
            rest = rest - currCount * c[i];

            res += currCount;
            if (rest == 0) {
                return res;
            }

        }
        return -1;
    }

    public static void main(String[] args) {
        int[] c = {3, 5};
        System.out.println(new _322_CoinChange1().coinChange(c, 11));
    }
}
