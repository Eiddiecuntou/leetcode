package com.cuntou.bs;

/**
 * @ClassName : _69_sqrtx  //类名
 * @Description :   //描述
 * @Author : 村头 //作者
 * @Date: 2022/6/15  18:38
 */

/**
 * 给你一个非负整数 x ，计算并返回 x 的 算术平方根
 */
public class _69_sqrtx {
    //找出算数平方根
    //因为算数平方根 是 x * x 这样来进行判断的
    // O(logn)
    public int mySqrt(int x) {
        int left = 0, right = x;
        int ans = -1;
        while (left <= right) {
            int k = left + (right - left) / 2;
            if ((long) k * k <= x) {
                ans = k;
                left = k + 1;
            } else {
                right = k - 1;
            }
        }
        return ans;
    }
}
