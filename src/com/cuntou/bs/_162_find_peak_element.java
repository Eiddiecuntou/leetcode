package com.cuntou.bs;

/**
 * @ClassName : _162_find_peak_element  //类名
 * @Description :   //描述
 * @Author : 村头 //作者
 * @Date: 2022/6/15  21:04
 */

public class _162_find_peak_element {
    public int findPeakElement(int[] nums) {
        int left = 0,right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < nums[mid + 1]) {
                left = mid + 1;
            } else {
                right = mid;
            }

        }
        return left;

    }
    public int findPeakElement1 (int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1]) return i;

        }
        return nums.length -1;
    }

}
