package com.cuntou.数学;

/**
 * @ClassName : _7_reverse_integer  //类名
 * @Description : 整数进行反转 先使用的是找出个位数，个位数之后就可以找十位数 要了解是不是会溢出这个情况
 * 给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。
 * 如果反转后整数超过 32 位的有符号整数的范围 [−231,  231 − 1] ，就返回 0。
 *
 * @Author : 村头 //作者
 * @Date: 2022/5/23  10:37
 */

public class _7_reverse_integer {
    // 溢出之前来判断
    public int reverse1 (int x) {
        int res = 0;
        while (x != 0) {
            int pop = x % 10;
            x = x / 10;
            //MAX_VAlUE = 2 ^ 31 - 1 = 2147483647;
            //MIN_VALUE =  -2 ^ 31 - 1 = -2147483648;
            if (res > Integer.MAX_VALUE / 10 || (res == Integer.MAX_VALUE && pop > 7)) return 0;
            if (res < Integer.MIN_VALUE / 10 || (res == Integer.MIN_VALUE && pop < -8)) return 0;

            res = res * 10 + pop;

        }
        return res;
    }
    //溢出之后判断
    public int reverse2 (int x) {
        int res = 0;
        while (x != 0) {
            int pop = x % 10;
            x = x / 10;
            int newRes = res * 10 + pop;
            if ((newRes - pop) / 10 != res) return 0;
            res = newRes;
        }
        return res;
    }
}
