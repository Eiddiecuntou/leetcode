package com.cuntou.排序算法;

/**
 * @ClassName : _628_maximum_product_of_three_numbers  //类名
 * 给你一个整型数组 nums ，在数组中找出由三个数组成的最大乘积，并输出这个乘积。
 * 这个时候考虑这个数组中试凑会存在负数
 * @Date: 2022/5/31  15:11
 */

public class _628_maximum_product_of_three_numbers {
    public int maximumProduct(int[] nums) {
        //求最小值的时候初始值为最大值,因为没有值会比最大值大
        int min1 = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;
        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;
        int max3 = Integer.MIN_VALUE;
        for (int num : nums) {
            if (num < min1) {
                min2 = min1;
                min1 = num;
            } else if (num < min2) {
                min2 = num;
            }

            if (num > max1) {
                max3 = max2;
                max2 = max1;
                max1 = num;
            } else if (num > max2) {
                max3 = max2;
                max2 = num;
            } else if (num > max3) {
                max3 = num;
            }
        }
        return Math.max(max1 * max2 * max3, max1 * min1 * min2);
    }
}
