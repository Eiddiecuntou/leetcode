package com.cuntou.bs;

/**
 * @ClassName : _153_find_minimum_in_rotated_sorted_array  //类名
 * @Description :   //描述
 * @Author : 村头 //作者
 * @Date: 2022/6/14  19:54
 */

public class _153_find_minimum_in_rotated_sorted_array {
    public int findMin_3(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return nums[left];
    }
}
